package review;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class reviewWriteAction extends ActionSupport{
   private static Reader reader;
   private static SqlMapClient sqlMapper;
   
   private reviewVO paramClass;
   private reviewVO resultClass;

   private int currentPage;
   private int rv_number;
   private String rv_m_id;
   private String rv_file_orgName;
   private String rv_file_savName;
   private String rv_title;
   private String rv_content;
   private String rv_pass;
   private String rv_name;
   private String rv_score;
   private int rv_ref;
   private int rv_ref_step;
   private int rv_ref_level;
   private Map session;

   private File upload;
   private String uploadContentType;
   private String uploadFileName;
   private String FileUploadPath = "C:\\Java\\upload\\";
   private boolean reply = false;
   
   public reviewWriteAction() throws IOException {
      reader=Resources.getResourceAsReader("sqlMapConfig.xml");
      sqlMapper=SqlMapClientBuilder.buildSqlMapClient(reader);
      reader.close();
   }
   
   public String form(){
      return SUCCESS;
   }
   public String reply() throws Exception
	{
	   	
	      
		reply=true;
		resultClass = new reviewVO();
		
		resultClass = (reviewVO) sqlMapper.queryForObject("Board.selectOneReview", getRv_number());
		resultClass.setRv_title("[´äº¯] " + resultClass.getRv_title());
		resultClass.setRv_content("");
		
		System.out.println(resultClass.getRv_m_id());
		System.out.println(resultClass.getRv_date());
		System.out.println(currentPage);
		
		return SUCCESS;
		
	}
  /* public String execute() throws Exception {
	   
	  System.out.println("rv_number"+getRv_number());
	  System.out.println("rv_number"+getRv_title());
	  
	  
      paramClass = new reviewVO();
      resultClass = new reviewVO();
      ActionContext context = ActionContext.getContext();
		Map session = context.getSession();
		String session_id = (String) session.get("session_id");
      
      if(rv_ref==0){
         paramClass.setRv_ref_level(0);
         paramClass.setRv_ref_step(0);   
      }else{
         paramClass.setRv_ref_step(getRv_ref_step());
         paramClass.setRv_ref_level(getRv_ref_level());
         sqlMapper.update("Board.updateReplyStep",paramClass);
         paramClass.setRv_ref_step(getRv_ref_step()+1);
         paramClass.setRv_ref_level(getRv_ref_level()+1);
         paramClass.setRv_ref(getRv_ref());
      }
      paramClass.setRv_m_id(session_id);
      paramClass.setRv_date(today.getTime());
      paramClass.setRv_title(getRv_title());
      paramClass.setRv_content(getRv_content());
      paramClass.setRv_pass(getRv_pass());
      paramClass.setRv_name(getRv_name());
      paramClass.setRv_date(rv_date.getTime());
      paramClass.setRv_score("0");
      
      if(rv_ref==0)
         sqlMapper.insert("Board.insertReview", paramClass);
      else
         sqlMapper.insert("Board.insertReviewReply",paramClass);
      
      if(getUpload()!=null){
         resultClass = (reviewVO)sqlMapper.queryForObject("Board.selectLastNo");
         
         String fileName = "file_" + getRv_number();
         String fileExt = getUploadFileName().substring(getUploadFileName().lastIndexOf('.')+1,getUploadFileName().length());
         
         File newFile = new File(FileUploadPath+fileName+"."+fileExt);
         FileUtils.copyFile(getUpload(), newFile);
         
         paramClass.setRv_number(resultClass.getRv_number());
         paramClass.setRv_org_image(getUploadFileName());
         paramClass.setRv_sav_image(fileName+"."+fileExt);
         
         sqlMapper.update("Board.updateRvFile",paramClass);
      }
      return SUCCESS;
   }*/
   
   public String execute() throws Exception {

	      paramClass = new reviewVO();
	      resultClass = new reviewVO();
	      ActionContext context = ActionContext.getContext();
	      Map session = context.getSession();
	      String session_id = (String) session.get("session_id");
	      
	      if(rv_ref==0){
	         paramClass.setRv_ref_level(0);
	         paramClass.setRv_ref_step(0);   
	      }else{
	         paramClass.setRv_ref_step(getRv_ref_step());
	         paramClass.setRv_ref_level(getRv_ref_level());
	         sqlMapper.update("Board.updateReplyStep",paramClass);
	         paramClass.setRv_ref_step(getRv_ref_step()+1);
	         paramClass.setRv_ref_level(getRv_ref_level()+1);
	         paramClass.setRv_ref(getRv_ref());
	      }
	      paramClass.setRv_m_id(session_id);
	      paramClass.setRv_title(getRv_title());
	      paramClass.setRv_content(getRv_content());
	      paramClass.setRv_pass(getRv_pass());
	      paramClass.setRv_name(getRv_name());
	      paramClass.setRv_score(getRv_score());
	      
	      if(rv_ref==0)
	         sqlMapper.insert("Board.insertReview", paramClass);
	      else
	         sqlMapper.insert("Board.insertReviewReply",paramClass);
	      
	      if(getUpload()!=null){
	         resultClass = (reviewVO)sqlMapper.queryForObject("Board.selectLastNo");
	         
	         String fileName = "file_" + getRv_number();
	         String fileExt = getUploadFileName().substring(getUploadFileName().lastIndexOf('.')+1,getUploadFileName().length());
	         
	         File newFile = new File(FileUploadPath+fileName+"."+fileExt);
	         FileUtils.copyFile(getUpload(), newFile);
	         
	         paramClass.setRv_number(resultClass.getRv_number());
	         paramClass.setRv_org_image(getUploadFileName());
	         paramClass.setRv_sav_image(fileName+"."+fileExt);
	         
	         sqlMapper.update("Board.updateRvFile",paramClass);
	      }
	      return SUCCESS;
	}
   
   
   public reviewVO getParamClass() {
      return paramClass;
   }



public void setParamClass(reviewVO paramClass) {
      this.paramClass = paramClass;
   }
   public reviewVO getResultClass() {
      return resultClass;
   }
   public void setResultClass(reviewVO resultClass) {
      this.resultClass = resultClass;
   }
  
   public static Reader getReader() {
	return reader;
}

public static void setReader(Reader reader) {
	reviewWriteAction.reader = reader;
}

public static SqlMapClient getSqlMapper() {
	return sqlMapper;
}

public static void setSqlMapper(SqlMapClient sqlMapper) {
	reviewWriteAction.sqlMapper = sqlMapper;
}

public int getCurrentPage() {
	return currentPage;
}

public void setCurrentPage(int currentPage) {
	this.currentPage = currentPage;
}



public int getRv_number() {
      return rv_number;
   }
   public void setRv_number(int rv_number) {
      this.rv_number = rv_number;
   }
   public String getRv_file_orgName() {
      return rv_file_orgName;
   }
   public void setRv_file_orgName(String rv_file_orgName) {
      this.rv_file_orgName = rv_file_orgName;
   }
   public String getRv_file_savName() {
      return rv_file_savName;
   }
   public void setRv_file_savName(String rv_file_savName) {
      this.rv_file_savName = rv_file_savName;
   }
   public String getRv_title() {
      return rv_title;
   }
   public void setRv_title(String rv_title) {
      this.rv_title = rv_title;
   }
   public String getRv_content() {
      return rv_content;
   }
   public void setRv_content(String rv_content) {
      this.rv_content = rv_content;
   }
   public String getRv_pass() {
      return rv_pass;
   }
   public void setRv_pass(String rv_pass) {
      this.rv_pass = rv_pass;
   }
   public String getRv_name() {
      return rv_name;
   }
   public void setRv_name(String rv_name) {
      this.rv_name = rv_name;
   }

 /*  public String getRv_score() {
      return rv_score;
   }
   public void setRv_score(String rv_score) {
      this.rv_score = rv_score;
   }*/
   public int getRv_ref() {
      return rv_ref;
   }
   public void setRv_ref(int rv_ref) {
      this.rv_ref = rv_ref;
   }
   public int getRv_ref_step() {
      return rv_ref_step;
   }
   public void setRv_ref_step(int rv_ref_step) {
      this.rv_ref_step = rv_ref_step;
   }
   public int getRv_ref_level() {
      return rv_ref_level;
   }
   public void setRv_ref_level(int rv_ref_level) {
      this.rv_ref_level = rv_ref_level;
   }
   public boolean isReply() {
      return reply;
   }
   public void setReply(boolean reply) {
      this.reply = reply;
   }

   public File getUpload() {
      return upload;
   }

   public void setUpload(File upload) {
      this.upload = upload;
   }

   public String getUploadContentType() {
      return uploadContentType;
   }

   public void setUploadContentType(String uploadContentType) {
      this.uploadContentType = uploadContentType;
   }

   public String getUploadFileName() {
      return uploadFileName;
   }

   public void setUploadFileName(String uploadFileName) {
      this.uploadFileName = uploadFileName;
   }

   public String getFileUploadPath() {
      return FileUploadPath;
   }

   public void setFileUploadPath(String fileUploadPath) {
      FileUploadPath = fileUploadPath;
   }

public Map getSession() {
	return session;
}

public void setSession(Map session) {
	this.session = session;
}

public String getRv_m_id() {
	return rv_m_id;
}

public void setRv_m_id(String rv_m_id) {
	this.rv_m_id = rv_m_id;
}

public String getRv_score() {
	return rv_score;
}

public void setRv_score(String rv_score) {
	this.rv_score = rv_score;
}


   
   
}