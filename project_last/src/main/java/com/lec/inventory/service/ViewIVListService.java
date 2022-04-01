package com.lec.inventory.service;

import java.sql.Connection;
import java.util.List;

import com.lec.db.JDBCUtil;
import com.lec.inventory.IVDAO;
import com.lec.inventory.IVVO;

public class ViewIVListService {

	public List<IVVO> getIVList() {
		List<IVVO> IVlist = null;
		Connection conn = JDBCUtil.getConnection();
		IVDAO dao = IVDAO.getInstance();
		dao.setConnection(conn);
		IVlist = dao.getIVList();
		JDBCUtil.close(conn, null, null);
		return IVlist;
	}

	public List<IVVO> getIVList_Search(String search_type, String search_text) {
		List<IVVO> IVlist = null;
		Connection conn = JDBCUtil.getConnection();
		IVDAO dao = IVDAO.getInstance();
		dao.setConnection(conn);
		IVlist = dao.getIVList_Search(search_type, search_text);
		JDBCUtil.close(conn, null, null);
		return IVlist;
	}

}
