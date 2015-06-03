package com.sshd.action;


import com.opensymphony.xwork2.ActionSupport;
import com.sshd.model.UserLogin;

public class RegAction extends ActionSupport {
	// private IUserLoginDao userLoginDao;
	
	/*
	public void setUserLoginDao(IUserLoginDao userLoginDao){
		this.userLoginDao = userLoginDao;
	}*/
	public String execute(){
		UserLogin userLogin = new UserLogin();
		userLogin.setType("2");
		userLogin.setLoginName(request.getParameter("loginName"));
		userLogin.setPwd(request.getParameter("pwd"));
		if(!userLoginDao.findByLoginName(userLogin.getLoginName())){
			System.out.println("用户名不存在，可以注册");
			Interger id = userLoginDao.insert(userLogin);
			request.getSession().setAttribute("id", id);
			request.getSession().setAttribute("loginName", userLogin.getLoginName());
			//进入填写基本信息页面
			return 
		}
	}
}
