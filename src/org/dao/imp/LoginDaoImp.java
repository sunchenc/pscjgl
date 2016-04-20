package org.dao.imp;

import java.util.List;
import org.dao.LoginDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.TbLogin;
import org.model.TbStudent;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class LoginDaoImp extends HibernateDaoSupport implements LoginDao {
	@Override
	public TbLogin find(String id, String password, Integer iden) {
//		try{
		Session session=getHibernateTemplate().getSessionFactory().openSession();
		Transaction ts=session.beginTransaction();
		Query query=session.createQuery("from TbLogin where id=? and password=? and iden=?");
		query.setParameter(0,id);
	    query.setParameter(1,password);
	    query.setParameter(2,iden);
		List list=query.list();
		ts.commit();
		session.close();
//		session=null;
//		return (TbLogin)list.get(0);
//		}catch(Exception e){
//			e.printStackTrace();
//			return null;
//		}
		if(list.size()>0)
 		 return (TbLogin)list.get(0);
		else
		 return null;
	}

	public void addOne(String id, String password, Integer iden) {
		 TbLogin s=new TbLogin();
		 s.setId(id);
		 s.setPassword(password);
		 s.setIden(iden);
		 getHibernateTemplate().save(s);
		
	}

	@Override
	public void modify(TbLogin login) {
		// TODO Auto-generated method stub
		 getHibernateTemplate().update(login);
	}
    public TbLogin findOne(String id){
    	List list=getHibernateTemplate().find("from TbLogin where id=?", id);
    	if(list.size()>0)
			return (TbLogin)list.get(0);
		else
		    return null;
    	 
    }
	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(findOne(id));
	}

}
