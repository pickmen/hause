package com.lec.work.service;

import java.sql.Connection;
import java.util.List;

import com.lec.db.JDBCUtil;
import com.lec.work.WorkDAO;
import com.lec.work.WorkVO;

public class ViewWorkService {

	public List<WorkVO> getWorkList() {
		List<WorkVO> worklist = null;
		
		Connection conn = JDBCUtil.getConnection();
		WorkDAO dao = WorkDAO.getInstance();
		dao.setConnection(conn);
		
		worklist = dao.selectList();
		
		JDBCUtil.close(conn, null, null);
		
		return worklist;
	}

}