package org.service.imp;

import java.sql.SQLException;
import java.util.List;
import org.dao.AddTeacherDao;
import org.dao.ClassDao;
import org.dao.LoginDao;
import org.model.TbTeacher;
import org.service.AddTeacherService;

public class AddTeacherServiceManage implements AddTeacherService{
	 private AddTeacherDao addTeacherDao;
	  private LoginDao loginDao; //5.14 0:46 加 顺带把login表的该老师也删除
//	 private ClassDao classDao;  //5.14 0:46 加 顺带把class表的该老师也删除
	 public void setAddTeacherDao(AddTeacherDao addTeacherDao) {
		this.addTeacherDao = addTeacherDao;
	}
	 
		public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

	
//		public void setClassDao(ClassDao classDao) {
//			this.classDao = classDao;
//		}

		@Override
		public boolean saveTeacherFromExcel(List<TbTeacher> list)
				throws SQLException {
			// TODO Auto-generated method stub
			return addTeacherDao.saveTeacherFromExcel(list);
		}
		@Override
		public List findAll() {
			return addTeacherDao.findAll();
		}
		@Override
		public void delete(String id) {
			// TODO Auto-generated method stub
		//	List list=classDao.getClassesOfSomeTeacher(id);
		//	if(list==null||list.size()<=0){
				addTeacherDao.delete(id);
				loginDao.delete(id);
	//		}
		
//			classDao.delete(id);
		}
		@Override
		public TbTeacher find(String id) {
			// TODO Auto-generated method stub
			return addTeacherDao.find(id);
		}

		@Override
		public boolean add(TbTeacher teacher) {
			// TODO Auto-generated method stub
			return addTeacherDao.add(teacher);
		}

		@Override
		public void update(TbTeacher teacher) {
			// TODO Auto-generated method stub
			addTeacherDao.update(teacher);
		}

	
}
