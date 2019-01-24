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
	public Object selectall(@RequestParam(defaultValue="1")int currentpage) {
		
		Page<NewsTable> page = newsTableService.selectall(currentpage);
		
//		model.addAttribute("newstable", selectall);
		
		return page;
		
		
	}
	
	@ResponseBody
	@GetMapping("/shtgselectall")
	public Page<NewsTable> shtgselectall(@RequestParam(defaultValue="1")int currentpage,@RequestParam(defaultValue="3")int nstatus) {
		
		Page<NewsTable> page = newsTableService.shtgselectall(currentpage, nstatus);
		
		return page;		
	
}
	@GetMapping("/addnews")
	public String addnews(NewsTable newsTable) {
		
		newsTableService.addnews(newsTable);
		
		return "2";		
	
}
	@GetMapping("/deletenews")
	public String deletenews(int id) {
		
		newsTableService.deletenews(id);
		
		return "2";		
	
}
	
	
	@GetMapping("/shenhenews")
	public String shenhenews(int id,int nstatus) {
		Map map=new HashMap<>();
		map.put("id", id);
		map.put("nstatus", nstatus);
		
		if(nstatus==3) {
			newsTableService.shenhenews(map);
			return "审核通过";
			
		}else {
			newsTableService.shenhenews(map);
			return "审核不通过";
		}
					
	}
	
	
	@GetMapping("/updatenews")
	public String updatenews(NewsTable newsTable) {
		
		newsTableService.updatenews(newsTable);
		
		return "2";		
	
}
	@GetMapping("/selectbyidnews")
	public String selectbyidnews(int id) {
		
		NewsTable newstable = newsTableService.selectbyid(id);
		
		return "2";		
	
}
	
	
}