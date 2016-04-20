package org.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.model.TbWork;
import org.service.AddStudentService;
import org.service.WorkService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SummaryOfGradeAction extends ActionSupport {
   //把某老师的所以学生work中的成绩分别 相加除以总次数 再加上试卷成绩
	   private WorkService workService;
	   private AddStudentService studentService; //5.13为了查某老师的所有学生加
	   private String cishu;
	   private String juanmian;
	   private String studentId;
    public void setWorkService(WorkService workService) {
		this.workService = workService;
	   }
	public void setStudentService(AddStudentService studentService) {
		this.studentService = studentService;
	}
	
	public String getCishu() {
		return cishu;
	}
	public void setCishu(String cishu) {
		this.cishu = cishu;
	}
	public String getJuanmian() {
		return juanmian;
	}
	public void setJuanmian(String juanmian) {
		this.juanmian = juanmian;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String execute()throws Exception{
		   //找到该生所有的work 获取grade相加，然后与卷面成绩整合 upadate到TbStudent
		
		  HttpServletResponse response = (HttpServletResponse)ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_RESPONSE);    
			response.setContentType("text/html;charset=UTF-8"); 
			response.setCharacterEncoding("UTF-8");//防止弹出的信息出现乱码  
			PrintWriter out = response.getWriter();
		      Float sum=new Float(0);
       		  sum=studentService.find(getStudentId()).getTotalGrade();
       		  if(sum!=0){
       		   out.print("<script>alert('已经整合过！')</script>");
			    out.print("<script>window.location.href='studentTotalGrade.action'</script>");
				out.flush();
				out.close();
				 return ERROR;
       		  }
			  List<TbWork> list=workService.findWorkOfSomeStudent(getStudentId());
			  if(list.size()<=0){
				  return ERROR;
			  }
			  for(TbWork w:list){
				  Float grade=new Float(0);
				  if(w.getGrade()!=null)
				  {
					  grade=w.getGrade();
				  }
			      sum=sum+grade;
			  }
			  Float totalGrade=sum/(Integer.parseInt(cishu))*new Float(0.3)+Float.parseFloat(juanmian)*new Float(0.7);
			  if(totalGrade>100){
				    out.print("<script>alert('整合失败，总成绩不得大于100！')</script>");
				    out.print("<script>window.location.href='studentTotalGrade.action'</script>");
					out.flush();
					out.close();
					 return ERROR;
			  }
			  studentService.update(getStudentId(), totalGrade);
			//  ActionContext.getContext().put("message", "提交成功！！");

		    	out.print("<script>alert('整合成功！')</script>");
			    out.print("<script>window.location.href='studentTotalGrade.action'</script>");
				out.flush();
				out.close();
				
			  return SUCCESS;
		}
}

