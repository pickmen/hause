package com.lec.sales;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lec.db.JDBCUtil;

public class SalesDAO {
	private static SalesDAO instance = new SalesDAO();
	private SalesDAO() {}
	Connection conn = null;
	public static SalesDAO getInstance() {
		return instance;
	}
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	public int insertSales(SalesVO sales) {
		PreparedStatement pstmt = null;
		int count = 0;
		String sql = "insert into sales values(?,?,?,?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sales.getSale_code());
			pstmt.setString(2, sales.getAccount_code());
			pstmt.setString(3, sales.getItem_code());
			pstmt.setString(4, sales.getItem_name());
			pstmt.setString(5, sales.getSale_date());
			pstmt.setInt(6, sales.getSale_cnt());
			pstmt.setDouble(7, sales.getSale_price());
			pstmt.setDouble(8, sales.getSale_cost());
			pstmt.setString(9, sales.getWare_code());
			count = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(null, pstmt, null);
		}
		return count;
	}
	public List<SalesVO> getSalesList() {
		List<SalesVO> saleslist = new ArrayList<SalesVO>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from sales";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				do {
					SalesVO sales = new SalesVO(rs.getString("sale_code"), rs.getString("account_code"), rs.getString("item_code"),
							rs.getString("item_name"), rs.getString("sale_date"), rs.getInt("sale_cnt"), rs.getDouble("sale_price"),
							rs.getDouble("sale_cost"), rs.getString("ware_code"));
					saleslist.add(sales);
				} while(rs.next());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(null, pstmt, rs);
		}
		return saleslist;
	}
	public int deleteSales(String sale_code) {
		int count = 0;
		PreparedStatement pstmt = null;
		String sql = "delete from sales where sale_code=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sale_code);
			count = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(null, pstmt, null);
		}
		return count;
	}
	public int updateSales(SalesVO sales) {
		PreparedStatement pstmt = null;
		int count = 0;
		String sql = "update sales set account_code=?, item_code=?, item_name=?, sale_date=?, sale_cnt=?, sale_price=?, sale_cost=?, ware_code=? where sale_code=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sales.getAccount_code());
			pstmt.setString(2, sales.getItem_code());
			pstmt.setString(3, sales.getItem_name());
			pstmt.setString(4, sales.getSale_date());
			pstmt.setInt(5, sales.getSale_cnt());
			pstmt.setDouble(6, sales.getSale_price());
			pstmt.setDouble(7, sales.getSale_cost());
			pstmt.setString(8, sales.getWare_code());
			pstmt.setString(9, sales.getSale_code());
			count = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(null, pstmt, null);
		}
		return count;
	}
}
