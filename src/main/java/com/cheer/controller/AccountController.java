package com.cheer.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cheer.controller.base.BaseController;
import com.cheer.mybatis.model.IAccount;
import com.cheer.service.AccountService;
import com.cheer.util.DateUtil;

@Controller
@RequestMapping("/account")
public class AccountController extends BaseController{
	@Resource(name = "accountService")
	AccountService accountService;

	@ModelAttribute
	public void setEncoding(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;utf-8");
	}
	
	//账户列表页面
	@RequestMapping("accountList.do")
	public String accountList(@ModelAttribute("iAccount") IAccount iAccount,Model model) {
		model.addAttribute("max_page",0);
		return "account_list";
	}
	
	@RequestMapping("queryAccount.do")
	public String queryAccount(@ModelAttribute("iAccount") IAccount iAccount,@RequestParam int queryPage,Model model) {
		List<IAccount> iAccountList = accountService.queryIAccount(iAccount,queryPage);
		if(iAccountList.size()==0) {
			model.addAttribute("max_page",0);
			return "account_list";
		}
		int maxPage = accountService.getMaxPage(iAccount);
		model.addAttribute("iAccountList",iAccountList);
		model.addAttribute("max_page",maxPage);
		model.addAttribute("current_page",queryPage);
		return "account_list";
	}
	
	//账户创建页面
	@RequestMapping("createAccountPage.do")
	public String createAccountPage(@ModelAttribute("iAccount") IAccount iAccount) {
		return "account_create";
	}

	/**
	 * 创建账号
	 * 
	 * @param account
	 * @param br
	 * @param privilegeId
	 * @param model
	 * @return
	 */
	@RequestMapping("createAccount.do")
	public String createAccount(@ModelAttribute("iAccount") @Valid IAccount iAccount, BindingResult br,
			@RequestParam("privilegeId") Integer privilegeId, Model model, HttpSession session) {
		
		// 账户校验
		if (br.hasErrors()) {
			ObjectError objError = br.getGlobalError();
			if (objError != null) {
				model.addAttribute("account_password_error", objError.getDefaultMessage());
			}
			model.addAttribute("account_create_msg", "创建账户失败，请检查后重试");
			return "account_create";
		}
		// 检查账户名是否重复
		if (accountService.accountExists(iAccount)) {
			model.addAttribute("account_create_msg", "账户名已存在");
			return "account_create";
		}
		//检查员工号是否重复
		if (accountService.empnoExists(iAccount)) {
			model.addAttribute("account_create_msg", "员工号已存在");
			return "account_create";
		}
		// 获取当前登录账户名
		iAccount.setCreatedBy(((IAccount) session.getAttribute("loginAccount")).getAccountName());
		iAccount.setCreatedTime(DateUtil.currentTime());
		// 尝试创建账号
		if (accountService.createAccount(iAccount, privilegeId)) {
			model.addAttribute("account_create_msg", "账户创建成功");
			return "account_create";
		}
		model.addAttribute("account_create_msg", "创建账户失败，请检查后重试");
		return "account_create";
	}

	@RequestMapping("updateAccountPage.do/{id}.do")
	public String updateAccountPage(@PathVariable int id,Model model) {
		IAccount iAccount = accountService.queryAccountById(id);
		model.addAttribute("iAccount",iAccount);
		return "account_update";
	}
	
	/**
	 * 修改账号信息
	 * @param iAccount
	 * @param br
	 * @param privilegeId
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("updateAccount.do")
	public String updateAccount(@ModelAttribute("iAccount") @Valid IAccount iAccount, BindingResult br,
			@RequestParam("privilegeId") Integer privilegeId, Model model, HttpSession session) {
		// 账户校验
		if (br.hasErrors()) {
			ObjectError objError = br.getGlobalError();
			if (objError != null) {
				model.addAttribute("account_password_error", objError.getDefaultMessage());
			}
			model.addAttribute("account_update_msg", "修改账户失败，请检查后重试");
			return "account_update";
		}
		//检查员工号是否重复
		if (accountService.empnoExists(iAccount)) {
			model.addAttribute("account_create_msg", "员工号已存在");
			return "account_create";
		}
		// 获取当前登录账户名
		iAccount.setUpdateBy(((IAccount) session.getAttribute("loginAccount")).getAccountName());
		// 尝试创建账号
		if (accountService.updateAccount(iAccount, privilegeId)) {
			model.addAttribute("account_update_msg", "账户修改成功");
			return "account_update";
		}
		model.addAttribute("account_update_msg", "修改账户失败，请检查后重试");
		return "account_update";
	}
	
	@RequestMapping("deleteAccountPage.do/{id}.do")
	public String deleteAccountPage(@PathVariable int id,Model model,RedirectAttributes redirectAttributes) {
		if(accountService.deleteAccount(id)) {
			redirectAttributes.addFlashAttribute("account_list_msg","账号已删除");
		}else {
			redirectAttributes.addFlashAttribute("account_list_msg","删除失败，请稍后重试");
		}
		return "redirect:/account/accountList.do";
	}

}
