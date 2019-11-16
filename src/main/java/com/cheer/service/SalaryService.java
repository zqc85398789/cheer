package com.cheer.service;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cheer.mybatis.mapper.ILeaveDayMapper;
import com.cheer.mybatis.mapper.ISalaryMapper;
import com.cheer.mybatis.mapper.IStaffMapper;
import com.cheer.mybatis.mapper.IWorkingHourMapper;
import com.cheer.mybatis.model.ISalary;
import com.cheer.mybatis.model.IStaff;
import com.cheer.util.DateUtil;

@Service
public class SalaryService {
	@Autowired
	IStaffMapper iStaffMapper;
	@Autowired
	ISalaryMapper iSalaryMapper;
	@Autowired
	IWorkingHourMapper iWorkingHourMapper;
	@Autowired
	ILeaveDayMapper iLeaveDayMapper;
	
	public boolean empnoExists(IStaff iStaff) {
		List<IStaff> list = iStaffMapper.queryIStaffByEmpno(iStaff);
		if(list.size()==0) {
			return false;
		}
		if(list.get(0).getId().equals(iStaff.getId())) {
			return false;
		}
		return true;
	}
	
	public boolean createStaff(IStaff iStaff) {
		try {
			iStaffMapper.insert(iStaff);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public IStaff queryStaffById(int id) {
		IStaff iStaff = iStaffMapper.selectByPrimaryKey(id);
		return iStaff;
	}

	public boolean updateStaff(IStaff iStaff) {
		int row = 0;
		try {
			row = iStaffMapper.updateByPrimaryKey((iStaff));
		}catch (Exception e) {
			e.printStackTrace();
		}
		return row>0;
	}

	public boolean inActiveStaff(IStaff iStaff) {
		iStaff.setIsActive("N");
		int row = iStaffMapper.changeStatus(iStaff);
		return row>0;
	}
	
	public boolean activeStaff(IStaff iStaff) {
		iStaff.setIsActive("Y");
		int row = iStaffMapper.changeStatus(iStaff);
		return row>0;
	}

	public List<ISalary> querySalary(ISalary iSalary, int queryPage) {
		int quantity = 5;
		int start = quantity*(queryPage-1);
		List<ISalary> iSalaryList = iSalaryMapper.queryISalaryInPage(iSalary,start,quantity);
		for(ISalary isa : iSalaryList) {
			//获取员工信息
			IStaff iStaff = new IStaff();
			iStaff.setEmpno(isa.getEmpno());
			IStaff ist = iStaffMapper.queryIStaffByEmpno(iStaff).get(0);
			isa.setiStaff(ist);
			//计算基本工资
			BigDecimal workHour = iWorkingHourMapper.
					querySumDurationByEmpno(isa.getEmpno(), isa.getFirstDayOfYear());
			if(workHour == null) {
				workHour = new BigDecimal(0);
			}
			BigDecimal leaveDays = iLeaveDayMapper.querySumDaysByEmpno(isa.getEmpno(), isa.getFirstDayOfYear(),isa.getEndOfYear());
			if(leaveDays == null) {
				leaveDays = new BigDecimal(0);
			}
			BigDecimal base = isa.getBasePay().multiply(workHour);
			//计算绩效工资【(总工时-8*请假天数)*1000/365】
			BigDecimal merit = workHour.subtract(leaveDays.multiply(new BigDecimal(8))).divide(new BigDecimal(365),6,RoundingMode.HALF_UP).multiply(new BigDecimal(1000)).setScale(2, BigDecimal.ROUND_UP);
			isa.setMerit(merit.compareTo(new BigDecimal(0))>-1?merit:new BigDecimal(0));
			//计算总额
			BigDecimal sumSalary = base.add(merit).add(isa.getBonus());
			isa.setSumSalary(sumSalary);
			//计算余额
			BigDecimal balance = sumSalary.subtract(isa.getPayed());
			isa.setBalance(balance);
		}
		return iSalaryList;
	}

	public int getMaxPage(ISalary iSalary) {
		int quantity = 5;
		try {
			int row = iSalaryMapper.countISalary(iSalary).intValue();
			return row%quantity==0?(row/quantity):(row/quantity+1);
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public ISalary queryISalaryById(int id) {
		ISalary iSalary = iSalaryMapper.selectByPrimaryKey(id);
		if(iSalary == null) {
			return null;
		}
		IStaff is = new IStaff();
		is.setEmpno(iSalary.getEmpno());
		IStaff iStaff = iStaffMapper.queryIStaffByEmpno(is).get(0);
		iSalary.setiStaff(iStaff);
		return iSalary;
	}

	public boolean updateSalary(ISalary iSalary) {
		int row = iSalaryMapper.updateByPrimaryKey(iSalary);
		return row>0;
	}

	public boolean recordExists(ISalary iSalary) {
		ISalary is= iSalaryMapper.queryISalaryByEmpnoAndYear(iSalary);
		return is!=null;
	}

	public boolean createSalary(ISalary iSalary) {
		int row = iSalaryMapper.insert(iSalary);
		return row>0;
	}
}
