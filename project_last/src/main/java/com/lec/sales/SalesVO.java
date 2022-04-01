package com.lec.sales;

public class SalesVO {
	String sale_code;
	String account_code;
	String item_code;
	String item_name;
	String sale_date;
	int sale_cnt;
	double sale_price;
	double sale_cost;
	String ware_code;
	public SalesVO() {}
	public SalesVO(String sale_code, String account_code, String item_code, String item_name, String sale_date,
			int sale_cnt, double sale_price, double sale_cost, String ware_code) {
		this.sale_code = sale_code;
		this.account_code = account_code;
		this.item_code = item_code;
		this.item_name = item_name;
		this.sale_date = sale_date;
		this.sale_cnt = sale_cnt;
		this.sale_price = sale_price;
		this.sale_cost = sale_cost;
		this.ware_code = ware_code;
	}
	public String getSale_code() {
		return sale_code;
	}
	public void setSale_code(String sale_code) {
		this.sale_code = sale_code;
	}
	public String getAccount_code() {
		return account_code;
	}
	public void setAccount_code(String account_code) {
		this.account_code = account_code;
	}
	public String getItem_code() {
		return item_code;
	}
	public void setItem_code(String item_code) {
		this.item_code = item_code;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getSale_date() {
		return sale_date;
	}
	public void setSale_date(String sale_date) {
		this.sale_date = sale_date;
	}
	public int getSale_cnt() {
		return sale_cnt;
	}
	public void setSale_cnt(int sale_cnt) {
		this.sale_cnt = sale_cnt;
	}
	public double getSale_price() {
		return sale_price;
	}
	public void setSale_price(double sale_price) {
		this.sale_price = sale_price;
	}
	public double getSale_cost() {
		return sale_cost;
	}
	public void setSale_cost(double sale_cost) {
		this.sale_cost = sale_cost;
	}
	public String getWare_code() {
		return ware_code;
	}
	public void setWare_code(String ware_code) {
		this.ware_code = ware_code;
	}
}
