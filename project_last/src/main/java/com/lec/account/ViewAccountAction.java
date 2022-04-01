package com.lec.account;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.action.Action;
import com.lec.action.ActionForward;

public class ViewAccountAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		List<ACVO> accountList = null;
		ActionForward forward = null;
		
		ViewAccountService viewAccountService = new ViewAccountService();
		accountList = viewAccountService.getAccountList();
		
		
		forward = new ActionForward();
		req.setAttribute("accountlist", accountList);
		forward.setNextPath("/account/viewAC.jsp");
		
		/* 리스트가 없을때 오류 발생
		if(accountList!=null && !accountList.isEmpty()) {
		}else {
			res.setContentType("text/html;charset=UTF-8");
			PrintWriter writer = res.getWriter();
			writer.println("<script> alert('불러오기실패!!');history.go(-1);</script>");
		}
		*/
		return forward;
	}

	
	
}
