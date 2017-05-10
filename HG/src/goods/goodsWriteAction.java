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
	//private int g_amount;
	//private String g_bottle;
	private String g_org_image; // ���ε� ���� ���� �̸�
	private String g_sav_image; // ������ ������ ���ε� ���� �̸� (������ȣ�� �з���)
	private int g_jaegoAmount;
	private Map session;

	private List<File> upload = new ArrayList<File>(); // ���� ��ü
	private List<String> uploadContentType = new ArrayList<String>(); // ������ Ÿ��
	private List<String> uploadFileName = new ArrayList<String>(); // ���� �̸�
	private String fileUploadPath = "C:\\Java\\HG\\HG\\WebContent\\template\\goods\\upload\\";// ���ε�
	private int index;// ���

	public goodsWriteAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}

	public String form() throws Exception {
		return SUCCESS;
	}

	public String execute() throws Exception {

		paramClass = new goodsVO();
		resultClass = new goodsVO();

		// ����� �׸� ����
		paramClass.setG_name(g_name);
		//paramClass.setG_amount(g_amount);
		//paramClass.setG_bottle(g_bottle);
		paramClass.setG_category(g_category);
		paramClass.setG_content(g_content);
		paramClass.setG_info(g_info);
		paramClass.setG_ingr(g_ingr);
		paramClass.setG_number(g_number);
		paramClass.setG_price(g_price);
		paramClass.setG_jaegoAmount(g_jaegoAmount);
		
		sqlMapper.insert("g_write", paramClass);
		// ÷�������� �����ߴٸ� ������ ���ε��Ѵ�.
	if (upload != null) {
			resultClass = (goodsVO)sqlMapper.queryForObject("selectLastNum");
			for (int i = 0; i < upload.size(); i++) {
				File destFile = new File(fileUploadPath + getUploadFileName().get(i));
				FileUtils.copyFile((getUpload()).get(i), destFile);
			}
			if (upload.size() > 0) {
				g_sav_image = getUploadFileName().get(0) + ",";
				for (int i = 1; i < upload.size(); i++) {
					g_sav_image += getUploadFileName().get(i) + ",";
				}
				index = g_sav_image.lastIndexOf(',');
				g_sav_image = g_sav_image.substring(0, index);
			}

			// ���� ���� �Ķ���� ����.
			paramClass.setG_number(resultClass.getG_number());
			paramClass.setG_org_image(g_sav_image); // ���� ���� �̸� -> �׳� save����
													// �̸����� �ֱ�
			paramClass.setG_sav_image(g_sav_image); // ���� ���� �̸�
			// ���� ���� ������Ʈ

			sqlMapper.update("g_upload", paramClass);
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

	public int getG_price() {
		return g_price;
	}

	public void setG_price(int g_price) {
		this.g_price = g_price;
	}

	public String getG_ingr() {
		return g_ingr;
	}

	public void setG_ingr(String g_ingr) {
		this.g_ingr = g_ingr;
	}

	public String getG_category() {
		return g_category;
	}

	public void setG_category(String g_category) {
		this.g_category = g_category;
	}

	public String getG_org_image() {
		return g_org_image;
	}

	public void setG_org_image(String g_org_image) {
		this.g_org_image = g_org_image;
	}

	public String getG_sav_image() {
		return g_sav_image;
	}

	public void setG_sav_image(String g_sav_image) {
		this.g_sav_image = g_sav_image;
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

	public int getG_jaegoAmount() {
		return g_jaegoAmount;
	}

	public void setG_jaegoAmount(int g_jaegoAmount) {
		this.g_jaegoAmount = g_jaegoAmount;
	}
	
	
}
