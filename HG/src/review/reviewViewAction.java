package review;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

public class reviewViewAction extends ActionSupport{
      private static Reader reader;
      private static SqlMapClient sqlMapper;
      //private reviewVO paramClass;
      private reviewVO resultClass;
      private static int number;

   public reviewViewAction() throws IOException {
      reader=Resources.getResourceAsReader("sqlMapConfig.xml");
      sqlMapper=SqlMapClientBuilder.buildSqlMapClient(reader);
      reader.close();
   }
   
   public String execute() throws SQLException{
      resultClass=(reviewVO)sqlMapper.queryForObject("Board.selectOneReview", number);
      sqlMapper.update("Board.updateRvReadHit", number);
      return SUCCESS;
   }

   public reviewVO getResultClass() {
      return resultClass;
   }

   public void setResultClass(reviewVO resultClass) {
      this.resultClass = resultClass;
   }

   public static int getNumber() {
      return number;
   }

   public static void setNumber(int number) {
      reviewViewAction.number = number;
   }   
   
   
}