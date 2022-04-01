package com.lec.product.service;

import java.sql.Connection;

import com.lec.db.JDBCUtil;
import com.lec.product.ProDAO;

public class DeleteProService {

	public boolean isDeletePro(String pro_code) {
		boolean isDeletePro = false;
		
		Connection conn = JDBCUtil.getConnection();
		ProDAO dao = ProDAO.getInstance();
		dao.setConnection(conn);
		isDeletePro = dao.deletePro(pro_code);
		JDBCUtil.close(conn, null, null);
		
		return isDeletePro;
	}

}
