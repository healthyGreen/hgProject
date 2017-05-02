package notice;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import member.memberVO;

public class noticeModifyAction extends ActionSupport {
	private static Reader reader;
	private static SqlMapClient sqlMapper;
	private noticeVO paramClass;
	private noticeVO resultClass;
	private memberVO memresultClass;
	private memberVO memparamClass;

	private int currentPage;
	
	private int n_number;
	private String n_title;
	private String n_name;
	private String n_content;

	public noticeModifyAction() throws IOException{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
		
	}
	
	
	public String form() throws Exception {
		memparamClass = new memberVO();
		memresultClass = new memberVO();
		paramClass= new noticeVO();
		resultClass = new noticeVO();
		ActionContext context = ActionContext.getContext();
		//Map<String, Object> session = context.getSession();
		/*String session_id = (String) session.get("m_id");
		memresultClass = (memberVO) sqlMapper.queryForObject("Member.UserCheck",
				session_id);*/
		paramClass.setN_number(getN_number());
		resultClass = (noticeVO) sqlMapper.queryForObject("Board.selectOneNotice", n_number);
		return SUCCESS;
	}

	public String execute() throws Exception {
		memparamClass = new memberVO();
		memresultClass = new memberVO();
	

		paramClass= new noticeVO();
		resultClass = new noticeVO();

		paramClass.setN_number(getN_number());
		paramClass.setN_title(getN_title());
		paramClass.setN_content(getN_content());
		sqlMapper.update("Board.updateNotice", paramClass);

		
		//resultClass = (noticeVO) sqlMapper.queryForObject("Board.selectOneNotice", n_number);
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

	

	public int getCurrentPage() {
		return currentPage;
	}


	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
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
