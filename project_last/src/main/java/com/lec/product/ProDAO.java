package com.lec.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lec.db.JDBCUtil;

public class ProDAO {
	// �떛湲��넠
	private static ProDAO instance = new ProDAO();
	
	private ProDAO() {}
	
	public static ProDAO getInstance() {
		return instance;
	}
	private Connection conn;
	public void setConnection(Connection conn) {
		this.conn = conn;
	}

	public int insertPro(ProVO pro) {
		int count = 0;
		PreparedStatement pstmt = null;
		String sql = "insert into product values(?,?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pro.getPro_code());
			pstmt.setString(2, pro.getItem_code());
			pstmt.setString(3, pro.getItem_name());
			pstmt.setString(4, pro.getPro_count());
			pstmt.setString(5, pro.getComplete());
			pstmt.setString(6, pro.getOutware_code());
			pstmt.setString(7, pro.getInware_code());
			count = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(null, pstmt, null);
		}
		return count;
	}

	public List<ProVO> selectList() {
		List<ProVO> prolist = new ArrayList<ProVO>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from product";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				do {
					ProVO pro = new ProVO(rs.getString("pro_code"),rs.getString("item_code"), rs.getString("item_name"), rs.getString("pro_count"),rs.getString("complete"),rs.getString("outware_code"),rs.getString("inware_code"));
					prolist.add(pro);
				} while (rs.next());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(null, pstmt, rs);
		}
		return prolist;
	}
	public ProVO getProbyCode(String pro_code) {
		ProVO pro = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = "select * from product where pro_code=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pro_code);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				pro = new ProVO(rs.getString("pro_code"),rs.getString("item_code"),rs.getString("item_name"),rs.getString("pro_count"),rs.getString("complete"),rs.getString("outware_code"),rs.getString("inware_code"));
			}
		} catch (Exception e) {
			System.out.println("select error");
		} finally {
			JDBCUtil.close(null, pstmt, rs);
		}
		return pro;
	}
	public boolean updatePro(ProVO pro) {
		PreparedStatement pstmt = null;
		String sql = "update product set item_code=?, item_name=?, pro_count=?, complete=?, outware_code=?,inware_code=? where pro_code=?";
		boolean isSuccess = false;
		int count = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pro.getItem_code());
			pstmt.setString(2, pro.getItem_name());
			pstmt.setString(3, pro.getPro_count());
			pstmt.setString(4, pro.getComplete());
			pstmt.setString(5, pro.getOutware_code());
			pstmt.setString(6, pro.getInware_code());
			pstmt.setString(7, pro.getPro_code());
			count = pstmt.executeUpdate();
			System.out.println("count " + count);
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
	public boolean deletePro(String pro_code) {
		PreparedStatement pstmt = null;
		String sql = "delete from product where pro_code=?";
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