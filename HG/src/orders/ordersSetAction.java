package orders;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

import basket.basketVO;
import goods.goodsVO;
import member.memberVO;

public class ordersSetAction extends ActionSupport {
	private static Reader reader;
	private static SqlMapClient sqlMapper;
	HttpServletResponse response;
	HttpServletRequest request;
	public int g_number;
	public String m_id;
	public String g_name;
	public int amount;
	public String bottle;
	public int price;
	public int totalprice;
	public String image;
	public basketVO basket;
	public memberVO member;
	public goodsVO goods;
	HttpSession session = request.getSession();
	public String session_id = (String)session.getAttribute("session_id");
	public String orderType;
	public List orderInfo = new ArrayList();
	public List<basketVO> basketList; // 장바구니에서 '주문하기'버튼 클릭시 넘어오는 값을  setter로 셋팅 
	public List<goodsVO> goodsList; // 장바구니에서 '주문하기'버튼 클릭시 장바구니 list에서 3개 셋팅해준 값을 setter로 셋팅
	public Vector vector = new Vector<>();
	
	public ordersSetAction() throws IOException {
		reader=Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper=SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	public String execute() throws SQLException{
		if(orderType.equals("goods")){
			orderInfo.add(g_number);
			orderInfo.add(g_name);
			orderInfo.add(amount);
			orderInfo.add(bottle);
			orderInfo.add(price);
			orderInfo.add(image);
			
			//request.setAttribute("orderInfo", orderInfo);
			//request.setAttribute("orderType", orderType);
		}else if(orderType.equals("basket")){
			//basketList = sqlMapper.queryForList("basketList",g_number);
			if(basketList!=null){
				goods = (goodsVO)sqlMapper.queryForObject("getGoodsforOrder",g_number);
				vector.add(basketList);
				vector.add(goodsList);	
			}
		}
		return SUCCESS;
	}
/*	public HttpServletResponse getResponse() {
		return response;
	}
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}*/
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
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public basketVO getBasket() {
		return basket;
	}
	public void setBasket(basketVO basket) {
		this.basket = basket;
	}
	public memberVO getMember() {
		return member;
	}
	public void setMember(memberVO member) {
		this.member = member;
	}
	public goodsVO getGoods() {
		return goods;
	}
	public void setGoods(goodsVO goods) {
		this.goods = goods;
	}
	public HttpSession getSession() {
		return session;
	}
	public void setSession(HttpSession session) {
		this.session = session;
	}
	public String getSession_id() {
		return session_id;
	}
	public void setSession_id(String session_id) {
		this.session_id = session_id;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public List getOrderInfo() {
		return orderInfo;
	}
	public void setOrderInfo(List orderInfo) {
		this.orderInfo = orderInfo;
	}
	public List<basketVO> getBasketList() {
		return basketList;
	}
	public void setBasketList(List<basketVO> basketList) {
		this.basketList = basketList;
	}
	public List<goodsVO> getGoodsList() {
		return goodsList;
	}
	public void setGoodsList(List<goodsVO> goodsList) {
		this.goodsList = goodsList;
	}
	public Vector getVector() {
		return vector;
	}
	public void setVector(Vector vector) {
		this.vector = vector;
	}
	
}
