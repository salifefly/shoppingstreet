package com.iotek.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iotek.entity.User;
import com.iotek.service.UserService;
import com.iotek.service.impl.UserServiceImpl;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

	private UserService userService = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("loginName");
		String pwd = req.getParameter("password");
		User user = userService.queryByNameAndPwd(name, pwd);
		if (user == null) {
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		} else {
			req.getSession().setAttribute("user", user);
			resp.sendRedirect("mainServlet");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
