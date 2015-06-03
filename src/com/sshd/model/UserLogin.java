package com.sshd.model;

import java.io.Serializable;

public class UserLogin implements Serializable {
	public static enum TYPE{
		S,M,T
	}
	private int  id;
	private String pwd;
	private String type;
	private String loginName;
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
