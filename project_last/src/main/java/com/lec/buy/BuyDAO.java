package com.lec.buy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lec.db.JDBCUtil;
import com.lec.web.PageInfo;


public class BuyDAO {

	private static BuyDAO instance = new BuyDAO();
	private BuyDAO() {}
	
	private Connection conn = null;
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	public static BuyDAO getInstance() {
		return instance;
		
	}
	public boolean insertBuy(BuyVO buy) {
		boolean isSuccessInsert = false;
		
		PreparedStatement pstmt = null;
		
		String sql = "insert into buy values(?,?,?,?,?,?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, buy.getBuy_code());
			pstmt.setString(2, buy.getAccount_code());
			pstmt.setString(3, buy.getItem_code());
			pstmt.setString(4, buy.getItem_name());
			pstmt.setString(5, buy.getBuy_date());
			pstmt.setInt(6, buy.getBuy_cnt());
			pstmt.setDouble(7, buy.getBuy_cost());
			pstmt.setDouble(8, buy.getBuy_price());
			pstmt.setString(9, buy.getWare_code());
			int count = pstmt.executeUpdate();

			if(count>0) {
				isSuccessInsert = true;
			}

		}catch(Exception e) {
			System.out.println("insert 에러");
		}finally {
			JDBCUtil.close(null, pstmt, null);
		}
		return isSuccessInsert;
		
	}
	public List<BuyVO> getBuyList() {
		List<BuyVO> buylist = new ArrayList<BuyVO>();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = "select * from buy";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				do {
					BuyVO buy = new BuyVO(rs.getString("buy_code"),rs.getString("account_code"),rs.getString("item_code"), rs.getString("item_name"),rs.getString("buy_date"), rs.getInt("buy_cnt"),rs.getDouble("buy_cost"),rs.getDouble("buy_price"),rs.getString("ware_code"));
					buylist.add(buy);
				} while (rs.next());
			}
		} catch (Exception e) {
			System.out.println("select error");
		} finally {
			JDBCUtil.close(null, pstmt, rs);
		}
		return buylist;
	}
	public boolean deleteBuy(String buy_code) {
		PreparedStatement pstmt = null;
		String sql = "delete from buy where buy_code=?";
		boolean isSuccess = false;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, buy_code);
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
	public BuyVO getBuybyCode(String buy_code) {
		BuyVO buy = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = "select * from buy where buy_code=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, buy_code);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				buy = new BuyVO(rs.getString("buy_code"),rs.getString("account_code"),rs.getString("item_code"), rs.getString("item_name"),rs.getString("buy_date"), rs.getInt("buy_cnt"),rs.getDouble("buy_cost"),rs.getDouble("buy_price"),rs.getString("ware_code"));
			}
		} catch (Exception e) {
			System.out.println("select error");
		} finally {
			JDBCUtil.close(null, pstmt, rs);
		}
		return buy;
	}
	public boolean updateBuy(BuyVO buy) {
		PreparedStatement pstmt = null;
		String sql = "update buy set account_code=?, item_code=? , item_name=?, buy_date=?, buy_cnt=?, buy_cost=?, buy_price=?, ware_code=? where buy_code = ?";
		boolean isSuccess = false;
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, buy.getAccount_code());
			pstmt.setString(2, buy.getItem_code());
			pstmt.setString(3, buy.getItem_name());
			pstmt.setString(4, buy.getBuy_date());
			pstmt.setInt(5, buy.getBuy_cnt());
			pstmt.setDouble(6, buy.getBuy_cost());
			pstmt.setDouble(7, buy.getBuy_price());
			pstmt.setString(8, buy.getWare_code());
			pstmt.setString(9, buy.getBuy_code());
			int count = pstmt.executeUpdate();
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
	public List<BuyVO> getBuyList_Search(String search_type, String search_text){
		List<BuyVO> buylist = new ArrayList<BuyVO>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from buy where " +search_type+" like '%" + search_text + "%'" ;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				do {
					BuyVO buy = new BuyVO(rs.getString("buy_code"),rs.getString("account_code"),rs.getString("item_code"), rs.getString("item_name"),rs.getString("buy_date"), rs.getInt("buy_cnt"),rs.getDouble("buy_cost"),rs.getDouble("buy_price"),rs.getString("ware_code"));
					buylist.add(buy);
				} while(rs.next());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			JDBCUtil.close(null, pstmt, rs);
		}
		return buylist;
	}
	public PageInfo getPaging(int page) {
		PageInfo paging = new PageInfo();
		int tot = totalCount(paging);
		paging.setTotalCount(tot);
		paging.setTotalPage((int)Math.ceil((double)tot/paging.getPageCount()));
		paging.setPageInfo(page);
		return paging;
	}
	public PageInfo getPaging_search(int page, String search_type, String search_text) {
		PageInfo paging = new PageInfo();
		int tot = totalCount_search(paging,search_type,search_text);
	      paging.setTotalCount(tot);
	      paging.setTotalPage((int) Math.ceil((double)tot / paging.getPageCount()));
	      paging.setPageInfo(page);
	      return paging;

	}
	
	private int totalCount_search(PageInfo paging, String search_type, String search_text) {
		int tot = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select count(*) from buy"+ " where " +search_type+" like '%" + search_text + "%'";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				tot = rs.getInt(1);
			}
			if(tot==0) {
				tot = 1;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(null, pstmt, rs);
		}
		return tot;
	}
	public int totalCount(PageInfo paging) {
		int tot = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select count(*) from buy";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				tot = rs.getInt(1);
			}
			if(tot==0) {
				tot = 1;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(null, pstmt, rs);
		}
		return tot;
	}
	
	
	
	
	
	
	
}
