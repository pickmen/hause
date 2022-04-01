package com.lec.account;

import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.action.Action;
import com.lec.action.ActionForward;
import com.lec.db.JDBCUtil;

public class ModifyPageAccountAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String account_code = req.getParameter("account_code");
		ActionForward forward = null;
		
		Connection conn = JDBCUtil.getConnection();
		ACDAO dao = ACDAO.getInstance();
		dao.setConnection(conn);
		ACVO account = dao.getAccountbyCode(account_code);
		JDBCUtil.close(conn, null, null);
		if(account != null) {
			req.setAttribute("account", account);
			
			forward = new ActionForward();
			forward.setNextPath("/account/modifyAccountpage.jsp");
		} else {
			res.setContentType("text/html;charset=UTF-8");
			PrintWriter writer = res.getWriter();
			writer.println("<script> alert('불러오기실패'); history.go(-1);</script>");
		}
		
		System.out.println(forward.getNextPath());
		return forward;
	}

}
