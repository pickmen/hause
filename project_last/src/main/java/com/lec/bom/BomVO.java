package com.lec.bom;

public class BomVO {
	String item_code;
	String item_name;
	int item_cnt;
	String prt_item_code;
	public BomVO() {}
	public BomVO(String item_code, String item_name, int item_cnt, String prt_item_code) {
		this.item_code = item_code;
		this.item_name = item_name;
		this.item_cnt = item_cnt;
		this.prt_item_code = prt_item_code;
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
	public int getItem_cnt() {
		return item_cnt;
	}
	public void setItem_cnt(int item_cnt) {
		this.item_cnt = item_cnt;
	}
	public String getPrt_item_code() {
		return prt_item_code;
	}
	public void setPrt_item_code(String prt_item_code) {
		this.prt_item_code = prt_item_code;
	}
	
}
