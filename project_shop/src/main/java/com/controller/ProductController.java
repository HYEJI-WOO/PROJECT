package com.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

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
		
		// 베스트 상품
		else if(pathInfo.equals("/best")) {
			nextPage = "best";
		}
		
		// 세일상품
		else if(pathInfo.equals("/sale")) {
			nextPage = "sale";
		}
		
		else if(pathInfo.equals("/manage")) {
			nextPage = "manage";
		}
		
		else if(pathInfo.equals("/addProduct")) {
			String name = request.getParameter("name");
			String paramprice = request.getParameter("price");
			String weight = request.getParameter("weight");
			String info = request.getParameter("info");
			String category = request.getParameter("category");
			int price = Integer.parseInt(paramprice);
			
			ProductVO vo = ProductVO.builder()
					.name(name)
					.price(price)
					.weight(weight)
					.info(info)
					.category(category)
					.build();
			service.addProduct(vo);
			
			response.sendRedirect(contextPath+"/product");
			return;
		}

		else {
			System.out.println("존재하지 않는 페이지");
		}
		
		rd = request.getRequestDispatcher(PRIFIX+nextPage+SUFFIX);
		rd.forward(request, response);
	}
	

}