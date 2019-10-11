package com.cheer.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cheer.beans.User;
import com.cheer.dao.inter.IUserDAO;
import com.cheer.util.DateUtil;

@Service
public class LoginRegistService {
	
	@Resource(name="userDAO")
	private IUserDAO userDAO;
	
	/**
	 * 登录验证
	 * @param user
	 * @param isAdmin
	 * @return
	 */
	public boolean loginCheck(User user,String isAdmin) {
		if(user.getPassword()==null||"".equals(user.getPassword().trim())) {
			return false;
		}
		User queryUser = userDAO.queryByUsername(user.getUsername());
		if(queryUser == null) {
			return false;
		}
		if(!user.getPassword().equals(queryUser.getPassword())) {
			return false;
		}
		if("Y".equals(isAdmin) && !queryUser.getEmpno().matches("[A][\\d]*")) {
			return false;
		}
		return true;
	}
	
	/**
	 * 注册验证
	 * @param user
	 * @return
	 */
	public boolean registCheck(User user) {
		User queryUser = userDAO.queryByUsername(user.getUsername());
		if(queryUser != null) {
			return false;
		}
		user.setCreate_by(user.getUsername());
		user.setCreate_time(DateUtil.currentTime());
		userDAO.addUser(user);
		return true;
	}
}
