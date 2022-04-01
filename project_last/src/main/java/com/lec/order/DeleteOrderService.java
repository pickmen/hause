package com.lec.order;

import java.sql.Connection;

import com.lec.db.JDBCUtil;

public class DeleteOrderService {

	public boolean isDeleteOrder(String order_code) {
		boolean isDeleteOrder = false;
		
		Connection conn = JDBCUtil.getConnection();
		OrderDAO dao = OrderDAO.getInstance();
		dao.setConnection(conn);
		isDeleteOrder = dao.deleteOrder(order_code);
		JDBCUtil.close(conn, null, null);
		
		return isDeleteOrder;
	}

}
