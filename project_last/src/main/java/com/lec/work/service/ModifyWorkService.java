package com.lec.work.service;

import java.sql.Connection;

import com.lec.db.JDBCUtil;
import com.lec.work.WorkDAO;
import com.lec.work.WorkVO;

public class ModifyWorkService {

	public boolean isModifySuccess(WorkVO work) {
		Connection conn = JDBCUtil.getConnection();
		boolean isSuccess = false;
		WorkDAO dao = WorkDAO.getInstance();
		dao.setConnection(conn);
		isSuccess = dao.updateWork(work);
		JDBCUtil.close(conn, null, null);
 		return isSuccess;
	}
}