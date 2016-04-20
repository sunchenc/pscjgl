package org.service;

import java.util.List;

import org.model.TbWork;

public interface WorkService {
	 public boolean uploadwork(String path,String student_id,Integer cishu,String liuyan);
     public List findAll(); 
     public void update(TbWork work);
     public TbWork find(Integer id);
     public List<TbWork> findWorkOfSomeStudent(String studentId);
     public List<TbWork> findAllOfOneTeacher(String teacherId);
     public TbWork findOne(String studentId,Integer cishu);
}
