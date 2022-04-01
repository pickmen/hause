package com.lec.ware;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lec.db.JDBCUtil;

public class WareDAO {
	
	private static WareDAO instance = new WareDAO();
	
	private WareDAO() {}
	
	private Connection conn;

	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	public static WareDAO getInstance() {
		return instance;
	}


	public boolean insertWare(WareVO ware) {
		boolean isSuccessInsert = false;
		PreparedStatement pstmt = null;
		String sql = "insert into ware values(?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ware.getWare_code());
			pstmt.setString(2, ware.getWare_name());
			pstmt.setString(3, ware.getWare_type());
			pstmt.setString(4, ware.getPro_code());
			pstmt.setString(5, ware.getAccount_code());
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

	public List<WareVO> getWareList() {
		List<WareVO> warelist = new ArrayList<WareVO>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from ware";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				do {
					WareVO ware = new WareVO(rs.getString("ware_code"), rs.getString("ware_name"), rs.getString("ware_type"), rs.getString("pro_code"), rs.getString("account_code"));
					warelist.add(ware);
				} while (rs.next());
			}
		} catch (Exception e) {
			System.out.println("셀렉트 에러발생");
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(null, pstmt, rs);
		}
		return warelist;
	}
	
	public WareVO getWarebyCode(String ware_code) {
		WareVO ware = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = "select * from ware where ware_code=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ware_code);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				ware = new WareVO(rs.getString("ware_code"),rs.getString("ware_name"),rs.getString("ware_type"),rs.getString("pro_code"),rs.getString("account_code"));
			}
		} catch (Exception e) {
			System.out.println("select error");
		} finally {
			JDBCUtil.close(null, pstmt, rs);
		}
		return ware;
		
	}
	
	public boolean updateWare(WareVO ware) {
		PreparedStatement pstmt = null;
		String sql = "update ware set ware_name=?, ware_type=?, pro_code=?, account_code=? where ware_code=?";
		boolean isSuccess = false;
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, ware.getWare_name());
			pstmt.setString(2, ware.getWare_type());
			pstmt.setString(3, ware.getPro_code());
			pstmt.setString(4, ware.getAccount_code());
			pstmt.setString(5, ware.getWare_code());
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
	
	public int deleteWare(String ware_code) {
		PreparedStatement pstmt = null;
		String sql = "delete from ware where ware_code=?";
		int count = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ware_code);
			count = pstmt.executeUpdate();
		
		} catch (Exception e) {
			System.out.println("delete error");
		} finally {
			JDBCUtil.close(null, pstmt, null);
		}
		return count;
	}
}
