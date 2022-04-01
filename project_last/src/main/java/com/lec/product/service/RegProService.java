package com.lec.product.service;

import java.sql.Connection;

import com.lec.db.JDBCUtil;
import com.lec.product.ProDAO;
import com.lec.product.ProVO;

public class RegProService {
	public boolean regPro(ProVO pro) {
		boolean isSuccess = false;
		
		Connection conn = JDBCUtil.getConnection();
		ProDAO dao = ProDAO.getInstance();
		dao.setConnection(conn);
		
		int count = dao.insertPro(pro);
		
		if (count > 0) {
			isSuccess = true;
		}
		
		JDBCUtil.close(conn, null, null);
		
		return isSuccess;
	}
}

