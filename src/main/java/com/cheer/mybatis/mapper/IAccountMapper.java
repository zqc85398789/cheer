package com.cheer.mybatis.mapper;

import com.cheer.mybatis.model.IAccount;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface IAccountMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(IAccount record);

	IAccount selectByPrimaryKey(Integer id);

	List<IAccount> selectAll();

	int updateByPrimaryKey(IAccount record);

	public List<IAccount> queryAccounts(IAccount iAccount);
	
	public List<IAccount> queryAccountsByEmpno(IAccount iAccount);
	
	public List<IAccount> queryIAccountInPage(@Param("iAccount")IAccount iAccount,@Param("start")int start,@Param("quantity")int quantity);
	
	public Long countIAccount(IAccount iAccount);
}