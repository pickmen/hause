package com.lec.sales.service;

import java.sql.Connection;

import com.lec.db.JDBCUtil;
import com.lec.sales.SalesDAO;
import com.lec.sales.SalesVO;

public class InsertSalesService {

	public boolean insert(SalesVO sales) {
		boolean isSuccessInsert = false;
		Connection conn = JDBCUtil.getConnection();
		int count = 0;
		SalesDAO dao = SalesDAO.getInstance();
		dao.setConnection(conn);
		
		count = dao.insertSales(sales);
		if(count>0) {
			isSuccessInsert = true;
			try{conn.commit();} catch (Exception e) {}
		} else {
			try{conn.rollback();} catch (Exception e) {}
		}
		
		JDBCUtil.close(conn, null, null);
		return isSuccessInsert;
	}

}
