package com.lec.poor.service;

import java.sql.Connection;
import java.util.List;

import com.lec.db.JDBCUtil;
import com.lec.poor.PoorDAO;
import com.lec.poor.PoorVO;

public class ViewPoorService {

	public List<PoorVO> getPoorList() {
		List<PoorVO> poorlist = null;
		
		Connection conn = JDBCUtil.getConnection();
		PoorDAO dao = PoorDAO.getInstance();
		dao.setConnection(conn);
		
		poorlist = dao.selectList();
		
		JDBCUtil.close(conn, null, null);
		
		return poorlist;
	}

}
