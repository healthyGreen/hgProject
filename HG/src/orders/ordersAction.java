package orders;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.Calendar;
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
	public ordersVO order;
	public basketVO basket;
	public goodsVO goods;
	public goodsVO goodsresultClass;
	public List<basketVO> basketList;
	public List<goodsVO> goodsList;
	//public Vector forOrder; 
	public String orderType;
	public int g_number;
	public String g_name;
	public int amount;
	public String bottle;
	public int price;
	/*	orderInfo.add(g_number);
		orderInfo.add(g_name);
		orderInfo.add(amount);
		orderInfo.add(bottle);
		orderInfo.add(price); */
	public int o_number;
	public String session_id;
	public String o_name;
	public int o_rphone;
	public String o_zipcode;
	public String o_addr1;
	public String o_addr2;
	public String o_comment;
	public String o_pay; // 지불 방식
	public Calendar o_date = Calendar.getInstance();
	
	public ordersAction() throws IOException {
		reader=Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper=SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	public String execute() throws SQLException{
		
		order.setO_m_id(session_id);
		order.setO_name(o_name);
		order.setO_rphone(o_rphone);
		order.setO_zipcode(o_zipcode);
		order.setO_addr1(o_addr1);
		order.setO_addr2(o_addr2);
		order.setO_comment(o_comment);
		order.setO_pay(o_pay);
		order.setO_date(o_date.getTime());
		
		if(orderType.equals("goods")){
			basket.setB_g_number(g_number);
			basket.setB_g_name(g_name);
			basket.setB_g_amout(amount);
			basket.setB_g_bottle(bottle);
			goods.setG_price(price);
		}else if(orderType.equals("basket")){
			basketList = sqlMapper.queryForList("Basket.basketList", session_id);
			
		}
		/*forOrder.add(basketList);
		forOrder.add(goodsList);
		for(int i=0; i<basketList.size(); i++){
		sqlMapper.insert("insertOrder",forOrder);
		}*/
		return SUCCESS;
	}
}