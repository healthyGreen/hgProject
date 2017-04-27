package orders;

import java.util.Date;

public class setOrderVO {
	private String b_m_id;
	private String b_g_name;
	private int  b_g_amount;
	private int b_allprice;
	private String b_g_bottle;
	private Date b_date;
	private int g_price;
	private String g_sav_image;
	public String getB_m_id() {
		return b_m_id;
	}
	public void setB_m_id(String b_m_id) {
		this.b_m_id = b_m_id;
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
	public int getB_allprice() {
		return b_allprice;
	}
	public void setB_allprice(int b_allprice) {
		this.b_allprice = b_allprice;
	}
	public String getB_g_bottle() {
		return b_g_bottle;
	}
	public void setB_g_bottle(String b_g_bottle) {
		this.b_g_bottle = b_g_bottle;
	}
	public Date getB_date() {
		return b_date;
	}
	public void setB_date(Date b_date) {
		this.b_date = b_date;
	}
	public int getG_price() {
		return g_price;
	}
	public void setG_price(int g_price) {
		this.g_price = g_price;
	}
	public String getG_sav_image() {
		return g_sav_image;
	}
	public void setG_sav_image(String g_sav_image) {
		this.g_sav_image = g_sav_image;
	}
}
