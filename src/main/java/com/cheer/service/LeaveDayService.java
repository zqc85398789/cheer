package com.cheer.service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cheer.mybatis.mapper.ILeaveDayMapper;
import com.cheer.mybatis.mapper.IStaffMapper;
import com.cheer.mybatis.model.ILeaveDay;
import com.cheer.mybatis.model.IStaff;
import com.cheer.util.DateUtil;


@Service
public class LeaveDayService {
	@Autowired
	ILeaveDayMapper iLeaveDayMapper;
	@Autowired
	IStaffMapper iStaffMapper;
	
	public int getMaxPage(String empno, Date startTime, Date endTime) {
		try {
			String startTimeAsStr = null;
			if(startTime != null) {
				startTimeAsStr = DateUtil.dateFormat(startTime, DateUtil.DATE_PATTERN);
			}
			String endTimeAsStr = null;
			if(endTime != null) {
				endTimeAsStr = DateUtil.dateFormat(endTime, DateUtil.DATE_PATTERN);
			}
			int row = iLeaveDayMapper.countILeaveDay(empno,startTimeAsStr,endTimeAsStr).intValue();
			int quantity = 5;
			return row%quantity==0?(row/quantity):(row/quantity+1);
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

//	public List<IWorkingHour> queryIWorkingHour(IStaff iStaff, int queryPage) {
//		int quantity = 5;
//		int start = quantity*(queryPage-1);
//		List<IWorkingHour> iWorkingHourList = new ArrayList<IWorkingHour>();
//		List<IStaff> iStaffList = iStaffMapper.queryIStaffInPage(iStaff, start, quantity);
//		for(IStaff is:iStaffList) {
//			IWorkingHour iw = new IWorkingHour();
//			iw.setEmpno(is.getEmpno());
//			//获取年工时
//			if(iWorkingHourMapper.querySumDurationByEmpno(is.getEmpno(), DateUtil.getLastYear(DateUtil.currentTime()))==null) {
//				iw.setYearDuration(0);
//			}else {
//				iw.setYearDuration(iWorkingHourMapper.querySumDurationByEmpno(is.getEmpno(), DateUtil.getLastYear(DateUtil.currentTime())).intValue());
//			}
//			//获取月工时
//			if(iWorkingHourMapper.querySumDurationByEmpno(is.getEmpno(), DateUtil.getLastMonth(DateUtil.currentTime()))==null) {
//				iw.setMonthDuration(0);
//			}else {
//				iw.setMonthDuration(iWorkingHourMapper.querySumDurationByEmpno(is.getEmpno(), DateUtil.getLastMonth(DateUtil.currentTime())).intValue());
//			}
//			//获取当天工时
//			if(iWorkingHourMapper.querySumDurationByEmpno(is.getEmpno(), DateUtil.getToday())==null) {
//				iw.setDuration(0);
//			}else {
//				iw.setDuration(iWorkingHourMapper.querySumDurationByEmpno(is.getEmpno(), DateUtil.getToday()).intValue());
//			}
//			iw.setiStaff(is);
//			iWorkingHourList.add(iw);
//		}
//		return iWorkingHourList;
//	}
	
//	public IWorkingHour getWorkingHour(String empno) {
//		IStaff iStaff = new IStaff();
//		iStaff.setEmpno(empno);
//		IStaff ist = iStaffMapper.queryIStaffByEmpno(iStaff).get(0);
//		IWorkingHour iwh = new IWorkingHour();
//		if(iWorkingHourMapper.querySumDurationByEmpno(iStaff.getEmpno(), DateUtil.getToday())!=null) {
//			iwh.setDuration(iWorkingHourMapper.querySumDurationByEmpno(iStaff.getEmpno(), DateUtil.getToday()).intValue());
//		}else {
//			iwh.setDuration(0);
//		}
//		iwh.setiStaff(ist);
//		return iwh;
//	}
	
	public List<ILeaveDay> queryILeaveDay(String empno, Date startTime, Date endTime, int queryPage) {
		int quantity = 5;
		int start = quantity*(queryPage-1);
		String startTimeAsStr = null;
		if(startTime != null) {
			startTimeAsStr = DateUtil.dateFormat(startTime, DateUtil.DATE_PATTERN);
		}
		String endTimeAsStr = null;
		if(endTime != null) {
			endTimeAsStr = DateUtil.dateFormat(endTime, DateUtil.DATE_PATTERN);
		}
		List<ILeaveDay> iLeaveDayList = iLeaveDayMapper.queryILeaveDayInPage(empno, startTimeAsStr,endTimeAsStr,start, quantity);
		return iLeaveDayList;
	}

	public int queryTotalDays(String empno, Date startTime, Date endTime) {
		String startTimeAsStr = null;
		if(startTime != null) {
			startTimeAsStr = DateUtil.dateFormat(startTime, DateUtil.DATE_PATTERN);
		}
		String endTimeAsStr = null;
		if(endTime != null) {
			endTimeAsStr = DateUtil.dateFormat(endTime, DateUtil.DATE_PATTERN);
		}
		int totalDays = iLeaveDayMapper.querySumDaysByEmpno(empno,startTimeAsStr,endTimeAsStr).intValue();
		return totalDays;
	}

	public ILeaveDay getILeaveDay(Integer id) {
		try {
			ILeaveDay iLeaveDay = iLeaveDayMapper.selectByPrimaryKey(id);
			if(iLeaveDay == null) {
				return null;
			}
			IStaff iStaff = new IStaff();
			iStaff.setEmpno(iLeaveDay.getEmpno());
			IStaff is = iStaffMapper.queryIStaffByEmpno(iStaff).get(0);
			iLeaveDay.setiStaff(is);
			return iLeaveDay;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean updateILeaveDay(ILeaveDay iLeaveDay) {
		int row = iLeaveDayMapper.updateByPrimaryKey(iLeaveDay);
		return row>0;
	}

	public boolean recordExists(ILeaveDay iLeaveDay) {
		ILeaveDay ild = iLeaveDayMapper.queryILeaveDayByDateAndEmpno(iLeaveDay);
		if(ild != null) {
			return true;
		}
		return false;
	}

	public boolean createILeaveDay(ILeaveDay iLeaveDay) {
		int row = iLeaveDayMapper.insert(iLeaveDay);
		return row>0;
	}

}
