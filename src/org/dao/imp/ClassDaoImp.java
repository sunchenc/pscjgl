package org.dao.imp;

import java.util.List;

import org.dao.ClassDao;
import org.model.TbClass;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class ClassDaoImp extends HibernateDaoSupport implements ClassDao {

	@Override
	public TbClass getOneClass(Integer classId) {
		// TODO Auto-generated method stub
		return (TbClass) getHibernateTemplate().find("from TbClass where id=?",classId).get(0);
	}

	@Override
	public void save(TbClass tbclass) {
		getHibernateTemplate().save(tbclass);
		
	}

	@Override
	public List<TbClass> getClassesOfSomeTeacher(String teacherId) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().find("from TbClass c where c.teacher.teacherId=?",teacherId);
	}

	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return getHibernateTemplate().find("from TbClass");
	}

	@Override
	public void update(TbClass tbclass) {
		// TODO Auto-generated method stub
		 getHibernateTemplate().update(tbclass);
	}

	@Override
	public void add(TbClass tbclass) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(tbclass);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(find(id));
	}

	@Override
	public TbClass find(Integer id) {
		// TODO Auto-generated method stub
		List list=getHibernateTemplate().find("from TbClass where id=?",id);
		if(list.size()>0)
			return (TbClass) list.get(0);
		else
		    return null;
	}

	@Override
	public TbClass findClassByName(String className) {
		// TODO Auto-generated method stub
		List list=getHibernateTemplate().find("from TbClass where className=?",className);
		if(list.size()>0)
			return (TbClass) list.get(0);
		else
		    return null;
	}

    
//	public void delete(String teacherId) {
//		// TODO Auto-generated method stub
//		List<TbClass> list=getClassesOfSomeTeacher(teacherId);
//		for(int i=0;i<list.size();i++){
//		getHibernateTemplate().delete(list.get(i));
//	}
//	}

}
