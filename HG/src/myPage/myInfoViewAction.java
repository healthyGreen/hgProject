package myPage;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.io.Reader;
import java.util.Map;

import member.memberVO;

public class myInfoViewAction extends ActionSupport{
	   public static Reader reader;
	   public static SqlMapClient sqlMapper;
	   private memberVO paramClass;
	   private memberVO resultClass;
	   private String m_pass;
	   private String m_name;
	   private String m_sex;
	   private int m_year;
	   private int m_month;
	   private int m_date;
	   private int m_phone;
	   private String m_email;
	   private String m_zipcode;
	   private String m_addr1;
	   private String m_addr2;
	   private String m_id;
	   private Map<String,Object> session;
	   
	   public myInfoViewAction() throws Exception{
		   reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		   sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		   reader.close();
	   }
	   
	   public String execute() throws Exception{
		   ActionContext context = ActionContext.getContext();
		   session = context.getSession();
		   if(session.get("session_id") == null){
			   return LOGIN;  // 아이디 없을 때 로그인으로 돌아가라
		   }
		   m_id = (String)session.get("session_id");
		   resultClass = (memberVO)sqlMapper.queryForObject("selectOneMember", m_id);
		   return SUCCESS;
	   }
	   // 개인정보 조회 폼 보여주는 처리
	   public String infoView() throws Exception{
		   return SUCCESS;
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

	public String getM_pass() {
		return m_pass;
	}

	public void setM_pass(String m_pass) {
		this.m_pass = m_pass;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getM_sex() {
		return m_sex;
	}

	public void setM_sex(String m_sex) {
		this.m_sex = m_sex;
	}

	public int getM_year() {
		return m_year;
	}

	public void setM_year(int m_year) {
		this.m_year = m_year;
	}

	public int getM_month() {
		return m_month;
	}

	public void setM_month(int m_month) {
		this.m_month = m_month;
	}

	public int getM_date() {
		return m_date;
	}

	public void setM_date(int m_date) {
		this.m_date = m_date;
	}

	public int getM_phone() {
		return m_phone;
	}

	public void setM_phone(int m_phone) {
		this.m_phone = m_phone;
	}

	public String getM_email() {
		return m_email;
	}

	public void setM_email(String m_email) {
		this.m_email = m_email;
	}

	public String getM_zipcode() {
		return m_zipcode;
	}

	public void setM_zipcode(String m_zipcode) {
		this.m_zipcode = m_zipcode;
	}

	public String getM_addr1() {
		return m_addr1;
	}

	public void setM_addr1(String m_addr1) {
		this.m_addr1 = m_addr1;
	}

	public String getM_addr2() {
		return m_addr2;
	}

	public void setM_addr2(String m_addr2) {
		this.m_addr2 = m_addr2;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
