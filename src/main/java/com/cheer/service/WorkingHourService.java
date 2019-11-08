package com.cheer.service;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cheer.beans.Account;
import com.cheer.beans.AccountPrivilege;
import com.cheer.beans.AccountStaff;
import com.cheer.beans.Staff;
import com.cheer.beans.WorkingHour;
import com.cheer.mapper.AccountMapper;
import com.cheer.mapper.AccountPrivilegeMapper;
import com.cheer.mapper.AccountStaffMapper;
import com.cheer.mapper.StaffMapper;
import com.cheer.mapper.WorkingHourMapper;
import com.cheer.util.DateUtil;

@Service
public class WorkingHourService {
	@Resource(name="staffDAO")
	StaffMapper staffDAO;
	@Resource(name="workingHourDAO")
	WorkingHourMapper workingHourDAO;
	
	public int getMaxPage(Staff staff) {
		try {
			int row = staffDAO.countStaff(staff);
			return row%5==0?(row/5):(row/5+1);
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public List<WorkingHour> queryWorkingHour(Staff staff, int queryPage) {
		List<WorkingHour> workingHourList = new ArrayList<WorkingHour>();
		List<Staff> staffList = staffDAO.queryStaff(staff, queryPage);
		for(Staff st:staffList) {
			WorkingHour wh = new WorkingHour();
			wh.setYearDuration(workingHourDAO.querySumDurationByEmpno(st.getEmpno(), DateUtil.getLastYear(DateUtil.currentTime())));
			wh.setMonthDuration(workingHourDAO.querySumDurationByEmpno(st.getEmpno(), DateUtil.getLastMonth(DateUtil.currentTime())));
			wh.setDuration(workingHourDAO.querySumDurationByEmpno(st.getEmpno(), DateUtil.getToday()));
			wh.setStaff(st);
			workingHourList.add(wh);
		}
		return workingHourList;
	}
	
	public WorkingHour getWorkingHour(String empno) {
		Staff staff = new Staff();
		staff.setEmpno(empno);
		Staff st = staffDAO.queryByEmpno(staff);
		WorkingHour wh = new WorkingHour();
		wh.setDuration(workingHourDAO.querySumDurationByEmpno(staff.getEmpno(), DateUtil.getToday()));
		wh.setStaff(st);
		return wh;
	}
	
	public boolean clockIn(WorkingHour workingHour) {
		try {
			workingHour.setWorkingDate(DateUtil.currentTime());
			WorkingHour wh = workingHourDAO.queryWorkingHourToday(workingHour);
			if(wh==null) {
				wh = new WorkingHour();
				wh.setDuration(workingHour.getDuration());
				wh.setWorkingDate(DateUtil.currentTime());
				wh.setCreatedBy(workingHour.getCreatedBy());
				Staff staff = staffDAO.queryByEmpno(workingHour.getStaff());
				wh.setStaff(staff);
				workingHourDAO.insertWorkingHour(wh);
			}else {
				wh.setDuration(workingHour.getDuration());
				wh.setUpdateBy(workingHour.getUpdateBy());
				Staff staff = staffDAO.queryByEmpno(workingHour.getStaff());
				wh.setStaff(staff);
				workingHourDAO.updateWorkingHour(wh);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
