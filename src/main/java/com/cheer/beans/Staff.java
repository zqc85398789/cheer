package com.cheer.beans;

import java.util.Date;

import com.cheer.util.DateUtil;

public class Staff extends BaseBean {
	private String staffName;
	private Date birthDate;
	private String birthDateAsStr;
	private String telephoneNo;
	private String idCard;
	private String gender;
	private String emergencyContact;
	private String emergency_tel;
	private String empno;
	private Account account;


	public Staff() {
		super();
	}

	public Staff(String staffName, Date birthDate, String telephoneNo, String idCard, String gender,
			String emergencyContact, String emergency_tel, String empno) {
		super();
		this.staffName = staffName;
		this.birthDate = birthDate;
		this.telephoneNo = telephoneNo;
		this.idCard = idCard;
		this.gender = gender;
		this.emergencyContact = emergencyContact;
		this.emergency_tel = emergency_tel;
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

	public String getEmergency_tel() {
		return emergency_tel;
	}

	public void setEmergency_tel(String emergency_tel) {
		this.emergency_tel = emergency_tel;
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
	

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
