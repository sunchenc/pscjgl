package org.tool;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.List;
import javax.security.auth.login.LoginException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.model.RoleResource;
import org.model.TbLogin;
import org.service.RoleResourceService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class JspFilter implements Filter{
	//FilterConfig可用于访问Filter的配置信息
	 private FilterConfig config;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		 this.config = null;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
	//对jsp页面进行过滤，未登录的跳到登录页面
		   HttpServletRequest httpRequest = (HttpServletRequest)request;
 	       HttpSession session = httpRequest.getSession();  
		  if(session.getAttribute("user")==null){
			  
//			response.setContentType("text/html;charset=UTF-8");  
//			response.setCharacterEncoding("UTF-8");//防止弹出的信息出现乱码  
//			PrintWriter out = response.getWriter();
//			out.println("<script>alert('你还未登录！')</script>");
//			out.flush();
//			out.close();
			  
//		    HttpServletResponse res=(HttpServletResponse)response;  //跳不动，出错
//		    res.sendRedirect("../login.jsp");  //跳不动，出错
			response.setContentType("text/html;charset=UTF-8");  
			response.setCharacterEncoding("UTF-8");//防止弹出的信息出现乱码  
			PrintWriter out = response.getWriter();
			out.print("<script>alert('你还未登录！');window.location.href='../login.jsp'</script>");
			out.flush();
			out.close();
		  
		  }
		
		    URL xmlpath = this.getClass().getClassLoader().getResource("applicationContext.xml"); 
	        ApplicationContext ctx=new FileSystemXmlApplicationContext(xmlpath.toString());
	        RoleResourceService rrs=null;
		    rrs=(RoleResourceService) ctx.getBean("roleResourceService");
//		    HttpServletRequest httpRequest = (HttpServletRequest)request; //5.21挪到上面去了
//		    HttpSession session = httpRequest.getSession();  //5.21挪到上面去了
	    	TbLogin user=(TbLogin)session.getAttribute("user");
		//	String uri=ServletActionContext.getRequest().getRequestURL().toString();
	        HttpServletRequest hrequest = (HttpServletRequest)request;
	        String s=hrequest.getServletPath();
	    		   //Filter只是链式处理，请求依然放行到目的地址  
			String u=s.substring(s.lastIndexOf('/')+1);
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
			//	throw new RuntimeException(new LoginException("您无权访问该页面"));
				
			
				response.setContentType("text/html;charset=UTF-8");  
				response.setCharacterEncoding("UTF-8");//防止弹出的信息出现乱码  
				PrintWriter out = response.getWriter();
				out.println("<script>alert('您无权访问该页面！')</script>");
				out.flush();
				out.close();
		}
	
		   chain.doFilter(request, response);

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.config = config;

		
	}

}
