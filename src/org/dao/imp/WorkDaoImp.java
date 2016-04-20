package org.dao.imp;

import java.util.ArrayList;
import java.util.List;

import org.dao.WorkDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.TbWork;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class WorkDaoImp  extends HibernateDaoSupport implements WorkDao{

	public boolean uploadwork(String path, String studentId,Integer cishu,String liuyan) {
		// TODO Auto-generated method stub
		TbWork work=new TbWork();
		work.setStudentId(studentId);
		work.setCishu(cishu);
		work.setPath(path);
		work.setLiuyan(liuyan);
		getHibernateTemplate().save(work);
		return true;
	}

	public List findAll() {
		// TODO Auto-generated method stub
		
		return getHibernateTemplate().find("from TbWork");
	}

	@Override
	public void update(TbWork work) {
	   getHibernateTemplate().update(work);
		
	}

	@Override
	public TbWork find(Integer id) {
		List list=getHibernateTemplate().find("from TbWork where id=?",id);
		if(list.size()>0)
			return (TbWork)list.get(0);
		else
			return null;
	}

	@Override
	public List<TbWork> findWorkOfSomeStudent(String studentId) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().find("from TbWork where studentId=?",studentId);
	}
	public List<TbWork> findAllOfOneTeacher(String teacherId){
//	return (List<TbWork>)getHibernateTemplate().find("select w.id,w.studentId,w.cishu,w.path,w.gradeDetail,w.grade,w.time from TbClass c,TbStudent s,TbWork w where c.teacher.teacherId=? and c.id=s.tbclass.id and s.studentId=w.studentId",teacherId);
    Session session=getHibernateTemplate().getSessionFactory().openSession();
    Transaction ts=session.beginTransaction();
    Query query=session.createQuery("SELECT w.id,w.studentId,w.cishu,w.path,w.gradeDetail,w.grade,w.time FROM TbClass c,TbStudent s,TbWork w WHERE c.teacher.teacherId=? and c.id=s.tbclass.id and s.studentId=w.studentId");
	query.setParameter(0,teacherId);
	List<TbWork> list=query.list();
    ts.commit();
    session.close();
    return list;
    }

	@Override
	public void delete(String studentId) {
		// TODO Auto-generated method stub
		List<TbWork> list=findWorkOfSomeStudent(studentId);
		for(int i=0;i<list.size();i++){
		getHibernateTemplate().delete(list.get(i));
		}
	}

	@Override
	public TbWork findOne(String studentId, Integer cishu) {
		// TODO Auto-generated method stub
//	    Session session=getHibernateTemplate().getSessionFactory().openSession();
//	    Transaction ts=session.beginTransaction();
//	    Query query=session.createQuery("SELECT w.id,w.studentId,w.cishu,w.path,w.gradeDetail,w.grade,w.time,w.liuyan FROM TbWork w WHERE w.studentId=? and w.cishu=?");
//		query.setParameter(0,studentId);
//		query.setParameter(1,cishu);
//		TbWork work=(TbWork) query.list();
//	    ts.commit();
//	    session.close();
//	    return work;
		Object[] o={studentId,cishu}; 
		List<TbWork> list= getHibernateTemplate().find("from TbWork where studentId=? and cishu=?",o);
		if(list.size()>0)
			return (TbWork)list.get(0);
		else
			return null;
	    }
	
}
    
