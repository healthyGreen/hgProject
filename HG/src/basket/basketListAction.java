package basket;

import java.io.Reader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import member.memberVO;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import goods.goodsVO;

public class basketListAction extends ActionSupport{
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	private basketVO basparamClass;
	private basketVO basresultClass;
	private goodsVO goodsparamClass;
	private goodsVO goodsresultClass;
	
	private String m_id;
	private int g_number;

	private List<String> b_image = new ArrayList();
	
	private List<basketVO> basketList = new ArrayList<basketVO>();
	private List<basketVO> subBasketList = new ArrayList<basketVO>();
	private List<goodsVO> goodsList = new ArrayList<goodsVO>();
	private int currentPage = 1; // 현재 페이지
	private int totalCount;// 총 게시물의 수
	private int blockCount = 10; // 한 페이지의 게시물 수
	private int blockPage = 5; // 한 화면에 보여줄 페이지 수
	private String pagingHtml; // 페이징을 구현한 HTML
	private basketPageAction page; // 페이징 클래스
	private Map session;
	private long allTotalPrice=0;
	private String what;
	public basketListAction() throws Exception{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	public String execute() throws Exception{
		basparamClass = new basketVO();
		basresultClass = new basketVO();
		/*ActionContext context = ActionContext.getContext(); // session을 생성하기 위해
		Map<String, Object> session = context.getSession();
		String session_id = (String) session.get("session_id");*/
		basketList = sqlMapper.queryForList("Basket.basketList",m_id);
		if(basketList!=null){
		for(int i=0; i< basketList.size(); i++){
			System.out.println(basketList.get(i).getB_allPrice());
			allTotalPrice+=basketList.get(i).getB_allPrice();
			}
		System.out.println(allTotalPrice);
		}
		

		totalCount = basketList.size();  // 전체 글의 갯수를 구함
		page = new basketPageAction(currentPage, totalCount, blockCount, blockPage);
		pagingHtml = page.getPagingHtml().toString();
		int lastCount = totalCount;
		// 현재 페이지의 마지막 글 번호가
		// 전체의 마지막 글번호보다 작다면
		// lastCount를 +1 번호로 설정
		if(page.getEndCount() < totalCount){
			lastCount = page.getEndCount() + 1;
		}
		
		subBasketList = basketList.subList(page.getStartCount(), lastCount);
		
		return SUCCESS;
		
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

	

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public List<String> getB_image() {
		return b_image;
	}

	public void setB_image(List<String> b_image) {
		this.b_image = b_image;
	}


	public List<basketVO> getSubBasketList() {
		return subBasketList;
	}

	public void setSubBasketList(List<basketVO> subBasketList) {
		this.subBasketList = subBasketList;
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

	public basketPageAction getPage() {
		return page;
	}

	public void setPage(basketPageAction page) {
		this.page = page;
	}

	public goodsVO getGoodsparamClass() {
		return goodsparamClass;
	}

	public void setGoodsparamClass(goodsVO goodsparamClass) {
		this.goodsparamClass = goodsparamClass;
	}

	public goodsVO getGoodsresultClass() {
		return goodsresultClass;
	}

	public void setGoodsresultClass(goodsVO goodsresultClass) {
		this.goodsresultClass = goodsresultClass;
	}

	public List<goodsVO> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<goodsVO> goodsList) {
		this.goodsList = goodsList;
	}

	public List<basketVO> getBasketList() {
		return basketList;
	}

	public void setBasketList(List<basketVO> basketList) {
		this.basketList = basketList;
	}

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}

	public long getAllTotalPrice() {
		return allTotalPrice;
	}

	public void setAllTotalPrice(long allTotalPrice) {
		this.allTotalPrice = allTotalPrice;
	}

	public int getG_number() {
		return g_number;
	}

	public void setG_number(int g_number) {
		this.g_number = g_number;
	}

	public String getWhat() {
		return what;
	}

	public void setWhat(String what) {
		this.what = what;
	}
	
	
	
	
}
