package review;

import java.io.Reader;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.opensymphony.xwork2.ActionSupport;

public class reviewPageAction{
   
	private int currentPage;   // 현재페이지
	private int totalCount;	 // 전체 게시물 수
	private int totalPage;	 // 전체 페이지 수
	private int blockCount;	 // 한 페이지의  게시물의 수
	private int blockPage;	 // 한 화면에 보여줄 페이지 수
	private int startCount;	 // 한 페이지에서 보여줄 게시글의 시작 번호
	private int endCount;	 // 한 페이지에서 보여줄 게시글의 끝 번호
	private int startPage;	 // 시작 페이지
	private int endPage;	 // 마지막 페이지
	
	private StringBuffer pagingHtml;
	
	public reviewPageAction(int currentPage, int totalCount, int blockCount, int blockPage, String searchNum, String isSearch
			){
		
		this.blockCount = blockCount;
		this.blockPage = blockPage;
		this.currentPage = currentPage;
		this.totalCount = totalCount;
		
		
		// 전체 페이지 수
				totalPage = (int) Math.ceil((double) totalCount / blockCount);
				if (totalPage == 0) {
					totalPage = 1;
	}
			//현재 페이지가 전체 페이지 수보다 클 때 전체 페이지 수로 설정	
				if(currentPage > totalPage){
					currentPage = totalPage;
				}
				
				//현재 페이지의 처음과 마지막 글의 번호 가져오는 것.
		startCount = (currentPage-1)*blockCount;
		endCount = startCount + blockCount - 1;
		
		//시작 페이지와 마지막 페이지 값 구하기.
		startPage = (int) ((currentPage-1)/blockPage)*blockPage+1;
		endPage = startPage + blockPage - 1;
		
		//마지막 페이지가 전체 페이지 수보다 클 때 전체 페이지 수로 설정
		if(endPage > totalPage){
			endPage = totalPage;
		}
		
		//이전 block 페이지
		pagingHtml = new StringBuffer();
		if(currentPage>blockPage){
			if(isSearch != "")
			pagingHtml.append("<a href=reviewList.action?currentPage="
					+(startPage-1)+ "&searchKeyword="+isSearch+"&searchNum="+searchNum+">");
			else
				pagingHtml.append("<a href=reviewList.action?currentPage=" +
			(startPage-1)+">");
			pagingHtml.append("이전");
			pagingHtml.append("</a>");
}
	

	for(int i = startPage; i<=endPage; i++){
		pagingHtml.append("|&nbsp;");
		if(i>totalPage){
			break;
		}
		if(i==currentPage){
			pagingHtml.append("&nbsp;<b> <font color='red'>");
			pagingHtml.append(i);
			pagingHtml.append("</font></b>");
	}else{
		pagingHtml.append("&nbsp;<a href=reviewList.action?currentPage=");
		pagingHtml.append(i);
		if(isSearch != ""){
			pagingHtml.append("&searchKeyword="+isSearch+"&searchNum="+searchNum);
		}
			pagingHtml.append(">");
		pagingHtml.append(i);
		pagingHtml.append("</a>");
	}
		pagingHtml.append("&nbsp;&nbsp;|&nbsp;&nbsp;");
}
	
	//다음 block 페이지
	if(totalPage - startPage >= blockPage){
		pagingHtml.append("&nbsp;<a href=reviewList.action?currentPage=");
		pagingHtml.append((endPage+1));
		if(isSearch != "")
			pagingHtml.append("&searchKeyword="+isSearch+"&searchNum="+searchNum);
		pagingHtml.append("'>");
		pagingHtml.append("다음");
		pagingHtml.append("</a>");
	}
	}
   
   public int getCurrentPage() {
      return currentPage;
   }

   public void setCurrentPage(int currentPage) {
      this.currentPage = currentPage;
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

public int getStartCount() {
	return startCount;
}

public void setStartCount(int startCount) {
	this.startCount = startCount;
}

public int getEndCount() {
	return endCount;
}

public void setEndCount(int endCount) {
	this.endCount = endCount;
}

public StringBuffer getPagingHtml() {
	return pagingHtml;
}

public void setPagingHtml(StringBuffer pagingHtml) {
	this.pagingHtml = pagingHtml;
}


   
   
   
}