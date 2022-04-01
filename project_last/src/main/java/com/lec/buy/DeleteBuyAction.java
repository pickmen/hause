package com.lec.buy;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.action.Action;
import com.lec.action.ActionForward;

public class DeleteBuyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ActionForward forward = null;
		String buy_code = req.getParameter("buy_code");
		
		DeleteBuyService deleteBuyService = new DeleteBuyService();
		boolean is_success = false;
		is_success = deleteBuyService.isDeleteBuy(buy_code);
		if (is_success) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setNextPath("/viewBuy.do");
		} else {
			res.setContentType("text/html;charset=UTF-8");
			PrintWriter writer = res.getWriter();
			writer.println("<script> alert('삭제실패'); history.go(-1);</script>");
		}
		
		return forward;
	}

}
