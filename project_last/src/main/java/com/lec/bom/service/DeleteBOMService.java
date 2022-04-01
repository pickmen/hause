package com.lec.bom.service;

import java.sql.Connection;

import com.lec.bom.BomDAO;
import com.lec.db.JDBCUtil;

public class DeleteBOMService {

	public boolean delete(String item_code) {
		boolean isSuccessDelete = false;
		Connection conn = JDBCUtil.getConnection();
		BomDAO dao = BomDAO.getInstance();
		dao.setConnection(conn);
		int count = dao.deleteBOM(item_code);
		if(count > 0) {
			isSuccessDelete = true;
			try {conn.commit();} catch (Exception e) {}
		} else {
			try {conn.rollback();} catch (Exception e) {}
		}
		return isSuccessDelete;
	}

}
