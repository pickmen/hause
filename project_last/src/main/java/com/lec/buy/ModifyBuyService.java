package com.lec.buy;

import java.sql.Connection;

import com.lec.db.JDBCUtil;

public class ModifyBuyService {

	public boolean isModifySuccess(BuyVO buy) {
		Connection conn = JDBCUtil.getConnection();
		boolean isSuccess = false;
		System.out.println("update");
		BuyDAO dao = BuyDAO.getInstance();
		dao.setConnection(conn);
		isSuccess = dao.updateBuy(buy);
		JDBCUtil.close(conn, null, null);
 		return isSuccess;
	}

}
