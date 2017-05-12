package myPage;

import com.opensymphony.xwork2.ActionSupport;
import member.memberVO;
import notice.noticeVO;

import com.opensymphony.xwork2.ActionContext;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import basket.basketVO;

public class myPageAction extends ActionSupport{
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	private memberVO paramClass;
	private memberVO resultClass;
	private Map session;
	private String m_id;
	private String m_name;
	private int m_point;
	private int basketCount;
	private int myPoint;
	List<basketVO> list = new ArrayList<basketVO>();
	
	
	public myPageAction() throws Exception{
		reader=Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper=SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	public String execute() throws Exception{
		ActionContext context = ActionContext.getContext(); // session�� �����ϱ� ����
		Map<String, Object> session = context.getSession();
		String session_id = (String) session.get("session_id");
		list = sqlMapper.queryForList("Basket.basketCount",session_id);
		myPoint = (int)sqlMapper.queryForObject("Member.selectPoint",session_id);
		System.out.println(myPoint);
		basketCount = list.size();
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

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
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

	public int getM_point() {
		return m_point;
	}

	public void setM_point(int m_point) {
		this.m_point = m_point;
	}

	public List<basketVO> getList() {
		return list;
	}

	public void setList(List<basketVO> list) {
		this.list = list;
	}

	public int getBasketCount() {
		return basketCount;
	}

	public void setBasketCount(int basketCount) {
		this.basketCount = basketCount;
	}

	public int getMyPoint() {
		return myPoint;
	}

	public void setMyPoint(int myPoint) {
		this.myPoint = myPoint;
	}

	
	
	
}
