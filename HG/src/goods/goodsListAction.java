package goods;


import java.net.*;
import java.util.*;
import java.io.Reader;
import java.io.IOException;
import com.opensymphony.xwork2.ActionSupport;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class goodsListAction extends ActionSupport{
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private List<goodsVO> list = new ArrayList<goodsVO>();
	
	private String searchKeyword;
	private int searchNum;
	
	private int currentPage = 1;
	private int totalCount;
	private int blockCount = 10;
	private int blockPage = 5;
	private String pagingHtml;
	private goodsPageAction page;
	private int num = 0;
	
	public goodsListAction() throws IOException{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();		
	}
	public String execute() throws Exception{
	if(getSearchKeyword() != null)
	{
		return search();
}
	list = sqlMapper.queryForList("selectAll");
	
	totalCount = list.size();
	page = new goodsPageAction(currentPage, totalCount, blockCount, blockPage, num, blockCount, "");
	pagingHtml = page.getPagingHtml().toString();
	
	int lastCount = totalCount;
	
	if(page.getEndCount() < totalCount)
		lastCount = page.getEndCount() + 1;
	
	list = list.subList(page.getStartCount(), lastCount);
	return SUCCESS;
	}
	
	public String search() throws Exception{
		if(searchNum == 0){
			list = sqlMapper.queryForList("selectSearchW", "%"+getSearchKeyword()+"%");
		}
		if(searchNum == 1){
			list = sqlMapper.queryForList("selectSearchS", "%"+getSearchKeyword()+"%");
		}
		if(searchNum == 2){
			list = sqlMapper.queryForList("selectSearchC", "%"+getSearchKeyword()+"%");	
		}
		
		totalCount = list.size();
		page = new goodsPageAction(currentPage, totalCount, blockCount, blockPage, searchNum, blockCount, getSearchKeyword());
		pagingHtml = page.getPagingHtml().toString();
		
		int lastCount = totalCount;
		
		if(page.getEndCount() < totalCount)
			lastCount = page.getEndCount() + 1;
		
		list = list.subList(page.getStartCount(), lastCount);
		return SUCCESS;
	}
	public List<goodsVO> getList() {
		return list;
	}
	public void setList(List<goodsVO> list) {
		this.list = list;
	}
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	public int getSearchNum() {
		return searchNum;
	}
	public void setSearchNum(int searchNum) {
		this.searchNum = searchNum;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getBlockCount() {
		return blockCount;
	}
	public void setBlockCount(int blockCount) {
		this.blockCount = blockCount;
	}
	public int getBlockPage() {
		return blockPage;
	}
	public void setBlockPage(int blockPage) {
		this.blockPage = blockPage;
	}
	public String getPagingHtml() {
		return pagingHtml;
	}
	public void setPagingHtml(String pagingHtml) {
		this.pagingHtml = pagingHtml;
	}
	public goodsPageAction getPage() {
		return page;
	}
	public void setPage(goodsPageAction page) {
		this.page = page;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
}
	
