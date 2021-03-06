package org.service;

import java.sql.SQLException;
import java.util.List;

import org.model.TbStudent;
public interface AddStudentService {
	public boolean saveStudentFromExcel(List<TbStudent> list) throws SQLException;
	public List findAll(); 
	public List<TbStudent> findStudentOfSomeClass(Integer classId);
	public TbStudent find(String id);
	public void delete(String id);
	public void update(String studentId,Float totalGrade);
	public boolean add(TbStudent student);
	public void update(TbStudent student);
}
