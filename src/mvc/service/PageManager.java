package mvc.service;

import mvc.dao.page.PageDao;
import mvc.dao.page.PageDaoImpl;
import mvc.model.page.PageGroupResult;
import mvc.model.page.PageInfo;
import mvc.model.page.PageRowResult;

public class PageManager {
	
	/**
	 * 보여줄 페이지
	 */
	private int requestPage;
	private int totalRecord;
	private String totalPageQuery;
	
	public PageManager() {}
	public PageManager(int requestPage) {
		this.requestPage = requestPage;		
	}
	public PageManager(int requestPage, String sql) {
		this(requestPage);
		this.totalPageQuery = sql;
		this.requestPage = getManagedPageNum();	
	}
	
	public int getManagedPageNum() {
		PageDao dao = new PageDaoImpl();
		this.totalRecord = dao.getCount(this.totalPageQuery);
		int totalPages = (int)Math.ceil((double)this.totalRecord  / PageInfo.ROW_COUNT_PER_PAGE);
		
		if(totalPages < requestPage)
			return totalPages;
		else if(requestPage<=0)
			return 1;
		return requestPage;
	}
	
	public PageRowResult getPageRowResult(String sql) {
		// 1부터 오름차순
//		PageRowResult result = new PageRowResult();
//		int start = (requestPage-1)*PageInfo.ROW_COUNT_PER_PAGE+1;
//		result.setRowStartNumber(start);
//		result.setRowEndNumber(start + PageInfo.ROW_COUNT_PER_PAGE-1);
		PageDao dao = new PageDaoImpl();
//		int totalRow = dao.getCount(sql);;
		// 마지막부터 내림차순
		PageRowResult result = new PageRowResult();
		int start = this.totalRecord  - (requestPage-1)*PageInfo.ROW_COUNT_PER_PAGE;
		result.setRowStartNumber(start);
		result.setRowEndNumber(start - PageInfo.ROW_COUNT_PER_PAGE+1);
		return result;
	}
	
	public PageGroupResult getPageGroupResult() {
		//1페이지부터 오름차순
//		int groupNumber2 = requestPage / PageInfo.SHOW_PAGE_COUNT + (requestPage%PageInfo.SHOW_PAGE_COUNT==0?0:1);
//		System.out.println("groupNumber:"+groupNumber+" groupNumber2:"+groupNumber2);
		PageGroupResult result = new PageGroupResult();		
		PageDao dao = new PageDaoImpl();		
		int startPage = 0;
		int endPage = 0;		
		int groupNumber = (int)Math.ceil((double)requestPage / PageInfo.SHOW_PAGE_COUNT);		
//		int totalRecord = dao.getCount(this.totalPageQuery);
		int totalPages = (int)Math.ceil((double)this.totalRecord  / PageInfo.ROW_COUNT_PER_PAGE);
		
		endPage = Math.min(groupNumber * PageInfo.SHOW_PAGE_COUNT,totalPages);
		startPage = Math.max(endPage - PageInfo.SHOW_PAGE_COUNT+1,1);
		
		result.setSelectPageNumber(requestPage);
		result.setGroupStartNumber(startPage);
		result.setGroupEndNumber(endPage);
		result.setAfterPage(endPage != totalPages);
		result.setBeforePage(startPage != 1);
		return result;
	}
}
