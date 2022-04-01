package com.lec.inventory.service;

import java.sql.Connection;

import com.lec.db.JDBCUtil;
import com.lec.inventory.IVDAO;
import com.lec.inventory.IVVO;

public class UpdateIVService {

	public boolean Update(IVVO iV) {
		boolean isSuccessUpdate = false;
		int count = 0;
		Connection conn = JDBCUtil.getConnection();
		IVDAO dao = IVDAO.getInstance();
		dao.setConnection(conn);
		count = dao.updateIV(iV);
		if (count > 0) {
			isSuccessUpdate = true;
			try {conn.commit();} catch (Exception e) {}
		} else {
			try {conn.rollback();} catch (Exception e) {}
		}
		JDBCUtil.close(conn, null, null);
		return isSuccessUpdate;
	}

}
