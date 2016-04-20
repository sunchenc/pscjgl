package org.action;
import java.util.List;
import java.util.Map;
import org.model.TbLogin;
import org.model.TbStudent;
import org.model.TbWork;
import org.service.AddStudentService;
import org.service.WorkService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class StudentViewTotalAction extends ActionSupport  {
    private AddStudentService addStudentService; //5.19为了查某老师的所有学生加
    private WorkService workService;
    
	public void setAddStudentService(AddStudentService addStudentService) {
		this.addStudentService = addStudentService;
	}

	public void setWorkService(WorkService workService) {
		this.workService = workService;
	}

	@Override
	public String execute()throws Exception{
     	 Map session=ActionContext.getContext().getSession();
		 TbLogin user=(TbLogin) session.get("user");
	     TbStudent st= addStudentService.find(user.getId());
	     List<TbWork> works=workService.findWorkOfSomeStudent(user.getId());	 
	     if(works.size()>0||st!=null)
	     {
		 Map request=(Map)ActionContext.getContext().get("request");
		 if(works.size()>0)
		 { 
		   request.put("list",works);	
		 }
		 if(st!=null)
		 {
		   request.put("total",st.getTotalGrade() );
		 }
	     return SUCCESS;
		}
		else
		 return ERROR;
		
	}
}
