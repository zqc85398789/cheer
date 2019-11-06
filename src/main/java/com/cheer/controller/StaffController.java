package com.cheer.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cheer.beans.Account;
import com.cheer.beans.Staff;
import com.cheer.service.StaffService;
import com.cheer.util.DateUtil;

@Controller
@RequestMapping("/staff")
public class StaffController {
	@Resource(name="staffService")
	StaffService staffService;
	
	@ModelAttribute
	public void setEncoding(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;utf-8");
	}
	
	//账户列表页面
	@RequestMapping("staffList.do")
	public String staffList(@ModelAttribute("staff") Staff staff,Model model) {
		model.addAttribute("max_page",0);
		return "staff_list";
	}
	
	@RequestMapping("queryAccount.do")
	public String queryAccount(@ModelAttribute("staff") Staff staff,@RequestParam int queryPage,Model model) {
		List<Account> accountList = staffService.queryStaff(staff,queryPage);
		int maxPage = staffService.getMaxPage(staff);
		model.addAttribute("accountList",accountList);
		model.addAttribute("max_page",maxPage);
		model.addAttribute("current_page",queryPage);
		return "account_list";
	}
	
//	//账户创建页面
//	@RequestMapping("createAccountPage.do")
//	public String createAccountPage(@ModelAttribute("account") Account account) {
//		return "account_create";
//	}
//
//	/**
//	 * 创建账号
//	 * 
//	 * @param account
//	 * @param br
//	 * @param privilegeId
//	 * @param model
//	 * @return
//	 */
//	@RequestMapping("createAccount.do")
//	public String createAccount(@ModelAttribute("account") @Valid Account account, BindingResult br,
//			@Param("privilegeId") String privilegeId, Model model, HttpSession session) {
//		
//		// 账户校验
//		if (br.hasErrors()) {
//			ObjectError objError = br.getGlobalError();
//			if (objError != null) {
//				model.addAttribute("account_password_error", objError.getDefaultMessage());
//			}
//			model.addAttribute("account_create_msg", "创建账户失败，请检查后重试");
//			return "account_create";
//		}
//		// 检查账户名是否重复
//		if (accountService.accountExists(account)) {
//			model.addAttribute("account_create_msg", "账户名已存在");
//			return "account_create";
//		}
//		// 获取当前登录账户名
//		account.setCreatedBy(((Account) session.getAttribute("loginAccount")).getAccountName());
//		account.setCreatedTime(DateUtil.currentTime());
//		// 尝试创建账号
//		if (accountService.createAccount(account, privilegeId)) {
//			model.addAttribute("account_create_msg", "账户创建成功");
//			return "account_create";
//		}
//		model.addAttribute("failed_create_msg", "创建账户失败，请检查后重试");
//		return "account_create";
//	}
//
//	@RequestMapping("updateStaffPage.do/{id}.do")
//	public String updateStaffPage(@PathVariable int id,Model model) {
//		Staff staff = accountService.queryAccountById(id);
//		model.addAttribute("staff",staff);
//		return "staff_update";
//	}
//	
//	/**
//	 * 修改账号信息
//	 * @param account
//	 * @param br
//	 * @param privilegeId
//	 * @param model
//	 * @param session
//	 * @return
//	 */
//	@RequestMapping("updateAccount.do")
//	public String updateAccount(@ModelAttribute("account") @Valid Account account, BindingResult br,
//			@RequestParam("privilegeId") String privilegeId, Model model, HttpSession session) {
//		// 账户校验
//		if (br.hasErrors()) {
//			ObjectError objError = br.getGlobalError();
//			if (objError != null) {
//				model.addAttribute("account_password_error", objError.getDefaultMessage());
//			}
//			model.addAttribute("account_update_msg", "修改账户失败，请检查后重试");
//			return "account_update";
//		}
//		// 获取当前登录账户名
//		account.setUpdateBy(((Account) session.getAttribute("loginAccount")).getAccountName());
//		account.setUpdateTime(DateUtil.currentTime());
//		// 尝试创建账号
//		if (accountService.updateAccount(account, privilegeId)) {
//			model.addAttribute("account_update_msg", "账户修改成功");
//			return "account_list";
//		}
//		model.addAttribute("account_update_msg", "修改账户失败，请检查后重试");
//		return "account_update";
//	}

}