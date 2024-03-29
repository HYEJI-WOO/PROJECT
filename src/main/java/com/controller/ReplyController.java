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
import javax.servlet.http.HttpSession;

import com.domain.ReplyVO;
import com.google.gson.Gson;
import com.service.ReplyService;

@WebServlet("/reply/*")
public class ReplyController extends HttpServlet {
	
	private ReplyService service;
	private Gson gson;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		ServletContext sc = config.getServletContext();
		service = (ReplyService) sc.getAttribute("replyService");
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
			String paramBno = request.getParameter("bno");
			int bno = Integer.parseInt(paramBno);
			List<ReplyVO> replyList = service.list(bno);
			out.print(gson.toJson(replyList));
			
		} else if(pathInfo.equals("/write")) {
			String paramBno = request.getParameter("bno");
			
			long currentTime = System.currentTimeMillis();
			HttpSession session = request.getSession(false);
			if(session.getAttribute("lastWriting")!=null) { // 마지막에 글을 쓴 시간이 있다면
				long lastWriting = (long) session.getAttribute("lastWriting");
				if(currentTime-lastWriting < 10000) {
					out.print(gson.toJson("10초 간격을 두고 답변을 작성해 주세요."));
					return;
				}
			}
			// 마지막에 글을 쓴 시간이 없다면
			session.setAttribute("lastWriting", currentTime);
			
			ReplyVO vo = ReplyVO.builder()
					.bno(Integer.parseInt(paramBno))
					.reply(request.getParameter("reply"))
					.writer(request.getParameter("writer")).build();
			
			service.writer(vo);
			String result = gson.toJson("답변이 등록되었습니다.");
			out.print(result);
			
		} else if(pathInfo.equals("/remove")) {
			String paramBno = request.getParameter("bno");
			String paramRno = request.getParameter("rno");
			ReplyVO vo = ReplyVO.builder()
					.bno(Integer.parseInt(paramBno))
					.rno(Integer.parseInt(paramRno))
					.build();
			
			service.remove(vo);
			String result = gson.toJson("답변이 삭제되었습니다.");
			out.print(result);
		}
	}

}