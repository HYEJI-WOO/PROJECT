package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.CartDao;
import com.domain.AuthVO;
import com.domain.CartVO;
import com.google.gson.Gson;
import com.service.CartService;

@WebServlet("/cart/*")
public class CartController extends HttpServlet {
	
	private CartService service;
	private Gson gson;
	
	@Override
	public void init() throws ServletException {
		CartDao dao = new CartDao();
		service = new CartService(dao);
		gson = new Gson();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		String pathInfo = request.getPathInfo();
		String contextPath = request.getContextPath();
		final String PRIFIX = "/WEB-INF/views/cart/";
		final String SUFFIX = ".jsp";
		
		RequestDispatcher rd = null;
		String nextPage = null;
		
		// 장바구니 
		if(pathInfo.equals("/addCart")) {
			String id = request.getParameter("id");
			String paramPno = request.getParameter("pno");
			int pno = Integer.parseInt(paramPno);
			CartVO vo = CartVO.builder()
					.id(id)
					.pno(pno)
					.build();
			service.addCart(vo);
			String result = "장바구니 담기 성공";
			out.print(gson.toJson(result));
			return;
		}
		
		else if(pathInfo.equals("/cartIn")) {
			HttpSession session = request.getSession(false);
			AuthVO auth = (AuthVO) session.getAttribute("auth");
			List<CartVO> info = service.cartIn(auth.getId());
			request.setAttribute("info", info);
			nextPage = "cartIn";
		}
		
		else if(pathInfo.equals("/delAllCart")) {
			String id = request.getParameter("id");
			service.delAllCart(id);
			String result = "장바구니 삭제 성공";
			out.print(gson.toJson(result));
			return;
		}
		
		else {
			System.out.println("페이지를 찾을 수 없음");
			return;
		}
		
		rd = request.getRequestDispatcher(PRIFIX+nextPage+SUFFIX);
		rd.forward(request, response);
	}

}

