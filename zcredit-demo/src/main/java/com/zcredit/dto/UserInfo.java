package com.zcredit.dto;

public class UserInfo {
	
	private long id;
	private String loginname;
	private String password;
	private String name;
	
	public UserInfo(){}
	
	public UserInfo(long id, String loginname, String password, String name) {
		super();
		this.id = id;
		this.loginname = loginname;
		this.password = password;
		this.name = name;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
