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

}
