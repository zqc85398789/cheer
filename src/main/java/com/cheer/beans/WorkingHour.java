package com.cheer.beans;

import java.util.Date;

import com.cheer.util.DateUtil;

public class WorkingHour extends BaseBean {
	private Integer id;
	private Date workingDate;
	private String empno;
	private String workingDateAsStr;
	private Integer duration;
	private Integer yearDuration;
	private Integer monthDuration;
	private Staff staff;

	public WorkingHour() {
		super();
	}

	public WorkingHour( Date workingDate, Integer duration) {
		super();
		this.workingDate = workingDate;
		this.duration = duration;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getWorkingDate() {
		return workingDate;
	}

	public void setWorkingDate(Date workingDate) {
		this.workingDate = workingDate;
	}

	public String getWorkingDateAsStr() {
		if (this.workingDate == null) {
			return "";
		}
		return DateUtil.dateFormat(this.workingDate, DateUtil.DATE_PATTERN);
	}

	public void setWorkingDateAsStr(String workingDateAsStr) {
		if (this.workingDate == null) {
			this.workingDateAsStr = "";
		}
		this.workingDateAsStr = DateUtil.dateFormat(this.workingDate, DateUtil.DATE_PATTERN);
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Integer getYearDuration() {
		return yearDuration;
	}

	public void setYearDuration(Integer yearDuration) {
		this.yearDuration = yearDuration;
	}

	public Integer getMonthDuration() {
		return monthDuration;
	}

	public void setMonthDuration(Integer monthDuration) {
		this.monthDuration = monthDuration;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public String getEmpno() {
		return empno;
	}

	public void setEmpno(String empno) {
		this.empno = empno;
	}

}
