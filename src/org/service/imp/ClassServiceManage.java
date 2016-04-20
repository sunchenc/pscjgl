package org.service.imp;

import java.util.List;

import org.dao.AddTeacherDao;
import org.dao.ClassDao;
import org.model.TbClass;
import org.service.ClassService;

public class ClassServiceManage implements ClassService {

	private ClassDao classDao;
	private AddTeacherDao addTeacherDao;  //5ÔÂ13¼Ó
	
	public void setClassDao(ClassDao classDao) {
		this.classDao = classDao;
	}
    
	public void setAddTeacherDao(AddTeacherDao addTeacherDao) {
		this.addTeacherDao = addTeacherDao;
	}

	@Override
	public TbClass getOneClass(Integer classId) {
		return classDao.getOneClass(classId);
	}

	@Override
	public void save(TbClass tbclass) {
		classDao.save(tbclass);
		
	}

	@Override
	public List<TbClass> getClassesOfSomeTeacher(String teacherId) {
		// TODO Auto-generated method stub
		return classDao.getClassesOfSomeTeacher(teacherId);
	}

	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return classDao.findAll();
	}

	@Override
	public void update(TbClass tbclass) {
		// TODO Auto-generated method stub
		classDao.update(tbclass);
	}

	@Override
	public void add(TbClass tbclass) {
		// TODO Auto-generated method stub
		classDao.add(tbclass);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		classDao.delete(id);
	}

	@Override
	public TbClass find(Integer id) {
		// TODO Auto-generated method stub
		return classDao.find(id);
	}

	@Override
	public TbClass findClassByName(String className) {
		// TODO Auto-generated method stub
		return classDao.findClassByName(className);
	}

	
}
