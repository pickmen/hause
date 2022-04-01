package com.lec.product;

public class ProVO {

	String pro_code;
	String item_code;
	String item_name;
	String pro_count;
	String complete;
	String outware_code;
	String inware_code;
	
	public ProVO() {}
	
	public ProVO(String pro_code,String item_code,String item_name,String pro_count,String complete,String outware_code,String inware_code) {
		this.pro_code = pro_code;
		this.item_code = item_code;
		this.item_name = item_name;
		this.pro_count = pro_count;
		this.complete = complete;
		this.outware_code = outware_code;
		this.inware_code = inware_code;
	}

	public String getPro_code() {
		return pro_code;
	}

	public void setPro_code(String pro_code) {
		this.pro_code = pro_code;
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

	public String getPro_count() {
		return pro_count;
	}

	public void setPro_count(String pro_count) {
		this.pro_count = pro_count;
	}



	public String getComplete() {
		return complete;
	}

	public void setComplete(String complete) {
		this.complete = complete;
	}

	public String getOutware_code() {
		return outware_code;
	}

	public void setOutware_code(String outware_code) {
		this.outware_code = outware_code;
	}

	public String getInware_code() {
		return inware_code;
	}

	public void setInware_code(String inware_code) {
		this.inware_code = inware_code;
	}
	
}
