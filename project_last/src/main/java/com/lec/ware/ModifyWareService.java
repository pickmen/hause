package com.lec.ware;

import java.sql.Connection;

import com.lec.db.JDBCUtil;

public class ModifyWareService {

	public boolean isModifySuccess(WareVO ware) {
		Connection conn = JDBCUtil.getConnection();
		boolean isSuccess = false;
		WareDAO dao = WareDAO.getInstance();
		dao.setConnection(conn);
		isSuccess = dao.updateWare(ware);
		JDBCUtil.close(conn, null, null);
 		return isSuccess;
	}

}
