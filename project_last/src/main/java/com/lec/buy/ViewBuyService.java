package com.lec.buy;

import java.sql.Connection;
import java.util.List;

import com.lec.buy.BuyDAO;
import com.lec.db.JDBCUtil;
import com.lec.web.PageInfo;
import com.lec.buy.BuyVO;

public class ViewBuyService {

	public List<BuyVO> getBuyList(){
		List<BuyVO> buylist = null;
		Connection conn = JDBCUtil.getConnection();
		BuyDAO dao = BuyDAO.getInstance();
		dao.setConnection(conn);
		buylist = dao.getBuyList();
		JDBCUtil.close(conn, null, null);
		return buylist;
	}
	
	public List<BuyVO> getBuyList_Search(String search_type, String search_text) {
		List<BuyVO> buylist = null;
		Connection conn = JDBCUtil.getConnection();
		BuyDAO dao = BuyDAO.getInstance();
		dao.setConnection(conn);
		buylist = dao.getBuyList_Search(search_type, search_text);
		JDBCUtil.close(conn, null, null);
		return buylist;
	}
	public PageInfo getPaging(int page) {
		PageInfo paging = null;
		Connection conn = JDBCUtil.getConnection();
		BuyDAO dao = BuyDAO.getInstance();
		dao.setConnection(conn);
		paging = dao.getPaging(page);
		JDBCUtil.close(conn, null, null);
		return paging;
	}

	public PageInfo getPaging_search(int page, String search_type, String search_text) {
		PageInfo paging = null;
		Connection conn = JDBCUtil.getConnection();
		BuyDAO dao = BuyDAO.getInstance();
		dao.setConnection(conn);
		paging = dao.getPaging_search(page,search_type,search_text);
		JDBCUtil.close(conn, null, null);
		return paging;
	}
}
