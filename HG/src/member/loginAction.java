package member;

import java.io.Reader;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

public class loginAction extends ActionSupport implements SessionAware{
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	private String m_id;
	private String m_pass;
	private Map session;
	private memberVO paramClass;
	private memberVO resultClass;
	private int M_ADMIN;
	
	public String index() throws Exception{
		if(session.get("session_id")==null)
			return LOGIN;
		else
			return SUCCESS;
	}
	public loginAction() throws Exception{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	public String execute() throws Exception{
		paramClass = new memberVO();
		paramClass.setM_ID(m_id);
		paramClass.setM_PASS(m_pass);
		resultClass = (memberVO)sqlMapper.queryForObject("loginCheck",paramClass);
		if(resultClass != null){
			session.put("session_id", resultClass.getM_ID());
			session.put("session_name", resultClass.getM_NAME());
			session.put("session_admin", resultClass.getM_ADMIN());

			return SUCCESS;
		}
		return ERROR;
		}
	public String logout() throws Exception{
		if(session.get("session_id") != null){
			if((int)session.get("session_admin") == 0){
				session.remove("session_stat");
			}
			session.remove("session_id");
			session.remove("session_name");
			session.remove("session_admin");
		}
		return SUCCESS;
	}
	
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getM_pass() {
		return m_pass;
	}
	public void setM_pass(String m_pass) {
		this.m_pass = m_pass;
	}
	public Map getSession() {
		return session;
	}
	public void setSession(Map session) {
		this.session = session;
	}
	public memberVO getParamClass() {
		return paramClass;
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
	public int getM_ADMIN() {
		return M_ADMIN;
	}
	public void setM_ADMIN(int m_ADMIN) {
		M_ADMIN = m_ADMIN;
	}
	

}
