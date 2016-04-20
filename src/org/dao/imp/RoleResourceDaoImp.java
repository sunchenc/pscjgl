package org.dao.imp;

import java.util.List;
import org.dao.RoleResourceDao;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class RoleResourceDaoImp extends HibernateDaoSupport implements RoleResourceDao {
	public List find(Integer iden) {
		// TODO Auto-generated method stub
		
		return getHibernateTemplate().find("from RoleResource where iden=?",iden);
	}
	
}
