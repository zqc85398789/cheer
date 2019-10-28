package com.cheer.beans;

import java.util.Date;

import com.cheer.util.DateUtil;

@SuppressWarnings("unused")
public class BaseBean {
	private Integer id;
	private Date createdTime;
	private String createdBy;
	private Date updateTime;
	private String updateBy;
	private Integer version;
	private String createdTimeAsStr;
	private String updateTimeAsStr;

	public BaseBean() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getCreatedTimeAsStr() {
		return DateUtil.dateFormat(this.createdTime, DateUtil.DATE_PATTERN);
	}

	public void setCreatedTimeAsStr(String createdTimeAsStr) {
		this.createdTimeAsStr = DateUtil.dateFormat(this.createdTime, DateUtil.DATE_PATTERN);
	}

	public String getUpdateTimeAsStr() {
		return DateUtil.dateFormat(this.updateTime, DateUtil.DATE_PATTERN);
	}

	public void setUpdateTimeAsStr(String updateTimeAsStr) {
		this.updateTimeAsStr = DateUtil.dateFormat(this.updateTime, DateUtil.DATE_PATTERN);
	}

}
