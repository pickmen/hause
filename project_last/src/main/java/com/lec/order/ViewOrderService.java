package com.lec.order;

import java.sql.Connection;
import java.util.List;

import com.lec.order.OrderDAO;
import com.lec.db.JDBCUtil;
import com.lec.web.PageInfo;
import com.lec.order.OrderVO;

public class ViewOrderService {

	public List<OrderVO> getOrderList(){
		List<OrderVO> orderlist = null;
		Connection conn = JDBCUtil.getConnection();
		OrderDAO dao = OrderDAO.getInstance();
		dao.setConnection(conn);
		orderlist = dao.getOrderList();
		JDBCUtil.close(conn, null, null);
		return orderlist;
	}
	
public List<OrderVO> getOrderList_Search(String search_type, String search_text){
	List<OrderVO> orderlist = null;
	Connection conn = JDBCUtil.getConnection();
	OrderDAO dao = OrderDAO.getInstance();
	dao.setConnection(conn);
	orderlist = dao.getOrderList_Search(search_type, search_text);
	JDBCUtil.close(conn, null, null);
	
	
	return orderlist;
	
}
public PageInfo getPaging(int page) {
	PageInfo paging = null;
	Connection conn = JDBCUtil.getConnection();
	OrderDAO dao = OrderDAO.getInstance();
	dao.setConnection(conn);
	paging = dao.getPaging(page);
	JDBCUtil.close(conn, null, null);
	return paging;
}

public PageInfo getPaging_search(int page, String search_type, String search_text) {
	PageInfo paging = null;
	Connection conn = JDBCUtil.getConnection();
	OrderDAO dao = OrderDAO.getInstance();
	dao.setConnection(conn);
	paging = dao.getPaging_search(page,search_type,search_text);
	JDBCUtil.close(conn, null, null);
	return paging;
}




}
