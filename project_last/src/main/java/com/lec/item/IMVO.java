package com.lec.item;

public class IMVO {
	private String item_code;
	private String item_name;
	private int item_cost;
	private int item_price;
	private String item_type;
	private String item_comment;
	
	public IMVO() {
	}
	
	public IMVO(String item_code, String item_name, int item_cost, int item_price, String item_type,
			String item_comment) {
		this.item_code = item_code;
		this.item_name = item_name;
		this.item_cost = item_cost;
		this.item_price = item_price;
		this.item_type = item_type;
		this.item_comment = item_comment;
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
	public int getItem_cost() {
		return item_cost;
	}
	public void setItem_cost(int item_cost) {
		this.item_cost = item_cost;
	}
	public int getItem_price() {
		return item_price;
	}
	public void setItem_price(int item_price) {
		this.item_price = item_price;
	}
	public String getItem_type() {
		return item_type;
	}
	public void setItem_type(String item_type) {
		this.item_type = item_type;
	}
	public String getItem_comment() {
		return item_comment;
	}
	public void setItem_comment(String item_commtent) {
		this.item_comment = item_commtent;
	}
}
