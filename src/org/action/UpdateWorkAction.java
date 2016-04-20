package org.action;

import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.model.TbWork;
import org.service.WorkService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateWorkAction extends ActionSupport {//更新进老师的成绩
   // private Float grade;
	private String grade;
	private String gradeDetail;
	private String id;
//	private Integer id;  //新加
	private WorkService workService;
	private TbWork tbwork=new TbWork();
	
	public void setWorkService(WorkService workService) {
		this.workService = workService;
	}
	
	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getGradeDetail() {
		return gradeDetail;
	}
	public void setGradeDetail(String gradeDetail) {
		this.gradeDetail = gradeDetail;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String execute()throws Exception{

		tbwork.setGrade(Float.parseFloat(grade));
		tbwork.setGradeDetail(gradeDetail);   //duoyu?
		TbWork work=workService.find(Integer.parseInt(id));
		work.setGrade(tbwork.getGrade());
		work.setGradeDetail(tbwork.getGradeDetail());
		work.setTime(new Date());
 		workService.update(work);
		return SUCCESS;
		
	}
}
