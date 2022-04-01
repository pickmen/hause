package com.lec.account;

import java.sql.Connection;

import com.lec.db.JDBCUtil;

public class RegAccountService {

	public boolean insertAC(ACVO account) {
		boolean isSuccessInsert = false;
		Connection conn = JDBCUtil.getConnection();
		ACDAO dao = ACDAO.getInstance();
		dao.setConnection(conn);
		isSuccessInsert = dao.insertAC(account);
		JDBCUtil.close(conn, null, null);
		return isSuccessInsert;
	}
}
