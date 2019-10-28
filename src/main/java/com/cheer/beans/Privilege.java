package com.cheer.beans;

/*
 * 权限类
 * */
public class Privilege extends BaseBean {
	private String privilegeName;
	private String privilegeUrl;

	public Privilege() {
		super();
	}

	public Privilege(String privilegeName, String privilegeUrl) {
		super();
		this.privilegeName = privilegeName;
		this.privilegeUrl = privilegeUrl;
	}

	public String getPrivilegeName() {
		return privilegeName;
	}

	public void setPrivilegeName(String privilegeName) {
		this.privilegeName = privilegeName;
	}

	public String getPrivilegeUrl() {
		return privilegeUrl;
	}

	public void setPrivilegeUrl(String privilegeUrl) {
		this.privilegeUrl = privilegeUrl;
	}

}
