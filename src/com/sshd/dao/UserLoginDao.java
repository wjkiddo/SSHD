package com.sshd.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sshd.hbm.HibernateUtil;
import com.sshd.model.UserLogin;
import com.sshd.model.UserLogin.TYPE;

public class UserLoginDao implements IUserLoginDao {

	@Override
	public UserLogin findByNameAndPwd(String name, String pwd) {
		// TODO Auto-generated method stub
		Session session = null;

		UserLogin result = null;
		Transaction t = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			 t = session.beginTransaction();
			String hql = "from UserLogin where loginname= ? and pwd = ?";
			Query q = session.createQuery(hql);
			q.setString(0, name);
			q.setString(1, pwd);
			List<UserLogin> list = q.list();
			result = list.get(0);
			t.commit();
		} catch (Exception e) {
			System.out.println(e);
			t.rollback();
		}

		return result;

	}

	@Override
	public boolean loginNameExisted(String loginName) {
		// TODO Auto-generated method stub
		Session session = null;
		boolean ok = false;
		Transaction t = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			 t = session.beginTransaction();
			String hql = "from UserLogin where loginname= ?";
			Query q = session.createQuery(hql);
			q = q.setString(0, loginName);
			List list = q.list();

			if (list.size() > 0) {
				ok = true;
			}
			t.commit();
		} catch (Exception e) {
			System.out.println(e);
			ok = false;
			t.rollback();
		}
		return ok;
	}

	@Override
	public boolean insert(UserLogin ul) {
		// TODO Auto-generated method stub
		Session session = null;
		boolean ok = false;
		Transaction t = null;
		try {

			session = HibernateUtil.getSessionFactory().openSession();
			 t = session.beginTransaction();
			if (!loginNameExisted(ul.getLoginName())) {
				session.save(ul);
			
			} else {
ok = false;
			}
			t.commit();
		} catch (Exception e) {
			System.out.println(e);
			ok = false;
			t.rollback();
		}

		return ok;
	}

	@Override
	public boolean updatePwd(int id, String pwd) {
		Session session = null;
		boolean ok = false;
		Transaction t = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			 t = session.beginTransaction();

			String hql = "from UserLogin where id= ?";
			Query q = session.createQuery(hql);
			q.setInteger(0, id);
			List<UserLogin> list = q.list();
			UserLogin ul = list.get(0);
			ul.setPwd(pwd);
			session.save(ul);
			t.commit();
		} catch (Exception e) {
			System.out.println(e);
			ok = false;
			t.rollback();
		}
		return ok;
	}

	public static void main(String[] args) {
		UserLoginDao dao = new UserLoginDao();
		UserLogin ul = new UserLogin();

		ul.setLoginName("0012");
		ul.setPwd("kiddo");
		ul.setType(UserLogin.getStringType(UserLogin.TYPE.S));
		dao.insert(ul);

	}

	@Override
	public boolean insert(String name, String pwd, TYPE type) {

		boolean ok = false;
		Transaction t = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			t = session.beginTransaction();

			if (!loginNameExisted(name)) {
				UserLogin ul = new UserLogin();
				ul.setLoginName(name);
				ul.setPwd(pwd);
				ul.setType(UserLogin.getStringType(type));
				session.save(ul);
				
			} else {
				ok = false;
				System.out.println("existed");
			}
			t.commit();
		} catch (Exception e) {
			System.out.println(e);
			ok = false;
			t.rollback();
		}
		return ok;
	}

}
