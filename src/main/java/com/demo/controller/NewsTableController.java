package com.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.NewsTable;
import com.demo.service.NewsTableService;
import com.demo.utils.Page;

@RestController
@RequestMapping(path = "/test", produces = { "application/json;charset=UTF-8" })
public class NewsTableController {

	@Autowired
  private	NewsTableService newsTableService;
	
	@GetMapping("/selectall")
	public Object selectall(@RequestParam(defaultValue="1")int currentpage,@RequestParam(defaultValue="2")int pagesize) {
		
		Page<NewsTable> page = newsTableService.selectall(currentpage,pagesize);
		
		
		return page;
		
		
	}
	
	@ResponseBody
	@GetMapping("/shtgselectall")
	public Page<NewsTable> shtgselectall(@RequestParam(defaultValue="1")int currentpage,@RequestParam(defaultValue="2")int pagesize) {
		
		Page<NewsTable> page = newsTableService.shtgselectall(currentpage, pagesize);
		
		return page;		
	
}
	@GetMapping("/shsbselectall")
	public Page<NewsTable> shsbselectall(@RequestParam(defaultValue="1")int currentpage,@RequestParam(defaultValue="2")int pagesize) {
		
		Page<NewsTable> page = newsTableService.shsbselectall(currentpage, pagesize);
		
		return page;		
	
}
	@GetMapping("/fbggselectall")
	public Page<NewsTable> fbggselectall(@RequestParam(defaultValue="1")int currentpage,@RequestParam(defaultValue="2")int pagesize) {
		
		Page<NewsTable> page = newsTableService.fbggselectall(currentpage, pagesize);
		
		return page;		
	
}
	@GetMapping("/tjshselectall")
	public Page<NewsTable> tjshselectall(@RequestParam(defaultValue="1")int currentpage,@RequestParam(defaultValue="2")int pagesize) {
		
		Page<NewsTable> page = newsTableService.tjshselectall(currentpage, pagesize);
		
		return page;		
	
}
	@GetMapping("/addnews")
	public String addnews(NewsTable newsTable) {
		
		int addnews = newsTableService.addnews(newsTable);
		if(addnews!=0) {
			return "添加成功";		
		}else {
			return "添加失败";	
		}
	
}
	@GetMapping("/deletenews")
	public String deletenews(int id) {
		
		int deletenews = newsTableService.deletenews(id);
		if(deletenews!=0) {
			return "删除成功";		
		}else {
			return "删除失败";	
		}
		
		
	
}
	
	
	@GetMapping("/shenhenews")
	public String shenhenews(int id) {
		
		int nstatus = newsTableService.czidshenhenews(id);
		 
		Map map=new HashMap<>();	
		map.put("id", id);
		if(nstatus==2) {
			boolean is;//审核通过或者拒绝
			if(is=true) {
				map.put("nstatus", 3);
				int shstatus = newsTableService.shenhenews(map);	
				return "审核通过";
			}else{
				map.put("nstatus", 4);
				int shstatus = newsTableService.shenhenews(map);	
				return "审核不通过";
			}
		}else {
			return "该新闻不是待审核状态不能审核！";
		}		
		
					
	}
	
	
	@GetMapping("/updatenews")
	public String updatenews(NewsTable newsTable) {
		
		int updatenews = newsTableService.updatenews(newsTable);
		if(updatenews!=0) {
			Map map=new HashMap<>();
			map.put("id", newsTable.getId());
			map.put("nstatus", 2);
			int shenhenews = newsTableService.shenhenews(map);
		}
		
		return "修改成功，变为提交审核状态";		
	
}
	@GetMapping("/selectbyidnews")
	public NewsTable selectbyidnews(int id) {
		
		NewsTable newstable = newsTableService.selectbyid(id);
		
		return newstable;		
	
}
	
	
}