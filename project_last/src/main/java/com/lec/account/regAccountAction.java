package com.lec.account;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.action.Action;
import com.lec.action.ActionForward;

public class regAccountAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ActionForward forward = null;
		
		String account_code = req.getParameter("account_code");
		String account_name = req.getParameter("account_name");
		String account_ceo = req.getParameter("account_ceo");
		String account_tell = req.getParameter("account_tell");
		String account_type = req.getParameter("account_type");
		
		ACVO account = new ACVO(account_code, account_name, account_ceo,account_tell ,account_type);
		
		RegAccountService regAccountService = new RegAccountService();
		boolean isSuccessInsert = regAccountService.insertAC(account);
		
		if(isSuccessInsert) {
			forward = new ActionForward();
			forward.setNextPath("/viewAC.do");
		} else {
			res.setContentType("text/html;charset=UTF-8");
			PrintWriter writer = res.getWriter();
			writer.println("<script> alert('등록실패'); history.go(-1);</script>");
		}
		
		return forward;
	}

}
