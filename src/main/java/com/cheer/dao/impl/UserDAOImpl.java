package com.cheer.dao.impl;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cheer.beans.User;
import com.cheer.dao.base.BaseDAO;
import com.cheer.dao.inter.IUserDAO;
import com.cheer.util.DateUtil;

@Repository("userDAO")
public class UserDAOImpl extends BaseDAO implements IUserDAO{
	
	@Override
	/**
	 * 添加用户
	 */
	public int addUser(User user) {
		//注册信息包含用户名、密码、真名、生日、创建者、创建时间
		String sql = "insert into user (username,password,legal_name,birth_date,create_by,create_time)"
				+ " values(?,?,?,?,?,?)";
		String format_birth_date = null;
		//若用户没有提交生日信息，做空值处理，防止日期转换异常
		if(user.getBirth_date()!=null) {
			format_birth_date = DateUtil.dateFormat(user.getBirth_date(), DateUtil.DATE_PATTERN);
		}
		int row = getJdbcTemplate().update(sql,new Object[] {user.getUsername(),user.getPassword(),
				user.getLegal_name(),format_birth_date,user.getCreate_by(),DateUtil.dateFormat(user.getCreate_time(), DateUtil.DATETIME_PATTERN)});
		return row;
	}
	
	@Override
	/**
	 * 删除用户
	 */
	public int deleteUser(String username) {
		String sql = "delete from user where username = ?";
		int row = getJdbcTemplate().update(sql,username);
		return row;
	}

	@Override
	/**
	 * 修改用户信息
	 */
	public int updateUser(User user) {
		String sql = "update user set password=?,legal_name=?,birth_date=?,gender=?,tel_no=?,empno=?,permission=?"
				+ "update_by=?,update_time=?,version = version+1 where username=?";
		int row = getJdbcTemplate().update(sql,new Object[] {user.getPassword(),user.getLegal_name(),DateUtil.dateFormat(user.getBirth_date(), DateUtil.DATE_PATTERN),
				user.getGender(),user.getTel_no(),user.getEmpno(),user.getPermission(),user.getUpdate_by(),DateUtil.dateFormat(DateUtil.currentTime(), DateUtil.DATETIME_PATTERN),user.getUsername()});
		return row;
	}

	@Override
	/**
	 * 根据用户名查询用户
	 */
	public User queryByUsername(String username) {
		String sql = "select username,password,legal_name,birth_date,gender,tel_no,empno,permission,"
				+ "create_by,create_time,update_by,update_time,version from user where username=?";
		List<Map<String,Object>> queryList = getJdbcTemplate().queryForList(sql,username);
		if(queryList.size()==0) {
			return null;
		}
		User user = null;
		for(Map<String,Object> row:queryList) {
			user = new User();
			user.setUsername((String)row.get("username"));
			user.setPassword((String)row.get("password"));
			user.setLegal_name((String)row.get("legal_name"));
			user.setBirth_date((Date)row.get("birth_date"));
			user.setGender((String)row.get("gender"));
			user.setTel_no((String)row.get("tel_no"));
			user.setEmpno((String)row.get("empno"));
			user.setPermission((String)row.get("permission"));
			user.setCreate_by((String)row.get("create_by"));
			user.setCreate_time((Date)row.get("create_time"));
			user.setUpdate_by((String)row.get("update_by"));
			user.setUpdate_time((Date)row.get("update_time"));
			user.setVersion((Integer)row.get("version"));
		}
		return user;
	}

	@Override
	/**
	 * 查询所有条目
	 */
	public List<User> queryAll() {
		List<User> userList = new ArrayList<User>();
		String sql = "select username,password,legal_name,birth_date,gender,tel_no,empno,permission,"
				+ "create_by,create_time,update_by,update_time,version from user";
		List<Map<String,Object>> queryList = getJdbcTemplate().queryForList(sql);
		if(queryList.size()==0) {
			return null;
		}
		for(Map<String,Object> row:queryList) {
			User user = new User();
			user.setUsername((String)row.get("username"));
			user.setPassword((String)row.get("password"));
			user.setLegal_name((String)row.get("legal_name"));
			user.setBirth_date((Date)row.get("birth_date"));
			user.setGender((String)row.get("gender"));
			user.setTel_no((String)row.get("tel_no"));
			user.setEmpno((String)row.get("empno"));
			user.setPermission((String)row.get("permission"));
			user.setCreate_by((String)row.get("create_by"));
			user.setCreate_time((Date)row.get("create_time"));
			user.setUpdate_by((String)row.get("update_by"));
			user.setUpdate_time((Date)row.get("update_time"));
			user.setVersion((Integer)row.get("version"));
			userList.add(user);
		}
		return userList;
	}
	
}
