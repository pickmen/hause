package com.lec.sales.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.action.Action;
import com.lec.action.ActionForward;
import com.lec.sales.SalesVO;
import com.lec.sales.service.UpdateSalesService;

public class UpdateSalesAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward = null;
		
		String sale_code = req.getParameter("sale_code");
		String account_code = req.getParameter("account_code");
		String[] item_code_name = req.getParameter("item_code").split(",,");
		String item_code = item_code_name[0];
		String item_name = item_code_name[1];
		String sale_date = req.getParameter("sale_date");
		int sale_cnt = Integer.parseInt(req.getParameter("sale_cnt"));
		double sale_cost = Double.parseDouble(req.getParameter("sale_cost"));
		double sale_price = sale_cost*sale_cnt;
		String ware_code = req.getParameter("ware_code");
		
		SalesVO sales = new SalesVO(sale_code, account_code, item_code, item_name, sale_date, sale_cnt, sale_price, sale_cost, ware_code);
		
		UpdateSalesService updateSalesService = new UpdateSalesService();
		boolean isSuccessUpdate = updateSalesService.Update(sales);
		
		if(isSuccessUpdate) {
			forward = new ActionForward();
			forward.setNextPath("/saleslistView.do");
			forward.setRedirect(true);
		} else {
			res.setContentType("text/html;charset=UTF-8");
			PrintWriter writer = res.getWriter();
			writer.println("<script> alert('수정실패'); history.go(-1);</script>");
		}
		
		return forward;
	}

}
