package review;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import goods.goodsPageAction;

public class reviewListAction extends ActionSupport {
   private static Reader reader;
   private static SqlMapClient sqlMapper;
   // private reviewVO resultClass

   private String search;
   private String forSearch;
   private int currentPage = 1;
   /*
    * private int startBLlock; private int endBlock; private int startPage;
    * private int endPage;
    */

   private int totalCount;
   private int blockCount = 10; // 10으로 다시 바꾸면 됨
   private int blockPage = 5;
   private String pagingHtml;
   private reviewPageAction page;
   private Map session;
   List<reviewVO> list = new ArrayList<>();

   public reviewListAction() throws IOException {
      reader = Resources.getResourceAsReader("sqlMapConfig.xml");
      sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
      reader.close();
   }

   public String execute() throws SQLException {
      if (search != null)
         return search();
      list = sqlMapper.queryForList("Board.selectAllReview");
      
      ActionContext context=ActionContext.getContext();
      session=context.getSession();
      
      totalCount = list.size();
   	
      page = new reviewPageAction(currentPage, totalCount, blockCount, blockPage, "", "");
      pagingHtml = page.getPagingHtml().toString();
      
      //System.out.println("page :"+page);
      //System.out.println("pagingHtml :"+pagingHtml);
      
      int lastCount = totalCount;
      if (page.getEndCount() < totalCount)
         lastCount = page.getEndCount() + 1;

      list = list.subList(page.getStartCount(), lastCount);
      return SUCCESS;
   }
 
   public String search() throws SQLException {
      if (forSearch.equals("writer"))
         list = sqlMapper.queryForList("Board.selectRvSearchW", "%" + search + "%");
      else if (forSearch.equals("content"))
         list = sqlMapper.queryForList("Board.selectRvSearchC", "%" + search + "%");
      else if (forSearch.equals("title"))
         list = sqlMapper.queryForList("Board.selectRvSearchT", "%" + search + "%");
      totalCount = list.size();
      page = new reviewPageAction(currentPage, totalCount, blockCount, blockPage, search, forSearch);
      pagingHtml = page.getPagingHtml().toString();
      
      int lastCount = totalCount;
      if (page.getEndCount() < totalCount)
         lastCount = page.getEndCount() + 1;
      
      list = list.subList(page.getStartCount(), lastCount);
      return SUCCESS;
   }

   public String getSearch() {
      return search;
   }

   public void setSearch(String search) {
      this.search = search;
   }

   public String getForSearch() {
      return forSearch;
   }

   public void setForSearch(String forSearch) {
      this.forSearch = forSearch;
   }

   public int getCurrentPage() {
      return currentPage;
   }

   public void setCurrentPage(int currentPage) {
      this.currentPage = currentPage;
   }


 


   public reviewPageAction getPage() {
      return page;
   }

   public void setPage(reviewPageAction page) {
      this.page = page;
   }

   public List<reviewVO> getList() {
      return list;
   }

   public void setList(List<reviewVO> list) {
      this.list = list;
   }

public Map getSession() {
	return session;
}

public void setSession(Map session) {
	this.session = session;
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


   

}