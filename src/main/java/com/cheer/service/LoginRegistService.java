package com.cheer.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cheer.beans.User;
import com.cheer.dao.inter.IUserDAO;
import com.cheer.util.DateUtil;

@Service
public class LoginRegistService {
	
	/*@Resource(name="userDAO")
	private IUserDAO userDAO;
	
	*//**
	 * 登录验证
	 * @param user
	 * @param isAdmin
	 * @return
	 *//*
	public boolean loginCheck(User user) {
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
		if("admin".equals(user.getPermission()) && !"admin".equals(queryUser.getPermission())) {
			System.out.println(user.getPermission());
			System.out.println(queryUser.getPermission());
			return false;
		}
		return true;
	}
	
	*//**
	 * 注册验证
	 * @param user
	 * @return
	 *//*
	public boolean registCheck(User user) {
		User queryUser = userDAO.queryByUsername(user.getUsername());
		if(queryUser != null) {
			return false;
		}
		user.setCreatedBy(user.getUsername());
		user.setCreatedTime(DateUtil.currentTime());
		userDAO.addUser(user);
		return true;
	}*/
}
