package com.cheer.beans;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;

import com.cheer.util.DateUtil;
import com.cheer.validator.annotation.IsEmpno;
import com.cheer.validator.annotation.IsIdCard;
import com.cheer.validator.annotation.IsTelephone;

public class Staff extends BaseBean {
	@NotBlank(message="{staff.staffName.empty}")
	private String staffName;
	@NotNull(message="{staff.birthDate.empty}")
	@Past(message="{staff.birthDate.past}")
	private Date birthDate;
	private String birthDateAsStr;
	@NotBlank(message="{staff.telephoneNo.empty}")
	@IsTelephone(message="{staff.telephoneNo.pattern}")
	private String telephoneNo;
	@NotBlank(message="{staff.idCard.empty}")
	@IsIdCard(message="{staff.idCard.pattern}")
	private String idCard;
	private String gender;
	private String emergencyContact;
	private String emergencyTel;
	@NotBlank(message="{staff.empno.empty}")
	@IsEmpno(message="{staff.empno.pattern}")
	private String empno;
	private String isActive;
	private Account account;


	public Staff() {
		super();
	}

	public Staff(String staffName, Date birthDate, String telephoneNo, String idCard, String gender,
			String emergencyContact, String emergencyTel, String empno) {
		super();
		this.staffName = staffName;
		this.birthDate = birthDate;
		this.telephoneNo = telephoneNo;
		this.idCard = idCard;
		this.gender = gender;
		this.emergencyContact = emergencyContact;
		this.emergencyTel = emergencyTel;
		this.empno = empno;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getTelephoneNo() {
		return telephoneNo;
	}

	public void setTelephoneNo(String telephoneNo) {
		this.telephoneNo = telephoneNo;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmergencyContact() {
		return emergencyContact;
	}

	public void setEmergencyContact(String emergencyContact) {
		this.emergencyContact = emergencyContact;
	}

	public String getEmergencyTel() {
		return emergencyTel;
	}

	public void setEmergencyTel(String emergencyTel) {
		this.emergencyTel = emergencyTel;
	}

	public String getBirthDateAsStr() {
		if (this.birthDate == null) {
			return "";
		}
		return DateUtil.dateFormat(this.birthDate, DateUtil.DATE_PATTERN);
	}

	public void setBirthDateAsStr(String birthDateAsStr) {
		if (this.birthDate == null) {
			this.birthDateAsStr = "";
		}
		this.birthDateAsStr = DateUtil.dateFormat(this.birthDate, DateUtil.DATE_PATTERN);
	}

	public String getEmpno() {
		return empno;
	}

	public void setEmpno(String empno) {
		this.empno = empno;
	}
	
	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
