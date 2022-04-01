package com.lec.sales.service;

import java.sql.Connection;

import com.lec.db.JDBCUtil;
import com.lec.sales.SalesDAO;
import com.lec.sales.SalesVO;

public class UpdateSalesService {

	public boolean Update(SalesVO sales) {
		boolean isSuccessUpdate = false;
		int count = 0;
		Connection conn = JDBCUtil.getConnection();
		SalesDAO dao = SalesDAO.getInstance();
		dao.setConnection(conn);
		count = dao.updateSales(sales);
		if (count > 0) {
			isSuccessUpdate = true;
			try {conn.commit();} catch (Exception e) {}
		} else {
			try {conn.rollback();} catch (Exception e) {}
		}
		JDBCUtil.close(conn, null, null);
		return isSuccessUpdate;
	}

}
