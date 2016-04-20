package org.dao;

import java.sql.SQLException;
import java.util.List;

import org.model.TbClass;
import org.model.TbStudent;
import org.model.TbTeacher;

public interface AddTeacherDao {
	 public boolean saveTeacherFromExcel(List<TbTeacher> list)throws SQLException;
	 public List findAll();
	 public void delete(String id);
	 public TbTeacher find(String id) ;
	 public boolean add(TbTeacher teacher);
	 public void update(TbTeacher teacher);
}
