package goods;

import java.io.IOException;
import java.io.Reader;
import java.util.Calendar;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

public class replyWriteAction extends ActionSupport {
	public static Reader reader; // 파일 스트립을 위한 reader.
	public static SqlMapClient sqlMapper; // sqlMapClient API를 사용하기위한
											// sqlMapper객체.

	private replyVO reClass; // 파라미터를 저장할 객체
	private replyVO reresult; // 쿼리 결과값을 저장할 객체

	private int currentPage;
	private int G_NUMBER;
	private String G_CATEGORY;
	private String G_SAV_IMAGE;
	
	private String name;
	private String password;
	private String content;
	private int originno;
	
	

	Calendar today = Calendar.getInstance();

	// 생성자
	public replyWriteAction() throws IOException {

		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}

	public String execute() throws Exception {
		reClass = new replyVO();
		reresult = new replyVO();

		reClass.setRP_NUMBER(getOriginno());
		reClass.setRP_M_ID(getName());
		reClass.setPassword(getPassword());
		reClass.setRP_CONTENT(getContent());
		reClass.setRP_DATE(today.getTime());
		
		sqlMapper.insert("insertComment", reClass);

		return SUCCESS;
	}

	public static Reader getReader() {
		return reader;
	}

	public static void setReader(Reader reader) {
		replyWriteAction.reader = reader;
	}

	public String G_SAV_IMAGE() {
		return G_SAV_IMAGE;
	}

	public void setG_SAV_IMAGE(String goods_savimage) {
		this.G_SAV_IMAGE = goods_savimage;
	}

	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}

	public static void setSqlMapper(SqlMapClient sqlMapper) {
		replyWriteAction.sqlMapper = sqlMapper;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getOriginno() {
		return originno;
	}

	public int getG_NUMBER() {
		return G_NUMBER;
	}

	public void setG_NUMBER(int goods_num) {
		this.G_NUMBER = goods_num;
	}

	public String getG_CATEGORY() {
		return G_CATEGORY;
	}

	public void setG_CATEGORY(String goods_category) {
		this.G_CATEGORY = goods_category;
	}

	public void setOriginno(int originno) {
		this.originno = originno;
	}

	public Calendar getToday() {
		return today;
	}

	public void setToday(Calendar today) {
		this.today = today;
	}

	
	public replyVO getReClass() {
		return reClass;
	}

	public void setReClass(replyVO reClass) {
		this.reClass = reClass;
	}

	public replyVO getReresult() {
		return reresult;
	}

	public void setReresult(replyVO reresult) {
		this.reresult = reresult;
	}

}