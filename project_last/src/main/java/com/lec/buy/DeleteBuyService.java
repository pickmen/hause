package com.lec.buy;

import java.sql.Connection;

import com.lec.db.JDBCUtil;

public class DeleteBuyService {

	public boolean isDeleteBuy(String buy_code) {
		boolean isDeleteBuy = false;
		
		Connection conn = JDBCUtil.getConnection();
		BuyDAO dao = BuyDAO.getInstance();
		dao.setConnection(conn);
		isDeleteBuy = dao.deleteBuy(buy_code);
		JDBCUtil.close(conn, null, null);
		
		return isDeleteBuy;
	}

}
