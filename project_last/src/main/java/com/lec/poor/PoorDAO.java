package com.lec.poor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lec.db.JDBCUtil;

public class PoorDAO {
	// 싱글톤
	private static PoorDAO instance = new PoorDAO();
	
	private PoorDAO() {}
	
	public static PoorDAO getInstance() {
		return instance;
	}
	private Connection conn;
	public void setConnection(Connection conn) {
		this.conn = conn;
	}

	public int insertPoor(PoorVO poor) {
		int count = 0;
		PreparedStatement pstmt = null;
		String sql = "insert into poor values(?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, poor.getPro_code());
			pstmt.setString(2, poor.getItem_code());
			pstmt.setString(3, poor.getPoor_count());
			pstmt.setString(4, poor.getBool_poor());
			count = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(null, pstmt, null);
		}
		return count;
	}

	public List<PoorVO> selectList() {
		List<PoorVO> poorlist = new ArrayList<PoorVO>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from poor";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				do {
					PoorVO poor = new PoorVO(rs.getString("pro_code"),rs.getString("item_code"), rs.getString("poor_count"), rs.getString("bool_poor"));
					poorlist.add(poor);
				} while (rs.next());
			}
		} catch (Exception e) {
			System.out.println("셀렉트 에러발생");
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(null, pstmt, rs);
		}
		return poorlist;
	}
	public PoorVO getProbyCode(String pro_code) {
		PoorVO poor = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = "select * from poor where pro_code=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pro_code);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				poor = new PoorVO(rs.getString("pro_code"),rs.getString("item_code"),rs.getString("poor_count"),rs.getString("bool_poor"));
			}
		} catch (Exception e) {
			System.out.println("select error");
		} finally {
			JDBCUtil.close(null, pstmt, rs);
		}
		return poor;
	}
	public boolean updatePoor(PoorVO poor) {
		PreparedStatement pstmt = null;
		String sql = "update poor set item_code=?, poor_count=?, bool_poor=? where pro_code=?";
		boolean isSuccess = false;
		int count = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, poor.getItem_code());
			pstmt.setString(2, poor.getPoor_count());
			pstmt.setString(3, poor.getBool_poor());
			pstmt.setString(4, poor.getPro_code());
			count = pstmt.executeUpdate();
			if (count > 0) {
				isSuccess = true;
			}
		} catch (Exception e) {
			System.out.println("update error");
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(null, pstmt, null);
		}
		return isSuccess;
	}
	public boolean deletePoor(String pro_code) {
		PreparedStatement pstmt = null;
		String sql = "delete from poor where pro_code=?";
		boolean isSuccess = false;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pro_code);
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
	
	
}
