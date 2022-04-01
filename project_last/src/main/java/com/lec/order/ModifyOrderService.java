package com.lec.order;

import java.sql.Connection;

import com.lec.db.JDBCUtil;

public class ModifyOrderService {

	public boolean isModifySuccess(OrderVO order) {
		Connection conn = JDBCUtil.getConnection();
		boolean isSuccess = false;
		System.out.println("update");
		OrderDAO dao = OrderDAO.getInstance();
		dao.setConnection(conn);
		isSuccess = dao.updateOrder(order);
		JDBCUtil.close(conn, null, null);
 		return isSuccess;
	}

}
