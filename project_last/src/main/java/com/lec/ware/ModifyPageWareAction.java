package com.lec.ware;


import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.action.Action;
import com.lec.action.ActionForward;
import com.lec.db.JDBCUtil;


public class ModifyPageWareAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String ware_code = req.getParameter("ware_code");
		ActionForward forward = null;
		
		Connection conn = JDBCUtil.getConnection();
		WareDAO dao = WareDAO.getInstance();
		dao.setConnection(conn);
		WareVO ware = dao.getWarebyCode(ware_code);
		JDBCUtil.close(conn, null, null);
		if(ware != null) {
			req.setAttribute("ware", ware);
			forward = new ActionForward();
			forward.setNextPath("/warehouse/modifyWarePage.jsp");
		} else {
			res.setContentType("text/html;charset=UTF-8");
			PrintWriter writer = res.getWriter();
			writer.println("<script> alert('불러오기실패'); history.go(-1);</script>");
		}
		
		
		return forward;
	}
	

}
