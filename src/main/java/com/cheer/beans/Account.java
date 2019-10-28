package com.cheer.beans;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.cheer.validator.annotation.IsPassword;
import com.cheer.validator.annotation.SamePassword;

/*
 * 账号类
 * */
@SamePassword(field1="accountPassword",field2="passwordCheck",message="{account.passwordCheck.differentPassword}")
public class Account extends BaseBean {
	@NotBlank(message="{account.accountName.empty}")
	@Length(min=5,max=20,message="{account.accountName.outOfLength}")
	private String accountName;
	@NotBlank(message="{account.accountPassword.empty}")
	@IsPassword(message="{account.accountPassword.errorPattern}")
	private String accountPassword;
	private String passwordCheck;

	public Account() {
		super();
	}

	public Account(String accountName, String accountPassword, String passwordCheck) {
		super();
		this.accountName = accountName;
		this.accountPassword = accountPassword;
		this.passwordCheck = passwordCheck;
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

	public void setAccountPassword(String accountPassword) {
		this.accountPassword = accountPassword;
	}

	public String getPasswordCheck() {
		return passwordCheck;
	}

	public void setPasswordCheck(String passwordCheck) {
		this.passwordCheck = passwordCheck;
	}

}
