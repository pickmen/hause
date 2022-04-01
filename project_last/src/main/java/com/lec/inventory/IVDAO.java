package com.lec.inventory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lec.db.JDBCUtil;

public class IVDAO {
	private static IVDAO instance = new IVDAO();
	private IVDAO() {}
	Connection conn = null;
	public static IVDAO getInstance() {
		return instance;
	}
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	public int insertIV(IVVO IV) {
		PreparedStatement pstmt = null;
		int count = 0;
		String sql = "insert into inventory values(?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, IV.getItem_code());
			pstmt.setString(2, IV.getItem_name());
			pstmt.setString(3, IV.getWare_code());
			pstmt.setInt(4, IV.getInven_cnt());
			count = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(null, pstmt, null);
		}
		return count;
	}
	public List<IVVO> getIVList() {
		List<IVVO> IVlist = new ArrayList<IVVO>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from inventory";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				do {
					IVVO IV = new IVVO(rs.getString("item_code"), rs.getString("item_name"), rs.getString("ware_code"),rs.getInt("inven_cnt"));
					IVlist.add(IV);
				} while(rs.next());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(null, pstmt, rs);
		}
		return IVlist;
	}
	public int deleteIV(IVVO IV) {
		PreparedStatement pstmt = null;
		int count = 0;
		String sql = "delete from inventory where item_code=? and item_name=? and ware_code=? and inven_cnt=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, IV.getItem_code());
			pstmt.setString(2, IV.getItem_name());
			pstmt.setString(3, IV.getWare_code());
			pstmt.setInt(4, IV.getInven_cnt());
			count = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(null, pstmt, null);
		}
		return count;
	}
	public int updateIV(IVVO IV) {
		PreparedStatement pstmt = null;
		int count = 0;
		String sql = "update inventory set item_name=?, ware_code=?, inven_cnt=? where item_code=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(4, IV.getItem_code());
			pstmt.setString(1, IV.getItem_name());
			pstmt.setString(2, IV.getWare_code());
			pstmt.setInt(3, IV.getInven_cnt());
			count = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(null, pstmt, null);
		}
		return count;
	}
	public List<IVVO> getIVList_Search(String search_type, String search_text) {
		List<IVVO> IVlist = new ArrayList<IVVO>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from inventory where "+search_type+" like '%" + search_text + "%'" ;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				do {
					IVVO IV = new IVVO(rs.getString("item_code"), rs.getString("item_name"), rs.getString("ware_code"),rs.getInt("inven_cnt"));
					IVlist.add(IV);
				} while(rs.next());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(null, pstmt, rs);
		}
		return IVlist;
	}
}
