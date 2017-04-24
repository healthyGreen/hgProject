package notice;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

public class noticeWriteAction extends ActionSupport{
	private static Reader reader;
	private static SqlMapClient sqlMapper;
	
	private int n_currentPage;
	
	private int n_number;
	private String n_title;
	private String n_name;
	Calendar n_date = Calendar.getInstance();
	private String n_content;
	
	private noticeVO paramClass;
	private noticeVO resultClass;
	
	public noticeWriteAction() throws IOException{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	public String form(){
		return SUCCESS;
	}
	
	
	public String execute() throws Exception{
		
		paramClass = new noticeVO();
		resultClass = new noticeVO();
		
		paramClass.setN_NUMBER(getN_number());
		paramClass.setN_TITLE(getN_title());
		paramClass.setN_NAME(getN_name());
		paramClass.setN_DATE(n_date.getTime());
		paramClass.setN_CONTENT(getN_content());
		
		sqlMapper.insert("Board.insertNotice", paramClass); 
		
		
		return SUCCESS;
	}

	public static Reader getReader() {
		return reader;
	}

	public static void setReader(Reader reader) {
		noticeWriteAction.reader = reader;
	}

	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}

	public static void setSqlMapper(SqlMapClient sqlMapper) {
		noticeWriteAction.sqlMapper = sqlMapper;
	}

	public int getN_currentPage() {
		return n_currentPage;
	}

	public void setN_currentPage(int n_currentPage) {
		this.n_currentPage = n_currentPage;
	}

	public int getN_number() {
		return n_number;
	}

	public void setN_number(int n_number) {
		this.n_number = n_number;
	}

	public String getN_title() {
		return n_title;
	}

	public void setN_title(String n_title) {
		this.n_title = n_title;
	}

	public String getN_name() {
		return n_name;
	}

	public void setN_name(String n_name) {
		this.n_name = n_name;
	}

	public Calendar getN_date() {
		return n_date;
	}

	public void setN_date(Calendar n_date) {
		this.n_date = n_date;
	}

	public String getN_content() {
		return n_content;
	}

	public void setN_content(String n_content) {
		this.n_content = n_content;
	}

	public noticeVO getParamClass() {
		return paramClass;
	}

	public void setParamClass(noticeVO paramClass) {
		this.paramClass = paramClass;
	}

	public noticeVO getResultClass() {
		return resultClass;
	}

	public void setResultClass(noticeVO resultClass) {
		this.resultClass = resultClass;
	}
	
	
	
	
}
