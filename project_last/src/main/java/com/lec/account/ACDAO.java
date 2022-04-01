package com.lec.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lec.db.JDBCUtil;


public class ACDAO {

	private static ACDAO instance = new ACDAO();
	private ACDAO() {}
	
	private Connection conn = null;
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	public static ACDAO getInstance() {
		return instance;
		
	}
	public boolean insertAC(ACVO account) {
		boolean isSuccessInsert = false;
		
		PreparedStatement pstmt = null;
		
		String sql = "insert into account values(?,?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account.getAccount_code());
			pstmt.setString(2, account.getAccount_name());
			pstmt.setString(3, account.getAccount_ceo());
			pstmt.setString(4, account.getAccount_tell());
			pstmt.setString(5, account.getAccount_type());
			int count = pstmt.executeUpdate();
			if(count>0) {
				isSuccessInsert = true;
			}
		}catch(Exception e) {
			System.out.println("insert 에러"); System.out.println(e.getMessage());
		}finally {
			JDBCUtil.close(null, pstmt, null);
		}
		return isSuccessInsert;
		
	}
	public List<ACVO> getAccountList() {
		List<ACVO> accountlist = new ArrayList<ACVO>();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = "select * from account";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				do {
					ACVO account = new ACVO(rs.getString("account_code"),rs.getString("account_name"),rs.getString("account_ceo"),rs.getString("account_tell"),rs.getString("account_type"));
					accountlist.add(account);
				} while (rs.next());
			}
		} catch (Exception e) {
			System.out.println("select error");
		} finally {
			JDBCUtil.close(null, pstmt, rs);
		}
		return accountlist;
	}
	
	public int deleteAccount(String account_code) {
		PreparedStatement pstmt = null;
		String sql = "delete from account where account_code=?";
		int count = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account_code);
			count = pstmt.executeUpdate();
		
		} catch (Exception e) {
			System.out.println("delete error");
		} finally {
			JDBCUtil.close(null, pstmt, null);
		}
		return count;
}
	public ACVO getAccountbyCode(String account_code) {
		ACVO account = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = "select * from account where account_code=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account_code);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				account = new ACVO(rs.getString("account_code"),rs.getString("account_name"),rs.getString("account_ceo"),rs.getString("account_tell"),rs.getString("account_type"));
			}
		} catch (Exception e) {
			System.out.println("select error");
		} finally {
			JDBCUtil.close(null, pstmt, rs);
		}
		return account;
	}
	public boolean updateAccount(ACVO account) {
		PreparedStatement pstmt = null;
		String sql = "update account set  account_name=?, account_ceo=?, account_tell=?, account_type=? where account_code = ?";
		boolean isSuccess = false;
		try {
			pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setString(1, account.getAccount_name());
			pstmt.setString(2, account.getAccount_ceo());
			pstmt.setString(3, account.getAccount_tell());
			pstmt.setString(4, account.getAccount_type());
			pstmt.setString(5, account.getAccount_code());
			
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
}
