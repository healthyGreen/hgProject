package review;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;
import java.util.Map;

public class reviewCheckPassAction extends ActionSupport{
	
	private static Reader reader;
	private static SqlMapClient sqlMapper;
	private String rv_pass;
	private int rv_number;
	private reviewVO paramClass;
	private reviewVO resultClass;
	
	public reviewCheckPassAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	public String form(){
		return SUCCESS;
	}
	
	
	public String execute() throws SQLException{
		
		 paramClass = new reviewVO();
		 resultClass = new reviewVO();
	      paramClass.setRv_pass(rv_pass);
	      paramClass.setRv_number(rv_number);
	      System.out.println(rv_number);
	      resultClass = (reviewVO)sqlMapper.queryForObject("Board.selectPasswordRV", paramClass);
	      if(resultClass != null){
	         /*checkPass = 1;*/
	      return SUCCESS;
	      }
	      else{
	         /*checkPass = 0;*/
	         return ERROR;
	      }
	}
	public static Reader getReader() {
		return reader;
	}
	public static void setReader(Reader reader) {
		reviewCheckPassAction.reader = reader;
	}
	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}
	public static void setSqlMapper(SqlMapClient sqlMapper) {
		reviewCheckPassAction.sqlMapper = sqlMapper;
	}
	public String getRv_pass() {
		return rv_pass;
	}
	public void setRv_pass(String rv_pass) {
		this.rv_pass = rv_pass;
	}
	public int getRv_number() {
		return rv_number;
	}
	public void setRv_number(int rv_number) {
		this.rv_number = rv_number;
	}
	public reviewVO getParamClass() {
		return paramClass;
	}
	public void setParamClass(reviewVO paramClass) {
		this.paramClass = paramClass;
	}
	public reviewVO getresultClass() {
		return resultClass;
	}
	public void setresultClass(reviewVO resultClass) {
		this.resultClass = resultClass;
	}
	
	
	
	
}
