package com.cheer.beans;

import java.util.Date;

public class User {
	private Integer id;
	private String username;
	private String password;
	private String legal_name;
	private Date birth_date;
	private String gender;
	private String tel_no;
	private String empno;
	private Date dimission_date;
	private String create_by;
	private Date create_time;
	private String update_by;
	private Date update_time;
	private Integer version;

	public User() {
		super();
	}

	public User(String username, String password, String legal_name) {
		super();
		this.username = username;
		this.password = password;
		this.legal_name = legal_name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLegal_name() {
		return legal_name;
	}

	public void setLegal_name(String legal_name) {
		this.legal_name = legal_name;
	}

	public Date getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getTel_no() {
		return tel_no;
	}

	public void setTel_no(String tel_no) {
		this.tel_no = tel_no;
	}

	public String getEmpno() {
		return empno;
	}

	public void setEmpno(String empno) {
		this.empno = empno;
	}

	public Date getDimission_date() {
		return dimission_date;
	}

	public void setDimission_date(Date dimission_date) {
		this.dimission_date = dimission_date;
	}

	public String getCreate_by() {
		return create_by;
	}

	public void setCreate_by(String create_by) {
		this.create_by = create_by;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public String getUpdate_by() {
		return update_by;
	}

	public void setUpdate_by(String update_by) {
		this.update_by = update_by;
	}

	public Date getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", legal_name=" + legal_name
				+ ", birth_date=" + birth_date + ", gender=" + gender + ", tel_no=" + tel_no + ", empno=" + empno
				+ ", create_by=" + create_by + ", create_time=" + create_time + ", update_by=" + update_by
				+ ", update_time=" + update_time + ", version=" + version + "]";
	}
}
