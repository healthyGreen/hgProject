package basket;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.io.Reader;
import java.util.Map;

import member.memberVO;
import basket.basketVO;


public class basketModifyAction extends ActionSupport{
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	private basketVO paramClass;
	private basketVO resultClass;
	private int b_g_amount;
	private int b_g_price;
	private int b_g_number;
	private String m_id;
	private int b_number;
	//private Map<String,Object> session;
	
	public basketModifyAction() throws Exception{
		reader=Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper=SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	public String execute() throws Exception{
		System.out.println(b_number);
		//ActionContext context=ActionContext.getContext();
		/*session=context.getSession();
		if(session.get("session_id")==null){
			return LOGIN;
		}*/
		paramClass = new basketVO();
		paramClass.setB_g_number(getB_g_number());
		paramClass.setB_g_amount(getB_g_amount()); //3
		paramClass.setB_number(getB_number()); //44
		paramClass.setB_allPrice(getB_g_amount()*getB_g_price());
		sqlMapper.update("Basket.amountModify",paramClass);
		return SUCCESS;
	}
	public basketVO getParamClass() {
		return paramClass;
	}
	public void setParamClass(basketVO paramClass) {
		this.paramClass = paramClass;
	}
	public basketVO getResultClass() {
		return resultClass;
	}
	public void setResultClass(basketVO resultClass) {
		this.resultClass = resultClass;
	}
	public int getB_g_amount() {
		return b_g_amount;
	}
	public void setB_g_amount(int b_g_amount) {
		this.b_g_amount = b_g_amount;
	}
	public int getB_g_number() {
		return b_g_number;
	}
	public void setB_g_number(int b_g_number) {
		this.b_g_number = b_g_number;
	}

	

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public int getB_g_price() {
		return b_g_price;
	}

	public void setB_g_price(int b_g_price) {
		this.b_g_price = b_g_price;
	}

	public int getB_number() {
		return b_number;
	}

	public void setB_number(int b_number) {
		this.b_number = b_number;
	}
	
	

}
