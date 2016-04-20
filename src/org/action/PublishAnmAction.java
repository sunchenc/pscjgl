package org.action;

import org.model.Announcement;
import org.service.PublishAnmService;

import com.opensymphony.xwork2.ActionSupport;

public class PublishAnmAction extends ActionSupport {
  private Announcement announcement;
  private PublishAnmService publishAnmService;
  public void setPublishAnmService(PublishAnmService publishAnmService) {
	this.publishAnmService = publishAnmService;
}

	public Announcement getAnnouncement() {
	return announcement;
}

public void setAnnouncement(Announcement announcement) {
	this.announcement = announcement;
}

	@Override
	public String execute()throws Exception{
		publishAnmService.add(announcement.getTitle(),announcement.getContent());
        return SUCCESS;
		
	}
  
}
