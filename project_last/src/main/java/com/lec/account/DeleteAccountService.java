package com.lec.account;

import java.sql.Connection;

import com.lec.db.JDBCUtil;

public class DeleteAccountService {

	public boolean isDeleteAccount(String account_code) {
		boolean isDeleteAccount = false;
		
		Connection conn = JDBCUtil.getConnection();
		ACDAO dao = ACDAO.getInstance();
		dao.setConnection(conn);
		int count = dao.deleteAccount(account_code);
		if(count > 0) {
			isDeleteAccount = true;
			try {conn.commit();} catch (Exception e) {}
		} else {
			try {conn.rollback();} catch (Exception e) {}
	
		}
		return isDeleteAccount;

	}

}