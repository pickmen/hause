package com.lec.ware;


import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.action.Action;
import com.lec.action.ActionForward;

public class DeleteWareAction implements Action{
	
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ActionForward forward = null;
		
		String Ware_code = req.getParameter("ware_code");
		DeleteWareService deleteWareService = new DeleteWareService();
		boolean is_success = deleteWareService.isDeleteWare(Ware_code);
	
		if (is_success) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setNextPath("/listWare.do");
		} else {
			res.setContentType("text/html;charset=UTF-8");
			PrintWriter writer = res.getWriter();
			writer.println("<script> alert('삭제실패'); history.go(-1);</script>");
		}
		
		return forward;
	}

}
