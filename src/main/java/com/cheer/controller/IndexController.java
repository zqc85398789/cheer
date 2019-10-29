package com.cheer.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cheer.beans.Account;
import com.cheer.beans.Staff;
import com.cheer.controller.base.BaseController;
import com.cheer.util.DateUtil;

@Controller
public class IndexController extends BaseController {
	//首页
	@RequestMapping("homePage.do")
	public String index() {
		return "home_page";
	}
	
	@RequestMapping("account.do")
	public String account(@ModelAttribute("account") Account account,Model model) {
		//实写数据用于测试
		List<Account> accountList = new ArrayList<Account>();
		for(int i=1;i<=5;i++) {
			Account ac = new Account();
			Staff st = new Staff();
			st.setStaffName("Aoyama Nanami");
			st.setEmpno("n000"+i);;
			ac.setId(i);
			ac.setAccountName("Nanami");
			ac.setCreatedBy("admin");
			ac.setCreatedTime(DateUtil.currentTime());
			ac.setStaff(st);
			ac.setUpdateBy("admin");
			ac.setUpdateTime(DateUtil.currentTime());
			accountList.add(ac);
		}
		model.addAttribute("accountList",accountList);
		return "account_list";
	}
}
