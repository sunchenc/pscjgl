package org.action;

import java.util.List;
import java.util.Map;

import org.model.TbClass;
import org.model.TbTeacher;
import org.service.AddTeacherService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShowTeacherAction extends ActionSupport {
	private AddTeacherService addTeacherService;
	private TbTeacher teacher;
	public void setAddTeacherService(AddTeacherService addTeacherService) {
		this.addTeacherService = addTeacherService;
	}
	
	public TbTeacher getTeacher() {
		return teacher;
	}

	public void setTeacher(TbTeacher teacher) {
		this.teacher = teacher;
	}

	public String updateTeacherView()throws Exception{
		TbTeacher teacher1=addTeacherService.find(teacher.getTeacherId());
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("teacher1", teacher1);
		return SUCCESS;
	}
	public String updateTeacher()throws Exception{
		TbTeacher tbTeacher=addTeacherService.find(teacher.getTeacherId());
		tbTeacher.setTeacherName(teacher.getTeacherName());
		Map request=(Map)ActionContext.getContext().get("request");
		addTeacherService.update(tbTeacher);
		return SUCCESS;
	}
	@Override
	public String execute() throws Exception {
		  List list= addTeacherService.findAll();
			if(list.size()>0){
				Map request=(Map)ActionContext.getContext().get("request");
				request.put("list", list);
				return SUCCESS;
			}else
				return ERROR;
	   }
}
