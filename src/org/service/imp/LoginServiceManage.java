package org.service.imp;

import org.dao.LoginDao;
import org.model.TbLogin;
import org.service.LoginService;

public class LoginServiceManage implements LoginService{
	
    private LoginDao login;
 	public void setLogin(LoginDao login) {
		this.login = login;
	}

	@Override
	public TbLogin find(String id, String password, Integer iden) {
		return login.find(id, password, iden);
	}

	@Override
	public void addOne(String id, String password, Integer iden) {
		login.addOne(id, password, iden);
		
	}

	@Override
	public void modify(TbLogin log) {
		// TODO Auto-generated method stub
		login.modify(log);
	}
    
}
