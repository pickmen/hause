package com.lec.account;

public class ACVO {

		private String account_code;
		private String account_name;
		private String account_ceo;
		private String account_tell;
		private String account_type;
		
		public ACVO() {
			
		}

		public String getAccount_code() {
			return account_code;
		}

		public void setAccount_code(String account_code) {
			this.account_code = account_code;
		}

		public String getAccount_name() {
			return account_name;
		}

		public void setAccount_name(String account_name) {
			this.account_name = account_name;
		}

		public String getAccount_ceo() {
			return account_ceo;
		}

		public void setAccount_ceo(String account_ceo) {
			this.account_ceo = account_ceo;
		}

		public String getAccount_tell() {
			return account_tell;
		}

		public void setAccount_tell(String account_tell) {
			this.account_tell = account_tell;
		}

		public String getAccount_type() {
			return account_type;
		}

		public void setAccount_type(String account_type) {
			this.account_type = account_type;
		}

		public ACVO(String account_code, String account_name, String account_ceo, String account_tell,
				String account_type) {
			super();
			this.account_code = account_code;
			this.account_name = account_name;
			this.account_ceo = account_ceo;
			this.account_tell = account_tell;
			this.account_type = account_type;
		}

		
}
