package org.dao;

import java.util.List;

import org.model.TbWork;

public interface WorkDao {
  public boolean uploadwork(String path,String student_id,Integer cishu,String liuyan);
  public List findAll();
  public TbWork find(Integer id);
  public void update(TbWork work);
  //通过学生id找所对应work
  public List<TbWork> findWorkOfSomeStudent(String studentId);
  public List<TbWork> findAllOfOneTeacher(String teacherId);
  public void delete(String studentId);
  public TbWork findOne(String studentId,Integer cishu);
}
