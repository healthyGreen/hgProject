package review;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

public class reviewDeleteAction extends ActionSupport{
	static private Reader reader;
	static private SqlMapClient sqlMapper;
	static int number;
	static String pass;
	private reviewVO paramClass;
	
	public reviewDeleteAction() throws IOException {
		reader=Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper=SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	public String execute() throws SQLException{
		paramClass.setRV_NUMBER(number);
		paramClass.setRV_PASS(pass);
		sqlMapper.delete("deleteReview", paramClass);
		return SUCCESS;
	}

	public static int getNumber() {
		return number;
	}

	public static void setNumber(int number) {
		reviewDeleteAction.number = number;
	}

	public static String getPass() {
		return pass;
	}

	public static void setPass(String pass) {
		reviewDeleteAction.pass = pass;
	}
}
