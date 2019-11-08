package com.cheer.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
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
				+ "emergency_tel,empno,is_active,created_by,created_time) values(?,?,?,?,?,?,?,?,?,?,?)";
		int row = getJdbcTemplate().update(sql,new Object[] {staff.getStaffName(),staff.getBirthDateAsStr(),
				staff.getTelephoneNo(),staff.getIdCard(),staff.getGender(),staff.getEmergencyContact(),staff.getEmergencyTel(),
				staff.getEmpno(),"Y",staff.getCreatedBy(),staff.getCreatedTimeAsStr()});
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
		String sql = "insert into i_staff (staff_name,id_card,empno,is_active,created_by,created_time) values"
				+ "('未登记','未登记','000000','Y',?,?)";
		int row = getJdbcTemplate().update(sql,new Object[] {staff.getCreatedBy(),staff.getCreatedTimeAsStr()});
		return row;
	}
	
	@Override
	public int updateStaff(Staff staff) {
		String sql = "update i_staff set staff_name=?,birth_date=?,telephone_no=?,id_card=?,gender=?,emergency_contact=?,"
				+ "emergency_tel=?,empno=?,update_by=?,update_time=now(),version = version+1 where id=?";
		int row = getJdbcTemplate().update(sql,new Object[] {staff.getStaffName(),staff.getBirthDateAsStr(),
				staff.getTelephoneNo(),staff.getIdCard(),staff.getGender(),staff.getEmergencyContact(),staff.getEmergencyTel(),
				staff.getEmpno(),staff.getUpdateBy(),staff.getId()});
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

	@Override
	public List<Staff> queryStaff(Staff staff, int currentPage) {
		int start = 5*(currentPage-1);
		int quantity = 5;
		String sql = "select id,staff_name,birth_date,telephone_no,id_card,gender,emergency_contact,emergency_tel,"
				+ "empno,is_active,created_by,created_time,update_by,update_time from i_staff where staff_name like ? "
				+ "and empno like ? limit ?,?";
		List<Map<String,Object>> queryList = getJdbcTemplate().queryForList(sql,new Object[] {"%"+staff.getStaffName()+"%","%"+staff.getEmpno()+"%",start,quantity});
		List<Staff> staffList = new ArrayList<Staff>();
		for(Map<String,Object> row:queryList) {
			Staff sf = getStaff(row);
			staffList.add(sf);
		}
		return staffList;
	}

	@Override
	public Staff queryByEmpno(Staff staff) {
		String sql = "select id,staff_name,birth_date,telephone_no,id_card,gender,emergency_contact,emergency_tel," + 
				"empno,created_by,created_time,update_by,update_time from i_staff where empno=?";
		List<Map<String,Object>> queryList = getJdbcTemplate().queryForList(sql,new Object[] {staff.getEmpno()});
		if(queryList.size()>0) {
			return getStaff(queryList.get(0));
		}
		return null;
	}

	@Override
	public Staff queryStaffById(Integer id) {
		String sql = "select id,staff_name,birth_date,telephone_no,id_card,gender,emergency_contact,emergency_tel,"
				+ "empno,created_by,created_time,update_by,update_time from i_staff where id=?";
		List<Map<String,Object>> queryList =  getJdbcTemplate().queryForList(sql,new Object[] {id});
		if(queryList.size()>0) {
			Staff st = getStaff(queryList.get(0));
			return st;
		}
		return null;
	}

	@Override
	public int activeStatus(Staff staff) {
		String sql = "update i_staff set is_active = ? where id =?";
		int row = getJdbcTemplate().update(sql,new Object[] {staff.getIsActive(),staff.getId()});
		return row;
	}
	
	private Staff getStaff(Map<String,Object> row) {
		Staff sf = new Staff();
		sf.setId((Integer)row.get("id"));
		sf.setStaffName((String)row.get("staff_name"));
		sf.setBirthDate((Date)row.get("birth_date"));
		sf.setTelephoneNo((String)row.get("telephone_no"));
		sf.setIdCard((String)row.get("id_card"));
		sf.setGender((String)row.get("gender"));
		sf.setEmergencyContact((String)row.get("emergency_contact"));
		sf.setEmergencyTel((String)row.get("emergency_tel"));
		sf.setEmpno((String)row.get("empno"));
		sf.setIsActive((String)row.get("is_active"));
		sf.setCreatedBy((String)row.get("create_by"));
		sf.setCreatedTime((Date)row.get("create_time"));
		sf.setUpdateBy((String)row.get("update_by"));
		sf.setUpdateTime((Date)row.get("update_time"));
		return sf;
	}

}
