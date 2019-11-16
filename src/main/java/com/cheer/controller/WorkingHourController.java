package com.cheer.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cheer.controller.base.BaseController;
import com.cheer.mybatis.model.IAccount;
import com.cheer.mybatis.model.IStaff;
import com.cheer.mybatis.model.IWorkingHour;
import com.cheer.service.WorkingHourService;

@Controller
public class WorkingHourController extends BaseController{
	@Resource(name="workingHourService")
	WorkingHourService workingHourService;
	
	@ModelAttribute
	public void setEnconding(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;utf-8");
	}
	
	@RequestMapping("workingHourList.do")
	public String staffList(@ModelAttribute("iStaff") IStaff iStaff,Model model) {
		model.addAttribute("max_page",0);
		return "working_hour_list";
	}
	
	@RequestMapping("queryWorkingHour.do")
	public String queryWorkingHour(@ModelAttribute("iStaff") IStaff iStaff,@RequestParam int queryPage,Model model) {
		List<IWorkingHour> iWorkingHourList = workingHourService.queryIWorkingHour(iStaff,queryPage);
		if(iWorkingHourList.size()==0) {
			model.addAttribute("max_page",0);
			return "working_hour_list";
		}
		int maxPage = workingHourService.getMaxPage(iStaff);
		model.addAttribute("iWorkingHourList",iWorkingHourList);
		model.addAttribute("max_page",maxPage);
		model.addAttribute("current_page",queryPage);
		return "working_hour_list";
	}
	
	@RequestMapping("updateWorkingHourPage.do/{empno}.do")
	public String updateWorkingHourPage(@PathVariable String empno,Model model) {
		IWorkingHour iwh = workingHourService.getWorkingHour(empno);
		model.addAttribute("iWorkingHour",iwh);
		return "working_hour_update";
	}
	
	@RequestMapping("updateWorkingHour.do")
	public String updateWorkingHour(@ModelAttribute("iWorkingHour") IWorkingHour iWorkingHour,HttpSession session,Model model) {
		String accountName = ((IAccount)session.getAttribute("loginAccount")).getAccountName();
		iWorkingHour.setCreatedBy(accountName);
		iWorkingHour.setUpdateBy(accountName);
		if(workingHourService.clockIn(iWorkingHour)) {
			model.addAttribute("workingHour_update_msg","工时已更新");
			return "working_hour_update";
		}
		model.addAttribute("workingHour_update_msg","更新失败，请检查后重试");
		return "working_hour_update";
	}
}
