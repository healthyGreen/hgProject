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
	private String M_ID;
	private int chkId;
	public void MemberIdChkAction() throws IOException{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	public String execute() throws Exception{
		memberVO=(memberVO) sqlMapper.queryForObject("idCheck",getM_ID());
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
	public String getM_ID() {
		return M_ID;
	}
	public void setM_ID(String m_ID) {
		M_ID = m_ID;
	}


	

}
