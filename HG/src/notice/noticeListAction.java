package notice;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

public class noticeListAction extends ActionSupport{
	private static Reader reader;
	private static SqlMapClient sqlMapper;

	  private int currentPage=1;
	  private int OnePageBlock=10;
	  private int pageBlocks=5;
	  private int totalPage;
	  private int totalBlock;
	  private String pagingHtml;
	  private noticePageAction page;
	  List<noticeVO> list = new ArrayList<>();
	  
	  public noticeListAction() throws IOException {
	      reader = Resources.getResourceAsReader("sqlMapConfig.xml");
	      sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
	      reader.close();
	   }
	  
	  public String execute() throws SQLException{
		  list = sqlMapper.queryForList("selectAllNotice");
		  totalBlock=list.size();  
	      page = new noticePageAction(currentPage, OnePageBlock, pageBlocks, totalBlock, "", "");
	      list=list.subList(page.getStartBlock(),page.getEndBlock());
	      pagingHtml=page.getPaginHtml().toString();
	      return SUCCESS;
	  }

	public static Reader getReader() {
		return reader;
	}

	public static void setReader(Reader reader) {
		noticeListAction.reader = reader;
	}

	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}

	public static void setSqlMapper(SqlMapClient sqlMapper) {
		noticeListAction.sqlMapper = sqlMapper;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getOnePageBlock() {
		return OnePageBlock;
	}

	public void setOnePageBlock(int onePageBlock) {
		OnePageBlock = onePageBlock;
	}

	public int getPageBlocks() {
		return pageBlocks;
	}

	public void setPageBlocks(int pageBlocks) {
		this.pageBlocks = pageBlocks;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalBlock() {
		return totalBlock;
	}

	public void setTotalBlock(int totalBlock) {
		this.totalBlock = totalBlock;
	}

	public String getPagingHtml() {
		return pagingHtml;
	}

	public void setPagingHtml(String pagingHtml) {
		this.pagingHtml = pagingHtml;
	}

	public noticePageAction getPage() {
		return page;
	}

	public void setPage(noticePageAction page) {
		this.page = page;
	}

	public List<noticeVO> getList() {
		return list;
	}

	public void setList(List<noticeVO> list) {
		this.list = list;
	}
	  
	  
}
