package com.lec.item;

import java.sql.Connection;

import com.lec.db.JDBCUtil;

public class RegItemService {

	public boolean insertIM(IMVO item) {
		boolean isSuccessInsert = false;
		Connection conn = JDBCUtil.getConnection();
		IMDAO dao = IMDAO.getInstance();
		dao.setConnection(conn);
		isSuccessInsert = dao.insertIM(item);
		JDBCUtil.close(conn, null, null);
		return isSuccessInsert;
	}
}
