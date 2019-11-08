package com.cheer.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cheer.beans.Staff;
import com.cheer.beans.WorkingHour;
import com.cheer.dao.base.BaseDAO;
import com.cheer.mapper.WorkingHourMapper;

@Repository("workingHourDAO")
public class WorkingHourDAOImpl extends BaseDAO implements WorkingHourMapper{

	@Override
	public int insertWorkingHour(WorkingHour workingHour) {
		String sql = "insert into i_working_hour (empno,working_date,duration,created_by,created_time) values"
				+ "(?,?,?,?,now())";
		int row = getJdbcTemplate().update(sql,new Object[]{workingHour.getStaff().getEmpno(),workingHour.getWorkingDateAsStr(),
				workingHour.getDuration(),workingHour.getCreatedBy()});
		return row;
	}

	@Override
	public int updateWorkingHour(WorkingHour workingHour) {
		String sql = "update i_working_hour set duration=?,update_by=?,update_time=now(),version=version+1 where empno=? and working_date=?";
		int row = getJdbcTemplate().update(sql,new Object[] {workingHour.getDuration(),workingHour.getUpdateBy(),
				workingHour.getStaff().getEmpno(),workingHour.getWorkingDateAsStr()});
		return row;
	}

	@Override
	public int querySumDurationByEmpno(String empno, String startDate) {
		String sql = "select sum(duration) sum from i_working_hour where empno=? and working_date>=?";
		List<Map<String,Object>> queryList = getJdbcTemplate().queryForList(sql, new Object[] {empno,startDate});
		BigDecimal sum = (BigDecimal) queryList.get(0).get("sum");
		if(sum == null) {
			return 0;
		}
		return sum.intValue();
	}

	@Override
	public WorkingHour queryWorkingHourToday(WorkingHour workingHour) {
		String sql = "select id,duration,working_date from i_working_hour where empno=? and working_date = ?";
		List<Map<String,Object>> queryList = getJdbcTemplate().queryForList(sql, new Object[] {workingHour.getStaff().getEmpno(),workingHour.getWorkingDateAsStr()});
		if(queryList.size()>0) {
			WorkingHour wh = new WorkingHour();
			wh.setId((Integer)queryList.get(0).get("id"));
			wh.setDuration((Integer)queryList.get(0).get("duration"));
			wh.setWorkingDate((Date)queryList.get(0).get("working_date"));
			return wh;
		}
		return null;
	}

}
