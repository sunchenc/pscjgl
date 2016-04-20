package org.service;

import java.sql.SQLException;
import java.util.List;

import org.model.TbStudent;
import org.model.TbTeacher;

public interface AddTeacherService {
	public boolean saveTeacherFromExcel(List<TbTeacher> list) throws SQLException;
	public List findAll();
	public TbTeacher find(String id);
 	public void delete(String id);
	public boolean add(TbTeacher teacher);
	public void update(TbTeacher teacher);
}
