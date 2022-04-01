package com.lec.poor.service;

import java.sql.Connection;

import com.lec.db.JDBCUtil;
import com.lec.poor.PoorDAO;

public class DeletePoorService {

	public boolean isDeletePoor(String pro_code) {
		boolean isDeletePoor = false;
		
		Connection conn = JDBCUtil.getConnection();
		PoorDAO dao = PoorDAO.getInstance();
		dao.setConnection(conn);
		isDeletePoor = dao.deletePoor(pro_code);
		if(isDeletePoor) {
			try {conn.commit();} catch (Exception e) {}
		} else {
			try {conn.rollback();} catch (Exception e) {}
		}
		JDBCUtil.close(conn, null, null);
		
		return isDeletePoor;
	}

}
