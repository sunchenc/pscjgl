package org.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
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
public class AddStudentAction extends ActionSupport{
 	private AddStudentService addStudentService;
	private TbStudent tbStudent;
//	private TbStudent student; //5.13 22点添加 为了删除某个学生加
	private String upload; //放哪？ 
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
	public String getUpload() {
		return upload;
	}
	public void setUpload(String upload) {
		this.upload = upload;
	}
	
// 	public TbStudent getStudent() {
//		return student;
//	}
//	public void setStudent(TbStudent student) {
//		this.student = student;
//	}
//	public String deleteStudent() throws Exception{  //5.13 23.22时删除学生添加 
//    	String id=student.getStudentId();
//    	addStudentService.delete(id);
//    	return SUCCESS;
//    }
	@Override
	public String execute()throws Exception{
//		Map session=(Map)ActionContext.getContext().getSession();
//		session.put("file", upload);
//	    return SUCCESS;
		ExcelOperationUtil eo=new ExcelOperationUtil();
	    List<TbStudent> list=eo.readExcelData(upload);
	    
	  //5.26 从excel表添加事，老师只可以添加自己教的班的学生，管理员都可以  
	    Map session=ActionContext.getContext().getSession();
		 TbLogin user=(TbLogin) session.get("user");
	    if(user.getIden()==1){
	    	//List<TbStudent> list3=new ArrayList<TbStudent>();
	    	List<TbStudent> delList = new ArrayList<TbStudent>();//用来装需要删除的元素
	    	List<TbClass> list1=classService.getClassesOfSomeTeacher(user.getId());
	    	
//	    	for(int j = 0;j<list.size();++j){  
//	    		  if(!list1.contains(list.get(j).getTbclass())){  
//	    		       list.remove(j);  
//	    		       --j;  
//	    		  }  	        }   
//	    		}
	    	
	    	//Collection<User> users =  new CopyOnWriteArrayList<User>()
	      	for(TbStudent s:list){
	      		if(!list1.contains(s.getTbclass())){ //contains比较contains方法会调用 o.equals(elementData[i])方法，其中elementData[i]是个object类的实例。也就是说我在调用list.contains(user)时实际上比较的是user.equals(object) 这当然会返回false。
	      			delList.add(s);               //重写了TbClass 的equals方法就可以了
	      		}
	      	}
	      	list.removeAll(delList);   //哪里错了。。。。 搞定
	    	
	    	
//	    	List<TbClass> list1=classService.getClassesOfSomeTeacher(user.getId());
//	    	Iterator<TbStudent> ite=list.iterator();
//	    	while(ite.hasNext()){
//	    	TbStudent s=(TbStudent) ite.next();
//	    	if(!list1.contains(s.getTbclass()))
//	    	ite.remove();
	     }
	    
	    
		HttpServletResponse response = (HttpServletResponse)ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_RESPONSE);    
		response.setContentType("text/html;charset=UTF-8"); 
		response.setCharacterEncoding("UTF-8");//防止弹出的信息出现乱码  
		PrintWriter out = response.getWriter();
		 boolean b=addStudentService.saveStudentFromExcel(list);
		 if((list.size()>0)&&(b==true))
		 {   	
    	out.print("<script>alert('添加成功！')</script>");
	    out.print("<script>window.location.href='showStudent.action'</script>");
		out.flush();
		out.close();
    	return SUCCESS;
    	}
		 else{
			 out.print("<script>alert('添加失败！')</script>");
			    out.print("<script>window.location.href='showStudent.action'</script>");
				out.flush();
				out.close();
		    	return ERROR;
			 
		 }
	    
	   
	//    boolean b=addStudentService.saveStudentFromExcel(list);
    	
         //	    for(int i=0;i<list.size();i++){
        //	     	 loginService.addOne(list.get(i).getStudentId(), list.get(i).getStudentId(),2);
          //	        }
//	    if(b==true)
//		return SUCCESS;
//	    else
//	    return ERROR;
	
		
}
}
