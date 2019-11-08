package com.cheer.mapper;


import com.cheer.beans.WorkingHour;

public interface WorkingHourMapper {
	public int insertWorkingHour(WorkingHour workinghour);
	
	public int updateWorkingHour(WorkingHour workinghour);
	
	public int querySumDurationByEmpno(String empno,String startDate);
	
	public WorkingHour queryWorkingHourToday(WorkingHour workingHour);
}
