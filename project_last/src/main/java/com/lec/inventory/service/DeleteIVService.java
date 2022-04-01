package com.lec.inventory.service;

import java.sql.Connection;

import com.lec.db.JDBCUtil;
import com.lec.inventory.IVDAO;
import com.lec.inventory.IVVO;

public class DeleteIVService {

	public boolean delete(IVVO IV) {
		
		boolean isSuccessDelete = false;
		Connection conn = JDBCUtil.getConnection();
		IVDAO dao = IVDAO.getInstance();
		dao.setConnection(conn);
		int count = dao.deleteIV(IV);
		if(count > 0) {
			isSuccessDelete = true;
			try {conn.commit();} catch (Exception e) {}
		} else {
			try {conn.rollback();} catch (Exception e) {}
		}
		return isSuccessDelete;
	}

}
