package com.lec.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lec.db.JDBCUtil;
import com.lec.web.PageInfo;


public class OrderDAO {

	private static OrderDAO instance = new OrderDAO();
	private OrderDAO() {}
	
	private Connection conn = null;
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	public static OrderDAO getInstance() {
		return instance;
		
	}
	public boolean insertOrder(OrderVO order) {
		boolean isSuccessInsert = false;
		
		PreparedStatement pstmt = null;
		
		String sql = "insert into order2 values(?,?,?,?,?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, order.getOrder_code());
			pstmt.setString(2, order.getAccount_code());
			pstmt.setString(3, order.getItem_code());
			pstmt.setString(4, order.getItem_name());
			pstmt.setString(5, order.getOrder_date());
			pstmt.setInt(6, order.getOrder_cnt());
			pstmt.setDouble(7, order.getOrder_cost());
			pstmt.setDouble(8, order.getOrder_price());
			int count = pstmt.executeUpdate();
			
			if(count>0) {
				isSuccessInsert = true;
			}

		}catch(Exception e) {
			System.out.println("insert 에러");
		}finally {
			JDBCUtil.close(null, pstmt, null);
		}
		return isSuccessInsert;
		
	}
	public List<OrderVO> getOrderList() {
		List<OrderVO> orderlist = new ArrayList<OrderVO>();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = "select * from order2";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				do {
					OrderVO order = new OrderVO(rs.getString("order_code"),rs.getString("account_code"),rs.getString("item_code"), rs.getString("item_name"),rs.getString("order_date"), rs.getInt("order_cnt"),rs.getDouble("order_cost"),rs.getDouble("order_price"));
					orderlist.add(order);
				} while (rs.next());
			}
		} catch (Exception e) {
			System.out.println("select error");
		} finally {
			JDBCUtil.close(null, pstmt, rs);
		}
		return orderlist;
	}
	public boolean deleteOrder(String order_code) {
		PreparedStatement pstmt = null;
		String sql = "delete from order2 where order_code=?";
		boolean isSuccess = false;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, order_code);
			int count = pstmt.executeUpdate();
			if (count>0) {
				isSuccess = true;
			}
		} catch (Exception e) {
			System.out.println("delete error");
		} finally {
			JDBCUtil.close(null, pstmt, null);
		}
		return isSuccess;
}
	public OrderVO getOrderbyCode(String order_code) {
		OrderVO order = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = "select * from order2 where order_code=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, order_code);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				order = new OrderVO(rs.getString("order_code"),rs.getString("account_code"),rs.getString("item_code"), rs.getString("item_name"),rs.getString("order_date"), rs.getInt("order_cnt"),rs.getDouble("order_cost"),rs.getDouble("order_price"));
			}
		} catch (Exception e) {
			System.out.println("select error");
		} finally {
			JDBCUtil.close(null, pstmt, rs);
		}
		return order;
	}
	public boolean updateOrder(OrderVO order) {
		PreparedStatement pstmt = null;
		String sql = "update order2 set account_code=?, item_code=? , item_name=?, order_date=?, order_cnt=?, order_cost=?, order_price=? where order_code = ?";
		boolean isSuccess = false;
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, order.getAccount_code());
			pstmt.setString(2, order.getItem_code());
			pstmt.setString(3, order.getItem_name());
			pstmt.setString(4, order.getOrder_date());
			pstmt.setInt(5, order.getOrder_cnt());
			pstmt.setDouble(6, order.getOrder_cost());
			pstmt.setDouble(7, order.getOrder_price());
			pstmt.setString(8, order.getOrder_code());
			int count = pstmt.executeUpdate();
			if (count > 0) {
				isSuccess = true;
			}
		} catch (Exception e) {
			System.out.println("update error");
		} finally {
			JDBCUtil.close(null, pstmt, null);
		}
		return isSuccess;
	}
	
	public List<OrderVO> getOrderList_Search(String search_type, String search_text){
		List<OrderVO> orderlist = new ArrayList<OrderVO>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from order2 where " +search_type+" like '%" + search_text + "%'" ;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				do {
					OrderVO order = new OrderVO(rs.getString("order_code"),rs.getString("account_code"),rs.getString("item_code"), rs.getString("item_name"),rs.getString("order_date"), rs.getInt("order_cnt"),rs.getDouble("order_cost"),rs.getDouble("order_price"));
					orderlist.add(order);
				} while(rs.next());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			JDBCUtil.close(null, pstmt, rs);
		}
		return orderlist;
	}
	public PageInfo getPaging(int page) {
		PageInfo paging = new PageInfo();
		int tot = totalCount(paging);
		paging.setTotalCount(tot);
		paging.setTotalPage((int)Math.ceil((double)tot/paging.getPageCount()));
		paging.setPageInfo(page);
		return paging;
	}
	public PageInfo getPaging_search(int page, String search_type, String search_text) {
		PageInfo paging = new PageInfo();
		int tot = totalCount_search(paging,search_type,search_text);
	      paging.setTotalCount(tot);
	      paging.setTotalPage((int) Math.ceil((double)tot / paging.getPageCount()));
	      paging.setPageInfo(page);
	      return paging;

	}
	
	private int totalCount_search(PageInfo paging, String search_type, String search_text) {
		int tot = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select count(*) from order2"+ " where " +search_type+" like '%" + search_text + "%'";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				tot = rs.getInt(1);
			}
			if(tot==0) {
				tot = 1;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(null, pstmt, rs);
		}
		return tot;
	}
	public int totalCount(PageInfo paging) {
		int tot = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select count(*) from order2";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				tot = rs.getInt(1);
			}
			if(tot==0) {
				tot = 1;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(null, pstmt, rs);
		}
		return tot;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
