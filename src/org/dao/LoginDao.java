package org.dao;

import org.model.TbLogin;

public interface LoginDao {
	public TbLogin find(String id, String password,Integer iden) ;
	public void addOne(String id, String password,Integer iden);
	public void modify(TbLogin login);
	public TbLogin findOne(String id);
	public void delete(String id);
}
