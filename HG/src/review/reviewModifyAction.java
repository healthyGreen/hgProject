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

public class reviewModifyAction extends ActionSupport{
   private static Reader reader;
   private static SqlMapClient sqlMapper;
   private reviewVO paramClass;
   private reviewVO resultClass;
   
   private int currentPage;
   private int number;
   private String title;
   private String name;
   private String content;
   private String old_file;
   private File upload;
   private String uploadContentType;
   private String uploadFileName;
   private String fileUploadPath = "C:\\Java\\upload\\";
   
   public reviewModifyAction() throws IOException {
      reader=Resources.getResourceAsReader("sqlMapConfig.xml");
      sqlMapper=SqlMapClientBuilder.buildSqlMapClient(reader);
      reader.close();
   }
   public String execute() throws SQLException, IOException{
      paramClass.setRV_NUMBER(number);
      paramClass.setRV_TITLE(title);
      paramClass.setRV_CONTENT(content);
      sqlMapper.update("updateReview", paramClass);
      if(getUpload()!=null){
         String file_name="file_"+getNumber();
         String file_ext = getUploadFileName().substring(getUploadFileName().lastIndexOf('.')+1,getUploadFileName().length());
         File deleteFile = new File(fileUploadPath+file_name+"."+file_ext);
         deleteFile.delete();
         
         File destFile = new File(fileUploadPath + file_name + "." +file_ext);
         FileUtils.copyFile(getUpload(), destFile);
         paramClass.setRV_ORG_IMAGE(uploadFileName);
         paramClass.setRV_SAV_IMAGE(file_name+"."+file_ext);
         sqlMapper.update("updateRvFile",paramClass);
      }
      resultClass=(reviewVO)sqlMapper.queryForObject("selectOneReview",number);
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
   public int getCurrentPage() {
      return currentPage;
   }
   public void setCurrentPage(int currentPage) {
      this.currentPage = currentPage;
   }
   public int getNumber() {
      return number;
   }
   public void setNumber(int number) {
      this.number = number;
   }
   public String getTitle() {
      return title;
   }
   public void setTitle(String title) {
      this.title = title;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public String getContent() {
      return content;
   }
   public void setContent(String content) {
      this.content = content;
   }
   public String getOld_file() {
      return old_file;
   }
   public void setOld_file(String old_file) {
      this.old_file = old_file;
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
      return fileUploadPath;
   }
   public void setFileUploadPath(String fileUploadPath) {
      this.fileUploadPath = fileUploadPath;
   }
   
}