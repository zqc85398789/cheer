package com.cheer.controller;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cheer.mybatis.model.IAccount;
import com.cheer.mybatis.model.IPrivilege;
import com.cheer.service.LoginService;

@Controller
public class LoginController {
	@Resource(name="loginService")
	private LoginService loginService;
	
	
	@ModelAttribute
	public void setEncoding(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;utf-8");
	}
	
	@RequestMapping("loginPage.do")
	public String loginPage(@ModelAttribute("iAccount") IAccount iAccount,HttpSession session) {
		if(session.getAttribute("loginAccount")!=null) {
			return "home_page";
		}
		return "login";
	}
	
	@RequestMapping("login.do")
	public String login(@ModelAttribute("iAccount") IAccount iAccount,Model model,HttpSession session,RedirectAttributes redirect) {
		if(loginService.loginCheck(iAccount)) {
			IPrivilege iPrivilege = loginService.getPrivilege(iAccount);
			session.setAttribute("loginAccount", iAccount);
			session.setAttribute("loginPrivilege", iPrivilege);
			return "redirect:homePage.do";
		}
		model.addAttribute("login_msg","登陆失败，请检查账户密码后重试");
		return "login";
	}
	
	@RequestMapping("logout.do")
	public String logout(@ModelAttribute("iAccount") IAccount iAccount,HttpSession session) {
		session.removeAttribute("loginAccount");
		session.removeAttribute("loginPrivilege");
		session.removeAttribute("admin");
		session.removeAttribute("boss");
		return "login";
	}
}
