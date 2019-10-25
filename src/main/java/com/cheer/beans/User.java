package com.cheer.beans;

import java.util.Date;

import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class User extends BaseBean{
	private Integer id;
	@NotBlank(message="{user.username.empty}")
	@Length(min=5,max=16,message="{user.username.outofsize}")
	private String username;
	@NotBlank(message="{user.password.empty}")
	@Length(min=8,max=16,message="{user.password.outofsize}")
	private String password;
	@NotBlank(message="{user.password.empty}")
	private String password_check;
	@NotBlank(message="{user.legalname.empty}")
	private String legal_name;
	@Past(message="{user.birthdate.future}")
	private Date birth_date;
	private String gender;
	private String tel_no;
	private String empno;
	private Date dimission_date;
	private String permission;

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

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public String getPassword_check() {
		return password_check;
	}

	public void setPassword_check(String password_check) {
		this.password_check = password_check;
	}
	
}
