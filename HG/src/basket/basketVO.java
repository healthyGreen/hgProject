package basket;

import java.util.Date;

public class basketVO {
   
   private String b_m_id;
   private int b_g_number;
   private String b_g_name;
   private int b_g_amout;
   private int b_allPrice;
   private Date b_date;
   private String b_g_bottle;
   private int b_g_price;
   
   public String getB_m_id() {
      return b_m_id;
   }
   public void setB_m_id(String b_m_id) {
      this.b_m_id = b_m_id;
   }
   public int getB_g_number() {
      return b_g_number;
   }
   public void setB_g_number(int b_g_number) {
      this.b_g_number = b_g_number;
   }
   public String getB_g_name() {
      return b_g_name;
   }
   public void setB_g_name(String b_g_name) {
      this.b_g_name = b_g_name;
   }
   public int getB_g_amout() {
      return b_g_amout;
   }
   public void setB_g_amout(int b_g_amout) {
      this.b_g_amout = b_g_amout;
   }
   public int getB_allPrice() {
      return b_allPrice;
   }
   public void setB_allPrice(int b_allPrice) {
      this.b_allPrice = b_allPrice;
   }
   public Date getB_date() {
      return b_date;
   }
   public void setB_date(Date b_date) {
      this.b_date = b_date;
   }
public String getB_g_bottle() {
	return b_g_bottle;
}
public void setB_g_bottle(String b_g_bottle) {
	this.b_g_bottle = b_g_bottle;
}
public int getB_g_price() {
	return b_g_price;
}
public void setB_g_price(int b_g_price) {
	this.b_g_price = b_g_price;
}

   
}