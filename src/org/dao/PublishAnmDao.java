package org.dao;

import java.text.ParseException;
import java.util.List;

import org.model.Announcement;
import org.model.TbStudent;

public interface PublishAnmDao {
  public void add(String title,String content)throws ParseException;
  public List findAll();
  public Announcement find(Integer id);
  public void delete(Integer id);
}
