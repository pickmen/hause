package com.lec.item;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.lec.db.JDBCUtil;

public class ViewItemService {

	public List<IMVO> getItemList() {
		List<IMVO> itemlist = null;
		Connection conn = JDBCUtil.getConnection();
		IMDAO dao =IMDAO.getInstance();
		dao.setConnection(conn);
		itemlist = dao.getItemList();
		JDBCUtil.close(conn, null, null);
		return itemlist;
	}
	
	
	public ArrayList<IMVO> getItemList(int page, int limit) {
		ArrayList<IMVO> itemlist = null;
		Connection conn = JDBCUtil.getConnection();
		IMDAO dao =IMDAO.getInstance();
		dao.setConnection(conn);
		itemlist = dao.getItemList(page, limit);
		JDBCUtil.close(conn, null, null);
		return itemlist;
	}

	public static int getListCount() {
		int listCount = 0;
		Connection conn = JDBCUtil.getConnection();
		IMDAO dao = IMDAO.getInstance();
		dao.setConnection(conn);
		listCount = dao.selectListCount();
		JDBCUtil.close(conn, null, null); 	
		return listCount;
	}
}
