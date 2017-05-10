package review;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

import review.reviewVO;

public class reviewDeleteAction extends ActionSupport{
	public static Reader reader; // 파일 스트림을 위한 reader
	public static SqlMapClient sqlMapper;// SqlMapClient API를 사용하기 위함
	
	private reviewVO resultClass;
	private reviewVO paramClass;
	private int currentPage;
	
	private int rv_number;
	private String rv_title;
	private String rv_name;
	private String rv_content;
	

	public reviewDeleteAction() throws Exception{
		reader=Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper=SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}

public String execute() throws Exception{

	paramClass = new reviewVO();
	resultClass = new reviewVO();
	/*ActionContext context = ActionContext.getContext();
	Map<String, Object> session = context.getSession();
	String session_id = (String) session.get("m_id");
	memresultClass = (memberVO) sqlMapper.queryForObject("Member.UserCheck",
			session_id);*/
	paramClass.setRv_number(getRv_number());
	System.out.println(rv_number);
	sqlMapper.delete("Board.deleteReview",paramClass);
	return SUCCESS;
}

public reviewVO getResultClass() {
	return resultClass;
}

public void setResultClass(reviewVO resultClass) {
	this.resultClass = resultClass;
}

public reviewVO getParamClass() {
	return paramClass;
}

public void setParamClass(reviewVO paramClass) {
	this.paramClass = paramClass;
}

public int getCurrentPage() {
	return currentPage;
}

public void setCurrentPage(int currentPage) {
	this.currentPage = currentPage;
}

public int getRv_number() {
	return rv_number;
}

public void setRv_number(int rv_number) {
	this.rv_number = rv_number;
}

public String getRv_title() {
	return rv_title;
}

public void setRv_title(String rv_title) {
	this.rv_title = rv_title;
}

public String getRv_name() {
	return rv_name;
}

public void setRv_name(String rv_name) {
	this.rv_name = rv_name;
}

public String getRv_content() {
	return rv_content;
}

public void setRv_content(String rv_content) {
	this.rv_content = rv_content;
}



	
}
