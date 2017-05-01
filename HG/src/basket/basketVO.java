package basket;

import java.util.Date;

public class basketVO {
   
   private String b_m_id;
   private int b_g_number;
   private String b_g_name;
   private int b_g_amount;
   private int b_allPrice;
   private String b_g_bottle;
   private int b_g_price;
   private Date b_date;
   private int b_number;
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
  
   public int getB_g_amount() {
	return b_g_amount;
}
public void setB_g_amount(int b_g_amount) {
	this.b_g_amount = b_g_amount;
}
public int getB_allPrice() {
      return b_allPrice;
   }
   public void setB_allPrice(int b_allPrice) {
      this.b_allPrice = b_allPrice;
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
public Date getB_date() {
	return b_date;
}
public void setB_date(Date b_date) {
	this.b_date = b_date;
}
public int getB_number() {
	return b_number;
}
public void setB_number(int b_number) {
	this.b_number = b_number;
}

}