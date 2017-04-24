package review;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

public class reviewListAction extends ActionSupport{
   private static Reader reader;
   private static SqlMapClient sqlMapper;
//   private reviewVO resultClass
   
   private String search;
   private String forSearch;
   private int currentPage=1;
   private int OnePageBlock=10;
   private int pageBlocks=5;
/*   private int startBLlock;
   private int endBlock;
   private int startPage;
   private int endPage;*/
   private int totalPage;
   private int totalBlock;
   private String pagingHtml;
   private reviewPageAction page;
   List<reviewVO> list = new ArrayList<>();
   
   public reviewListAction() throws IOException {
      reader = Resources.getResourceAsReader("sqlMapConfig.xml");
      sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
      reader.close();
   }
   
   public String execute() throws SQLException{
      if(search!=null)
         return search();
      list = sqlMapper.queryForList("Board.selectAllReview");
      totalBlock=list.size();  
      page = new reviewPageAction(currentPage, OnePageBlock, pageBlocks, totalBlock, "", "");
      list=list.subList(page.getStartBlock(),page.getEndBlock());
      pagingHtml=page.getPaginHtml().toString();
      return SUCCESS;
   }
   public String search() throws SQLException{
      if(forSearch.equals("writer"))
         list=sqlMapper.queryForList("Board.selectRvSearchW","%"+search+"%");
      else if(forSearch.equals("content"))
         list=sqlMapper.queryForList("Board.selectRvSearchC","%"+search+"%");
      else if(forSearch.equals("title"))
         list=sqlMapper.queryForList("Board.selectRvSearchT","%"+search+"%");
      totalBlock=list.size();
      page = new reviewPageAction(currentPage, OnePageBlock, pageBlocks, totalBlock, search, forSearch);
      pagingHtml = page.getPaginHtml().toString();
      list=list.subList(page.getStartBlock(), page.getEndBlock());
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
   
}