package com.cheer.mybatis.mapper;

import com.cheer.mybatis.model.IAccount;
import com.cheer.mybatis.model.IAccountPrivilege;
import com.cheer.mybatis.model.IPrivilege;

import java.util.List;

public interface IAccountPrivilegeMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(IAccountPrivilege record);

	IAccountPrivilege selectByPrimaryKey(Integer id);

	List<IAccountPrivilege> selectAll();

	int updateByPrimaryKey(IAccountPrivilege record);

	int updateAccountPrivilege(IAccountPrivilege iAccountPrivilege);

	IPrivilege queryPrivilegeByIAccount(IAccount iAccount);
}