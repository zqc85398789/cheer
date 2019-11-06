package com.cheer.mapper;

import com.cheer.beans.Staff;

public interface StaffMapper {
	public int insertStaff(Staff staff);
	
	public int defaultInsert(Staff staff);
	
	public int lastInsertId();

	public int countStaff(Staff staff);
}
