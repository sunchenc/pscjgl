package org.action;

import java.util.List;
import java.util.Map;
import org.service.PublishAnmService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SeeAnmAction extends ActionSupport{
   private PublishAnmService publishAnmService;

   public void setPublishAnmService(PublishAnmService publishAnmService) {
	this.publishAnmService = publishAnmService;
   }
   @Override
public String execute() throws Exception {
	  List list= publishAnmService.findAll();
		if(list.size()>0){
			Map request=(Map)ActionContext.getContext().get("request");
			request.put("list", list);
			return SUCCESS;
		}else
			return ERROR;
   }
}
