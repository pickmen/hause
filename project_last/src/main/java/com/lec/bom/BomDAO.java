package com.lec.bom;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lec.db.JDBCUtil;

public class BomDAO {

	private static BomDAO instance = new BomDAO();
	private BomDAO() {}
	Connection conn = null;
	public static BomDAO getInstance() {
		return instance;
	}
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	public int insertBOM(BomVO bom) {
		PreparedStatement pstmt = null;
		int count = 0;
		String sql = "insert into bom values(?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bom.getItem_code());
			pstmt.setString(2, bom.getItem_name());
			pstmt.setInt(3, bom.getItem_cnt());
			pstmt.setString(4, bom.getPrt_item_code());
			count = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(null, pstmt, null);
		}
		return count;
	}
	public List<BomVO> getBOMList() {
		List<BomVO> bomlist = new ArrayList<BomVO>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from bom";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				do {
					BomVO bom = new BomVO(rs.getString("item_code"), rs.getString("item_name"), rs.getInt("item_cnt"), rs.getString("prt_item_code"));
					bomlist.add(bom);
				} while(rs.next());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(null, pstmt, rs);
		}
		return bomlist;
	}
	public int updateBOM(BomVO bom) {
		PreparedStatement pstmt = null;
		int count = 0;
		String sql = "update bom set item_name=?, item_cnt=?, prt_item_code=? where item_code=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(4, bom.getItem_code());
			pstmt.setString(1, bom.getItem_name());
			pstmt.setInt(2, bom.getItem_cnt());
			pstmt.setString(3, bom.getPrt_item_code());
			count = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(null, pstmt, null);
		}
		return count;
	}
	public int deleteBOM(String item_code) {
		int count = 0;
		PreparedStatement pstmt = null;
		String sql = "delete from bom where item_code=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, item_code);
			count = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(null, pstmt, null);
		}
		return count;
	}
	
}
