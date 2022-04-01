package com.lec.order;

public class OrderVO {

		String order_code;
		String account_code;
		String item_code;
		String item_name;
		String order_date;
		int order_cnt;
		double order_cost;
		double order_price;
		
		
		
		public OrderVO() {
			
		}

		public OrderVO(String order_code, String account_code, String item_code, String item_name, String order_date, int order_cnt, double order_cost, double order_price) {
			
			this.order_code = order_code;
			this.account_code = account_code;
			this.item_code = item_code;
			this.item_name = item_name;
			this.order_date = order_date;
			this.order_cnt = order_cnt;
			this.order_cost = order_cost;
			this.order_price = order_price;
			
			
		}

		public String getOrder_code() {
			return order_code;
		}

		public void setOrder_code(String order_code) {
			this.order_code = order_code;
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

		public String getOrder_date() {
			return order_date;
		}

		public void setOrder_date(String order_date) {
			this.order_date = order_date;
		}

		public int getOrder_cnt() {
			return order_cnt;
		}

		public void setOrder_qty(int order_cnt) {
			this.order_cnt = order_cnt;
		}

		public double getOrder_cost() {
			return order_cost;
		}

		public void setOrder_cost(double order_cost) {
			this.order_cost = order_cost;
		}

		public double getOrder_price() {
			return order_price;
		}

		public void setOrder_price(double order_price) {
			this.order_price = order_price;
		}

		
	
}
