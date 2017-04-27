package orders;

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
		/*memresultClass = (memberVO) sqlMapper.queryForObject("Member.UserCheck",
				session_id);*/

		// orderparamClass.setOrder_id(session_id);
		orderList = sqlMapper.queryForList("Order.orderList", session_id);
		totalCount = orderList.size();
		page = new orderListPageAction(currentPage, totalCount, blockCount, blockPage);
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

}
