package com.lec.buy;

public class BuyVO {

		 String buy_code;
		 String account_code;
		 String item_code;
		 String item_name;
		 String buy_date;
		 int buy_cnt;
		 double buy_cost;
		 double buy_price;
		 String ware_code;
		
		
		
		public BuyVO() {
			
		}

		public BuyVO(String buy_code, String account_code, String item_code, String item_name, String buy_date, int buy_cnt, double buy_cost, double buy_price, String ware_code) {
			
			this.buy_code = buy_code;
			this.account_code = account_code;
			this.item_code = item_code;
			this.item_name = item_name;
			this.buy_date = buy_date;
			this.buy_cnt = buy_cnt;
			this.buy_cost = buy_cost;
			this.buy_price = buy_price;
			this.ware_code = ware_code;
			
			
		}

		public String getBuy_code() {
			return buy_code;
		}

		public void setBuy_code(String buy_code) {
			this.buy_code = buy_code;
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

		public String getBuy_date() {
			return buy_date;
		}

		public void setBuy_date(String buy_date) {
			this.buy_date = buy_date;
		}

		public int getBuy_cnt() {
			return buy_cnt;
		}

		public void setBuy_cnt(int buy_cnt) {
			this.buy_cnt = buy_cnt;
		}

		public double getBuy_cost() {
			return buy_cost;
		}

		public void setBuy_cost(double buy_cost) {
			this.buy_cost = buy_cost;
		}

		public double getBuy_price() {
			return buy_price;
		}

		public void setBuy_price(double buy_price) {
			this.buy_price = buy_price;
		}

		public String getWare_code() {
			return ware_code;
		}

		public void setWare_code(String ware_code) {
			this.ware_code = ware_code;
		}

}
