package org.service;

import java.util.List;

import org.model.TbClass;

public interface ClassService {
	  //插入班级信息
	   public void save(TbClass tbclass);
	   //根据班级ID找班级信息
	   public TbClass getOneClass(Integer classId);
	   //通过老师找班级
	   public List<TbClass> getClassesOfSomeTeacher(String teacherId);
	   public List findAll();
	   public void update(TbClass tbclass);
		public void add(TbClass tbclass);
		   public void delete(Integer id);
		   public TbClass find(Integer id) ;
		   public TbClass findClassByName(String className);
}
