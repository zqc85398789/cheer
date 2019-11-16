package com.cheer.controller.base;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.cheer.mybatis.model.IPrivilege;


@Controller
public class BaseController {
	//登录控制
	@ModelAttribute
	public void loginControl(HttpServletRequest request,HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		Object obj = session.getAttribute("loginAccount");
		if(obj==null) {
			request.setAttribute("login_msg", "对不起，请登录后再访问");
			request.getRequestDispatcher("/loginPage.do").forward(request, response);
		}
	}
	
	//权限控制
	@ModelAttribute
	public void privilegeControl(HttpSession session,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		IPrivilege iPrivilege = (IPrivilege) session.getAttribute("loginPrivilege");
		if("/admin".equals(iPrivilege.getPrivilegeUrl())) {
			session.setAttribute("admin", "admin");
			return;
		}
		if("/boss".equals(iPrivilege.getPrivilegeUrl())) {
			session.setAttribute("boss", "boss");
			return;
		}
		StringBuffer path = request.getRequestURL();
		if(path.indexOf("ccount")>0 || path.indexOf("alary")>0 ||path.indexOf("eave")>0 ||
				path.indexOf("ode")>0 || path.indexOf("inance")>0) {
			request.getRequestDispatcher("/404.do").forward(request, response);
		}
	}
}
