package com.lec.ware;

import java.sql.Connection;

import com.lec.db.JDBCUtil;

public class DeleteWareService {

	public boolean isDeleteWare(String ware_code) {
		boolean isDeleteWare = false;
		Connection conn = JDBCUtil.getConnection();
		WareDAO dao = WareDAO.getInstance();
		dao.setConnection(conn);
		int count = dao.deleteWare(ware_code);
		if(count > 0) {
			isDeleteWare = true;
			try {conn.commit();} catch (Exception e) {}
		} else {
			try {conn.rollback();} catch (Exception e) {}
		}
		return isDeleteWare;
	}

}
