package goods;

import java.io.IOException;
import java.io.Reader;
import java.util.Calendar;
import java.util.Date;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

public class replyWriteAction extends ActionSupport {
	public static Reader reader; // 파일 스트립을 위한 reader.
	public static SqlMapClient sqlMapper; // sqlMapClient API를 사용하기위한
											// sqlMapper객체.

	private replyVO reClass; // 파라미터를 저장할 객체
	private replyVO reresult; // 쿼리 결과값을 저장할 객체
	
	private int currentPage;
	private int g_number;
	//private String G_CATEGORY;
	//private String G_SAV_IMAGE;
	
	private String name;
	private String password;
	private String content;
	private int originno;
	private Date rp_date;
	private int rp_ref;
	private int rp_ref_step;
	private int rp_g_number;
	private int checked;
	
	
	
    // private int ref; private int re_step; private int re_level;
	 // boolean reply = false;
	Calendar today = Calendar.getInstance();

	// 생성자
	public replyWriteAction() throws IOException {

		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}

	public String execute() throws Exception {
		/*if(checked ==1){*/
		
		reClass = new replyVO();
		reresult = new replyVO();
		
		/*if(rp_ref==0){
			reClass.setRp_ref_step(0);
		}else{
			reClass.setRp_ref_step(getRef_step());
			reClass.setRp_ref(getRef());
			reClass.setRp_ref_step(getRef_step()+1);
		}*/
		
		System.out.println("number"+getG_number());

		reClass.setRp_number(getOriginno());
		System.out.println(originno);
		reClass.setRp_m_id(getName());
		System.out.println(name);
		reClass.setRp_content(getContent());
		System.out.println(content);
		reClass.setRp_pass(getPassword());
		System.out.println(password);
		reClass.setRp_date(today.getTime());
		System.out.println(today);
		reClass.setRp_ref(getRp_number());
		System.out.println(rp_ref);
		reClass.setRp_ref_step(getRp_number());
		reClass.setRp_g_number(getRp_number());
		System.out.println(rp_g_number);
		
		
		System.out.println(reClass);
		sqlMapper.insert("g_insertReply", reClass);
		
	/*	if(rp_ref==0)
			sqlMapper.insert("g_insertReply", reClass);
		else
			sqlMapper.insert("g_insertReplyComment", reClass);
		*/
		
		return SUCCESS;
	}
	
	private int getRp_number() {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getRp_g_number() {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getRef_step() {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getRef() {
		// TODO Auto-generated method stub
		return 0;
	}

	public static Reader getReader() {
		return reader;
	}

	public static void setReader(Reader reader) {
		replyWriteAction.reader = reader;
	}

/*	public String G_SAV_IMAGE() {
		return G_SAV_IMAGE;
	}

	public void setG_SAV_IMAGE(String goods_savimage) {
		this.G_SAV_IMAGE = goods_savimage;
	}*/

	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}

	public static void setSqlMapper(SqlMapClient sqlMapper) {
		replyWriteAction.sqlMapper = sqlMapper;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getOriginno() {
		return originno;
	}



/*	public String getG_CATEGORY() {
		return G_CATEGORY;
	}

	public void setG_CATEGORY(String goods_category) {
		this.G_CATEGORY = goods_category;
	}*/

	public int getG_number() {
		return g_number;
	}

	public void setG_number(int g_number) {
		this.g_number = g_number;
	}

	public void setOriginno(int originno) {
		this.originno = originno;
	}

	public Calendar getToday() {
		return today;
	}

	public void setToday(Calendar today) {
		this.today = today;
	}

	
	public replyVO getReClass() {
		return reClass;
	}

	public void setReClass(replyVO reClass) {
		this.reClass = reClass;
	}

	public replyVO getReresult() {
		return reresult;
	}

	public void setReresult(replyVO reresult) {
		this.reresult = reresult;
	}

	public void setRp_g_number(int rp_g_number) {
		this.rp_g_number = rp_g_number;
	}

	public void setChecked(int checked) {
		this.checked = checked;
	}


	
	
	
	

}