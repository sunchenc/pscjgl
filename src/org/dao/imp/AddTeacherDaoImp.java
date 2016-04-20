package org.dao.imp;
import java.sql.SQLException;
import java.util.List;

import org.dao.AddTeacherDao;
import org.model.TbStudent;
import org.model.TbTeacher;
import org.service.LoginService;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class AddTeacherDaoImp extends HibernateDaoSupport implements AddTeacherDao{
	private LoginService loginService;
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	@Override
	public boolean saveTeacherFromExcel(List<TbTeacher> list)
			throws SQLException {
		if(list.size()<=0)
			return false;
		 for(TbTeacher tt:list){
			 if( find(tt.getTeacherId())!=null){
				find(tt.getTeacherId()).setTeacherName(tt.getTeacherName());
			    getHibernateTemplate().update(find(tt.getTeacherId()));
			 }
			 else{
			 TbTeacher t=new TbTeacher();
			 t.setTeacherId(tt.getTeacherId());
			 t.setTeacherName(tt.getTeacherName());
			 getHibernateTemplate().save(t);
			 loginService.addOne(tt.getTeacherId(),tt.getTeacherId(),1);
		   }
		 }
         return true;  
	}

	@Override
	public List findAll() {
		return getHibernateTemplate().find("from TbTeacher");
	}


	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(find(id));
	}

	@Override
	public TbTeacher find(String id) {
		// TODO Auto-generated method stub
		List list=getHibernateTemplate().find("from TbTeacher where teacherId=?",id);
		if(list.size()>0)
			return (TbTeacher) list.get(0);
		else
		    return null;
	}

	@Override
	public boolean add(TbTeacher teacher) {
		// TODO Auto-generated method stub
		if( find(teacher.getTeacherId())!=null)
		{
			find(teacher.getTeacherId()).setTeacherName(teacher.getTeacherName());
			getHibernateTemplate().update(find(teacher.getTeacherId()));
			return false;
		}
		else{
			getHibernateTemplate().save(teacher);
			return true;
		}
	}

	@Override
	public void update(TbTeacher teacher) {
		// TODO Auto-generated method stub
		 getHibernateTemplate().update(teacher);
	}
}
