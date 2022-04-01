package com.lec.inventory;

public class IVVO {

	String item_code;
	String item_name;
	String ware_code;
	int inven_cnt;
	public IVVO(String item_code, String item_name, String ware_code, int inven_cnt) {
		this.item_code = item_code;
		this.item_name = item_name;
		this.ware_code = ware_code;
		this.inven_cnt = inven_cnt;
	}
	public IVVO() {}
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
	public String getWare_code() {
		return ware_code;
	}
	public void setWare_code(String ware_code) {
		this.ware_code = ware_code;
	}
	public int getInven_cnt() {
		return inven_cnt;
	}
	public void setInven_cnt(int inven_cnt) {
		this.inven_cnt = inven_cnt;
	}
	
}
