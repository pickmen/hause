package com.lec.ware;

import java.sql.Connection;

import com.lec.db.JDBCUtil;

public class RegWareService  {

	public boolean insertWare(WareVO ware) {
		boolean isSuccessInsert = false;
		Connection conn = JDBCUtil.getConnection();
		WareDAO dao = WareDAO.getInstance();
		dao.setConnection(conn);
		isSuccessInsert = dao.insertWare(ware);
		JDBCUtil.close(conn, null, null);
		return isSuccessInsert;
	
	}

}
