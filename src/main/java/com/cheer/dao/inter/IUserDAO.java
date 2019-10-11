package com.cheer.dao.inter;

import java.util.List;

import com.cheer.beans.User;

public interface IUserDAO {
	public int addUser(User user);

	public int deleteUser(String username);

	public int updateUser(User user);

	public User queryByUsername(String username);

	public List<User> queryAll();
}
