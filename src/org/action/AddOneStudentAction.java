package org.action;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.model.TbClass;
import org.model.TbLogin;
import org.model.TbStudent;
import org.service.AddStudentService;
import org.service.ClassService;
import org.service.LoginService;
import org.tool.ExcelOperationUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class AddOneStudentAction extends ActionSupport{
 	private AddStudentService addStudentService;
	private TbStudent tbStudent;
	private LoginService loginService;  //5月12号21：46分加
	private ClassService classService;      //需要吗？
	    public void setClassService(ClassService classService) {  //需要吗？
			this.classService = classService;     //需要吗？
		}
	public void setAddStudentService(AddStudentService addStudentService) {
		this.addStudentService = addStudentService;
	}
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	public TbStudent getTbStudent() {
		return tbStudent;
	}
	public void setTbStudent(TbStudent tbStudent) {
		this.tbStudent = tbStudent;
	}

	public String addStudentView()throws Exception{
		//只显示某个老师所带的班级
		 Map session=ActionContext.getContext().getSession();
		 TbLogin user=(TbLogin) session.get("user");
		 if(user.getIden()==0){
			List classes=classService.findAll();
			Map request=(Map)ActionContext.getContext().get("request");
			request.put("classes",classes);
		 }
		 if(user.getIden()==1){
		    List classes=classService.getClassesOfSomeTeacher(user.getId());
			Map request=(Map)ActionContext.getContext().get("request");
			request.put("classes",classes);
		 }
	//	List classes=classService.findAll();
//		Map request=(Map)ActionContext.getContext().get("request");
//		request.put("classes",classes);
		return SUCCESS;
	}
	public String addStudent()throws Exception{
		HttpServletResponse response = (HttpServletResponse)ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_RESPONSE);    
		response.setContentType("text/html;charset=UTF-8"); 
		response.setCharacterEncoding("UTF-8");//防止弹出的信息出现乱码  
		PrintWriter out = response.getWriter();
//		if(tbStudent.getStudentId().isEmpty())
//		{
//			out.print("<script>alert('编号不能为空！')</script>");
//			 out.print("<script>window.location.href='addStudentView.action'</script>");
//			out.flush();
//			out.close();
//			
//			return ERROR;
//		}
//		if(tbStudent.getStudentName()==null)
//		{
//			out.print("<script>alert('姓名不能为空！')</script>");
//			out.print("<script>window.location.href='addStudentView.action'</script>");
//			out.flush();
//			out.close();
//			
//			return ERROR;
//		}
		TbStudent student=new TbStudent();
		student.setStudentId(tbStudent.getStudentId());
		student.setStudentName(tbStudent.getStudentName());
		student.setTotalGrade(new Float(0));
		student.setTbclass(classService.getOneClass(tbStudent.getTbclass().getId()));
		Map request=(Map)ActionContext.getContext().get("request");
		if(addStudentService.add(student)==true){
			loginService.addOne(student.getStudentId(),student.getStudentId(),2);
		}
//		loginService.addOne(student.getStudentId(),student.getStudentId(),2);
//		return SUCCESS;
	 	out.print("<script>alert('添加成功！')</script>");
	    out.print("<script>window.location.href='showStudent.action'</script>");
		out.flush();
		out.close();
		return SUCCESS;
	}
	public String execute()throws Exception{
//		Map session=(Map)ActionContext.getContext().getSession();
//		session.put("file", upload);
//	    return SUCCESS;
		
		return SUCCESS;
	   
	
	}
}
