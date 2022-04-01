package com.lec.poor.service;

import java.sql.Connection;

import com.lec.db.JDBCUtil;
import com.lec.poor.PoorDAO;
import com.lec.poor.PoorVO;

public class RegPoorService {
	public boolean regPoor(PoorVO poor) {
		boolean isSuccess = false;
		
		Connection conn = JDBCUtil.getConnection();
		PoorDAO dao = PoorDAO.getInstance();
		dao.setConnection(conn);
		
		int count = dao.insertPoor(poor);
		
		if (count > 0) {
			isSuccess = true;
		}
		
		JDBCUtil.close(conn, null, null);
		
		return isSuccess;
	}
}

