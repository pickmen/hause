package com.lec.work;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lec.db.JDBCUtil;


public class WorkDAO {
	// 싱글톤
	private static WorkDAO instance = new WorkDAO();
	
	private WorkDAO() {}
	private ResultSet rs;
	public static WorkDAO getInstance() {
		return instance;
	}
	private Connection conn;
	public void setConnection(Connection conn) {
		this.conn = conn;
	}

	public int insertWork(WorkVO work) {
		int count = 0;
		PreparedStatement pstmt = null;
		String sql = "insert into work values(?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, work.getWork_code());
			pstmt.setString(2, work.getItem_code());
			pstmt.setString(3, work.getItem_name());
			pstmt.setString(4, work.getWork_count());
			pstmt.setString(5, work.getWork_time());
			count = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(null, pstmt, null);
		}
		return count;
	}

	public List<WorkVO> selectList() {
		List<WorkVO> worklist = new ArrayList<WorkVO>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from work";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				do {
					WorkVO work = new WorkVO(rs.getString("work_code"),rs.getString("item_code"), rs.getString("item_name"), rs.getString("work_count"),rs.getString("work_time"));
					worklist.add(work);
				} while (rs.next());
			}
		} catch (Exception e) {
			System.out.println("셀렉트 에러발생");
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(null, pstmt, rs);
		}
		return worklist;
	}
	public WorkVO getProbyCode(String work_code) {
		WorkVO work = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = "select * from work where work_code=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, work_code);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				work = new WorkVO(rs.getString("work_code"),rs.getString("item_code"),rs.getString("item_name"),rs.getString("work_count"),rs.getString("work_time"));
			}
		} catch (Exception e) {
			System.out.println("select error");
		} finally {
			JDBCUtil.close(null, pstmt, rs);
		}
		return work;
	}
	public boolean updateWork(WorkVO work) {
		PreparedStatement pstmt = null;
		String sql = "update work set item_code=?, item_name=?, work_count=?, work_time=? where work_code=?";
		boolean isSuccess = false;
		int count = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, work.getItem_code());
			pstmt.setString(2, work.getItem_name());
			pstmt.setString(3, work.getWork_count());
			pstmt.setString(4, work.getWork_time());
			pstmt.setString(5, work.getWork_code());
			count = pstmt.executeUpdate();
			System.out.println(count);
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
	public boolean deleteWork(String work_code) {
		PreparedStatement pstmt = null;
		String sql = "delete from work where work_code=?";
		boolean isSuccess = false;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, work_code);
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
	public List<WorkVO> selectAll(int page){
        //1번 페이지 1~10
        //2번 페이지 11~20        
		PreparedStatement pstmt = null;
        int startNum = (page-1)*10+1;
        int endNum = page*10;
        String sql = "SELECT * FROM ("
                + "SELECT * FROM ("
                + "SELECT ROWNUM as row_num, work.* FROM work"
                + ") WHERE row_num >= ?"
                + ") WHERE row_num <= ?";
        List<WorkVO> list = new ArrayList<WorkVO>();
        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, startNum);
            pstmt.setInt(2, endNum);
            rs = pstmt.executeQuery();
            while(rs.next()){
            	WorkVO work = new WorkVO(rs.getString("work_code"),rs.getString("item_code"),rs.getString("item_name"),rs.getString("work_count"),rs.getString("work_time"));
            	work.setWork_code(rs.getString("work_code"));
	            work.setItem_code(rs.getString("item_code"));
	            work.setItem_name(rs.getString("item_name"));
	            work.setWork_count(rs.getString("work_count"));
	            work.setWork_time(rs.getString("work_time"));
	            list.add(work);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            JDBCUtil.close(null, pstmt, rs);
        }
        return list;
    }
	
}