package com.sshd.dao;

import java.util.List;

import com.sshd.model.Course;

public interface ICourseDao {
	public List<Course> findByAll();
	public Course findById(int id);
	public void updateIsFinished(int id);
	public void inert(Course course);
}
