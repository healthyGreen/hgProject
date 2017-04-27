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
	public int g_number;
	public String m_id;
	public String g_name;
	public int amount;
	public String bottle;
	public int price;
	public int totalPrice;
	//public setOrderVO setOrder;
	public ordersVO order;
	public ordersVO orderResult;
	public basketVO basket;
	public List<basketVO> basketList;
	//public List<setOrderVO> setOrderList;
	//public Vector forOrder; 
	public String orderType;
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
	// 장바구니가 아닌 그냥 바로 상품주문
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
			order.setO_m_id(session_id);
			order.setO_name(g_name);
			order.setO_g_number(g_number);
			order.setO_g_amount(amount);
			order.setO_g_bottle(bottle);
			order.setO_price(price);
			order.setO_allprice(totalPrice);
			order.setO_orderType(orderType);
		}
			sqlMapper.insert("Orders.insertOrder", order);
		
			return SUCCESS;
	}
	
	// 장바구니에 넣었을때 
	public String execute2() throws SQLException{
		
		basketList = sqlMapper.queryForList("Basket.basketList",session_id);
		for(int i=0; i<basketList.size(); i++){
			
			basket = basketList.get(i);
			order.setO_m_id(session_id);
			order.setO_name(o_name);
			order.setO_rphone(o_rphone);
			order.setO_zipcode(o_zipcode);
			order.setO_addr1(o_addr1);
			order.setO_addr2(o_addr2);
			order.setO_comment(o_comment);
			order.setO_pay(o_pay);
			order.setO_date(o_date.getTime());
			order.setO_m_id(basket.getB_m_id());
			order.setO_name(basket.getB_g_name());
			order.setO_g_number(basket.getB_g_number());
			order.setO_g_amount(basket.getB_g_amout());
			order.setO_g_bottle(basket.getB_g_bottle());
			order.setO_price(basket.getB_g_price());
			order.setO_allprice(basket.getB_allPrice());
			order.setO_orderType(orderType);
			sqlMapper.insert("Orders.insertOrder", order);
		}
		return SUCCESS;
	}
}