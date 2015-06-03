package com.sshd.hbm;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.sshd.model.Teacher;

public class TeacherManager {


	public boolean insert(String name, String teacherNo) {
		Session session = null;
		boolean ok = true;
		try {

			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();

			String hql = "from Teacher where teacherid	 = ?";
			Query q = session.createQuery(hql);
			q = q.setString(0, teacherNo);
			List list = q.list();

			if (list.size() == 0) {

				Teacher t = new Teacher();
				t.setName(name);
				t.setTeacherNo(teacherNo);
				session.save(t);
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
		TeacherManager tm =new TeacherManager();
		boolean ok = tm.insert("sdfsd", "sdfsd");
		System.out.println(ok);
	}
}
