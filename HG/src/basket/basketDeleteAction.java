package basket;

import java.io.Reader;
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
	
	private int b_g_number;
	
	public basketDeleteAction() throws Exception{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	public String execute() throws Exception{
		basparamClass = new basketVO();
		basresultClass = new basketVO();
		memresultClass = new memberVO();
		ActionContext context = ActionContext.getContext();
		Map<String, Object> session = context.getSession();
		String session_id = (String)session.get("m_id");
		memresultClass = (memberVO) sqlMapper.queryForObject("Member.UserCheck", session_id);
		basparamClass.setB_G_NUMBER(b_g_number);
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

	public int getB_g_number() {
		return b_g_number;
	}

	public void setB_g_number(int b_g_number) {
		this.b_g_number = b_g_number;
	}

	

}
