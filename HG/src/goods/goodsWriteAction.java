package goods;

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

public class goodsWriteAction extends ActionSupport implements SessionAware{

	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private goodsVO paramClass;
	private goodsVO resultClass;
	private int currentPage;
	
	private int prodcode; //��ǰ�ڵ�
	private String id; // �Ǹ��� ���̵�
	private String category; // ī�װ�(��ǰ�з�)
	private String prodname; // ��ǰ��
	private int unit; // ����
	private int price; // �ݾ�
	private String orgimage; // ���ε� ���� ���� �̸�
	private String savimage; // ������ ������ ���ε� ���� �̸� (������ȣ�� �з���)
	private String content; // ��ǰ����
	
	private Map session;
	
	private List<File> upload = new ArrayList<File>(); // ���� ��ü
	private List<String> uploadContentType = new ArrayList<String>(); // ������ Ÿ��
	private List<String> uploadFileName = new ArrayList<String>(); // ���� �̸�
	private String fileUploadPath="����";// ���ε�
	private int index;// ���
	
	/*private int ref;
	private int re_step;
	private int re_level;*/
	

	//boolean reply = false;
	
	public goodsWriteAction() throws IOException{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	public String form() throws Exception{
		return SUCCESS;
			}
	
	/*public String reply() throws Exception{
	reply=true;
	resultClass = new ProductVO();
	
	resultClass = (ProductVO) sqlMapper.queryForObject("saleboard.selectOne", getNo());
	resultClass.setSubject("[�亯] " + resultClass.getSubject());
	resultClass.setPassword("");
	resultClass.setName("");
	resultClass.setContent("");
	resultClass.setFile_orgname(null);
	resultClass.setFile_savname(null);		
	
	return SUCCESS;		
}*/
	
public String execute() throws Exception {
		
		paramClass = new goodsVO();
		resultClass = new goodsVO();
		/*if(ref == 0){
			paramClass.setRe_step(0);
			paramClass.setRe_level(0);
		}else{			
			paramClass.setRef(getRef());
			paramClass.setRe_step(getRe_step());
			sqlMapper.update("updateReplyStep", paramClass);
			
			paramClass.setRe_step(getRe_step() + 1);
			paramClass.setRe_level(getRe_level() + 1);
			paramClass.setRef(getRef());
		}		*/
		// ����� �׸� ����
		paramClass.setG_NUMBER(getNumber());
		paramClass.setG_CATEGORY(getCategory());
		paramClass.setG_NAME(getProdname());
		paramClass.setG_AMOUNT(getUnit());
		paramClass.setG_PRICE(getPrice());
		paramClass.setG_CONTENT(getContent());
		
		// ��� ���� ����		
		sqlMapper.insert("g_write", paramClass);
		
		// ÷�������� �����ߴٸ� ������ ���ε��Ѵ�.
				resultClass = (goodsVO) sqlMapper.queryForObject("saleboard.prodselectLastNo");
				if(getUpload() != null){			
					for (int i = 0; i < upload.size(); i++) {
						File destFile = new File(fileUploadPath
								+ getUploadFileName().get(i));
						FileUtils.copyFile((getUpload()).get(i), destFile);
					}
					if (upload.size() > 0){
						savimage = getUploadFileName().get(0) + ",";
						for (int i = 1; i < upload.size(); i++){
							savimage += getUploadFileName().get(i) + ",";
						}
						index = savimage.lastIndexOf(',');
						savimage = savimage.substring(0, index);
					}

					// ���� ���� �Ķ���� ����.
					paramClass.setG_NUMBER(resultClass.getG_NUMBER());
					paramClass.setG_ORG_IMAGE(getOrgimage()); // ���� ���� �̸�
					paramClass.setG_SAV_IMAGE(getSavimage()); // ���� ���� �̸�
					// ���� ���� ������Ʈ
					sqlMapper.update("saleboard.updateFile", paramClass);
				}
				return SUCCESS;
}

private int getNumber() {
		return 0;
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

public int getCurrentPage() {
	return currentPage;
}

public void setCurrentPage(int currentPage) {
	this.currentPage = currentPage;
}

public int getProdcode() {
	return prodcode;
}

public void setProdcode(int prodcode) {
	this.prodcode = prodcode;
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getCategory() {
	return category;
}

public void setCategory(String category) {
	this.category = category;
}

public String getProdname() {
	return prodname;
}

public void setProdname(String prodname) {
	this.prodname = prodname;
}

public int getUnit() {
	return unit;
}

public void setUnit(int unit) {
	this.unit = unit;
}

public int getPrice() {
	return price;
}

public void setPrice(int price) {
	this.price = price;
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

public String getContent() {
	return content;
}

public void setContent(String content) {
	this.content = content;
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
