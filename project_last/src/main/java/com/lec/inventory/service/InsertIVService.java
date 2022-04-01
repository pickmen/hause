package com.lec.inventory.service;

import java.sql.Connection;
import com.lec.db.JDBCUtil;
import com.lec.inventory.IVDAO;
import com.lec.inventory.IVVO;

public class InsertIVService {

	public boolean insert(IVVO IV) {
		boolean isSuccessInsert = false;
		Connection conn = JDBCUtil.getConnection();
		int count = 0;
		IVDAO dao = IVDAO.getInstance();
		dao.setConnection(conn);
		
		count = dao.insertIV(IV);
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
