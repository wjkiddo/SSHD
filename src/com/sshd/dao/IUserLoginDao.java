package com.sshd.dao;

import com.sshd.model.UserLogin;
import com.sshd.model.UserLogin.TYPE;

public interface IUserLoginDao {
	public UserLogin findByNameAndPwd(String name,String pwd);
	public boolean loginNameExisted(String loginName);
	public boolean insert(UserLogin ul);
	public boolean updatePwd(int id,String pwd);
	public boolean insert(String name,String pwd,TYPE type);
}
