package goods;

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
   HttpServletRequest request;
   HttpSession session = request.getSession();
   private String sesssion_id = (String) session.getAttribute("session_id");
   private int currentPage = 1;
   private int totalCount;
   private int blockCount = 10;
   private int blockPage = 5;
   private List<replyVO> rp_list = new ArrayList<>();
   private int no;
   private String password;

   replyPagingAction rp_page;
   private String pagingHtml;
   private InputStream inputStream;
   private String contentDisposition;
   private long contentLength;

   public goodsViewAction() throws IOException {
      reader = Resources.getResourceAsReader("sqlMapConfig.xml");
      sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
      reader.close();
   }

   public String execute() throws Exception {
      goodsResult = (goodsVO) sqlMapper.queryForObject("goods.g_view", no);
      if (sesssion_id != null) {
         rp_list = sqlMapper.queryForList("reply.g_selectReply");
      } else return LOGIN;
      
     // totalCount = rp_list.size();
      
      rp_page = new replyPagingAction(currentPage, totalCount, blockCount, blockPage);
      pagingHtml = rp_page.getPagingHtml().toString();
      int endCount = rp_page.getEndCount();
      if(endCount>totalCount) endCount=totalCount;
      rp_list=rp_list.subList(rp_page.getStartCount(),endCount);
      
      if (goodsResult == null) return ERROR;
      return SUCCESS;
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

   public HttpSession getSession() {
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

   public List<replyVO> getRp_list() {
      return rp_list;
   }

   public void setRp_list(List<replyVO> rp_list) {
      this.rp_list = rp_list;
   }

   public int getNo() {
      return no;
   }

   public void setNo(int no) {
      this.no = no;
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

   
}