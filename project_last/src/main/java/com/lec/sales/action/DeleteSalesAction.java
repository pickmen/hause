package com.lec.sales.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.action.Action;
import com.lec.action.ActionForward;
import com.lec.sales.service.DeleteSalesService;

public class DeleteSalesAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward = null;
		
		String sale_code = req.getParameter("sale_code");
		
		DeleteSalesService deleteSalesService = new DeleteSalesService();
		boolean isSuccessDelete = deleteSalesService.delete(sale_code);
		
		if(isSuccessDelete) {
			forward = new ActionForward();
			forward.setNextPath("/saleslistView.do");
			forward.setRedirect(true);
		} else {
			res.setContentType("text/html;charset=UTF-8");
			PrintWriter writer = res.getWriter();
			writer.println("<script> alert('삭제실패'); history.go(-1);</script>");
		}
		return forward;
	}

}
