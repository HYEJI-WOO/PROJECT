package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ProductReplyDao;
import com.domain.ProductReplyVO;
import com.google.gson.Gson;
import com.service.ProductReplyService;

@WebServlet("/productReply/*")
public class ProductReplyController extends HttpServlet{
	
	private ProductReplyService service;
	private Gson gson;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		ServletContext sc = config.getServletContext();
		//service = (ProductReplyService) sc.getAttribute("productReplyService");
		service = new ProductReplyService(new ProductReplyDao());
		gson = new Gson();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		String pathInfo = request.getPathInfo();
		String contextPath = request.getContextPath();
		
		if(pathInfo.equals("/list")) {
			String name = request.getParameter("name");
			List<ProductReplyVO> list = service.list(name);
			out.print(gson.toJson(list));
		}
		
		else if(pathInfo.equals("/write")) {
			String paramPno = request.getParameter("pno");
			
			ProductReplyVO vo = ProductReplyVO.builder()
					.pno(Integer.parseInt(paramPno))
					.reply(request.getParameter("reply"))
					.writer(request.getParameter("writer"))
					.build();
			service.writer(vo);
			
			String result = gson.toJson("리뷰가 작성되었습니다.");
			out.print(result);
		}
		else if(pathInfo.equals("/remove")) {
			String paramRno = request.getParameter("rno");
			
			ProductReplyVO vo = ProductReplyVO.builder()
					.rno(Integer.parseInt(paramRno))
					.build();
			service.remove(vo);
			
			String result = gson.toJson("리뷰가 삭제되었습니다.");
			out.print(result);
		}
		
		else if(pathInfo.equals("/prCheck")) {
			int result = 0;
		    String id = request.getParameter("id");
		    int pno = Integer.parseInt(request.getParameter("pno"));
			if(service.prCheck(id, pno)) {
				result = 1;
			}
			out.print(gson.toJson(result));
			return;
		}
		
		else if(pathInfo.equals("/updateCommentCount")) {
			String id = request.getParameter("id");
			int pno = Integer.parseInt(request.getParameter("pno"));
			service.updateCommentCount(id, pno);
			String result = gson.toJson("success");
			out.print(result);
		}
		
	}
	
}
