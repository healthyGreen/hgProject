package goods;

import com.opensymphony.xwork2.ActionSupport;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.io.Reader;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class goodsDeleteAction extends ActionSupport{

		public static Reader reader;
		public static SqlMapClient sqlMapper;

		private goodsVO goods_paramClass; // �Ķ���͸� ������ ��ü
		private goodsVO goods_resultClass; // ���� ��� ���� ������ ��ü

		private replyVO reClass = new replyVO(); // ����� �Ķ���͸� ������ ��ü
		private replyVO reResult = new replyVO(); // ����� ���� ������� ������ ��ü

		private int currentPage;

		private int no;
		private int goods_num;
		private String goods_category;
		private String category;

		// ������
		public goodsDeleteAction() throws IOException {
			reader = Resources.getResourceAsReader("sqlMapConfig.xml");
			// sqlMapConfig.xml������ ���������� �����´�.
			sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
			// sqlMapConfig.xml�� ������ ������ sqlMapper��ü ����.

			reader.close();
		}

		// �Խñ� �� ����
		public String execute() throws Exception {

			// �Ķ���Ϳ� ����Ʈ ��ü ����.
			goods_paramClass = new goodsVO();
			goods_resultClass = new goodsVO();

			// �ش��ȣ�� ���� �����´�.
			goods_resultClass = (goodsVO) sqlMapper.queryForObject(
					"goodsselectOne", getGoods_num());

			// ������ �׸� ����.
			goods_paramClass.setG_NUMBER(getGoods_num());

			// ���� ���� ����.
			sqlMapper.update("deleteGoods", goods_paramClass);

			return SUCCESS;
		}

		// ��� ����
		public String execute2() throws Exception {

			reClass = new replyVO();
			reResult = new replyVO();

			// ������ �׸� ����.
			reClass.setNo(getNo());

			// ������ ���� ����.
			sqlMapper.update("deleteComment", reClass);

			return SUCCESS;
		}

		public static Reader getReader() {
			return reader;
		}

		public static void setReader(Reader reader) {
			goodsDeleteAction.reader = reader;
		}

		public static SqlMapClient getSqlMapper() {
			return sqlMapper;
		}

		public static void setSqlMapper(SqlMapClient sqlMapper) {
			goodsDeleteAction.sqlMapper = sqlMapper;
		}

		public int getCurrentPage() {
			return currentPage;
		}

		public void setCurrentPage(int currentPage) {
			this.currentPage = currentPage;
		}

		public int getNo() {
			return no;
		}

		public void setNo(int no) {
			this.no = no;
		}

		public replyVO getReClass() {
			return reClass;
		}

		public void setReClass(replyVO reClass) {
			this.reClass = reClass;
		}

		public replyVO getcResult() {
			return reResult;
		}

		public void setcResult(replyVO reResult) {
			this.reResult = reResult;
		}

		public replyVO getReResult() {
			return reResult;
		}

		public void setReResult(replyVO reResult) {
			this.reResult = reResult;
		}

		public int getGoods_num() {
			return goods_num;
		}

		public void setGoods_num(int goods_num) {
			this.goods_num = goods_num;
		}

		public String getGoods_category() {
			return goods_category;
		}

		public void setGoods_category(String goods_category) {
			this.goods_category = goods_category;
		}

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}

		public goodsVO getGoods_paramClass() {
			return goods_paramClass;
		}

		public void setGoods_paramClass(goodsVO goods_paramClass) {
			this.goods_paramClass = goods_paramClass;
		}

		public goodsVO getGoods_resultClass() {
			return goods_resultClass;
		}

		public void setGoods_resultClass(goodsVO goods_resultClass) {
			this.goods_resultClass = goods_resultClass;
		}

	}


