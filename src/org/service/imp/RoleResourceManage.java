package org.service.imp;

import java.util.List;

import org.dao.RoleResourceDao;
import org.service.RoleResourceService;

public class RoleResourceManage implements RoleResourceService{
	private RoleResourceDao roleResourceDao;
	
	 public void setRoleResourceDao(RoleResourceDao roleResourceDao) {
		this.roleResourceDao = roleResourceDao;
	}

	public List find(Integer iden){
		 return roleResourceDao.find(iden);
	 }
}
