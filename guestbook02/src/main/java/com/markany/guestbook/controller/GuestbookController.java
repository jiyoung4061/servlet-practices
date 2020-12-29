package com.markany.guestbook.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.markany.guestbook.dao.GuestBookDao;
import com.markany.guestbook.vo.GuestBookVo;

public class GuestbookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String actionName = request.getParameter("a");
		System.out.println("action>>"+actionName);
		if ("add".equals(actionName)) {
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String message = request.getParameter("message");
			String reg_date = request.getParameter("reg_date");

			GuestBookVo vo = new GuestBookVo();
			vo.setName(name);
			vo.setPassword(password);
			vo.setMessage(message);
			vo.setReg_date(reg_date);

			new GuestBookDao().insert(vo);
			response.sendRedirect(request.getContextPath()+"/gb");
		} else if ("delete".equals(actionName)) {
			String no = request.getParameter("no");
			String password = request.getParameter("password");
			
			new GuestBookDao().delete(no, password);
			response.sendRedirect(request.getContextPath()+"/gb");
		} else if ("deleteform".equals(actionName)) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/deleteform.jsp");
			rd.forward(request, response);
		} else {
			List<GuestBookVo> list = new GuestBookDao().findAll();
			
			request.setAttribute("list", list);

			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
