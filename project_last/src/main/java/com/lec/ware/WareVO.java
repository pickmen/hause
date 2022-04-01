package com.lec.ware;



public class WareVO {
	
	String ware_code;
	String ware_name;
	String ware_type;
	String pro_code;
	String account_code;
	
	public WareVO() {}
	

	public WareVO(String ware_code, String ware_name, String ware_type, String pro_code, 
			String account_code) {
	
		this.ware_code = ware_code;
		this.ware_name = ware_name;
		this.ware_type = ware_type;
		this.pro_code = pro_code;
		this.account_code = account_code;
	}


	public String getWare_code() {
		return ware_code;
	}

	public void setWare_code(String ware_code) {
		this.ware_code = ware_code;
	}

	public String getWare_name() {
		return ware_name;
	}

	public void setWare_name(String ware_name) {
		this.ware_name = ware_name;
	}

	public String getWare_type() {
		return ware_type;
	}

	public void setWare_type(String ware_type) {
		this.ware_type = ware_type;
	}

	public String getPro_code() {
		return pro_code;
	}

	public void setPro_code(String pro_code) {
		this.pro_code = pro_code;
	}

	public String getAccount_code() {
		return account_code;
	}

	public void setAccount_code(String account_code) {
		this.account_code = account_code;
	}






	
	
	
}
