package org.action;

import java.util.List;
import org.model.TbTeacher;
import org.service.AddTeacherService;
import org.service.LoginService;
import org.tool.ExcelOperationUtil;
import com.opensymphony.xwork2.ActionSupport;
public class AddTeacherAction extends ActionSupport{
 	private AddTeacherService addTeacherService;
	private LoginService loginService;  //5ÔÂ12ºÅ21£º46·Ö¼Ó
	private TbTeacher tbTeacher;
	private String upload; 
 
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	public TbTeacher getTbTeacher() {
		return tbTeacher;
	}

	public void setTbTeacher(TbTeacher tbTeacher) {
		this.tbTeacher = tbTeacher;
	}

	public void setAddTeacherService(AddTeacherService addTeacherService) {
		this.addTeacherService = addTeacherService;
	}

	public String getUpload() {
		return upload;
	}

	public void setUpload(String upload) {
		this.upload = upload;
	}

	@Override
	public String execute()throws Exception{
		ExcelOperationUtil eo=new ExcelOperationUtil();
  	    List<TbTeacher> list=eo.readExcelTeacherData(upload);
  	    boolean b=addTeacherService.saveTeacherFromExcel(list);
//  	    for(int i=0;i<list.size();i++){
//     	 loginService.addOne(list.get(i).getTeacherId(), list.get(i).getTeacherId(),1);
//        }
  	    if(b==true)
		return SUCCESS;
  	    else
  	    return ERROR;
	
	}
}
