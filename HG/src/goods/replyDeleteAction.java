package goods;

import com.opensymphony.xwork2.ActionSupport;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.io.Reader;
import java.sql.SQLException;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class replyDeleteAction extends ActionSupport{
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private replyVO re_paramClass;
	private replyVO re_resultClass;
	
	private replyVO reClass = new replyVO();
	private replyVO reResult = new replyVO();
	private replyVO passResult = new replyVO();
	
	private String rp_pass;
	private int rp_number;
	
	
	public replyDeleteAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	public String execute() throws Exception {
		 re_paramClass= new replyVO();
		 re_resultClass = new replyVO();
		 
		 System.out.println(rp_number);
		 
		 re_paramClass.setRp_number(rp_number);
		 System.out.println("´ñ±Û¹øÈ£:"+re_paramClass.getRp_number());
		 sqlMapper.delete("rp_delete", rp_number);
		 
		 return SUCCESS;
		 
	}
	
	
	public String checkform(){
		return SUCCESS;
	}
	
	public String checkAction() throws SQLException{
		reClass = new replyVO();
		reClass.setRp_pass(rp_pass);
		reClass.setRp_number(rp_number);
		passResult = (replyVO)sqlMapper.queryForObject("reply_passCheck",reClass);
		if(reResult!=null)
			return SUCCESS;
		else return ERROR;
	}

	public replyVO getRe_paramClass() {
		return re_paramClass;
	}

	public void setRe_paramClass(replyVO re_paramClass) {
		this.re_paramClass = re_paramClass;
	}

	public replyVO getRe_resultClass() {
		return re_resultClass;
	}

	public void setRe_resultClass(replyVO re_resultClass) {
		this.re_resultClass = re_resultClass;
	}

	public replyVO getReClass() {
		return reClass;
	}

	public void setReClass(replyVO reClass) {
		this.reClass = reClass;
	}

	public replyVO getReResult() {
		return reResult;
	}

	public void setReResult(replyVO reResult) {
		this.reResult = reResult;
	}

	public replyVO getPassResult() {
		return passResult;
	}

	public void setPassResult(replyVO passResult) {
		this.passResult = passResult;
	}

	public String getRp_pass() {
		return rp_pass;
	}

	public void setRp_pass(String rp_pass) {
		this.rp_pass = rp_pass;
	}

	public int getRp_number() {
		return rp_number;
	}

	public void setRp_number(int rp_number) {
		this.rp_number = rp_number;
	}
	
	
}
