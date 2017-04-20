package myPage;

import java.io.Reader;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import member.memberVO;

public class existAction extends ActionSupport{
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	private memberVO paramClass;
	private memberVO resultClass;
	private String M_ID;
	private String M_PASS;
	private String M_NAME;
	private String M_SEX;
	private int M_YEAR;
	private int M_MONTH;
	private int M_DATE;
	private int M_PHONE;
	private String M_EMAIL;
	private String M_ZIPCODE;
	private String M_ADDR1;
	private String M_ADDR2;
	private Date M_JOINDATE;
	private int M_POINT;
	private int checkPass;
	Calendar today = Calendar.getInstance();
	
	public existAction() throws Exception{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	//회원탈퇴전 비밀번호 체크 폼이동
	public String checkForm() throws Exception{
		return SUCCESS;
	}
	//비밀번호 확인후 SUCCESS시 경고문이동 ERROR 시 passerror.jsp 이동
	public String form() throws Exception{
		if(resultClass.getM_PASS().equals(M_PASS)){
			checkPass = 1;
		return SUCCESS;
		}
		else{
			checkPass = 0;
			return ERROR;
		}
	}
	//회원 탈퇴 처리
	public String execute() throws Exception{
		paramClass = new memberVO();
		resultClass = new memberVO();
		ActionContext context = ActionContext.getContext();
		Map<String, Object> session = context.getSession();
		String session_id = (String) session.get("m_id");
		resultClass = (memberVO) sqlMapper.queryForObject("UserCheck", session_id);	
			paramClass.setM_ID(session_id);
			sqlMapper.delete("deleteMember", paramClass);
			context.getSession().clear();
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

	public String getM_ID() {
		return M_ID;
	}

	public void setM_ID(String m_ID) {
		M_ID = m_ID;
	}

	public String getM_PASS() {
		return M_PASS;
	}

	public void setM_PASS(String m_PASS) {
		M_PASS = m_PASS;
	}

	public String getM_NAME() {
		return M_NAME;
	}

	public void setM_NAME(String m_NAME) {
		M_NAME = m_NAME;
	}

	public String getM_SEX() {
		return M_SEX;
	}

	public void setM_SEX(String m_SEX) {
		M_SEX = m_SEX;
	}

	public int getM_YEAR() {
		return M_YEAR;
	}

	public void setM_YEAR(int m_YEAR) {
		M_YEAR = m_YEAR;
	}

	public int getM_MONTH() {
		return M_MONTH;
	}

	public void setM_MONTH(int m_MONTH) {
		M_MONTH = m_MONTH;
	}

	public int getM_DATE() {
		return M_DATE;
	}

	public void setM_DATE(int m_DATE) {
		M_DATE = m_DATE;
	}

	public int getM_PHONE() {
		return M_PHONE;
	}

	public void setM_PHONE(int m_PHONE) {
		M_PHONE = m_PHONE;
	}

	public String getM_EMAIL() {
		return M_EMAIL;
	}

	public void setM_EMAIL(String m_EMAIL) {
		M_EMAIL = m_EMAIL;
	}

	public String getM_ZIPCODE() {
		return M_ZIPCODE;
	}

	public void setM_ZIPCODE(String m_ZIPCODE) {
		M_ZIPCODE = m_ZIPCODE;
	}

	public String getM_ADDR1() {
		return M_ADDR1;
	}

	public void setM_ADDR1(String m_ADDR1) {
		M_ADDR1 = m_ADDR1;
	}

	public String getM_ADDR2() {
		return M_ADDR2;
	}

	public void setM_ADDR2(String m_ADDR2) {
		M_ADDR2 = m_ADDR2;
	}

	public Date getM_JOINDATE() {
		return M_JOINDATE;
	}

	public void setM_JOINDATE(Date m_JOINDATE) {
		M_JOINDATE = m_JOINDATE;
	}

	public int getM_POINT() {
		return M_POINT;
	}

	public void setM_POINT(int m_POINT) {
		M_POINT = m_POINT;
	}

	public Calendar getToday() {
		return today;
	}

	public void setToday(Calendar today) {
		this.today = today;
	}

	public int getCheckPass() {
		return checkPass;
	}

	public void setCheckPass(int checkPass) {
		this.checkPass = checkPass;
	}
	
	

}
