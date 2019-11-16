package com.cheer.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cheer.controller.base.BaseController;
import com.cheer.mybatis.mapper.IStaffMapper;
import com.cheer.mybatis.model.IAccount;
import com.cheer.mybatis.model.IStaff;
import com.cheer.service.StaffService;
import com.cheer.util.DateUtil;

@Controller
@RequestMapping("/staff")
public class StaffController extends BaseController{
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
	public String staffList(@ModelAttribute("iStaff") IStaff iStaff,Model model) {
		model.addAttribute("max_page",0);
		return "staff_list";
	}
	
	@RequestMapping("queryStaff.do")
	public String queryStaff(@ModelAttribute("iStaff") IStaff iStaff,@RequestParam int queryPage,Model model) {
		List<IStaff> iStaffList = staffService.queryStaff(iStaff,queryPage);
		if(iStaffList.size()==0) {
			model.addAttribute("max_page",0);
			return "staff_list";
		}
		int maxPage = staffService.getMaxPage(iStaff);
		model.addAttribute("iStaffList",iStaffList);
		model.addAttribute("max_page",maxPage);
		model.addAttribute("current_page",queryPage);
		return "staff_list";
	}
	
	//员工创建页面
	@RequestMapping("createStaffPage.do")
	public String createAccountPage(@ModelAttribute("iStaff") IStaff iStaff) {
		return "staff_create";
	}

	//新建员工页面
	@RequestMapping("createStaff.do")
	public String createAccount(@ModelAttribute("iStaff") @Valid IStaff iStaff, BindingResult br,
			 Model model, HttpSession session) {
		// 信息校验
		if (br.hasErrors()) {
			model.addAttribute("staff_create_msg", "创建账户失败，请检查后重试");
			return "staff_create";
		}
		// 检查员工号是否重复
		if (staffService.empnoExists(iStaff)) {
			model.addAttribute("staff_create_msg", "创建账户失败，员工号已存在");
			return "staff_create";
		}
		// 获取当前登录账户名
		iStaff.setCreatedBy(((IAccount) session.getAttribute("loginAccount")).getAccountName());
		// 尝试创建账号
		if (staffService.createStaff(iStaff)) {
			model.addAttribute("staff_create_msg", "员工添加成功");
			return "staff_create";
		}
		model.addAttribute("staff_create_msg", "员工添加失败，请检查后重试");
		return "staff_create";
	}

	@RequestMapping("updateStaffPage.do/{id}.do")
	public String updateStaffPage(@PathVariable int id,Model model) {
		IStaff iStaff = staffService.queryStaffById(id);
		model.addAttribute("iStaff",iStaff);
		return "staff_update";
	}

	@RequestMapping("updateStaff.do")
	public String updateAccount(@ModelAttribute("iStaff") @Valid IStaff iStaff, BindingResult br,
			Model model, HttpSession session) {
		// 信息校验
		if (br.hasErrors()) {
			model.addAttribute("staff_update_msg", "修改失败，请检查后重试");
			return "staff_update";
		}
		// 检查员工号是否重复
		if (staffService.empnoExists(iStaff)) {
			model.addAttribute("staff_update_msg", "修改失败，员工号已存在");
			return "staff_update";
		}
		// 获取当前登录账户名
		iStaff.setUpdateBy(((IAccount) session.getAttribute("loginAccount")).getAccountName());
		// 修改员工信息
		if (staffService.updateStaff(iStaff)) {
			model.addAttribute("staff_update_msg", "修改成功");
			return "staff_update";
		}
		model.addAttribute("staff_update_msg", "修改失败，请检查后重试");
		return "staff_update";
	}

	@RequestMapping("deleteStaff.do/{id}.do")
	public String deleteStaff(@PathVariable("id")int id,Model model) {
		IStaff iStaff = new IStaff();
		iStaff.setId(id);
		if(staffService.inActiveStaff(iStaff)) {
			model.addAttribute("staff_list_msg","删除成功");
			return "staff_list";
		}
		model.addAttribute("staff_list_msg","操作失败");
		return "staff_list";
	}
	
	@RequestMapping("activeStaff.do/{id}.do")
	public String activeStaff(@PathVariable int id,Model model) {
		IStaff iStaff = new IStaff();
		iStaff.setId(id);
		if(staffService.activeStaff(iStaff)) {
			model.addAttribute("staff_list_msg","激活成功");
			return "staff_list";
		}
		model.addAttribute("staff_list_msg","操作失败");
		return "staff_list";
	}
}
