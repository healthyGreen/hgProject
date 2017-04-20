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
	Calendar today = Calendar.getInstance();
	
	public existAction() throws Exception{
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
		ActionContext context = ActionContext.getContext();
		Map<String, Object> session = context.getSession();
		String session_id = (String) session.get("m_id");
		resultClass = (memberVO) sqlMapper.queryForObject("UserCheck", session_id);
		if(resultClass.getM_PASS().equals(M_PASS)){
			paramClass.setM_ID(session_id);
			sqlMapper.delete("deleteMember", paramClass);
			context.getSession().clear();
			return SUCCESS;
		}
		return ERROR;
	}

}
