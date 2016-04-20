package org.action;

import java.util.List;
import java.util.Map;

import org.model.TbClass;
import org.service.AddTeacherService;
import org.service.ClassService;
import org.service.PublishAnmService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SeeClassAction  extends ActionSupport{
	   private ClassService classService;
	   private AddTeacherService addTeacherService; //5.24显示可选的老师
	   private TbClass tbClass;

	   public TbClass getTbClass() {
		return tbClass;
	}

	public void setTbClass(TbClass tbClass) {
		this.tbClass = tbClass;
	}

	public void setClassService(ClassService classService) {
		this.classService = classService;
	}
	   
public void setAddTeacherService(AddTeacherService addTeacherService) {
		this.addTeacherService = addTeacherService;
	}

public String updateClassView()throws Exception{
	TbClass tbclass=classService.getOneClass(tbClass.getId());
	List teachers=addTeacherService.findAll();
	Map request=(Map)ActionContext.getContext().get("request");
	request.put("tbclass",tbclass);
	request.put("teachers", teachers);
	return SUCCESS;
}
public String updateClass()throws Exception{
	Integer id=tbClass.getId();
	TbClass tbclass1=classService.getOneClass(id);
	tbclass1.setClassName(tbClass.getClassName());
	tbclass1.setNumber(tbClass.getNumber());
	tbclass1.setTeacher(addTeacherService.find(tbClass.getTeacher().getTeacherId()));
	Map request=(Map)ActionContext.getContext().get("request");
	classService.update(tbclass1);
	return SUCCESS;
}
	@Override
	public String execute() throws Exception {
		  List list= classService.findAll();
			if(list.size()>0){
				Map request=(Map)ActionContext.getContext().get("request");
				request.put("list", list);
				return SUCCESS;
			}else
				return ERROR;
	   }
	}