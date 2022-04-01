package com.lec.work;

public class WorkVO {
	
	String work_code;
	String item_code;
	String item_name;
	String work_count;
	String work_time;
	
	public WorkVO() {}
	
	public WorkVO(String work_code, String item_code, String item_name,String work_count,String work_time) {
		this.work_code = work_code;
		this.item_code = item_code;
		this.item_name = item_name;
		this.work_count = work_count;
		this.work_time = work_time;
	}

	public String getWork_code() {
		return work_code;
	}

	public void setWork_code(String work_code) {
		this.work_code = work_code;
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

	public String getWork_count() {
		return work_count;
	}

	public void setWork_count(String work_count) {
		this.work_count = work_count;
	}

	public String getWork_time() {
		return work_time;
	}

	public void setWork_time(String work_time) {
		this.work_time = work_time;
	}


	
	
	
	
	
}
