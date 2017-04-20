package myPage;

import com.opensymphony.xwork2.ActionSupport;
import member.memberVO;
import com.opensymphony.xwork2.ActionContext;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.io.Reader;
import java.util.Map;

public class myInfoModifyAction extends ActionSupport{
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
	
	public myInfoModifyAction() throws Exception{
		reader=Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper=SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	public String form() throws Exception{
		return SUCCESS;
		
	}
	public String execute() throws Exception{
		//보안을위한 아이디 로그인 체크
		ActionContext context=ActionContext.getContext();
		session=context.getSession();
		if(session.get("session_id")==null){
			return LOGIN;
		}
		paramClass = new memberVO();
		paramClass.setM_PASS(getM_pass());
		paramClass.setM_NAME(getM_name());
		paramClass.setM_SEX(getM_sex());
		paramClass.setM_YEAR(getM_year());
		paramClass.setM_MONTH(getM_month());
		paramClass.setM_DATE(getM_date());
		paramClass.setM_PHONE(getM_phone());
		paramClass.setM_EMAIL(getM_email());
		paramClass.setM_ZIPCODE(getM_zipcode());
		paramClass.setM_ADDR1(getM_addr1());
		paramClass.setM_ADDR2(getM_addr2());
		paramClass.setM_ID(getM_id());
		sqlMapper.update("modifyMember",paramClass);
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
