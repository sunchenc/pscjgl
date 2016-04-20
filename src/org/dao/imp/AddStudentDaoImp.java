package org.dao.imp;
import java.sql.SQLException;
import java.util.List;
import org.dao.AddStudentDao;
import org.hibernate.FlushMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.model.TbStudent;
import org.service.LoginService;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
public class AddStudentDaoImp extends HibernateDaoSupport implements AddStudentDao{
	
	private LoginService loginService;
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	public boolean saveStudentFromExcel(List<TbStudent> list)
			throws SQLException {
		if(list.size()<=0)
			return false;
		 for(TbStudent stu:list){
		   if( find(stu.getStudentId())!=null)
			{
			find(stu.getStudentId()).setStudentName(stu.getStudentName());
			find(stu.getStudentId()).setTbclass((stu.getTbclass()));
			getHibernateTemplate().update(find(stu.getStudentId()));
			}
			else{		 
			 TbStudent s=new TbStudent();
			 s.setStudentId(stu.getStudentId());
			 s.setStudentName(stu.getStudentName());
			 s.setTbclass(stu.getTbclass());
//			 if(stu.getTotalGrade()==null){
//				 s.setTotalGrade(new Float(0));
//			 } 
//			 else{
				 s.setTotalGrade(stu.getTotalGrade());
		//	 }
			 getHibernateTemplate().save(s);   
	     	 loginService.addOne(stu.getStudentId(),stu.getStudentId(),2);
		 }
		 }
		   return true;
	}

	public List findAll() {
		// TODO Auto-generated method stub
	  return getHibernateTemplate().find("from TbStudent");
	}

	public List<TbStudent> findStudentOfSomeClass(Integer classId) {
	//	return getHibernateTemplate().find("from TbStudent.tbclass c where c.id=?",classId);
		return getHibernateTemplate().find("from TbStudent c where c.tbclass.id=?",classId);
	}
    


	@Override
	public TbStudent find(String id) {
		// TODO Auto-generated method stub
		List list=getHibernateTemplate().find("from TbStudent where studentId=?",id);
		if(list.size()>0)
			return (TbStudent) list.get(0);
		else
		    return null;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(find(id));
	}

	@Override
	public void update(String studentId,Float totalGrade) {   //整合总成绩 5.19
		// TODO Auto-generated method stub
         
        Session session=getHibernateTemplate().getSessionFactory().openSession();
		Transaction ts=session.beginTransaction();
		Query query=session.createQuery("update TbStudent set totalGrade=? where studentId=?");
		query.setParameter(0,totalGrade);
	    query.setParameter(1,studentId);
		query.executeUpdate();
		ts.commit();
		session.close();

	}
//	public List findStuTeaClass(){
//	    Session session=getHibernateTemplate().getSessionFactory().openSession();
//	    Transaction ts=session.beginTransaction();
//	    Query query=session.createQuery("SELECT t.teacherName,s.studentId,s.studentName,s.tbclass.className,s.totalGrade FROM TbStudent s,TbTeacher t WHERE s.tbclass.teacher.teacherId=t.teacherId");
//		List list=query.list();
//	    ts.commit();
//	    session.close();
//	    return list;
//	    }

	@Override
	public boolean add(TbStudent student) {
		// TODO Auto-generated method stub

		if( find(student.getStudentId())!=null)
		{
			find(student.getStudentId()).setStudentName(student.getStudentName());
			find(student.getStudentId()).setTbclass((student.getTbclass()));
			getHibernateTemplate().update(find(student.getStudentId()));
			return false;
		}
		else{
			if(student.getTotalGrade()==null){
				student.setTotalGrade(new Float(0));
			}
			getHibernateTemplate().save(student);
			 return true;
//			Session session=getSessionFactory().openSession();
//			 Transaction ts =session.beginTransaction();
//			
//			 session.save(student);
//		     ts.commit();
//		    
		}
    }

	@Override
	public void update(TbStudent student) {
		// TODO Auto-generated method stub
		 getHibernateTemplate().update(student);
	}
	
}
