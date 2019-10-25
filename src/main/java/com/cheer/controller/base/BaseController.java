package com.cheer.controller.base;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class BaseController {
	//登录控制
	@ModelAttribute
	public void loginControl(HttpServletResponse response, HttpSession session,RedirectAttributes attr) throws IOException {
		Object obj = session.getAttribute("loginUser");
		if(obj==null) {
			//attr.addFlashAttribute("login_msg","对不起，请先登录");
			session.setAttribute("login_msg", "对不起，请登录后再访问");
			response.sendRedirect("loginPage.do");
		}
	}
}
