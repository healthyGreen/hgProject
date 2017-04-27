package notice;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import member.memberVO;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class noticeWriteAction extends ActionSupport{
	private static Reader reader;
	private static SqlMapClient sqlMapper;
	
	private memberVO memresultClass;
	private memberVO memparamClass;
	private noticeVO paramClass;
	private noticeVO resultClass;
	
	private List<noticeVO> noticeList = new ArrayList<noticeVO>();
	
	private int currentPage;
	
	private int n_number;
	private String n_title;
	private String n_name;
	Calendar n_date = Calendar.getInstance();
	private String n_content;
	
	
	
	public noticeWriteAction() throws IOException{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	public String form() throws Exception{
		System.out.println(n_date);
		memparamClass = new memberVO();
		memresultClass = new memberVO();
		ActionContext context = ActionContext.getContext();
		Map<String, Object> session = context.getSession();
		String session_id = (String) session.get("m_id");
		memresultClass = (memberVO) sqlMapper.queryForObject("Member.UserCheck",
				session_id);
		return SUCCESS;
	}
	
	
	
	public String execute() throws Exception{
		memparamClass = new memberVO();
		memresultClass = new memberVO();
		paramClass = new noticeVO();
		resultClass = new noticeVO();
		ActionContext context = ActionContext.getContext();
		Map<String, Object> session = context.getSession();
		String session_id = (String) session.get("m_id");
		memresultClass = (memberVO) sqlMapper.queryForObject("Member.UserCheck",
				session_id);
		paramClass.setN_name(getN_name());
		System.out.println(getN_title());
		paramClass.setN_title(getN_title());
		paramClass.setN_content(getN_content());
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

	public List<noticeVO> getNoticeList() {
		return noticeList;
	}

	public void setNoticeList(List<noticeVO> noticeList) {
		this.noticeList = noticeList;
	}

	public int getN_currentPage() {
		return currentPage;
	}

	public void setN_currentPage(int n_currentPage) {
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
	
	

	
	
	
	
}
