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
import member.memberVO;

public class ordersAction extends ActionSupport{
	private static Reader reader;
	private static SqlMapClient sqlMapper;
	public int g_number;
	public String m_id;
	//public String b_m_id;
	public String g_name;
	public int amount;
	public String bottle;
	public int price;
	public int ttotalPrice;
	public int totalPrice;
	public int x; 
	public int y;
	//public setOrderVO setOrder;
	public ordersVO order;
	public ordersVO orderResult;
	public basketVO basket;
	public memberVO member;
	public List<basketVO> basketList;
	//public List<setOrderVO> setOrderList;
	//public Vector forOrder; 
	public String orderType;
	/*	orderInfo.add(g_number);
		orderInfo.add(g_name);
		orderInfo.add(amount);
		orderInfo.add(bottle);
		orderInfo.add(price); */
	//public int o_number;
	//public String session_id;
	public String o_name;
	public int o_rphone;
	public String o_zipcode;
	public String o_addr1;
	public String o_addr2;
	public String o_comment;
	public String o_pay; // 지불 방식
	public Calendar o_ddate = Calendar.getInstance();
	public Date o_date = o_ddate.getTime();
	public int myPoint=0;
	
	public ordersAction() throws IOException {
		reader=Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper=SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	// 장바구니가 아닌 그냥 바로 상품주문
	public String execute() throws SQLException{
		order = new ordersVO();
		member = new memberVO();
		//System.out.println(o_name);
		if (orderType.equals("basket")){
			return execute2();
		}
		else if(orderType.equals("goods")){
			order.setO_m_id(m_id);
			order.setO_name(o_name);
			order.setO_rphone(o_rphone);
			order.setO_zipcode(o_zipcode);
			order.setO_addr1(o_addr1);
			order.setO_addr2(o_addr2);
			order.setO_comment(o_comment);
			order.setO_pay(o_pay);
			order.setO_date(o_date);
			//order.setO_m_id(m_id);
			order.setO_name(g_name);
			order.setO_g_number(g_number);
			order.setO_g_amount(amount);
			order.setO_g_bottle(bottle);
			order.setO_price(price);
			order.setO_allprice(totalPrice);
			order.setO_orderType(orderType);
		}
			myPoint = (int) (myPoint + totalPrice*0.05); 
			member.setM_point(myPoint);
			member.setM_id(m_id);
			sqlMapper.insert("Orders.insertOrder", order);
			sqlMapper.update("member.updatePoint",member);
			return SUCCESS;
	}
	
	// 장바구니에 넣었을때 
	public String execute2() throws SQLException{
		order = new ordersVO();
		basketList = sqlMapper.queryForList("Basket.basketList", m_id);
		for(int i=0; i<basketList.size(); i++){
			
			basket = basketList.get(i);
			//order.setO_m_id(m_id);
			order.setO_name(o_name);
			order.setO_rphone(o_rphone);
			order.setO_zipcode(o_zipcode);
			order.setO_addr1(o_addr1);
			order.setO_addr2(o_addr2);
			order.setO_comment(o_comment);
			order.setO_pay(o_pay);
			order.setO_date(o_date);
			order.setO_m_id(basket.getB_m_id());
			order.setO_name(basket.getB_g_name());
			order.setO_g_number(basket.getB_g_number());
			order.setO_g_amount(basket.getB_g_amount());
			order.setO_g_bottle(basket.getB_g_bottle());
			order.setO_price(basket.getB_g_price());
			order.setO_allprice(basket.getB_allPrice());
			order.setO_orderType(orderType);
			sqlMapper.insert("Orders.insertOrder", order);
		}
		return SUCCESS;
	}
	public int getG_number() {
		return g_number;
	}
	public void setG_number(int g_number) {
		this.g_number = g_number;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getG_name() {
		return g_name;
	}
	public void setG_name(String g_name) {
		this.g_name = g_name;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getBottle() {
		return bottle;
	}
	public void setBottle(String bottle) {
		this.bottle = bottle;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getTtotalPrice() {
		return ttotalPrice;
	}
	public void setTtotalPrice(int ttotalPrice) {
		this.ttotalPrice = ttotalPrice;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public ordersVO getOrder() {
		return order;
	}
	public void setOrder(ordersVO order) {
		this.order = order;
	}
	public ordersVO getOrderResult() {
		return orderResult;
	}
	public void setOrderResult(ordersVO orderResult) {
		this.orderResult = orderResult;
	}
	public basketVO getBasket() {
		return basket;
	}
	public void setBasket(basketVO basket) {
		this.basket = basket;
	}
	public List<basketVO> getBasketList() {
		return basketList;
	}
	public void setBasketList(List<basketVO> basketList) {
		this.basketList = basketList;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	/*public int getO_number() {
		return o_number;
	}
	public void setO_number(int o_number) {
		this.o_number = o_number;
	}*/
	public String getO_name() {
		return o_name.trim();
	}
	public void setO_name(String o_name) {
		this.o_name = o_name.trim();
	}
	public int getO_rphone() {
		return o_rphone;
	}
	public void setO_rphone(int o_rphone) {
		this.o_rphone = o_rphone;
	}
	public String getO_zipcode() {
		return o_zipcode;
	}
	public void setO_zipcode(String o_zipcode) {
		this.o_zipcode = o_zipcode;
	}
	public String getO_addr1() {
		return o_addr1;
	}
	public void setO_addr1(String o_addr1) {
		this.o_addr1 = o_addr1;
	}
	public String getO_addr2() {
		return o_addr2;
	}
	public void setO_addr2(String o_addr2) {
		this.o_addr2 = o_addr2;
	}
	public String getO_comment() {
		return o_comment;
	}
	public void setO_comment(String o_comment) {
		this.o_comment = o_comment;
	}
	public String getO_pay() {
		return o_pay;
	}
	public void setO_pay(String o_pay) {
		this.o_pay = o_pay;
	}
	
	public Calendar getO_ddate() {
		return o_ddate;
	}
	public void setO_ddate(Calendar o_ddate) {
		this.o_ddate = o_ddate;
	}
	public Date getO_date() {
		return o_date;
	}
	public void setO_date(Date o_date) {
		this.o_date = o_date;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getMyPoint() {
		return myPoint;
	}
	public void setMyPoint(int myPoint) {
		this.myPoint = myPoint;
	}
	
}