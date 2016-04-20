package org.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.model.TbClass;
import org.model.TbLogin;
import org.model.TbStudent;
import org.model.TbTeacher;
import org.model.TbWork;
import org.service.AddStudentService;
import org.service.ClassService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShowStudentAction extends ActionSupport {
	private ClassService classService;
	private AddStudentService addStudentService;
	private TbStudent student; //6.7¼Ó
	public void setAddStudentService(AddStudentService addStudentService) {
		this.addStudentService = addStudentService;
	}
	
	public void setClassService(ClassService classService) {
		this.classService = classService;
	}
	
	public TbStudent getStudent() {
		return student;
	}

	public void setStudent(TbStudent student) {
		this.student = student;
	}

	public String updateStudentView()throws Exception{
		TbStudent student1=addStudentService.find(student.getStudentId());
		 Map session=ActionContext.getContext().getSession();
		 TbLogin user=(TbLogin) session.get("user");
	     List<TbClass> classes=classService.getClassesOfSomeTeacher(user.getId());	 
     	 Map request=(Map)ActionContext.getContext().get("request");
		 request.put("student1", student1);
	     if( classes.size()>0)
	     {
		    request.put("classes",classes);	
		 }
		return SUCCESS;
	}
	public String updateStudent()throws Exception{
		TbStudent tbStudent=addStudentService.find(student.getStudentId());
		tbStudent.setStudentName(student.getStudentName());
		tbStudent.setTbclass(classService.getOneClass(student.getTbclass().getId()));
		tbStudent.setTotalGrade(student.getTotalGrade());
		Map request=(Map)ActionContext.getContext().get("request");
		addStudentService.update(tbStudent);
		return SUCCESS;
	}

	public String execute() throws Exception {
	     Map session=ActionContext.getContext().getSession();
		 TbLogin user=(TbLogin) session.get("user");
		 List<TbStudent> list=new ArrayList<TbStudent>();
		 if(user.getIden()==1){
		 List<TbClass> list1=classService.getClassesOfSomeTeacher(user.getId());
		 for(TbClass tc:list1){
		   List<TbStudent> list2= addStudentService.findStudentOfSomeClass(tc.getId());
		   list.addAll(list2);
		 }
		 }
		 if(user.getIden()==0){
			 list= addStudentService.findAll();
		 }
			if(list.size()>0){
				Map request=(Map)ActionContext.getContext().get("request");
				request.put("list", list);
				return SUCCESS;
			}else
				return ERROR;
	   }
}
