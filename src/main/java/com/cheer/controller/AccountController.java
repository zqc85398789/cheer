package com.cheer.controller;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cheer.beans.Account;
import com.cheer.mapper.AccountMapper;
import com.cheer.service.AccountService;
import com.cheer.util.DateUtil;

@Controller
@RequestMapping("/account")
public class AccountController {
	@Resource(name="accountService")
	AccountService accountService;
	
	
	@ModelAttribute
	public void setEncoding(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;utf-8");
	}
	
	@RequestMapping("createAccountPage.do")
	public String createAccountPage(@ModelAttribute("account")Account account) {
		return "create_account";
	}
	
	@RequestMapping("createAccount.do")
	public String createAccount(@ModelAttribute("account") @Valid Account account,BindingResult br,@Param("privilegeId")String privilegeId ,Model model) {
		account.setCreatedBy("admin");//此处实写，实际因从session获取
		account.setCreatedTime(DateUtil.currentTime());
		if(br.hasErrors()) {
			ObjectError objError =  br.getGlobalError();
			if(objError!=null) {
				model.addAttribute("account_password_error",objError.getDefaultMessage());
				model.addAttribute("failed_create_account","创建账户失败，请检查后重试");
			}
			return "create_account";
		}
		if(accountService.createAccount(account, privilegeId)) {
			return "index";
		}
		model.addAttribute("failed_create_account","创建账户失败，请检查后重试");
		return "create_account";
	}
	
}
