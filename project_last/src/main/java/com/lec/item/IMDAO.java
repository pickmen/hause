package com.lec.item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lec.db.JDBCUtil;

public class IMDAO {
	
	private static IMDAO instance = new IMDAO();
	private IMDAO() {}
	
	
	private Connection conn = null;
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	public static IMDAO getInstance() {
		return instance;
	}
	public boolean insertIM(IMVO item) {
		boolean isSuccessInsert = false;
		
		PreparedStatement pstmt = null;
		
		String sql = "insert into item_master values(?,?,?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, item.getItem_code());
			pstmt.setString(2, item.getItem_name());
			pstmt.setInt(3, item.getItem_cost());
			pstmt.setInt(4, item.getItem_price());
			pstmt.setString(5, item.getItem_type());
			pstmt.setString(6, item.getItem_comment());
			int count = pstmt.executeUpdate();
			if(count>0) {
				isSuccessInsert = true;
			}
		} catch (Exception e) {
			System.out.println("insert error");
		} finally {
			JDBCUtil.close(null, pstmt, null);
		}
		return isSuccessInsert;
	}
	public List<IMVO> getItemList() {
		List<IMVO> itemlist = new ArrayList<IMVO>();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = "select * from item_master";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				do {
					IMVO item = new IMVO(rs.getString("item_code"),rs.getString("item_name"),rs.getInt("item_cost"),rs.getInt("item_price"),rs.getString("item_type"),rs.getString("item_comment"));
					itemlist.add(item);
				} while (rs.next());
			}
		} catch (Exception e) {
			System.out.println("select error");
		} finally {
			JDBCUtil.close(null, pstmt, rs);
		}
		return itemlist;
	}
	public ArrayList<IMVO> getItemList(int page, int limit) {
		ArrayList<IMVO> itemlist = new ArrayList<IMVO>();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		String sql = "select * from item_master"+ " limit ?, " + limit;
		int startRow = (page - 1) * limit;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				do {
					IMVO item = new IMVO(rs.getString("item_code"),rs.getString("item_name"),rs.getInt("item_cost"),rs.getInt("item_price"),rs.getString("item_type"),rs.getString("item_comment"));
					itemlist.add(item);
				} while (rs.next());
			}
		} catch (Exception e) {
			System.out.println("select error");
		} finally {
			JDBCUtil.close(null, pstmt, rs);
		}
		return  itemlist;
	}
	public IMVO getItembyCode(String item_code) {
		IMVO item = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = "select * from item_master where item_code=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, item_code);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				item = new IMVO(rs.getString("item_code"),rs.getString("item_name"),rs.getInt("item_cost"),rs.getInt("item_price"),rs.getString("item_type"),rs.getString("item_comment"));
			}
		} catch (Exception e) {
			System.out.println("select error");
		} finally {
			JDBCUtil.close(null, pstmt, rs);
		}
		return item;
	}
	public boolean updateItem(IMVO item) {
		PreparedStatement pstmt = null;
		String sql = "update item_master set item_name=?, item_cost=?, item_price=?, item_type=?, item_comment=? where item_code=?";
		boolean isSuccess = false;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, item.getItem_name());
			pstmt.setInt(2, item.getItem_cost());
			pstmt.setInt(3, item.getItem_price());
			pstmt.setString(4, item.getItem_type());
			pstmt.setString(5, item.getItem_comment());
			pstmt.setString(6, item.getItem_code());
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
	public int deleteItem(String item_code) {
		PreparedStatement pstmt = null;
		String sql = "delete from item_master where item_code=?";
		int count = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, item_code);
			count = pstmt.executeUpdate();
		
		} catch (Exception e) {
			System.out.println("delete error");
		} finally {
			JDBCUtil.close(null, pstmt, null);
		}
		return count;
	}
	
	public int selectListCount() {
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select count(*) from item_master";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) listCount = rs.getInt(1);
		} catch (Exception e) {
			System.out.println("목록 갯수 가져오기 실패!!" + e.getMessage());
		} finally {
			JDBCUtil.close(null, pstmt, rs);
		}		
		return listCount; 
		
		
	}
}
