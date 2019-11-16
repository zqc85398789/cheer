package com.cheer.service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cheer.mybatis.mapper.IStaffMapper;
import com.cheer.mybatis.model.IStaff;

@Service
public class StaffService {
	@Autowired
	IStaffMapper iStaffMapper;
	
	
	public int getMaxPage(IStaff iStaff) {
		int quantity = 5;
		try {
			int row = iStaffMapper.countIStaff(iStaff).intValue();
			return row%quantity==0?(row/quantity):(row/quantity+1);
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public List<IStaff> queryStaff(IStaff iStaff, int queryPage) {
		int quantity = 5;
		int start = quantity*(queryPage-1);
		List<IStaff> iStaffList = iStaffMapper.queryIStaffInPage(iStaff,start,quantity);
		return iStaffList;
	}

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
}
