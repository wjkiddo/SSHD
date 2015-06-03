package com.sshd.model;

import java.io.Serializable;

public class Course implements Serializable{
	private int id;
	private String name;
	private String schooltime;
	private float credit;
	private int teacherid;
	private boolean finished;
	private int maxnum;
	private int selectednum;
	private int unselectednum;
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
	public String getSchooltime() {
		return schooltime;
	}
	public void setSchooltime(String schooltime) {
		this.schooltime = schooltime;
	}
	public float getCredit() {
		return credit;
	}
	public void setCredit(float credit) {
		this.credit = credit;
	}
	public int getTeacherid() {
		return teacherid;
	}
	public void setTeacherid(int teacherid) {
		this.teacherid = teacherid;
	}
	public boolean getFinished() {
		return finished;
	}
	public void setFinished(boolean isFinished) {
		this.finished = isFinished;
	}
	public int getMaxnum() {
		return maxnum;
	}
	public void setMaxnum(int maxnum) {
		this.maxnum = maxnum;
	}
	public int getSelectednum() {
		return selectednum;
	}
	public void setSelectednum(int selectednum) {
		this.selectednum = selectednum;
	}
	public int getUnselectednum() {
		return unselectednum;
	}
	public void setUnselectednum(int unselectednum) {
		this.unselectednum = unselectednum;
	}
	
	
	
	
}
