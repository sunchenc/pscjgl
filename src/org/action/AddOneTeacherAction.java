package org.action;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.model.TbTeacher;
import org.service.AddTeacherService;
import org.service.LoginService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class AddOneTeacherAction extends ActionSupport{
 	private AddTeacherService addTeacherService;
	private LoginService loginService;  
	private TbTeacher tbTeacher;
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	
	public void setAddTeacherService(AddTeacherService addTeacherService) {
		this.addTeacherService = addTeacherService;
	}
	
	
	public TbTeacher getTbTeacher() {
		return tbTeacher;
	}

	public void setTbTeacher(TbTeacher tbTeacher) {
		this.tbTeacher = tbTeacher;
	}

	public String execute()throws Exception{
//		HttpServletResponse response = (HttpServletResponse)ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_RESPONSE);    
//		response.setContentType("text/html;charset=UTF-8"); 
//		response.setCharacterEncoding("UTF-8");//防止弹出的信息出现乱码  
//		PrintWriter out = response.getWriter();
//		if(tbTeacher.getTeacherId().isEmpty())
//		{
//			out.print("<script>alert('编号不能为空！')</script>");
//		 	 out.print("<script>window.location.href='showTeacher.action'</script>");
//			out.flush();
//			out.close();
//			
//			return ERROR;
//		}
//		if(tbTeacher.getTeacherName().isEmpty())
//		{
//			out.print("<script>alert('姓名不能为空！')</script>");
//			out.print("<script>window.location.href='showTeacher.action'</script>");
//			out.flush();
//			out.close();
//			
//			return ERROR;
//		}
		if(addTeacherService.add(tbTeacher)==true){
			loginService.addOne(tbTeacher.getTeacherId(),tbTeacher.getTeacherId(),1);
		}
		return SUCCESS;
	   
	
	}
}
