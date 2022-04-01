package com.lec.item;

import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.action.Action;
import com.lec.action.ActionForward;
import com.lec.db.JDBCUtil;

public class ModifyPageItemAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String item_code = req.getParameter("item_code");
		ActionForward forward = null;
		
		Connection conn = JDBCUtil.getConnection();
		IMDAO dao = IMDAO.getInstance();
		dao.setConnection(conn);
		IMVO item = dao.getItembyCode(item_code);
		JDBCUtil.close(conn, null, null);
		if(item != null) {
			req.setAttribute("item", item);
			forward = new ActionForward();
			forward.setNextPath("/item/modifyItemPage.jsp");
		} else {
			res.setContentType("text/html;charset=UTF-8");
			PrintWriter writer = res.getWriter();
			writer.println("<script> alert('불러오기실패'); history.go(-1);</script>");
		}
		
		
		return forward;
	}

}
