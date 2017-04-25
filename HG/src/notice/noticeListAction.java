package notice;

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

import member.memberVO;

public class noticeListAction extends ActionSupport{
   private static Reader reader;
   private static SqlMapClient sqlMapper;
   
     private memberVO memresultClass;
     private memberVO memparamClass;
     private int currentPage=1;
     private int OnePageBlock=10;
     private int pageBlocks=5;
     private int totalPage;
     private int totalBlock;
     private String pagingHtml;
     private noticePageAction page;
     private Map session;
     List<noticeVO> list = new ArrayList<noticeVO>();
     
     public noticeListAction() throws IOException {
         reader = Resources.getResourceAsReader("sqlMapConfig.xml");
         sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
         reader.close();
      }
     
     public String execute() throws SQLException{
        memparamClass = new memberVO();
        memresultClass = new memberVO();
        ActionContext context = ActionContext.getContext();
         Map<String, Object> session = context.getSession();
         String session_id = (String) session.get("m_id");
         memresultClass = (memberVO) sqlMapper.queryForObject("Member.UserCheck",
               session_id);
        list = sqlMapper.queryForList("Board.selectAllNotice");
        totalBlock=list.size();  
         page = new noticePageAction(currentPage, OnePageBlock, pageBlocks, totalBlock, "", "");
         list=list.subList(page.getStartBlock(),page.getEndBlock());
         pagingHtml=page.getPaginHtml().toString();
         return SUCCESS;
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

   public Map getSession() {
      return session;
   }

   public void setSession(Map session) {
      this.session = session;
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
   
   
     
     
}