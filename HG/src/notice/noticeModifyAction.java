package notice;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;

import org.apache.commons.io.FileUtils;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

public class noticeModifyAction extends ActionSupport {
	private static Reader reader;
	private static SqlMapClient sqlMapper;
	private noticeVO paramClass;
	private noticeVO resultClass;
	
	private int currentPAge;
	
	private int n_number;
	private String n_title;
	private String n_name;
	private String n_content;

	public noticeModifyAction() throws IOException{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
		
	}
	
	public String form(){
		return SUCCESS;
	}
	
	public String execute() throws SQLException, IOException{
		paramClass.setN_NUMBER(n_number);
		paramClass.setN_TITLE(n_title);
		paramClass.setN_NAME(n_name);
		paramClass.setN_CONTENT(n_content);
		
		sqlMapper.update("Board.updateNotice", paramClass);
		
		resultClass=(noticeVO)sqlMapper.queryForObject("Board.selectOneNotice", n_number);
		return SUCCESS;

		
	}

	public static Reader getReader() {
		return reader;
	}

	public static void setReader(Reader reader) {
		noticeModifyAction.reader = reader;
	}

	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}

	public static void setSqlMapper(SqlMapClient sqlMapper) {
		noticeModifyAction.sqlMapper = sqlMapper;
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

	public int getCurrentPAge() {
		return currentPAge;
	}

	public void setCurrentPAge(int currentPAge) {
		this.currentPAge = currentPAge;
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

	public String getN_content() {
		return n_content;
	}

	public void setN_content(String n_content) {
		this.n_content = n_content;
	}
	
	
	
}
