package org.service;

import java.text.ParseException;
import java.util.List;

import org.model.Announcement;

public interface PublishAnmService {
	public void add(String title, String content) throws ParseException;
    public List findAll();
	public void delete(Integer id);
	public Announcement find(Integer id);
}
