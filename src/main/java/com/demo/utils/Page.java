package com.demo.utils;

import java.util.List;

/**
 * 通用的，用来处理分页的类
 * @author 叶金雄
 */
public class Page<T> {
	private Integer currentPage;   //当前页码
	private Integer pageSize;      //每页展示的条数
	private Integer count;         //数据总条数
	private Integer totalPage;     //数据的总页数
	private Integer startIndex;    //查询的开始下标
	private List<T> dataList;  //定义一个集合，用来保存分页查询的结果的数据集合
	//有参构造，只能放入前端可直接获取得参数，totalPage、startIndex、dataList需要通过计算才能得到，所以不能作为参数
	public Page(Integer currentPage, Integer pageSize, Integer count) {
		super();
		this.pageSize = pageSize;
		this.count = count;
		//计算总页数
		this.totalPage = (count % pageSize == 0)? (count / pageSize) : (count / pageSize + 1);
		//计算开始下标
		if(currentPage > totalPage){
			currentPage = totalPage;
		}
		if(currentPage == null || currentPage <= 0){
			currentPage = 1;
		}
		this.currentPage = currentPage;
		//查询的开始页码
		this.startIndex = (currentPage - 1) * pageSize;
	}
	
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}
	public List<T> getDataList() {
		return dataList;
	}
	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}
}
