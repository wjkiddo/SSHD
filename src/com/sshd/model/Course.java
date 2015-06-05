package com.sshd.model;

import java.io.Serializable;

public class Course implements Serializable{
	private int id;
	private String name;
	private String schoolTime;
	private float credit;
	private int teacherId;
	private boolean finished;
	private int maxNum;
	private int selectedNum;
	private int unSelectedNum;

	public Course(){};
	
	
	public Course(String name, String schoolTime, float credit, int teacherId,
			int maxNum) {
		super();
		this.name = name;
		this.schoolTime = schoolTime;
		this.credit = credit;
		this.teacherId = teacherId;
		this.maxNum = maxNum;
		this.unSelectedNum = maxNum;
	}


	public boolean getFinished() {
		return finished;
	}
	public void setFinished(boolean isFinished) {
		this.finished = isFinished;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSchoolTime() {
		return schoolTime;
	}
	public void setSchoolTime(String schoolTime) {
		this.schoolTime = schoolTime;
	}
	public float getCredit() {
		return credit;
	}
	public void setCredit(float credit) {
		this.credit = credit;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public int getMaxNum() {
		return maxNum;
	}
	public void setMaxNum(int maxNum) {
		this.maxNum = maxNum;
	}
	public int getSelectedNum() {
		return selectedNum;
	}
	public void setSelectedNum(int selectedNum) {
		this.selectedNum = selectedNum;
	}
	public int getUnSelectedNum() {
		return unSelectedNum;
	}
	public void setUnSelectedNum(int unSelectedNum) {
		this.unSelectedNum = unSelectedNum;
	}
	

	
	
	
	
	
}
