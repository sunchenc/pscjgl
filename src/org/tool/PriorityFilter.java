package org.tool;
import java.io.PrintWriter;
import java.net.URL;
import java.util.List;
import java.util.Map;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.model.RoleResource;
import org.model.TbLogin;
import org.service.RoleResourceService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
public class PriorityFilter extends AbstractInterceptor{
   // private RoleResourceService roleResourceService;
	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		
	    URL xmlpath = this.getClass().getClassLoader().getResource("applicationContext.xml"); 
        ApplicationContext ctx=new FileSystemXmlApplicationContext(xmlpath.toString());
        RoleResourceService rrs=null;
	    rrs=(RoleResourceService) ctx.getBean("roleResourceService");
	    Map session=arg0.getInvocationContext().getSession();
		TbLogin user=(TbLogin)session.get("user");
		String uri=ServletActionContext.getRequest().getRequestURL().toString();
		String u=uri.substring(uri.lastIndexOf('/')+1);
		List list=rrs.find(user.getIden());
		boolean authentificated=false;
		for(int i=0;i<list.size();i++){
			RoleResource rr=(RoleResource)list.get(i);
			if(rr.getResources().equalsIgnoreCase(u)){
				authentificated=true;
				break;
			}
			
		}
		if(authentificated==false){
		//	throw new RuntimeException(new LoginException("您无权访问该页面")); // 后期改
			ActionContext ct = ActionContext.getContext();       
			HttpServletRequest request =(HttpServletRequest)ct.get(ServletActionContext.HTTP_REQUEST);    
			HttpServletResponse response = (HttpServletResponse)ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_RESPONSE);    
			response.setContentType("text/html;charset=UTF-8"); 
			response.setCharacterEncoding("UTF-8");//防止弹出的信息出现乱码  
			PrintWriter out = response.getWriter();
			out.println("<script>alert('您无权访问该页面！')</script>");
			out.flush();
			out.close();
		}
		return arg0.invoke();
	}
}
