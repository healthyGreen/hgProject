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
import review.reviewPageAction;

public class noticeListAction extends ActionSupport{
   private static Reader reader;
   private static SqlMapClient sqlMapper;
   
   //  private memberVO memresultClass;
   //  private memberVO memparamClass;
     private int currentPage=1;
     private int totalCount;
     private int blockCount = 10; // 10으로 다시 바꾸면 됨
     private int blockPage = 5;

 
 
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
      //  memparamClass = new memberVO();
       // memresultClass = new memberVO();
        ActionContext context = ActionContext.getContext();
       //  Map<String, Object> session = context.getSession();
        /* String session_id = (String) session.get("session_id");
         memresultClass = (memberVO) sqlMapper.queryForObject("Member.UserCheck",
               session_id);*/
        list = sqlMapper.queryForList("Board.selectAllNotice");
        totalCount = list.size();  
      
         page = new noticePageAction(currentPage, totalCount, blockCount, blockPage, "", "");
         pagingHtml = page.getPagingHtml().toString();
         
         //System.out.println("page :"+page);
         //System.out.println("pagingHtml :"+pagingHtml);
         
         int lastCount = totalCount;
         if (page.getEndCount() < totalCount)
            lastCount = page.getEndCount() + 1;

         list = list.subList(page.getStartCount(), lastCount);
         return SUCCESS;
     }

   public int getCurrentPage() {
      return currentPage;
   }

   public void setCurrentPage(int currentPage) {
      this.currentPage = currentPage;
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
   
   
}