package org.service.imp;

import java.util.List;

import org.dao.AddStudentDao;
import org.dao.ClassDao;
import org.dao.WorkDao;
import org.model.TbWork;
import org.service.WorkService;

public class WorkServiceManage implements WorkService {
  private WorkDao workDao;
  private ClassDao classDao;   //5.13为了查看某老师全部学生的成绩而加
  private AddStudentDao addStudentDao;  //5.13为了查看某老师全部学生的成绩而加
  
	public void setWorkDao(WorkDao workDao) {
	this.workDao = workDao;
}

	public void setClassDao(ClassDao classDao) {
		this.classDao = classDao;
	}

	public void setAddStudentDao(AddStudentDao addStudentDao) {
		this.addStudentDao = addStudentDao;
	}

	@Override
	public boolean uploadwork(String path, String studentId,Integer cishu,String liuyan) {
		// TODO Auto-generated method stub
		return workDao.uploadwork(path, studentId,cishu,liuyan);
	}

	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return workDao.findAll();
	}

	public void update(TbWork work) {
		workDao.update(work);
		
	}

	@Override
	public TbWork find(Integer id) {
		// TODO Auto-generated method stub
		return workDao.find(id);
	}

	@Override
	public List<TbWork> findWorkOfSomeStudent(String studentId) {
		// TODO Auto-generated method stub
		return workDao.findWorkOfSomeStudent(studentId);
	}
	public List<TbWork> findAllOfOneTeacher(String teacherId){
		return workDao.findAllOfOneTeacher(teacherId);
	}

	@Override
	public TbWork findOne(String studentId, Integer cishu) {
		// TODO Auto-generated method stub
		return workDao.findOne(studentId, cishu);
	}

}
