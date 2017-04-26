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

public class goodsDeleteAction extends ActionSupport{

		public static Reader reader;
		public static SqlMapClient sqlMapper;

		private goodsVO goods_paramClass; // 파라미터를 저장할 객체
		private goodsVO goods_resultClass; // 쿼리 결과 값을 저장할 객체

		private replyVO reClass = new replyVO(); // 댓글의 파라미터를 저장할 객체
		private replyVO reResult = new replyVO(); // 댓글의 쿼리 결과값을 저장할 객체
		private replyVO passResult = new replyVO();
		private int currentPage;
		private String rp_pass;
		private int no;
		private int G_NUMBER;
		private String G_CATEGORY;
		private String category;
		private int rp_number;

		// 생성자
		public goodsDeleteAction() throws IOException {
			reader = Resources.getResourceAsReader("sqlMapConfig.xml");
			// sqlMapConfig.xml파일의 설정내용을 가져온다.
			sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
			// sqlMapConfig.xml의 내용을 적용한 sqlMapper객체 생성.

			reader.close();
		}

		// 게시글 글 삭제
		public String execute() throws Exception {

			// 파라미터와 리절트 객체 생성.
			goods_paramClass = new goodsVO();
			goods_resultClass = new goodsVO();

			// 해당번호의 글을 가져온다.
		/*	goods_resultClass = (goodsVO) sqlMapper.queryForObject(
					"g_list_selectOne", getG_NUMBER());*/

			// 삭제할 항목 설정.
			goods_paramClass.setG_number(getG_NUMBER());

			// 삭제 쿼리 수행.
			sqlMapper.delete("g_delete", goods_paramClass);

			return SUCCESS;
		}

		// 댓글 삭제
		public String execute2() throws Exception {

			reClass = new replyVO();
			reResult = new replyVO();

			// 삭제할 항목 설정.
			reClass.setRp_number(getNo());

			// 삭제할 쿼리 수행.
			sqlMapper.update("g_deleteReply", reClass);

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

		public int getG_NUMBER() {
			return G_NUMBER;
		}

		public void setG_NUMBER(int goods_num) {
			this.G_NUMBER = goods_num;
		}

		public String getG_CATEGORY() {
			return G_CATEGORY;
		}

		public void setG_CATEGORY(String goods_category) {
			this.G_CATEGORY = goods_category;
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


