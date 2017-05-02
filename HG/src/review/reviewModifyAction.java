package review;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;

import org.apache.commons.io.FileUtils;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

import notice.noticeVO;

public class reviewModifyAction extends ActionSupport{
   private static Reader reader;
   private static SqlMapClient sqlMapper;
   private reviewVO paramClass;
   private reviewVO resultClass;
   
   private int currentPage;
   private int rv_number;
   private String rv_title;
   private String rv_name;
   private String rv_content;
   private String rv_old_file;
   private File rv_upload;
   private String uploadContentType;
   private String uploadFileName;
   private String fileUploadPath = "C:\\Java\\upload\\";
   
   public reviewModifyAction() throws IOException {
      reader=Resources.getResourceAsReader("sqlMapConfig.xml");
      sqlMapper=SqlMapClientBuilder.buildSqlMapClient(reader);
      reader.close();
   }
   public String execute() throws Exception{
	   paramClass= new reviewVO();
		resultClass = new reviewVO();
	   
      paramClass.setRv_number(getRv_number());
      
      
      paramClass.setRv_title(getRv_title());
      
      paramClass.setRv_content(getRv_content());
      
      
      sqlMapper.update("Board.updateReview", paramClass);
      
      
      if(getRv_upload()!=null){
       String file_name="file_"+getRv_number();
         String file_ext = getUploadFileName().substring(getUploadFileName().lastIndexOf('.')+1,getUploadFileName().length());
         File deleteFile = new File(fileUploadPath+file_name+"."+file_ext);
         deleteFile.delete();
       
         File destFile = new File(fileUploadPath + getRv_old_file());
         FileUtils.copyFile(getRv_upload(), destFile);
         paramClass.setRv_org_image(uploadFileName);
         paramClass.setRv_sav_image(file_name+"."+file_ext);
         sqlMapper.update("Board.reUpdateRvFile",paramClass);
      }
      //resultClass=(reviewVO)sqlMapper.queryForObject("Board.selectOneReview",number);
      return SUCCESS;
   }
public static Reader getReader() {
	return reader;
}
public static void setReader(Reader reader) {
	reviewModifyAction.reader = reader;
}
public static SqlMapClient getSqlMapper() {
	return sqlMapper;
}
public static void setSqlMapper(SqlMapClient sqlMapper) {
	reviewModifyAction.sqlMapper = sqlMapper;
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
public String getRv_title() {
	return rv_title;
}
public void setRv_title(String rv_title) {
	this.rv_title = rv_title;
}
public String getRv_name() {
	return rv_name;
}
public void setRv_name(String rv_name) {
	this.rv_name = rv_name;
}
public String getRv_content() {
	return rv_content;
}
public void setRv_content(String rv_content) {
	this.rv_content = rv_content;
}
public String getRv_old_file() {
	return rv_old_file;
}
public void setRv_old_file(String rv_old_file) {
	this.rv_old_file = rv_old_file;
}
public File getRv_upload() {
	return rv_upload;
}
public void setRv_upload(File rv_upload) {
	this.rv_upload = rv_upload;
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
	return fileUploadPath;
}
public void setFileUploadPath(String fileUploadPath) {
	this.fileUploadPath = fileUploadPath;
}
   
   
   
}