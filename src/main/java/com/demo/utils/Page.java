package com.demo.utils;

import java.util.List;

public class Page<T> {
private int currentpage;
private int pagesize;
private int count;
private int startindex;
private int totalpage;
public List<T> dataList;
public int getCurrentpage() {
	return currentpage;
}
public void setCurrentpage(int currentpage) {
	this.currentpage = currentpage;
}
public int getPagesize() {
	return pagesize;
}
public void setPagesize(int pagesize) {
	this.pagesize = pagesize;
}
public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}
public int getStartindex() {
	return startindex;
}
public void setStartindex(int startindex) {
	this.startindex = startindex;
}
public int getTotalpage() {
	return totalpage;
}
public void setTotalpage(int totalpage) {
	this.totalpage = totalpage;
}
public List<T> getDataList() {
	return dataList;
}
public void setDataList(List<T> dataList) {
	this.dataList = dataList;
}
public Page(int currentpage, int pagesize, int count) {
	super();
	
	this.pagesize = pagesize;
	this.count = count;
	this.totalpage=(count%pagesize==0)?(count/pagesize):(count/pagesize+1);
	if(currentpage<=0) {
		currentpage=1;
	}
	if(currentpage>totalpage) {
		currentpage=totalpage;
	}
	this.currentpage = currentpage;
	this.startindex=(currentpage-1)*pagesize;
	
}




}
