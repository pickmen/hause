package com.lec.buy;

import java.sql.Connection;

import com.lec.db.JDBCUtil;

public class RegBuyService {

	public boolean insertBuy(BuyVO buy) {
		boolean isSuccessInsert = false;
		Connection conn = JDBCUtil.getConnection();
		BuyDAO dao = BuyDAO.getInstance();
		dao.setConnection(conn);
		isSuccessInsert = dao.insertBuy(buy);
		JDBCUtil.close(conn, null, null);
		return isSuccessInsert;
	}
}
