package com.lec.sales.service;

import java.sql.Connection;

import com.lec.db.JDBCUtil;
import com.lec.sales.SalesDAO;

public class DeleteSalesService {

	public boolean delete(String sale_code) {
		boolean isSuccessDelete = false;
		Connection conn = JDBCUtil.getConnection();
		SalesDAO dao = SalesDAO.getInstance();
		dao.setConnection(conn);
		int count = dao.deleteSales(sale_code);
		if(count > 0) {
			isSuccessDelete = true;
			try {conn.commit();} catch (Exception e) {}
		} else {
			try {conn.rollback();} catch (Exception e) {}
		}
		return isSuccessDelete;
	}

}
