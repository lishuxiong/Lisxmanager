package com.lisx.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import com.lisx.mode.User;
import com.lisx.service.UserService;
import com.lisx.service.impl.UserServiceImpl;
import com.lisx.util.WebUtil;
import com.lisx.web.bean.UserFormBean;

public class ControllerServlet extends HttpServlet {

	private static final String LOGIN = "login";
	private static final String REGISTER = "register";
	private static final String LOGOUT = "logout";

	private UserService userService = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String op = request.getParameter("op");
		System.out.println("lisx : "+ op +"\n");
		if (LOGIN.equals(op)) {
			login(request, response);
		} else if (REGISTER.equals(op)) {
			register(request, response);
		} else if (LOGOUT.equals(op)) {
			logout(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);

	}

	private void login(HttpServletRequest request, HttpServletResponse response) {

		try {
			PrintWriter out = response.getWriter();
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			User user = userService.login(username, password);
			if (user != null) {
				request.getSession().setAttribute("user", user);
				out.write("登录成功，2秒后进入系统管理界面");
				response.setHeader("Refresh", "2;URL=" + request.getContextPath());
			} else {
				out.write("登录失败，2秒后跳转登录页面");
				response.setHeader("Refresh", "2;URL=" + request.getContextPath() + "/login.jsp");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void logout(HttpServletRequest request, HttpServletResponse response) {
		PrintWriter out;
		try {
			out = response.getWriter();
			HttpSession session = request.getSession();
			session.removeAttribute("user");
			session.invalidate();
			out.write("注销成功，2秒后跳转主页");
			response.setHeader("Refresh", "2;URL=" + request.getContextPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void register(HttpServletRequest request, HttpServletResponse response) {
		try {
			PrintWriter out = response.getWriter();
			UserFormBean formBean = WebUtil.fillBean(request, UserFormBean.class);
			if (!formBean.validation()) {
				request.setAttribute("formBean", formBean);
				request.getRequestDispatcher("/register.jsp").forward(request, response);
				return;
			}
			User user = new User();
			ConvertUtils.register(new DateLocaleConverter(), Date.class);
			BeanUtils.copyProperties(user, formBean);
			boolean flag = userService.register(user);
			if (flag) {
				out.write("登录成功，2秒后进入系统管理界面");
				response.setHeader("Refresh", "2;URL=" + request.getContextPath());
			} else {
				formBean.getErrorMsg().put("username", "注册失败，用户名已经存在!");
				request.setAttribute("formBean", formBean);
				request.getRequestDispatcher("/register.jsp").forward(request, response);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
