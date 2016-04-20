package org.action;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.model.TbClass;
import org.service.AddTeacherService;
import org.service.ClassService;
public class AddClassViewAction extends ActionSupport{
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

	@Override
	public String execute() throws Exception {
		
		List teachers=addTeacherService.findAll();
		Map request=(Map)ActionContext.getContext().get("request");
     	request.put("teachers", teachers);
		return SUCCESS;
	   }
	}
