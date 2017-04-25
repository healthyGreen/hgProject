package basket;

import java.io.Reader;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import member.memberVO;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class basketInputAction extends ActionSupport{
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private memberVO memparamClass;
	private memberVO memresultClass;
	private basketVO basparamClass;
	private basketVO basresultClass;
	
	private String g_number;
	private String g_name;
	private String g_sav_image;
	private int g_price;
	private int g_amout;
	
	private String b_m_id;
	private int b_g_number;
	private String b_g_name;
	private int b_g_amout;
	private int b_allprice;
	private String b_bottle;
	private Date b_date;
	Calendar today = Calendar.getInstance();

	public basketInputAction() throws Exception{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	public String execute() throws Exception{
		basparamClass = new basketVO();
		basresultClass = new basketVO();
		ActionContext context = ActionContext.getContext();
		Map<String, Object> session = context.getSession();
		String session_id = (String) session.get("m_id");
		memresultClass = (memberVO) sqlMapper.queryForObject("Member.UserCheck", session_id);
		
		basparamClass.setB_m_id(session_id);
		basparamClass.setB_g_name(getB_g_name());
		basparamClass.setB_g_amout(getB_g_amout());
		basparamClass.setB_allPrice(getB_allprice());
		basparamClass.setB_g_bottle(getB_bottle());
		basparamClass.setB_date(getB_date());
		basparamClass.setB_g_number(getB_g_number());  // 굳이 넣지 않아도 됩니다!!!(장바구니에 상품 번호 안뜨기 때문에)
		sqlMapper.insert("Basket.basketInsert", basparamClass);
		return SUCCESS;
	}

	public memberVO getMemparamClass() {
		return memparamClass;
	}

	public void setMemparamClass(memberVO memparamClass) {
		this.memparamClass = memparamClass;
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

	public String getG_number() {
		return g_number;
	}

	public void setG_number(String g_number) {
		this.g_number = g_number;
	}

	public String getG_name() {
		return g_name;
	}

	public void setG_name(String g_name) {
		this.g_name = g_name;
	}

	public String getG_sav_image() {
		return g_sav_image;
	}

	public void setG_sav_image(String g_sav_image) {
		this.g_sav_image = g_sav_image;
	}

	public int getG_price() {
		return g_price;
	}

	public void setG_price(int g_price) {
		this.g_price = g_price;
	}

	public int getG_amout() {
		return g_amout;
	}

	public void setG_amout(int g_amout) {
		this.g_amout = g_amout;
	}

	public String getB_m_id() {
		return b_m_id;
	}

	public void setB_m_id(String b_m_id) {
		this.b_m_id = b_m_id;
	}

	public int getB_g_number() {
		return b_g_number;
	}

	public void setB_g_number(int b_g_number) {
		this.b_g_number = b_g_number;
	}

	public String getB_g_name() {
		return b_g_name;
	}

	public void setB_g_name(String b_g_name) {
		this.b_g_name = b_g_name;
	}

	public int getB_g_amout() {
		return b_g_amout;
	}

	public void setB_g_amout(int b_g_amout) {
		this.b_g_amout = b_g_amout;
	}

	public int getB_allprice() {
		return b_allprice;
	}

	public void setB_allprice(int b_allprice) {
		this.b_allprice = b_allprice;
	}
	public Date getB_date() {
		return b_date;
	}

	public void setB_date(Date b_date) {
		this.b_date = b_date;
	}

	public Calendar getToday() {
		return today;
	}

	public void setToday(Calendar today) {
		this.today = today;
	}

	public static Reader getReader() {
		return reader;
	}

	public static void setReader(Reader reader) {
		basketInputAction.reader = reader;
	}

	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}

	public static void setSqlMapper(SqlMapClient sqlMapper) {
		basketInputAction.sqlMapper = sqlMapper;
	}

	public String getB_bottle() {
		return b_bottle;
	}

	public void setB_bottle(String b_bottle) {
		this.b_bottle = b_bottle;
	}
	

}
