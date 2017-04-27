package member;

import com.opensymphony.xwork2.ActionSupport;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.util.*;
import java.io.Reader;
import java.io.IOException;

public class findPwAction extends ActionSupport{
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	private memberVO paramClass;
	private memberVO resultClass;
	private String m_id;
	private String m_name;
	private int m_phone;
	
	public findPwAction() throws IOException{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	public String form() throws Exception{
		return SUCCESS;
	}
	public String execute() throws Exception{
		paramClass = new memberVO();
		resultClass = new memberVO();
		paramClass.setM_id(getM_id());
		paramClass.setM_name(getM_name());
		paramClass.setM_phone(getM_phone());
		resultClass = (memberVO)sqlMapper.queryForObject("Member.findPassword", paramClass);
		if(resultClass != null){
			sqlMapper.update("Member.setPassword1111", paramClass.getM_id());
		} else if(resultClass == null){
			return ERROR;
		}
		return SUCCESS;
		
	}
	// pw찾은 후 jsp 실행 위한 메서드
	public String pwResult() throws Exception{
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
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public int getM_phone() {
		return m_phone;
	}
	public void setM_phone(int m_phone) {
		this.m_phone = m_phone;
	}

}
