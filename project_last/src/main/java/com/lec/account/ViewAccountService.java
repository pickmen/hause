package com.lec.account;

import java.sql.Connection;
import java.util.List;

import com.lec.db.JDBCUtil;

public class ViewAccountService {

	public List<ACVO> getAccountList(){
		List<ACVO> accountlist = null;
		Connection conn = JDBCUtil.getConnection();
		ACDAO dao = ACDAO.getInstance();
		dao.setConnection(conn);
		accountlist = dao.getAccountList();
		JDBCUtil.close(conn, null, null);
		return accountlist;
	}
}
