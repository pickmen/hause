package com.lec.item;

import java.sql.Connection;

import com.lec.db.JDBCUtil;

public class DeleteItemService {

	public boolean isDeleteItem(String item_code) {
		boolean isDeleteItem = false;
		Connection conn = JDBCUtil.getConnection();
		IMDAO dao = IMDAO.getInstance();
		dao.setConnection(conn);
		int count = dao.deleteItem(item_code);
		if(count > 0) {
			isDeleteItem = true;
			try {conn.commit();} catch (Exception e) {}
		} else {
			try {conn.rollback();} catch (Exception e) {}
		}
		return isDeleteItem;
	}

}
