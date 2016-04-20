package org.service;

import org.model.TbLogin;

public interface LoginService {
	public TbLogin find(String id,String password,Integer iden);
	public void addOne(String id, String password,Integer iden);
	public void modify(TbLogin login);
}
