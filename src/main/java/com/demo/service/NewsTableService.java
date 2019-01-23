package com.demo.service;

import java.util.List;
import java.util.Map;

import com.demo.entity.NewsTable;
import com.demo.utils.Page;

public interface NewsTableService {

	public Page<NewsTable> selectall(int currentpage);
	
	public Page<NewsTable> bcxwselectall(int currentpage,int nstatus);

	public Page<NewsTable> tjshselectall(int currentpage,int nstatus);

	public Page<NewsTable> shtgselectall(int currentpage,int nstatus);

	public Page<NewsTable> shsbselectall(int currentpage,int nstatus);
	
	public int count();

	public NewsTable selectbyid(int id);

	public int addnews(NewsTable newsTable);

	public int deletenews(int id);

	public int updatenews(NewsTable newsTable);

	public int shenhenews(Map map);



}
