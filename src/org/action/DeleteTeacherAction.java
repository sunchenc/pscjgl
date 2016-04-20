package org.action;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.model.TbStudent;
import org.model.TbTeacher;
import org.service.AddStudentService;
import org.service.AddTeacherService;
import org.service.ClassService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteTeacherAction extends ActionSupport{
	private AddTeacherService addTeacherService;
	private TbTeacher teacher; //5.13 22点添加 为了删除某个学生加
	private ClassService classService;	
 	

	public TbTeacher getTeacher() {
		return teacher;
	}

	public void setTeacher(TbTeacher teacher) {
		this.teacher = teacher;
	}

	public void setAddTeacherService(AddTeacherService addTeacherService) {
		this.addTeacherService = addTeacherService;
	}

	public void setClassService(ClassService classService) {
		this.classService = classService;
	}

	@Override
	public String execute()throws Exception{
		HttpServletResponse response = (HttpServletResponse)ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_RESPONSE);    
		response.setContentType("text/html;charset=UTF-8"); 
		response.setCharacterEncoding("UTF-8");//防止弹出的信息出现乱码  
		PrintWriter out = response.getWriter();
		String id=teacher.getTeacherId();
		List list=classService.getClassesOfSomeTeacher(id);
		if(list==null||list.size()<=0)
    	{
		addTeacherService.delete(id);
    	out.print("<script>alert('删除成功！')</script>");
	    out.print("<script>window.location.href='showTeacher.action'</script>");
		out.flush();
		out.close();
    	return SUCCESS;
    	}
		else{
			out.print("<script>alert('删除失败！')</script>");
		    out.print("<script>window.location.href='showTeacher.action'</script>");
			out.flush();
			out.close();
	    	return ERROR;
		}
	
	}
}

