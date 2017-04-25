/*package goods;

import goods.goodsVO;

import com.opensymphony.xwork2.ActionSupport;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import org.apache.struts2.interceptor.SessionAware;

import java.util.*;
import java.io.Reader;
import java.io.IOException;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.jasper.tagplugins.jstl.core.Param;

public class goodsWriteAction extends ActionSupport implements SessionAware {

   public static Reader reader;
   public static SqlMapClient sqlMapper;

   private goodsVO paramClass;
   private goodsVO resultClass;
   // private int currentPage;

   private int g_number; // ��ǰ�ڵ�
   private String g_name; // ��ǰ��
   private String g_content; // ��ǰ����
   private String g_info;
   private int g_price;
   private String g_ingr;
   private String g_category;
   private int g_amount;
   private String g_bottle;
   private String g_org_image; // ���ε� ���� ���� �̸�
   private String g_sav_image; // ������ ������ ���ε� ���� �̸� (������ȣ�� �з���)

   private Map session;

   private List<File> upload = new ArrayList<File>(); // ���� ��ü
   private List<String> uploadContentType = new ArrayList<String>(); // ������ Ÿ��
   private List<String> uploadFileName = new ArrayList<String>(); // ���� �̸�
   private String fileUploadPath = "����";// ���ε�
   private int index;// ���

   
    * private int ref; private int re_step; private int re_level;
    

   // boolean reply = false;

   public goodsWriteAction() throws IOException {
      reader = Resources.getResourceAsReader("sqlMapConfig.xml");
      sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
      reader.close();
   }

   public String form() throws Exception {
      return SUCCESS;
   }

   
    * public String reply() throws Exception{ reply=true; resultClass = new
    * ProductVO();
    * 
    * resultClass = (ProductVO) sqlMapper.queryForObject("saleboard.selectOne",
    * getNo()); resultClass.setSubject("[�亯] " + resultClass.getSubject());
    * resultClass.setPassword(""); resultClass.setName("");
    * resultClass.setContent(""); resultClass.setFile_orgname(null);
    * resultClass.setFile_savname(null);
    * 
    * return SUCCESS; }
    

   public String execute() throws Exception {

      paramClass = new goodsVO();
      resultClass = new goodsVO();

      // ����� �׸� ����
      
       * private int g_number; //��ǰ�ڵ� private String g_name; // ��ǰ�� private
       * String g_content; // ��ǰ���� private String g_info; private String
       * g_price; private String g_ingr; private String g_hit; private String
       * g_category; private String g_amount; private String g_bottle;
       
      paramClass.setG_name(g_name);
      paramClass.setG_amount(g_amount);
      paramClass.setG_bottle(g_bottle);
      paramClass.setG_category(g_category);
      paramClass.setG_content(g_content);
      paramClass.setG_info(g_info);
      paramClass.setG_ingr(g_ingr);
      paramClass.setG_name(g_name);
   
      if(upload == null)
         sqlMapper.insert("g_write", paramClass);
      // ÷�������� �����ߴٸ� ������ ���ε��Ѵ�.
      else if (upload != null) {
         paramClass.setG_org_image(g_org_image);
         paramClass.setG_sav_image(g_sav_image);
   

         resultClass = (goodsVO) sqlMapper.queryForObject("g_upload", paramClass);
         if (getUpload() != null) {
            for (int i = 0; i < upload.size(); i++) {
               File destFile = new File(fileUploadPath + getUploadFileName().get(i));
               FileUtils.copyFile((getUpload()).get(i), destFile);
            }
            if (upload.size() > 0) {
               savimage = getUploadFileName().get(0) + ",";
               for (int i = 1; i < upload.size(); i++) {
                  savimage += getUploadFileName().get(i) + ",";
               }
               index = savimage.lastIndexOf(',');
               savimage = savimage.substring(0, index);
            }

            // ���� ���� �Ķ���� ����.
            paramClass.setG_number(resultClass.getG_number());
            paramClass.setG_org_image(getOrgimage()); // ���� ���� �̸�
            paramClass.setG_sav_image(getSavimage()); // ���� ���� �̸�
            // ���� ���� ������Ʈ
            sqlMapper.update("g_update", paramClass);
         }
      }
      return SUCCESS;
   }

   public goodsVO getParamClass() {
      return paramClass;
   }

   public void setParamClass(goodsVO paramClass) {
      this.paramClass = paramClass;
   }

   public goodsVO getResultClass() {
      return resultClass;
   }

   public void setResultClass(goodsVO resultClass) {
      this.resultClass = resultClass;
   }

   public int getG_number() {
      return g_number;
   }

   public void setG_number(int g_number) {
      this.g_number = g_number;
   }

   public String getG_name() {
      return g_name;
   }

   public void setG_name(String g_name) {
      this.g_name = g_name;
   }

   public String getG_content() {
      return g_content;
   }

   public void setG_content(String g_content) {
      this.g_content = g_content;
   }

   public String getG_info() {
      return g_info;
   }

   public void setG_info(String g_info) {
      this.g_info = g_info;
   }

   public String getG_price() {
      return g_price;
   }

   public void setG_price(String g_price) {
      this.g_price = g_price;
   }

   public String getG_ingr() {
      return g_ingr;
   }

   public void setG_ingr(String g_ingr) {
      this.g_ingr = g_ingr;
   }

   public String getG_hit() {
      return g_hit;
   }

   public void setG_hit(String g_hit) {
      this.g_hit = g_hit;
   }

   public String getG_category() {
      return g_category;
   }

   public void setG_category(String g_category) {
      this.g_category = g_category;
   }

   public String getG_amount() {
      return g_amount;
   }

   public void setG_amount(String g_amount) {
      this.g_amount = g_amount;
   }

   public String getG_bottle() {
      return g_bottle;
   }

   public void setG_bottle(String g_bottle) {
      this.g_bottle = g_bottle;
   }

   public String getOrgimage() {
      return orgimage;
   }

   public void setOrgimage(String orgimage) {
      this.orgimage = orgimage;
   }

   public String getSavimage() {
      return savimage;
   }

   public void setSavimage(String savimage) {
      this.savimage = savimage;
   }

   public Map getSession() {
      return session;
   }

   public void setSession(Map session) {
      this.session = session;
   }

   public List<File> getUpload() {
      return upload;
   }

   public void setUpload(List<File> upload) {
      this.upload = upload;
   }

   public List<String> getUploadContentType() {
      return uploadContentType;
   }

   public void setUploadContentType(List<String> uploadContentType) {
      this.uploadContentType = uploadContentType;
   }

   public List<String> getUploadFileName() {
      return uploadFileName;
   }

   public void setUploadFileName(List<String> uploadFileName) {
      this.uploadFileName = uploadFileName;
   }

   public String getFileUploadPath() {
      return fileUploadPath;
   }

   public void setFileUploadPath(String fileUploadPath) {
      this.fileUploadPath = fileUploadPath;
   }

   public int getIndex() {
      return index;
   }

   public void setIndex(int index) {
      this.index = index;
   }

}
*/