package com.demo.service.serviceImp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.NewsTable;
import com.demo.mapper.NewsTableMapper;
import com.demo.service.NewsTableService;
import com.demo.utils.Page;

@Service
public class NewsTableServiceImp implements NewsTableService {
	
	@Autowired
	private NewsTableMapper newsTableMapper;

	@Override
	public Page<NewsTable> selectall(int currentpage) {
		if(currentpage<=0) {
			currentpage=1;
		}
		
	 int   pagesize=2;
	   
	   int count=newsTableMapper.count();
	   
	   Page page=new Page(currentpage,pagesize,count);
	   
	 Map map=new HashMap<>();
	 map.put("startindex", page.getStartindex());
	 map.put("pagesize", page.getPagesize());
	 
	 List<NewsTable> list = newsTableMapper.selectall(map);
	 page.setDataList(list);   
		
		return page ;
	}

	@Override
	public NewsTable selectbyid(int id) {
		// TODO Auto-generated method stub
		return newsTableMapper.selectbyid(id);
	}

	@Override
	public int addnews(NewsTable newsTable) {
		// TODO Auto-generated method stub
		return newsTableMapper.addnews(newsTable);
	}

	@Override
	public int deletenews(int id) {
		// TODO Auto-generated method stub
		return newsTableMapper.deletenews(id);
	}

	@Override
	public int updatenews(NewsTable newsTable) {
		// TODO Auto-generated method stub
		return newsTableMapper.updatenews(newsTable);
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return newsTableMapper.count();
	}

	@Override
	public int shenhenews(Map map) {


	
		return newsTableMapper.shenhenews(map);
	}

	@Override
	public Page<NewsTable> bcxwselectall(int currentpage,int nstatus) {
		if(currentpage<=0) {
			currentpage=1;
		}
		
	 int   pagesize=2;
	   
	   int count=newsTableMapper.count();
	   
	   Page page=new Page(currentpage,pagesize,count);
	   
	 Map map=new HashMap<>();
	 map.put("startindex", page.getStartindex());
	 map.put("pagesize", page.getPagesize());
	 map.put("nstatus", 1);
	 
	 List<NewsTable> list = newsTableMapper.selectall(map);
	 page.setDataList(list);   
		
		return page ;
	}

	@Override
	public Page<NewsTable> tjshselectall(int currentpage,int nstatus) {
		if(currentpage<=0) {
			currentpage=1;
		}
		
	 int   pagesize=2;
	   
	   int count=newsTableMapper.count();
	   
	   Page page=new Page(currentpage,pagesize,count);
	   
	 Map map=new HashMap<>();
	 map.put("startindex", page.getStartindex());
	 map.put("pagesize", page.getPagesize());
	 map.put("nstatus", 2);
	 List<NewsTable> list = newsTableMapper.nstatusselectall(map);
	 page.setDataList(list);   
		
		return page ;
	}

	@Override
	public Page<NewsTable> shtgselectall(int currentpage,int nstatus) {
		if(currentpage<=0) {
			currentpage=1;
		}
		
	 int   pagesize=2;
	   
	   int count=newsTableMapper.count();
	   
	   Page page=new Page(currentpage,pagesize,count);
	   
	 Map map=new HashMap<>();
	 map.put("startindex", page.getStartindex());
	 map.put("pagesize", page.getPagesize());
	 map.put("nstatus", 3);
	 List<NewsTable> list = newsTableMapper.nstatusselectall(map);
	 page.setDataList(list);   
		
		return page ;
	}

	@Override
	public Page<NewsTable> shsbselectall(int currentpage,int nstatus) {
		if(currentpage<=0) {
			currentpage=1;
		}
		
	 int   pagesize=2;
	   
	   int count=newsTableMapper.count();
	   
	   Page page=new Page(currentpage,pagesize,count);
	   
	 Map map=new HashMap<>();
	 map.put("startindex", page.getStartindex());
	 map.put("pagesize", page.getPagesize());
	 map.put("nstatus", 4);
	 List<NewsTable> list = newsTableMapper.nstatusselectall(map);
	 page.setDataList(list);   
		
		return page ;
	}

}
