package goods;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.io.Reader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import goods.replyVO;

public class goodsViewAction extends ActionSupport {
   public static Reader reader;
   public static SqlMapClient sqlMapper;

   private goodsVO goodsResult = new goodsVO();
   private replyVO replyParam = new replyVO();
   private replyVO replyResult = new replyVO();
  /* HttpServletRequest request;
   HttpSession session = request.getSession();
   private String sesssion_id = (String) session.getAttribute("session_id");*/
   private int currentPage = 1;
   private int totalCount;
   private int blockCount = 10;
   private int blockPage = 5;
   private List<replyVO> rp_list = new ArrayList<>();
   private int g_number;
   
   private int rp_g_number;
   private String password;
   private int searchNum;
   private int num = 0;
   /*ActionContext context = ActionContext.getContext();
	Map<String, Object> session = context.getSession();
	String session_id = (String) session.get("m_id");*/
   replyPagingAction rp_page;
   private String pagingHtml;
   private InputStream inputStream;
   private String contentDisposition;
   private long contentLength;
   private List<replyVO> replylist = new ArrayList<replyVO>();

   public goodsViewAction() throws IOException {
      reader = Resources.getResourceAsReader("sqlMapConfig.xml");
      sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
      reader.close();
   }

   public String execute() throws Exception {
	   System.out.println("글넘버:"+getG_number());
	   // 글 상세보기 SQL
	   goodsResult.setG_number(getG_number());
	   
      goodsResult = (goodsVO) sqlMapper.queryForObject("g_view", getG_number());
     
        // rp_list = sqlMapper.queryForList("g_selectReply");
         
         replylist = sqlMapper.queryForList("replySelectAll",getG_number());
         
         System.out.println("size:"+replylist.size());
         
      
     // totalCount = rp_list.size();
      
     /* rp_page = new replyPagingAction(currentPage, totalCount, blockCount, blockPage);
      pagingHtml = rp_page.getPagingHtml().toString();
      int endCount = rp_page.getEndCount();
      if(endCount>totalCount) endCount=totalCount;
      replylist=replylist.subList(rp_page.getStartCount(),endCount);*/
      
      if (goodsResult != null) {
    	 
      }
      return SUCCESS;
   
   }

   
   private Object getRp_number() {
	// TODO Auto-generated method stub
	return null;
}

public String insertRp() {
      
      return SUCCESS;
   }
  


   
   
   public goodsVO getGoodsResult() {
      return goodsResult;
   }

   public void setGoodsResult(goodsVO goodsResult) {
      this.goodsResult = goodsResult;
   }

   public replyVO getReplyParam() {
      return replyParam;
   }

   public void setReplyParam(replyVO replyParam) {
      this.replyParam = replyParam;
   }

   public replyVO getReplyResult() {
      return replyResult;
   }

   public void setReplyResult(replyVO replyResult) {
      this.replyResult = replyResult;
   }

   /*public HttpSession getSession() {
      return session;
   }

   public void setSession(HttpSession session) {
      this.session = session;
   }

   public String getSesssion_id() {
      return sesssion_id;
   }

   public void setSesssion_id(String sesssion_id) {
      this.sesssion_id = sesssion_id;
   }*/

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

   public List<replyVO> getRp_list() {
      return rp_list;
   }

   public void setRp_list(List<replyVO> rp_list) {
      this.rp_list = rp_list;
   }

   

   public int getG_number() {
	return g_number;
}

public void setG_number(int g_number) {
	this.g_number = g_number;
}

public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public replyPagingAction getRp_page() {
      return rp_page;
   }

   public void setRp_page(replyPagingAction rp_page) {
      this.rp_page = rp_page;
   }

   public String getPagingHtml() {
      return pagingHtml;
   }

   public void setPagingHtml(String pagingHtml) {
      this.pagingHtml = pagingHtml;
   }

   public InputStream getInputStream() {
      return inputStream;
   }

   public void setInputStream(InputStream inputStream) {
      this.inputStream = inputStream;
   }

   public String getContentDisposition() {
      return contentDisposition;
   }

   public void setContentDisposition(String contentDisposition) {
      this.contentDisposition = contentDisposition;
   }

   public long getContentLength() {
      return contentLength;
   }

   public void setContentLength(long contentLength) {
      this.contentLength = contentLength;
   }

public List<replyVO> getReplylist() {
	return replylist;
}

public void setReplylist(List<replyVO> replylist) {
	this.replylist = replylist;
}

public int getRp_g_number() {
	return rp_g_number;
}

public void setRp_g_number(int rp_g_number) {
	this.rp_g_number = rp_g_number;
}
   
}
   
