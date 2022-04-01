package com.lec.order;

import java.sql.Connection;

import com.lec.db.JDBCUtil;

public class RegOrderService {

	public boolean insertOrder(OrderVO order) {
		boolean isSuccessInsert = false;
		Connection conn = JDBCUtil.getConnection();
		OrderDAO dao = OrderDAO.getInstance();
		dao.setConnection(conn);
		isSuccessInsert = dao.insertOrder(order);
		JDBCUtil.close(conn, null, null);
		return isSuccessInsert;
	}
}
