package com.cheer.mapper;

import java.util.List;

import com.cheer.beans.Staff;

public interface StaffMapper {
	public int insertStaff(Staff staff);
	
	public int defaultInsert(Staff staff);
	
	public int updateStaff(Staff staff);
	
	public int lastInsertId();

	public int countStaff(Staff staff);
	
	public int activeStatus(Staff staff);
	
	public List<Staff> queryStaff(Staff staff,int currentPage);
	
	public Staff queryByEmpno(Staff staff);
	
	public Staff queryStaffById(Integer id);
}
