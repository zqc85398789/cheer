package com.cheer.mybatis.model;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.cheer.util.DateUtil;
import com.cheer.validator.annotation.IsEmpno;
import com.cheer.validator.annotation.IsPassword;
import com.cheer.validator.annotation.SamePassword;

@SamePassword(field1 = "accountPassword", field2 = "passwordCheck", message = "{account.passwordCheck.differentPassword}")
public class IAccount implements Serializable {
	private Integer id;
	@NotBlank(message = "{account.accountName.empty}")
	@Length(min = 5, max = 20, message = "{account.accountName.outOfLength}")
	private String accountName;
	@NotBlank(message = "{account.accountPassword.empty}")
	@IsPassword(message = "{account.accountPassword.errorPattern}")
	private String accountPassword;
	
	private String passwordCheck;
	@NotBlank(message = "{staff.empno.empty}")
	private String empno;

	private Date createdTime;

	private String createdBy;

	private Date updateTime;

	private String updateBy;

	private Integer version;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountPassword() {
		return accountPassword;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of
	 * the database column i_account.account_password
	 *
	 * @param accountPassword
	 *            the value for i_account.account_password
	 *
	 * @mbggenerated
	 */
	public void setAccountPassword(String accountPassword) {
		this.accountPassword = accountPassword;
	}

	public String getPasswordCheck() {
		return passwordCheck;
	}

	public void setPasswordCheck(String passwordCheck) {
		this.passwordCheck = passwordCheck;
	}

	public String getEmpno() {
		return empno;
	}

	public void setEmpno(String empno) {
		this.empno = empno;
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

	private String createdTimeAsStr;
	private String updateTimeAsStr;

	public String getCreatedTimeAsStr() {
		return DateUtil.dateFormat(this.createdTime, DateUtil.DATE_PATTERN);
	}

	public void setCreatedTimeAsStr(String createdTimeAsStr) {
		this.createdTimeAsStr = DateUtil.dateFormat(this.createdTime, DateUtil.DATE_PATTERN);
	}

	public String getUpdateTimeAsStr() {
		if (this.updateTime == null) {
			return "";
		}
		return DateUtil.dateFormat(this.updateTime, DateUtil.DATE_PATTERN);
	}

	public void setUpdateTimeAsStr(String updateTimeAsStr) {
		if (this.updateTime != null) {
			this.updateTimeAsStr = DateUtil.dateFormat(this.updateTime, DateUtil.DATE_PATTERN);
		} else {
			this.updateTimeAsStr = "";
		}
	}
}