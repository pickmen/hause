package com.lec.bom.service;

import java.sql.Connection;

import com.lec.bom.BomDAO;
import com.lec.bom.BomVO;
import com.lec.db.JDBCUtil;

public class InsertBOMService {

	public boolean insert(BomVO bom){
		boolean isSuccessInsert = false;
		Connection conn = JDBCUtil.getConnection();
		int count = 0;
		BomDAO dao = BomDAO.getInstance();
		dao.setConnection(conn);
		
		count = dao.insertBOM(bom);
		if(count>0) {
			isSuccessInsert = true;
			try{conn.commit();} catch (Exception e) {}
		} else {
			try{conn.rollback();} catch (Exception e) {}
		}
		
		JDBCUtil.close(conn, null, null);
		return isSuccessInsert;
	}

}
