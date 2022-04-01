package com.lec.product.service;

import java.sql.Connection;

import com.lec.db.JDBCUtil;
import com.lec.product.ProDAO;
import com.lec.product.ProVO;

public class ModifyProService {

	public boolean isModifySuccess(ProVO pro) {
		Connection conn = JDBCUtil.getConnection();
		boolean isSuccess = false;
		ProDAO dao = ProDAO.getInstance();
		dao.setConnection(conn);
		isSuccess = dao.updatePro(pro);
		JDBCUtil.close(conn, null, null);
 		return isSuccess;
	}
}
