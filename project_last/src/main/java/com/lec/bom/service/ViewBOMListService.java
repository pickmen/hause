package com.lec.bom.service;

import java.sql.Connection;
import java.util.List;

import com.lec.bom.BomDAO;
import com.lec.bom.BomVO;
import com.lec.db.JDBCUtil;

public class ViewBOMListService {

	public List<BomVO> getBOMList() {
		List<BomVO> bomlist = null;
		Connection conn = JDBCUtil.getConnection();
		BomDAO dao = BomDAO.getInstance();
		dao.setConnection(conn);
		bomlist = dao.getBOMList();
		JDBCUtil.close(conn, null, null);
		return bomlist;
	}
	
}
