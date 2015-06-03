package com.sshd.model;

import java.io.Serializable;

public class Student implements Serializable{
	private int id;
	private String stuNo;
	private String name;
	private String sex;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStuNo() {
		return stuNo;
	}

	public Student(String stuNo, String name, String sex) {
		super();
		this.stuNo = stuNo;
		this.name = name;
		this.sex = sex;
	}

	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

}
