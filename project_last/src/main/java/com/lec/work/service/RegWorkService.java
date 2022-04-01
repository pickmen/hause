package com.lec.work.service;

import java.sql.Connection;

import com.lec.db.JDBCUtil;
import com.lec.work.WorkDAO;
import com.lec.work.WorkVO;

public class RegWorkService {
	public boolean regWork(WorkVO work) {
		boolean isSuccess = false;
		
		Connection conn = JDBCUtil.getConnection();
		WorkDAO dao = WorkDAO.getInstance();
		dao.setConnection(conn);
		
		int count = dao.insertWork(work);
		
		if (count > 0) {
			isSuccess = true;
		}
		
		JDBCUtil.close(conn, null, null);
		
		return isSuccess;
	}
}
