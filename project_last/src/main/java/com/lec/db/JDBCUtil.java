package com.lec.db;

import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JDBCUtil {

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Context initContext = new InitialContext(); // 빈 context
			Context envContext = (Context) initContext.lookup("java:comp/env"); // 파일을 읽은 컨텍스트
			DataSource ds = (DataSource) envContext.lookup("jdbc/mariadb"); // 컨텍스트 파일을 ds 형식으로 불러온 파일
			conn = ds.getConnection();
			// conn.setAutoCommit(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	public static void rollback(Connection conn) {
		try { if(conn!=null) conn.rollback(); }catch (Exception e) {}
	}
	public static void commit(Connection conn) {
		try { if(conn!=null) conn.commit(); }catch (Exception e) {}
	}
}