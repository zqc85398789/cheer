package com.cheer.beans;

public class AccountStaff extends BaseBean {
	private String accountId;
	private String staffId;

	public AccountStaff() {
		super();
	}

	public AccountStaff(String accountId, String staffId) {
		super();
		this.accountId = accountId;
		this.staffId = staffId;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

}
