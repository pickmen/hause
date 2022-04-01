package com.lec.account;

import java.sql.Connection;

import com.lec.db.JDBCUtil;

public class ModifyAccountService {

	public boolean isModifySuccess(ACVO account) {
		Connection conn = JDBCUtil.getConnection();
		boolean isSuccess = false;
		ACDAO dao = ACDAO.getInstance();
		dao.setConnection(conn);
		isSuccess = dao.updateAccount(account);
		JDBCUtil.close(conn, null, null);
 		return isSuccess;
	}

}
