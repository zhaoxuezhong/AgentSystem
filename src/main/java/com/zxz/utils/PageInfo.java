package com.zxz.utils;

import java.util.List;

import com.zxz.utils.Constants;

/**
 * @author zhaoxuezhong
 *
 */
public class PageInfo<T> {

	private Integer pageIndex;
	private Integer pageSize;
	private Integer totalCount;
	@SuppressWarnings("unused")
	private Integer pageTotalCount;
	private List<T> list;
	private String url;
	public PageInfo() {
		super();
	}
	public Integer getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(Integer pageIndex) {
		if(pageIndex==null||pageIndex<1){
			pageIndex=Constants.PAGEINDEX;
		}
		if(pageIndex>getPageTotalCount()){
			pageIndex=getPageTotalCount();
		}
		this.pageIndex = pageIndex;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		if(pageSize==null||pageSize<1){
			pageSize=Constants.PAGESIZE;
		}		
		this.pageSize = pageSize;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		if(totalCount==null||totalCount<0){
			totalCount=0;
		}
		this.totalCount = totalCount;
	}
	
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public Integer getPageTotalCount() {
		if(totalCount==0){
			return 0;
		}		
		return totalCount%pageSize==0?(totalCount/pageSize):(totalCount/pageSize+1);
	}
	public void setPageTotalCount(Integer pageTotalCount) {
		this.pageTotalCount = pageTotalCount;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
