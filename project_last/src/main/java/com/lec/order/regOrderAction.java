package com.lec.order;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.action.Action;
import com.lec.action.ActionForward;

public class regOrderAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException , IOException{
		ActionForward forward = null;
		
				
		String order_code = req.getParameter("order_code");
		String account_code = req.getParameter("account_code");
		
		String[] item_code_name = req.getParameter("item_code").split(",,");
		String item_code = item_code_name[0];
		String item_name = item_code_name[1];
		
		String order_date = req.getParameter("order_date");
		int order_cnt = Integer.parseInt(req.getParameter("order_cnt"));
		double order_cost = Double.parseDouble(req.getParameter("order_cost"));
		double order_price = order_cost*order_cnt;
		
		OrderVO order = new OrderVO(order_code, account_code, item_code, item_name, order_date, order_cnt, order_cost, order_price);
		RegOrderService regOrderService = new RegOrderService();
		boolean isSuccessInsert = regOrderService.insertOrder(order);
		
		if(isSuccessInsert) {
			forward = new ActionForward();
			forward.setNextPath("/viewOrder.do");
			forward.setRedirect(true);
		} else {
			res.setContentType("text/html;charset=UTF-8");
			PrintWriter writer = res.getWriter();
			writer.println("<script> alert('등록실패'); history.go(-1);</script>");
		}
		
		return forward;
	}

}
