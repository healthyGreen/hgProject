package myPage;

import com.opensymphony.xwork2.ActionSupport;
import member.memberVO;
import com.opensymphony.xwork2.ActionContext;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.io.Reader;
import java.util.Map;

public class myPageAction extends ActionSupport{
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	private memberVO paramClass;
	private memberVO resultClass;
	private Map session;
	public memberVO getParamClass() {
		return paramClass;
	}
	
	public myPageAction() throws Exception{
		reader=Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper=SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	/*��ٱ��� ����Ʈ �̵�*/
	public String basketList() throws Exception{
		return SUCCESS;
	}
	
	/*���� �� �� �̵�*/
	public String myBoard() throws Exception{
		return SUCCESS;
	}
	
	/*�ֹ����� �̵�*/
	public String orderList() throws Exception{
		return SUCCESS;
	}
	
	/*���� ���� ���� �̵�*/
	public String execute() throws Exception{
		return SUCCESS;
	}
	
	public void setParamClass(memberVO paramClass) {
		this.paramClass = paramClass;
	}
	public memberVO getResultClass() {
		return resultClass;
	}
	public void setResultClass(memberVO resultClass) {
		this.resultClass = resultClass;
	}
	public Map getSession() {
		return session;
	}
	public void setSession(Map session) {
		this.session = session;
	}

}
