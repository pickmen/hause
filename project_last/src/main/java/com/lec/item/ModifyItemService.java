package com.lec.item;

import java.sql.Connection;

import com.lec.db.JDBCUtil;

public class ModifyItemService {

	public boolean isModifySuccess(IMVO item) {
		Connection conn = JDBCUtil.getConnection();
		boolean isSuccess = false;
		IMDAO dao = IMDAO.getInstance();
		dao.setConnection(conn);
		isSuccess = dao.updateItem(item);
		JDBCUtil.close(conn, null, null);
 		return isSuccess;
	}

}
