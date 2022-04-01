package com.lec.sales.service;

import java.sql.Connection;
import java.util.List;

import com.lec.db.JDBCUtil;
import com.lec.sales.SalesDAO;
import com.lec.sales.SalesVO;

public class ViewSalesListService {

	public List<SalesVO> getSalesList() {
		List<SalesVO> saleslist = null;
		Connection conn = JDBCUtil.getConnection();
		SalesDAO dao = SalesDAO.getInstance();
		dao.setConnection(conn);
		saleslist = dao.getSalesList();
		JDBCUtil.close(conn, null, null);
		return saleslist;
	}

}
