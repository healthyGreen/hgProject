package review;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

public class reviewCheckPassAction extends ActionSupport{
	
	private static Reader reader;
	private static SqlMapClient sqlMapper;
	private String pass;
	private int number;
	private reviewVO paramClass;
	private reviewVO passCheckClass;
	
	public reviewCheckPassAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	public String form(){
		return SUCCESS;
	}
	public String execute() throws SQLException{
		paramClass.setRv_number(number);
		paramClass.setRv_pass(pass);
		passCheckClass = (reviewVO)sqlMapper.queryForObject("Board.selectPasswordRV", paramClass);
		if(passCheckClass!=null) return SUCCESS;
		else return ERROR;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
}
