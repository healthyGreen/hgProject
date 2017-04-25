/*package orders;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import member.memberVO;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ordersListAction extends ActionSupport {
	public static Reader reader;
	public static SqlMapClient sqlMapper;

	private memberVO memparamClass;
	private memberVO memresultClass;
	private ordersVO orderparamClass;
	private ordersVO orderresultClass;
	private List<ordersVO> orderList = new ArrayList<ordersVO>();
	private int currentPage = 1; // 현재 페이지
	private int totalCount;// 총 게시물의 수
	private int blockCount = 10; // 한 페이지의 게시물 수
	private int blockPage = 5; // 한 화면에 보여줄 페이지 수
	private String pagingHtml; // 페이징을 구현한 HTML
	private orderListPageAction page; // 페이징 클래스
	private int num = 0;

	private int O_NUMBER; //주문번호
	private String O_M_ID; //주문번호
	private String O_NAME; //주문자 아이디
	private int O_RPHONE; //받는사람 이름
	private String O_ZIPCODE; //받는사람 우편번호
	private String O_ADDR1; //받는사람 주소1
	private String O_ADDR2; //받는사람 주소2
	private String O_COMMENT; //남길말
	private String O_PAY; //결제수단
	private Date O_DATE; //날짜
	private int O_ALLPRICE; //상품합계금액
	private int O_ALLPRICE_F; //총결제금액
	private int O_G_NUMBER; //상품번호
	private int O_G_AMOUNT; //수량
	private String O_G_BOTTEL; //보틀

	public ordersListAction() throws IOException {

		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}

	public String execute() throws Exception {
		memparamClass = new memberVO();
		memresultClass = new memberVO();
		orderparamClass = new ordersVO();
		orderresultClass = new ordersVO();
		ActionContext context = ActionContext.getContext();
		Map<String, Object> session = context.getSession();
		String session_id = (String) session.get("m_id");
		memresultClass = (memberVO) sqlMapper.queryForObject("Member.UserCheck",
				session_id);

		// orderparamClass.setOrder_id(session_id);
		orderList = sqlMapper.queryForList("Order.orderList", session_id);

		totalCount = orderList.size();
		page = new orderListPageAction(currentPage, totalCount, blockCount,
				blockPage);
		pagingHtml = page.getPagingHtml().toString();
		int lastCount = totalCount;
		if (page.getEndCount() < totalCount) {
			lastCount = page.getEndCount() + 1;
		}
		orderList = orderList.subList(page.getStartCount(), lastCount);

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

	public ordersVO getOrderparamClass() {
		return orderparamClass;
	}

	public void setOrderparamClass(ordersVO orderparamClass) {
		this.orderparamClass = orderparamClass;
	}

	public ordersVO getOrderresultClass() {
		return orderresultClass;
	}

	public void setOrderresultClass(ordersVO orderresultClass) {
		this.orderresultClass = orderresultClass;
	}

	public List<ordersVO> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<ordersVO> orderList) {
		this.orderList = orderList;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getBlockCount() {
		return blockCount;
	}

	public void setBlockCount(int blockCount) {
		this.blockCount = blockCount;
	}

	public int getBlockPage() {
		return blockPage;
	}

	public void setBlockPage(int blockPage) {
		this.blockPage = blockPage;
	}

	public String getPagingHtml() {
		return pagingHtml;
	}

	public void setPagingHtml(String pagingHtml) {
		this.pagingHtml = pagingHtml;
	}

	public orderListPageAction getPage() {
		return page;
	}

	public void setPage(orderListPageAction page) {
		this.page = page;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getO_NUMBER() {
		return O_NUMBER;
	}

	public void setO_NUMBER(int o_NUMBER) {
		O_NUMBER = o_NUMBER;
	}

	public String getO_M_ID() {
		return O_M_ID;
	}

	public void setO_M_ID(String o_M_ID) {
		O_M_ID = o_M_ID;
	}

	public String getO_NAME() {
		return O_NAME;
	}

	public void setO_NAME(String o_NAME) {
		O_NAME = o_NAME;
	}

	public int getO_RPHONE() {
		return O_RPHONE;
	}

	public void setO_RPHONE(int o_RPHONE) {
		O_RPHONE = o_RPHONE;
	}

	public String getO_ZIPCODE() {
		return O_ZIPCODE;
	}

	public void setO_ZIPCODE(String o_ZIPCODE) {
		O_ZIPCODE = o_ZIPCODE;
	}

	public String getO_ADDR1() {
		return O_ADDR1;
	}

	public void setO_ADDR1(String o_ADDR1) {
		O_ADDR1 = o_ADDR1;
	}

	public String getO_ADDR2() {
		return O_ADDR2;
	}

	public void setO_ADDR2(String o_ADDR2) {
		O_ADDR2 = o_ADDR2;
	}

	public String getO_COMMENT() {
		return O_COMMENT;
	}

	public void setO_COMMENT(String o_COMMENT) {
		O_COMMENT = o_COMMENT;
	}

	public String getO_PAY() {
		return O_PAY;
	}

	public void setO_PAY(String o_PAY) {
		O_PAY = o_PAY;
	}

	public Date getO_DATE() {
		return O_DATE;
	}

	public void setO_DATE(Date o_DATE) {
		O_DATE = o_DATE;
	}

	public int getO_ALLPRICE() {
		return O_ALLPRICE;
	}

	public void setO_ALLPRICE(int o_ALLPRICE) {
		O_ALLPRICE = o_ALLPRICE;
	}

	public int getO_ALLPRICE_F() {
		return O_ALLPRICE_F;
	}

	public void setO_ALLPRICE_F(int o_ALLPRICE_F) {
		O_ALLPRICE_F = o_ALLPRICE_F;
	}

	public int getO_G_NUMBER() {
		return O_G_NUMBER;
	}

	public void setO_G_NUMBER(int o_G_NUMBER) {
		O_G_NUMBER = o_G_NUMBER;
	}

	public int getO_G_AMOUNT() {
		return O_G_AMOUNT;
	}

	public void setO_G_AMOUNT(int o_G_AMOUNT) {
		O_G_AMOUNT = o_G_AMOUNT;
	}

	public String getO_G_BOTTEL() {
		return O_G_BOTTEL;
	}

	public void setO_G_BOTTEL(String o_G_BOTTEL) {
		O_G_BOTTEL = o_G_BOTTEL;
	}

	
}
*/