package notice;

import java.io.Reader;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.opensymphony.xwork2.ActionSupport;

public class noticePageAction {
	 private int currentPage;
	   private int OnePageBlocks;
	   private int pageBlocks;
	   private int startBlock;
	   private int endBlock;
	   private int startPage;
	   private int endPage;
	   private int totalPage;
	   private int totalBlock;
	   
	   private StringBuffer paginHtml;

	   public noticePageAction(int currentPage, int onePageBlock, int pageBlocks, int totalBlock, String search, String forSearch) {
	      this.currentPage=currentPage;
	      this.OnePageBlocks=onePageBlock;
	      this.pageBlocks=pageBlocks;
	      this.totalBlock=totalBlock;
	      
	      totalPage=(int)Math.ceil((double)totalBlock/OnePageBlocks);
	      if(totalPage==0){
	         totalPage=1;
	      }
	      if(currentPage>totalPage)
	         currentPage=totalPage;
	      
	      startBlock=(currentPage-1)*OnePageBlocks;
	      endBlock=startBlock+OnePageBlocks-1;
	      if(endBlock>totalBlock)
	         endBlock=totalBlock;
	      
	      startPage=((currentPage-1)/pageBlocks) * pageBlocks +1;
	      endPage = startPage+pageBlocks-1;
	      if(endPage>totalPage)
	         endPage=totalPage;
	      
	      paginHtml = new StringBuffer();
	      if(currentPage>pageBlocks){
	         if(search!="")
	            paginHtml.append("<a href=noticeListAction.action?currentPage="+(startPage-1)+"&search="+search+"&forSearch="+forSearch+">");
	         else
	            paginHtml.append("<a href=noticeListAction.action?currentPage="+(startPage-1)+">");
	         paginHtml.append("[이전]");
	         paginHtml.append("</a>");
	      }
	      paginHtml.append("&nbsp;|&nbsp;");
	      for(int i=startBlock; i<=endBlock; i++){
	         if(i==currentPage){
	            paginHtml.append("&nbsp;<b><font color='red'>");
	            paginHtml.append(i);
	            paginHtml.append("</font></b>");
	         }else{
	            paginHtml.append("&nbsp;<a href='noticeListAction?currentPage=");
	            paginHtml.append(i);
	            
	            if(search!="")
	               paginHtml.append("&search="+search+"&forSearch="+"forSearch");
	            paginHtml.append("'>");
	            paginHtml.append(i);
	            paginHtml.append("</a>");
	         }
	         paginHtml.append("&nbsp");
	      }
	      paginHtml.append("&nbsp;|&nbsp;");
	      
	      if(endPage<totalPage){
	         paginHtml.append("&nbsp;<a href='noticeListAction?currentPage=");
	         paginHtml.append(endPage+1);
	         
	         if(search!="")
	            paginHtml.append("&search="+search+"&forSearch"+forSearch);
	         
	         paginHtml.append("'>");
	         paginHtml.append("[다음]");
	         paginHtml.append("</a>");
	      }
	   }
	   public int getCurrentPage() {
	      return currentPage;
	   }

	   public void setCurrentPage(int currentPage) {
	      this.currentPage = currentPage;
	   }

	   public int getOnePageBlocks() {
	      return OnePageBlocks;
	   }

	   public void setOnePageBlocks(int onePageBlocks) {
	      OnePageBlocks = onePageBlocks;
	   }

	   public int getPageBlocks() {
	      return pageBlocks;
	   }

	   public void setPageBlocks(int pageBlocks) {
	      this.pageBlocks = pageBlocks;
	   }

	   public int getStartBlock() {
	      return startBlock;
	   }

	   public void setStartBlock(int startBlock) {
	      this.startBlock = startBlock;
	   }

	   public int getEndBlock() {
	      return endBlock;
	   }

	   public void setEndBlock(int endBlock) {
	      this.endBlock = endBlock;
	   }

	   public int getStartPage() {
	      return startPage;
	   }

	   public void setStartPage(int startPage) {
	      this.startPage = startPage;
	   }

	   public int getEndPage() {
	      return endPage;
	   }

	   public void setEndPage(int endPage) {
	      this.endPage = endPage;
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

	   public StringBuffer getPaginHtml() {
	      return paginHtml;
	   }

	   public void setPaginHtml(StringBuffer paginHtml) {
	      this.paginHtml = paginHtml;
	   }
	   

}
