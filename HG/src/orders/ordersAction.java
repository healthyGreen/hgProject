package orders;

import java.io.IOException;
import java.io.Reader;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

import basket.basketVO;
import goods.goodsVO;

public class ordersAction extends ActionSupport{
	private static Reader reader;
	private static SqlMapClient sqlMapper;
	public List<basketVO> basketList;
	public List<goodsVO> goodsList;
	public String session_id;
	Vector vector; //OrderSet에서 getter로 넘겨눈 값을 여기서  setter로 받는것
	String orderType;
	List orderInfo;
	public int o_number;
	public String o_name;
	
	/*
	 * private int O_NUMBER;
	private String O_M_ID;
	private String O_NAME;
	private int O_RPHONE;
	private String O_ZIPCODE;
	private String O_ADDR1;
	private String O_ADDR2;
	private String O_COMMENT;
	private String O_PAY;
	private Date O_DATE;
	private int O_ALLPRICE;
	private int O_ALLPRICE_F;
	private int O_G_NUMBER;
	private int O_G_AMOUNT;
	private String O_G_BOTTEL;
	 */
	public ordersAction() throws IOException {
		reader=Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper=SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	public String execute(){
		return SUCCESS;
	}
}
