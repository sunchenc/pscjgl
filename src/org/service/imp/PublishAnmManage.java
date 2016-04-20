package org.service.imp;

import java.text.ParseException;
import java.util.List;

import org.dao.PublishAnmDao;
import org.model.Announcement;
import org.service.PublishAnmService;

public class PublishAnmManage implements PublishAnmService{
    private PublishAnmDao publishAnmDao;
    
	public void setPublishAnmDao(PublishAnmDao publishAnmDao) {
		this.publishAnmDao = publishAnmDao;
	}


	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return publishAnmDao.findAll();
	}


	@Override
	public void add(String title, String content)throws ParseException{
		// TODO Auto-generated method stub
		publishAnmDao.add(title, content);
	}


	@Override
	public void delete(Integer id) {
		publishAnmDao.delete(id);
		
	}


	@Override
	public Announcement find(Integer id) {
		// TODO Auto-generated method stub
		return publishAnmDao.find(id);
	}
   
}
