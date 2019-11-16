package com.cheer.service;


import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cheer.mybatis.mapper.IStaffMapper;
import com.cheer.mybatis.mapper.IWorkingHourMapper;
import com.cheer.mybatis.model.IStaff;
import com.cheer.mybatis.model.IWorkingHour;
import com.cheer.util.DateUtil;

@Service
public class WorkingHourService {
	@Autowired
	IStaffMapper iStaffMapper;
	@Autowired
	IWorkingHourMapper iWorkingHourMapper;
	
	public int getMaxPage(IStaff iStaff) {
		try {
			int row = iStaffMapper.countIStaff(iStaff).intValue();
			int quantity = 5;
			return row%quantity==0?(row/quantity):(row/quantity+1);
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	

	public List<IWorkingHour> queryIWorkingHour(IStaff iStaff, int queryPage) {
		int quantity = 5;
		int start = quantity*(queryPage-1);
		List<IWorkingHour> iWorkingHourList = new ArrayList<IWorkingHour>();
		List<IStaff> iStaffList = iStaffMapper.queryIStaffInPage(iStaff, start, quantity);
		for(IStaff is:iStaffList) {
			IWorkingHour iw = new IWorkingHour();
			iw.setEmpno(is.getEmpno());
			//获取年工时
			if(iWorkingHourMapper.querySumDurationByEmpno(is.getEmpno(), DateUtil.getLastYear(DateUtil.currentTime()))==null) {
				iw.setYearDuration(0);
			}else {
				iw.setYearDuration(iWorkingHourMapper.querySumDurationByEmpno(is.getEmpno(), DateUtil.getLastYear(DateUtil.currentTime())).intValue());
			}
			//获取月工时
			if(iWorkingHourMapper.querySumDurationByEmpno(is.getEmpno(), DateUtil.getLastMonth(DateUtil.currentTime()))==null) {
				iw.setMonthDuration(0);
			}else {
				iw.setMonthDuration(iWorkingHourMapper.querySumDurationByEmpno(is.getEmpno(), DateUtil.getLastMonth(DateUtil.currentTime())).intValue());
			}
			//获取当天工时
			if(iWorkingHourMapper.querySumDurationByEmpno(is.getEmpno(), DateUtil.getToday())==null) {
				iw.setDuration(0);
			}else {
				iw.setDuration(iWorkingHourMapper.querySumDurationByEmpno(is.getEmpno(), DateUtil.getToday()).intValue());
			}
			iw.setiStaff(is);
			iWorkingHourList.add(iw);
		}
		return iWorkingHourList;
	}
	
	public IWorkingHour getWorkingHour(String empno) {
		IStaff iStaff = new IStaff();
		iStaff.setEmpno(empno);
		IStaff ist = iStaffMapper.queryIStaffByEmpno(iStaff).get(0);
		IWorkingHour iwh = new IWorkingHour();
		if(iWorkingHourMapper.querySumDurationByEmpno(iStaff.getEmpno(), DateUtil.getToday())!=null) {
			iwh.setDuration(iWorkingHourMapper.querySumDurationByEmpno(iStaff.getEmpno(), DateUtil.getToday()).intValue());
		}else {
			iwh.setDuration(0);
		}
		iwh.setiStaff(ist);
		return iwh;
	}
	
	public boolean clockIn(IWorkingHour iWorkingHour) {
		try {
			iWorkingHour.setWorkingDate(DateUtil.currentTime());
			IWorkingHour iwh = iWorkingHourMapper.queryWorkingHourToday(iWorkingHour);
			if(iwh==null) {
				iwh = new IWorkingHour();
				iwh.setDuration(iWorkingHour.getDuration());
				iwh.setWorkingDate(DateUtil.currentTime());
				iwh.setCreatedBy(iWorkingHour.getCreatedBy());
				IStaff iStaff = iStaffMapper.queryIStaffByEmpno(iWorkingHour.getiStaff()).get(0);
				iwh.setEmpno(iStaff.getEmpno());
				iwh.setiStaff(iStaff);
				iWorkingHourMapper.insert(iwh);
			}else {
				iwh.setDuration(iWorkingHour.getDuration());
				iwh.setUpdateBy(iWorkingHour.getUpdateBy());
				IStaff iStaff = iStaffMapper.queryIStaffByEmpno(iWorkingHour.getiStaff()).get(0);
				iwh.setiStaff(iStaff);
				iWorkingHourMapper.updateIWorkingHourByEmpno(iwh);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
