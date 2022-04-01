package com.lec.ware;

import java.sql.Connection;
import java.util.List;

import com.lec.db.JDBCUtil;

public class ViewWareService {

	public List<WareVO> getWareList() {
		List<WareVO> warelist = null;
		Connection conn = JDBCUtil.getConnection();
		WareDAO dao = WareDAO.getInstance();
		dao.setConnection(conn);
		warelist = dao.getWareList();
		JDBCUtil.close(conn, null, null);
		return warelist;
	}

}
