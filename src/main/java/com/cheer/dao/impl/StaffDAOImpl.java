package com.cheer.dao.impl;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cheer.beans.Staff;
import com.cheer.dao.base.BaseDAO;
import com.cheer.mapper.StaffMapper;

@Repository("staffDAO")
public class StaffDAOImpl extends BaseDAO implements StaffMapper{

	@Override
	public int insertStaff(Staff staff) {
		String sql = "insert into i_staff (staff_name,birth_date,telephone_no,id_card,gender,emergency_contact,"
				+ "emergency_tel,empno,created_by,created_time) values(?,?,?,?,?,?,?,?,?,?)";
		int row = getJdbcTemplate().update(sql,new Object[] {staff.getStaffName(),staff.getBirthDateAsStr(),
				staff.getTelephoneNo(),staff.getIdCard(),staff.getGender(),staff.getEmergencyContact(),staff.getEmergency_tel(),
				staff.getEmpno(),staff.getCreatedBy(),staff.getCreatedTimeAsStr()});
		return row;
	}

	@Override
	public int lastInsertId() {
		String sql = "select last_insert_id() id";
		List<Map<String,Object>> queryList = getJdbcTemplate().queryForList(sql);
		BigInteger id = (BigInteger)queryList.get(0).get("id");
		return id.intValue();
	}

	@Override
	public int defaultInsert(Staff staff) {
		String sql = "insert into i_staff (staff_name,id_card,empno,created_by,created_time) values"
				+ "('未登记','未登记','000000',?,?)";
		int row = getJdbcTemplate().update(sql,new Object[] {staff.getCreatedBy(),staff.getCreatedTimeAsStr()});
		return row;
	}

	@Override
	public int countStaff(Staff staff) {
		String sql = "select count(id) count from i_staff where staff_name like ? and empno like ?";
		List<Map<String,Object>> queryList = getJdbcTemplate().queryForList(sql,new Object[] {
				"%"+staff.getStaffName()+"%","%"+staff.getEmpno()+"%"});
		long count = (Long)queryList.get(0).get("count");
		return (int)count;
	}

}
