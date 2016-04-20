package org.service.imp;

import java.sql.SQLException;
import java.util.List;

import org.dao.AddStudentDao;
import org.dao.AddTeacherDao;
import org.dao.ClassDao;
import org.dao.LoginDao;
import org.dao.WorkDao;
import org.model.TbStudent;
import org.service.AddStudentService;

public class AddStudentServiceManage implements AddStudentService{
    private AddStudentDao addStudentDao;
    private LoginDao loginDao; //5.13 22:45加 顺带把login表的该学生也删除
    private WorkDao workDao;   //5.13 22:45加 顺带把work表的该学生的信息也删除
    private ClassDao classDao;  //需要吗？   
	public void setClassDao(ClassDao classDao) {   //需要吗？   
		this.classDao = classDao;                   //需要吗？   
	}
    
	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

	public void setWorkDao(WorkDao workDao) {
		this.workDao = workDao;
	}

	public void setAddStudentDao(AddStudentDao addStudentDao) {
		this.addStudentDao = addStudentDao;
	}

	public boolean saveStudentFromExcel(List<TbStudent> list) throws SQLException {
		return addStudentDao.saveStudentFromExcel(list);
	}


	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return addStudentDao.findAll();
	}

	@Override
	public List<TbStudent> findStudentOfSomeClass(Integer classId) {
		// TODO Auto-generated method stub
		return addStudentDao.findStudentOfSomeClass(classId);
	}

	@Override
	public void delete(String id) {   //5.13 23.22时删除学生添加 
		addStudentDao.delete(id);
		loginDao.delete(id);
		workDao.delete(id);
		
	}

	@Override
	public TbStudent find(String id) {
		// TODO Auto-generated method stub
		return addStudentDao.find(id);
	}

	@Override
	public void update(String studentId, Float totalGrade) {
		// TODO Auto-generated method stub
		addStudentDao.update(studentId, totalGrade);
	}

	@Override
	public boolean add(TbStudent student) {
		// TODO Auto-generated method stub
		return addStudentDao.add(student);
	}

	@Override
	public void update(TbStudent student) {
		// TODO Auto-generated method stub
		addStudentDao.update(student);
	}

	
}
