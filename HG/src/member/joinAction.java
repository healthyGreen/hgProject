package member;

import com.opensymphony.xwork2.ActionSupport;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.util.*;
import java.io.Reader;
import java.io.IOException;

public class joinAction extends ActionSupport{
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	private memberVO paramClass;
	private memberVO resultClass;
	
	private String m_id;
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
	private int m_admin;
	private int m_point;
	Calendar today = Calendar.getInstance();
	
	public joinAction() throws IOException{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	// 회원가입 약관 동의 페이지 이동
	public String joinCheck() throws Exception{
		return SUCCESS;
	}
	
	// 회원가입 폼
	public String form() throws Exception{
		return SUCCESS;
	}
	
	// 회원가입 입력 액션
	public String execute() throws Exception{
		paramClass = new memberVO();
		resultClass = new memberVO();
		paramClass.setM_id(getM_id());
		resultClass=(memberVO)sqlMapper.queryForObject("Member.selectOneMember", paramClass.getM_id());
		if(resultClass != null){
			return ERROR;
		}else{
		
		paramClass.setM_pass(getM_pass());
		paramClass.setM_name(getM_name());
		paramClass.setM_sex(getM_sex());
		paramClass.setM_year(getM_year());
		paramClass.setM_month(getM_month());
		paramClass.setM_date(getM_date());
		paramClass.setM_phone(getM_phone());
		paramClass.setM_email(getM_email());
		paramClass.setM_zipcode(getM_zipcode());
		paramClass.setM_addr1(getM_addr1());
		paramClass.setM_addr2(getM_addr2());
		paramClass.setM_admin(getM_admin());
		paramClass.setM_point(getM_point());
		paramClass.setM_joindate(today.getTime());
				
		sqlMapper.insert("Member.insertMember", paramClass);
				
			return SUCCESS;
		}
		
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

	public int getM_admin() {
		return m_admin;
	}
	public void setM_admin(int m_admin) {
		this.m_admin = m_admin;
	}
	public int getM_point() {
		return m_point;
	}
	public void setM_point(int m_point) {
		this.m_point = m_point;
	}
	public Calendar getToday() {
		return today;
	}

	public void setToday(Calendar today) {
		this.today = today;
	}
}
