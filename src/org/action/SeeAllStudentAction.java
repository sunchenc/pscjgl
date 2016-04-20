package org.action;
import java.util.List;
import java.util.Map;
import org.model.TbStudent;
import org.service.AddStudentService;
import org.service.AddTeacherService;
import org.service.ClassService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class SeeAllStudentAction extends ActionSupport {
		private AddStudentService addStudentService;
		public void setAddStudentService(AddStudentService addStudentService) {
			this.addStudentService = addStudentService;
		}
		public String execute() throws Exception {
			 List list= addStudentService.findAll();
	         if(list.size()>0){
					Map request=(Map)ActionContext.getContext().get("request");
					request.put("list", list);
					return SUCCESS;
				}else
					return ERROR;
		   }
	}

