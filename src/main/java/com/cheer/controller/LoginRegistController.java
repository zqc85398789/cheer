package com.cheer.controller;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cheer.beans.User;
import com.cheer.service.LoginRegistService;
import com.cheer.util.DateUtil;

@Controller
public class LoginRegistController {
	
	@Resource(name="loginRegistService")
	private LoginRegistService loginRegistService;
	
	@RequestMapping("loginPage.do")
	public String loginPage() {
		return "login";
	}
	
	@RequestMapping("login.do")
	public String login(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws UnsupportedEncodingException {
		response.setContentType("text/html;charset=utf-8"); 
		request.setCharacterEncoding("UTF-8");
		String username  = request.getParameter("username");
		String password = request.getParameter("password");
		String isAdmin = request.getParameter("isAdmin");
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		if(loginRegistService.loginCheck(user, isAdmin)) {
			session.setAttribute("loginUser", user);
			return "redirect:index.do";
		}
		request.setAttribute("username", username);
		request.setAttribute("msg", "登录信息不正确，请检查后重试");
		return "login";
	}

	@RequestMapping("registPage.do")
	public String registPage() {
		return "regist";
	}
	
	@RequestMapping("regist.do")
	public String regist(HttpServletRequest request,HttpServletResponse response,RedirectAttributes redirectAttributes) throws UnsupportedEncodingException, ParseException {
		response.setContentType("text/html;charset=utf-8"); 
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String legal_name = request.getParameter("legal_name");
		String birth_date = request.getParameter("birth_date");
		String gender = request.getParameter("gender");
		User user = new User(username,password,legal_name);
		if(!"".equals(birth_date)) {
			user.setBirth_date(DateUtil.dateParse(birth_date, DateUtil.DATE_PATTERN));
		}
		user.setGender(gender);
		if(loginRegistService.registCheck(user)) {
			redirectAttributes.addFlashAttribute("msg","注册成功，请登录");
			return "redirect:loginPage.do";
		}
		request.setAttribute("user", user);
		request.setAttribute("msg", "该账号已经存在");
		return "regist";
	}
	
	@RequestMapping("index.do")
	public String index() {
		return "index";
	}
}
