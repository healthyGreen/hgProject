package goods;

import goods.goodsPageAction;
import member.memberVO;
import java.net.*;
import java.util.*;
import java.io.Reader;
import java.io.IOException;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class goodsListAction extends ActionSupport {
   private memberVO memresultClass;
   private memberVO memparamClass;
   public static Reader reader;
   public static SqlMapClient sqlMapper;

   private List<goodsVO> list = new ArrayList<goodsVO>();

   private goodsVO goods_paramClass = new goodsVO();
   private goodsVO goods_resultClass = new goodsVO();

   private String searchKeyword;
   private String g_category;
   private int searchNum;

   private int currentPage = 1;
   private int totalCount;
   private int blockCount = 10;
   private int blockPage = 5;
   private String pagingHtml;
   private goodsPageAction page;
   private int num = 0;

   public goodsListAction() throws IOException {
      reader = Resources.getResourceAsReader("sqlMapConfig.xml");
      sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
      reader.close();
   }

   public String category() throws Exception {
      ActionContext context = ActionContext.getContext();
      Map<String, Object> session = context.getSession();
      String sessionid = (String) session.get("id");
      memresultClass = (memberVO) sqlMapper.queryForObject("Member.UserCheck", sessionid);

      goods_paramClass = new goodsVO();
      goods_paramClass.setG_category(getGoods_category());
      list = sqlMapper.queryForList("g_Category", goods_paramClass);
      totalCount = list.size();

      page = new goodsPageAction(currentPage, totalCount, blockCount, blockPage, g_category, "");
      pagingHtml = page.getPagingHtml().toString();

      int lastCount = totalCount;
      if (page.getEndCount() < totalCount)
         lastCount = page.getEndCount() + 1;

      list = list.subList(page.getStartCount(), lastCount);
      return SUCCESS;
   }

   private String getGoods_category() {

      return null;
   }

   public String execute() throws Exception {
      ActionContext context = ActionContext.getContext();
      Map<String, Object> session = context.getSession();
      String sessionid = (String) session.get("id");
      memresultClass = (memberVO) sqlMapper.queryForList("Member.UserCheck", sessionid);
      if (getSearchKeyword() != null) {
         return search();
      }
      if (getGoods_category() != null) {
         return category();
      }
      list = sqlMapper.queryForList("g_list_selectAll");

      totalCount = list.size();
      page = new goodsPageAction(currentPage, totalCount, blockCount, blockPage, num, blockCount, "");
      pagingHtml = page.getPagingHtml().toString();

      int lastCount = totalCount;

      if (page.getEndCount() < totalCount)
         lastCount = page.getEndCount() + 1;

      list = list.subList(page.getStartCount(), lastCount);
      return SUCCESS;
   }

   public String search() throws Exception {
      if (searchNum == 0) {
         list = sqlMapper.queryForList("selectSearchW", "%" + getSearchKeyword() + "%");
      }
      if (searchNum == 1) {
         list = sqlMapper.queryForList("selectSearchS", "%" + getSearchKeyword() + "%");
      }
      if (searchNum == 2) {
         list = sqlMapper.queryForList("selectSearchC", "%" + getSearchKeyword() + "%");
      }

      totalCount = list.size();
      page = new goodsPageAction(currentPage, totalCount, blockCount, blockPage, searchNum, blockCount,
            getSearchKeyword());
      pagingHtml = page.getPagingHtml().toString();

      int lastCount = totalCount;

      if (page.getEndCount() < totalCount)
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