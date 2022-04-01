package com.lec.poor.service;

import java.sql.Connection;

import com.lec.db.JDBCUtil;
import com.lec.poor.PoorDAO;
import com.lec.poor.PoorVO;

public class ModifyPoorService {

	public boolean isModifySuccess(PoorVO poor) {
		Connection conn = JDBCUtil.getConnection();
		boolean isSuccess = false;
		PoorDAO dao = PoorDAO.getInstance();
		dao.setConnection(conn);
		isSuccess = dao.updatePoor(poor);
		JDBCUtil.close(conn, null, null);
 		return isSuccess;
	}
}
