package com.cheer.beans;

public class AccountPrivilege extends BaseBean{
	private String accountId;
	private String privilegeId;

	public AccountPrivilege() {
		super();
	}

	public AccountPrivilege(String accountId, String privilegeId) {
		super();
		this.accountId = accountId;
		this.privilegeId = privilegeId;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getPrivilegeId() {
		return privilegeId;
	}

	public void setPrivilegeId(String privilegeId) {
		this.privilegeId = privilegeId;
	}

}
