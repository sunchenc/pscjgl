package org.action;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.model.Announcement;
import org.service.PublishAnmService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class DeleteAnmAction extends ActionSupport{
	private PublishAnmService publishAnmService;
	private Announcement anm; //5.24  添加 为了删除某个公告加
	public Announcement getAnm() {
		return anm;
	}
	public void setAnm(Announcement anm) {
		this.anm = anm;
	}
	public void setPublishAnmService(PublishAnmService publishAnmService) {
		this.publishAnmService = publishAnmService;
	}

	@Override
	public String execute()throws Exception{
		Integer id=anm.getId();
		publishAnmService.delete(id);
		HttpServletResponse response = (HttpServletResponse)ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_RESPONSE);    
		response.setContentType("text/html;charset=UTF-8"); 
		response.setCharacterEncoding("UTF-8");//防止弹出的信息出现乱码  
		PrintWriter out = response.getWriter();
        out.print("<script>alert('删除成功！')</script>");
        out.print("<script>window.location.href='seeAnm.action'</script>");
        out.flush();
        out.close();
    	return SUCCESS;
	
	}
}

