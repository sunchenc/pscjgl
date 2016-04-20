package org.action;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.model.TbLogin;
import org.service.LoginService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
		private LoginService loginService;
		private TbLogin login;
		public TbLogin getLogin() {
			return login;
		}
		public void setLogin(TbLogin login) {
			this.login = login;
		}
		public void setLoginService(LoginService loginService) {
			this.loginService = loginService;
		}
		@Override
		public String execute()throws Exception{
			HttpServletResponse response = (HttpServletResponse)ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_RESPONSE);    
			response.setContentType("text/html;charset=UTF-8"); 
			response.setCharacterEncoding("UTF-8");//防止弹出的信息出现乱码  
			PrintWriter out = response.getWriter();
			
			TbLogin user=loginService.find(login.getId(), login.getPassword(),login.getIden());
			if(user!=null){
				Map session=ActionContext.getContext().getSession();
				session.put("user", user);
				session.put("iden", user.getIden());
			    out.print("<script>alert('登录成功！')</script>");
				out.print("<script>window.location.href='login_success.jsp'</script>");
			    out.flush();
			    out.close();
				return SUCCESS;
			}else
			{
				  out.print("<script>alert('用户名或密码错误！')</script>");
				  out.print("<script>window.location.href='login.jsp'</script>");
				  out.flush();
				  out.close();
					return ERROR;
			}
			
		}
//		public void validate(){
//			if(this.getLogin().getId()==null||this.getLogin().getId().trim().equals("")){
//				addFieldError("login.id","用户名不能为空！");
//			}
//		}
	}

