package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ProductDao;
import com.domain.BoardVO;
import com.domain.MemberVO;
import com.domain.ProductVO;
import com.service.ProductService;

@WebServlet("/product/*")
public class ProductController extends HttpServlet {
	
	private ProductService service;
	
	@Override
	public void init() throws ServletException {
		ProductDao dao = new ProductDao();
		service = new ProductService(dao);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pathInfo = request.getPathInfo();
		String contextPath = request.getContextPath();
		final String PRIFIX = "/WEB-INF/views/product/";
		final String SUFFIX = ".jsp";
		
		RequestDispatcher rd = null;
		String nextPage = null;
		
		// 상품목록
		if(pathInfo==null || pathInfo.equals("/") || pathInfo.equals("/list")) {
			List<ProductVO> productList = service.productList();
			request.setAttribute("list", productList);
			nextPage = "list";
		}
		
		// 상품상세
		else if(pathInfo.equals("/detail")) {
			String name = request.getParameter("name");
			ProductVO product = service.findProduct(name);
			request.setAttribute("product", product);
			nextPage = "detail";
		}
		
		// 베스트상품
		else if(pathInfo.equals("/best")) {
			nextPage = "best";
		}
		
		// 세일상품
		else if(pathInfo.equals("/sale")) {
			nextPage = "sale";
		}
		
		else if(pathInfo.equals("/manage")) {
			List<ProductVO> productManage = service.productManage();
			request.setAttribute("list", productManage);
			nextPage = "manage";
		}
		
		else if(pathInfo.equals("/modproduct")) {
			String parampno = request.getParameter("pno");
			String name = request.getParameter("name");
			String paramprice = request.getParameter("price");
			String info = request.getParameter("info");
			String weight = request.getParameter("weight");
			String category = request.getParameter("category");
			System.out.println(parampno);
			System.out.println(name);
			System.out.println(paramprice);
			System.out.println(info);
			System.out.println(weight);
			System.out.println(category);
			ProductVO vo = ProductVO.builder()
					.pno(Integer.parseInt(parampno))
					.name(name)
					.price(Integer.parseInt(paramprice))
					.info(info)
					.weight(weight)
					.category(category)
					.build();
			service.modProduct(vo);
			response.sendRedirect(contextPath+"/product/manage");
			return;
		}
		else {
			System.out.println("존재하지 않는 페이지");
		}
		
		rd = request.getRequestDispatcher(PRIFIX+nextPage+SUFFIX);
		rd.forward(request, response);
	}
	

}