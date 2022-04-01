package com.lec.bom.service;

import java.sql.Connection;

import com.lec.bom.BomDAO;
import com.lec.bom.BomVO;
import com.lec.db.JDBCUtil;

public class UpdateBOMService {

	public boolean Update(BomVO bom) {
		boolean isSuccessUpdate = false;
		int count = 0;
		Connection conn = JDBCUtil.getConnection();
		BomDAO dao = BomDAO.getInstance();
		dao.setConnection(conn);
		count = dao.updateBOM(bom);
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
