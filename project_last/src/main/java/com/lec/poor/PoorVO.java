package com.lec.poor;

public class PoorVO {

	String pro_code;
	String item_code;
	String poor_count;
	String bool_poor;
	
	public PoorVO() {}
	
	public PoorVO(String pro_code,String item_code,String poor_count,String bool_poor) {
		this.pro_code = pro_code;
		this.item_code = item_code;
		this.poor_count = poor_count;
		this.bool_poor = bool_poor;
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

	public String getPoor_count() {
		return poor_count;
	}

	public void setPoor_count(String poor_count) {
		this.poor_count = poor_count;
	}

	public String getBool_poor() {
		return bool_poor;
	}

	public void setBool_poor(String bool_poor) {
		this.bool_poor = bool_poor;
	}
	
}
