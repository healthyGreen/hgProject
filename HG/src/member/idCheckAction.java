package member;

import java.io.Reader;
import java.io.IOException;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

public class idCheckAction extends ActionSupport{
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	private memberVO memberVO;
	private String m_id;
	private int chkId;
	
	public idCheckAction() throws IOException{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	public String execute() throws Exception{
		memberVO=(memberVO) sqlMapper.queryForObject("Member.idCheck",getM_id());
		if(memberVO == null){
			chkId=0;
		}else{
			chkId=1;
		}
		return SUCCESS;
	}
	
	public memberVO getMemberVO() {
		return memberVO;
	}
	public void setMemberVO(memberVO memberVO) {
		this.memberVO = memberVO;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public int getChkId() {
		return chkId;
	}
	public void setChkId(int chkId) {
		this.chkId = chkId;
	}
	
	


	

}
