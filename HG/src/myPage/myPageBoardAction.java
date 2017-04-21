package myPage;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.interceptor.SessionAware;

import java.util.List;	
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.IOException;
import java.io.Reader;

import review.reviewVO;
import orders.ordersVO;
import member.memberVO;
import basket.basketVO;

public class myPageBoardAction extends ActionSupport implements SessionAware{
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	private Map session;
	
	
	private int no;
	private int board_index;
	private String type;
	
	private int currentPage = 1;
	private int totalCount;
	private int blockCount = 10;
	private int blockPage = 5;
	private String pagingHtml;
	
	
	Map param = new HashMap();
	
	private List<reviewVO> Reviewlist = new ArrayList<reviewVO>();
	private List<ordersVO> Goodslist = new ArrayList<ordersVO>();
	private List<memberVO> Memberlist = new ArrayList<memberVO>();
	private List<basketVO> Basketlist = new ArrayList<basketVO>();
	
	public myPageBoardAction() throws IOException{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	public String execute() throws Exception{
		return SUCCESS;
	}
	
	public String myReviewList() throws Exception{
		String id=(String) session.get("session_id");
		String name=(String) session.get("session_name");
		String point=(String) session.get("session_point");
		
		if(type.equals("reviewboard")){
			param.put("reviewlist", myReviewList());
			param.put("review id", id);
			
			Reviewlist = sqlMapper.queryForList("review.selectAllReview", param);
			
			totalCount = Reviewlist.size();
			
			int lastCount = totalCount;
		}
		return SUCCESS;
	}
	
	public String myBasketList() throws Exception{
		String id=(String) session.get("session_id");
		String name=(String)session.get("session_name");
		String point=(String)session.get("session_point");
		
		if(type.equals("basketlist")){
			param.put("baksetlist", myBasketList());
			param.put("basket id", id);
			
			Basketlist = sqlMapper.queryForList("basket.basketList", param);
			totalCount = Basketlist.size();
			int lastCount = totalCount;
		}
		return SUCCESS;
	
	}
	
	
	public void setSession(Map arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
}
