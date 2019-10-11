package com.cheer.dao.base;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("baseDAO")
public class BaseDAO extends JdbcDaoSupport{
	@Resource(name="dataSource")
	public void initDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
}
