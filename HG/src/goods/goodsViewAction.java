package goods;

import com.opensymphony.xwork2.ActionSupport;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.io.Reader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.net.URLEncoder;
import goods.replyVO;

public class goodsViewAction extends ActionSupport{
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private replyVO paramClass = new replyVO();
	private replyVO resultClass = new replyVO();
	
	private int currentPage;
	
	private int no;
	private String password;
	
	private InputStream inputStream;
	private String contentDisposition;
	private long contentLength;
	
	public goodsViewAction() throws IOException{
		reader=Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	public String execute() throws Exception{
		paramClass.setNo(getNo());
		sqlMapper.update("updateReadHit", paramClass);
		
		resultClass = (replyVO) sqlMapper.queryForObject("selectOne", getNo());
		return SUCCESS;
	}
	public String checkForm() throws Exception{
		return SUCCESS;
	}
	
	public String checkAction() throws Exception{
		paramClass.setNo(getNo());
		paramClass.setPassword(getPassword());
		
		resultClass = (replyVO) sqlMapper.queryForObject("selectPassword",
				paramClass);
		
		if(resultClass == null)
			return ERROR;
		
		return SUCCESS;
	}

	public replyVO getParamClass() {
		return paramClass;
	}

	public void setParamClass(replyVO paramClass) {
		this.paramClass = paramClass;
	}

	public replyVO getResultClass() {
		return resultClass;
	}

	public void setResultClass(replyVO resultClass) {
		this.resultClass = resultClass;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getContentDisposition() {
		return contentDisposition;
	}

	public void setContentDisposition(String contentDisposition) {
		this.contentDisposition = contentDisposition;
	}

	public long getContentLength() {
		return contentLength;
	}

	public void setContentLength(long contentLength) {
		this.contentLength = contentLength;
	}
			
}
