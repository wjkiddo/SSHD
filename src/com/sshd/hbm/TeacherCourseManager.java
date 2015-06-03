package com.sshd.hbm;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.sshd.model.TeacherCourse;

public class TeacherCourseManager {
	public boolean insert(int teacherId,int courseId){
		Session session = null;
		boolean ok = true;
		try {

			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();

			String hql = "from TeacherCourse where teacherId = ? and courseId=? ";
			Query q = session.createQuery(hql);
			q.setInteger(0, teacherId);
			q.setInteger(1, courseId);
			List list = q.list();

			if (list.size() == 0) {

				TeacherCourse tc = new TeacherCourse();
				tc.setCourseId(courseId);
				tc.setTeacherId(teacherId);
				session.save(tc);
				session.getTransaction().commit();

			} else {
				ok = false;
			}
		} catch (Exception e) {
			System.out.println(e);
			session.getTransaction().rollback();
			ok = false;
		} finally {
			HibernateUtil.getSessionFactory().close();
		}
		return ok;
		
		
	}
	
	public static void main(String[] args) {
		TeacherCourseManager manager = new TeacherCourseManager();
		System.out.println(manager.insert(123, 456));;
	}
}
