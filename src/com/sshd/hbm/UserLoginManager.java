package com.sshd.hbm;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.sshd.model.UserLogin;
import com.sshd.model.UserLogin.TYPE;

public class UserLoginManager {
	public boolean insert(String name,String pwd,TYPE type) {
		Session session=null;
		boolean ok = false;
		try {

			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();

			String hql = "from UserLogin where loginname= ?";
			Query q = session.createQuery(hql);
			q = q.setString(0, name);
			List list = q.list();

			if (list.size() == 0) {

				UserLogin ul = new UserLogin();
				ul.setLoginName(name);
				ul.setPwd(pwd);
				ul.setType(getStringType(type));
				session.save(ul);
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

	public String getStringType(TYPE type) {
		
		String result = null;
		if(TYPE.S==type) {
			result = "S";
		}
		
		if(TYPE.M==type) {
			result = "M";
		}
		
		if(TYPE.T==type) {
			result = "T";
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		UserLoginManager um=new UserLoginManager();
		um.insert("12", "333", TYPE.M);
	}
	
	
}
