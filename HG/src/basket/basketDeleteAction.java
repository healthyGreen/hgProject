package basket;

import java.io.Reader;
import java.sql.SQLException;
import java.util.Map;

import member.memberVO;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class basketDeleteAction extends ActionSupport{
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private memberVO memresultClass;
	private basketVO basparamClass;
	private basketVO basresultClass;;
	private int b_number;
	private String m_id;
	//private int b_g_number;
	private Map session;
	
	public Map getSession() {
		return session;
	}
	public void setSession(Map session) {
		this.session = session;
	}
	public basketDeleteAction() throws Exception{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	public String deleteAll() throws SQLException{
		/*ActionContext context = ActionContext.getContext(); // session을 생성하기 위해
		Map<String, Object> session = context.getSession();
		String session_id = (String) session.get("session_id");*/
		sqlMapper.delete("Basket.basketDeleteAll",m_id);
		return SUCCESS;
	}
	public String execute() throws Exception{
		System.out.println(b_number);
		basparamClass = new basketVO();
		basresultClass = new basketVO();
		memresultClass = new memberVO();
		basparamClass.setB_number(b_number);
		
		/*ActionContext context = ActionContext.getContext();
		Map<String, Object> session = context.getSession();
*/		/*String session_id = (String)session.get("m_id");
		memresultClass = (memberVO) sqlMapper.queryForObject("Member.UserCheck", session_id);
		basparamClass.setB_g_number(b_g_number);*/
		sqlMapper.delete("Basket.basketDelete", basparamClass);
		return SUCCESS;
	}

	public memberVO getMemresultClass() {
		return memresultClass;
	}

	public void setMemresultClass(memberVO memresultClass) {
		this.memresultClass = memresultClass;
	}

	public basketVO getBasparamClass() {
		return basparamClass;
	}

	public void setBasparamClass(basketVO basparamClass) {
		this.basparamClass = basparamClass;
	}

	public basketVO getBasresultClass() {
		return basresultClass;
	}

	public void setBasresultClass(basketVO basresultClass) {
		this.basresultClass = basresultClass;
	}

	public int getB_number() {
		return b_number;
	}

	public void setB_number(int b_number) {
		this.b_number = b_number;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	

	/*public int getB_g_number() {
		return b_g_number;
	}

	public void setB_g_number(int b_g_number) {
		this.b_g_number = b_g_number;
	}*/
	
	

}
