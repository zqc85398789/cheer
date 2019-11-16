package com.cheer.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cheer.controller.base.BaseController;
import com.cheer.mybatis.model.IAccount;
import com.cheer.mybatis.model.ILeaveDay;
import com.cheer.mybatis.model.IStaff;
import com.cheer.mybatis.model.IWorkingHour;
import com.cheer.service.LeaveDayService;

@Controller
public class LeaveDayController extends BaseController{
	@Resource(name="leaveDayService")
	LeaveDayService leaveDayService;
	
	@ModelAttribute
	public void setEnconding(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;utf-8");
	}
	
	@RequestMapping("leaveDayList.do")
	public String leaveDayList(@ModelAttribute("iLeaveDay")ILeaveDay iLeaveDay,Model model) {
		model.addAttribute("max_page",0);
		return "leave_day_list";
	}
	
	@RequestMapping("queryLeaveDay.do")
	public String queryLeaveDay(@RequestParam("empno")String empno,@RequestParam("startTime")Date startTime,
			@RequestParam("endTime")Date endTime,@RequestParam int queryPage,Model model) {
		if(StringUtils.isEmpty(empno)) {
			model.addAttribute("max_page",0);
			model.addAttribute("leave_day_msg","员工号不能为空");
			return "leave_day_list";
		}
		List<ILeaveDay> iLeaveDayList = leaveDayService.queryILeaveDay(empno,startTime,endTime,queryPage);
		if(iLeaveDayList.size()==0) {
			model.addAttribute("max_page",0);
			model.addAttribute("leave_day_msg","没有查询到数据");
			return "leave_day_list";
		}
		int totalDays = leaveDayService.queryTotalDays(empno,startTime,endTime);
		int maxPage = leaveDayService.getMaxPage(empno, startTime, endTime);
		model.addAttribute("empno",empno);
		model.addAttribute("max_page",maxPage);
		model.addAttribute("current_page",queryPage);
		model.addAttribute("iLeaveDayList",iLeaveDayList);
		model.addAttribute("totalDays",totalDays);
		return "leave_day_list";
	}
	
	@RequestMapping("updateLeaveDatePage.do/{id}.do")
	public String updateLeaveDatePage(@PathVariable Integer id,Model model) {
		ILeaveDay ild = leaveDayService.getILeaveDay(id);
		if(ild == null) {
			model.addAttribute("max_page",0);
			model.addAttribute("leave_day_msg","没有查询到数据");
			return "leave_day_list";
		}
		model.addAttribute("iLeaveDay",ild);
		return "leave_day_update";
	}
	
	@RequestMapping("updateLeaveDay.do")
	public String updateLeaveDay(@ModelAttribute("iLeaveDay") ILeaveDay iLeaveDay,HttpSession session,Model model) {
		String accountName = ((IAccount)session.getAttribute("loginAccount")).getAccountName();
		iLeaveDay.setUpdateBy(accountName);
		if(leaveDayService.updateILeaveDay(iLeaveDay)) {
			model.addAttribute("leave_day_update_msg","工时已更新");
			return "leave_day_update";
		}
		model.addAttribute("leave_day_update_msg","更新失败，请检查后重试");
		return "leave_day_update";
	}
	
	@RequestMapping("createLeaveDayPage.do")
	public String createLeaveDayPage(@ModelAttribute("iLeaveDay")ILeaveDay iLeaveDay) {
		return "leave_day_create";
	}
	
	@RequestMapping("createLeaveDay.do")
	public String createLeaveDay(@ModelAttribute("iLeaveDay") @Valid ILeaveDay iLeaveDay, BindingResult br,
			 Model model, HttpSession session) {
		// 信息校验
		if (br.hasErrors()) {
			model.addAttribute("leave_day_create_msg", "新增记录失败，请检查后重试");
			return "leave_day_create";
		}
		// 检查当日记录是否已存在
		if (leaveDayService.recordExists(iLeaveDay)) {
			model.addAttribute("leave_day_create_msg", "新增记录失败，已存在同日记录");
			return "leave_day_create";
		}
		// 获取当前登录账户名
		iLeaveDay.setCreatedBy(((IAccount) session.getAttribute("loginAccount")).getAccountName());
		// 尝试新增记录
		if (leaveDayService.createILeaveDay(iLeaveDay)) {
			model.addAttribute("leave_day_create_msg", "新增记录成功");
			return "leave_day_create";
		}
		model.addAttribute("leave_day_create_msg", "新增记录失败，请检查后重试");
		return "leave_day_create";
	}
}
