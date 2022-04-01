package com.lec.product.service;

import java.sql.Connection;
import java.util.List;

import com.lec.db.JDBCUtil;
import com.lec.product.ProDAO;
import com.lec.product.ProVO;

public class ViewProService {

	public List<ProVO> getProList() {
		List<ProVO> prolist = null;
		
		Connection conn = JDBCUtil.getConnection();
		ProDAO dao = ProDAO.getInstance();
		dao.setConnection(conn);
		
		prolist = dao.selectList();
		
		JDBCUtil.close(conn, null, null);
		
		return prolist;
	}

}
