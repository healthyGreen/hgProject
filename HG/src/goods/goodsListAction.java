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
   private int adminCurrentPage = 1;
   private int totalCount;
   private int blockCount = 3; // 10으로 다시 바꾸면 됨
   private int blockPage = 5;
   private String pagingHtml;
   private goodsPageAction page;
   private adminGoodsPageAction adminPage;
   private int num = 0;

   public goodsListAction() throws IOException {
      reader = Resources.getResourceAsReader("sqlMapConfig.xml");
      sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
      reader.close();
   }

   public String execute() throws Exception {
	   
	   if (getSearchKeyword() != null) {
	         return search();
	      }
	   list = sqlMapper.queryForList("g_list_selectAll", g_category);
     totalCount = list.size();
     	
      page = new goodsPageAction(currentPage, totalCount, blockCount, blockPage, 0, "");
      pagingHtml = page.getPagingHtml().toString();
      
   
      int lastCount = totalCount;
      if (page.getEndCount() < totalCount)
         lastCount = page.getEndCount() + 1;

      list = list.subList(page.getStartCount(), lastCount);
    //  System.out.println(list);
      return SUCCESS;
   }
   public String adminList() throws Exception {
	   
		 // System.out.println(getG_category());

	     // System.out.println("sessionid:"+sessionid);
		   list = sqlMapper.queryForList("admin_list_selectAll");
	     totalCount = list.size();
	     	
	      adminPage = new adminGoodsPageAction(adminCurrentPage, totalCount, blockCount, blockPage);
	      pagingHtml = adminPage.getPagingHtml().toString();
	      
	      //System.out.println("page :"+page);
	      //System.out.println("pagingHtml :"+pagingHtml);
	      
	      int lastCount = totalCount;
	      if (adminPage.getEndCount() < totalCount)
	         lastCount = adminPage.getEndCount() + 1;

	      list = list.subList(adminPage.getStartCount(), lastCount);
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
      page = new goodsPageAction(currentPage, totalCount, blockCount, blockPage, searchNum, getSearchKeyword());
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

public memberVO getMemresultClass() {
	return memresultClass;
}

public void setMemresultClass(memberVO memresultClass) {
	this.memresultClass = memresultClass;
}

public memberVO getMemparamClass() {
	return memparamClass;
}

public void setMemparamClass(memberVO memparamClass) {
	this.memparamClass = memparamClass;
}

public goodsVO getGoods_paramClass() {
	return goods_paramClass;
}

public void setGoods_paramClass(goodsVO goods_paramClass) {
	this.goods_paramClass = goods_paramClass;
}

public goodsVO getGoods_resultClass() {
	return goods_resultClass;
}

public void setGoods_resultClass(goodsVO goods_resultClass) {
	this.goods_resultClass = goods_resultClass;
}

public String getG_category() {
	return g_category;
}

public void setG_category(String g_category) {
	this.g_category = g_category;
}

public adminGoodsPageAction getAdminPage() {
	return adminPage;
}

public void setAdminPage(adminGoodsPageAction adminPage) {
	this.adminPage = adminPage;
}

public int getAdminCurrentPage() {
	return adminCurrentPage;
}

public void setAdminCurrentPage(int adminCurrentPage) {
	this.adminCurrentPage = adminCurrentPage;
}
   
}