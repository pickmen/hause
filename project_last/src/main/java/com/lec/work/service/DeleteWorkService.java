package com.lec.work.service;

import java.sql.Connection;

import com.lec.db.JDBCUtil;
import com.lec.work.WorkDAO;

public class DeleteWorkService {

	public boolean isDeleteWork(String work_code) {
		boolean isDeleteWork = false;
		
		Connection conn = JDBCUtil.getConnection();
		WorkDAO dao = WorkDAO.getInstance();
		dao.setConnection(conn);
		isDeleteWork = dao.deleteWork(work_code);
		JDBCUtil.close(conn, null, null);
		
		return isDeleteWork;
	}

}