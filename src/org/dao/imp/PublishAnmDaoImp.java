package org.dao.imp;


import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.dao.PublishAnmDao;
import org.model.Announcement;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class PublishAnmDaoImp extends HibernateDaoSupport implements PublishAnmDao{

	@Override
	public void add(String title, String content) throws ParseException {
		Announcement announcement=new Announcement();
		announcement.setTitle(title);
		announcement.setContent(content);
	    Date dt=new Date();
//	     SimpleDateFormat matter1=new SimpleDateFormat("yyyy-MM-dd");   
//	     Date today = matter1.parse(matter1.format(dt));  
		Timestamp nousedate = new Timestamp(dt.getTime());
		announcement.setTime(nousedate);
		getHibernateTemplate().save(announcement);
		
	}

	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return getHibernateTemplate().find("from Announcement"); 
	}

	@Override
	public void delete(Integer id) {
		getHibernateTemplate().delete(find(id));
		
	}

	@Override
	public Announcement find(Integer id) {
		// TODO Auto-generated method stub
		List list=getHibernateTemplate().find("from Announcement where id=?",id);
		if(list.size()>0)
			return (Announcement)list.get(0);
		else
		    return null;
	}
}
