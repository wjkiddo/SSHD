package com.sshd.hbm;

import org.hibernate.Session;

import com.sshd.model.Course;

public class CourseManager {
	

	public boolean insert(String name, String schooltime, float credit,
			int teacherId, int maxnum) {
		Session session = null;
		boolean ok = true;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();

			Course c = new Course();
			c.setName(name);
			c.setSchoolTime(schooltime);
			c.setCredit(credit);
			c.setTeacherId(teacherId);
			c.setMaxNum(maxnum);
			session.save(c);
			session.getTransaction().commit();

		} catch (Exception e) {
			System.out.println(e);
			session.getTransaction().rollback();
			ok = false;
		} finally {
			HibernateUtil.getSessionFactory().close();
		}
		return ok;
	}
}
