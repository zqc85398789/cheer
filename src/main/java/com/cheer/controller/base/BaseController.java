package com.cheer.controller.base;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
public class BaseController {
	//登录控制
	@ModelAttribute
	public void loginControl(HttpServletRequest request,HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		Object obj = session.getAttribute("loginAccount");
		if(obj==null) {
			request.setAttribute("login_msg", "对不起，请登录后再访问");
			request.getRequestDispatcher("loginPage.do").forward(request, response);
		}
	}
}
