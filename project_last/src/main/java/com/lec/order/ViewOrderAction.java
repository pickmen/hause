package com.lec.order;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.action.Action;
import com.lec.action.ActionForward;
import com.lec.web.PageInfo;

public class ViewOrderAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		List<OrderVO> orderList = null;
		ActionForward forward = null;
		String pagestr = req.getParameter("page");
		int page = 1;
		if (pagestr != null && pagestr != "") {
			page = Integer.parseInt(pagestr);
		}
		
		ViewOrderService viewOrderService = new ViewOrderService();
		orderList = viewOrderService.getOrderList();
		
		PageInfo paging = null;
		paging = viewOrderService.getPaging(page);
		
		
		forward = new ActionForward();
		req.setAttribute("orderlist", orderList);
		forward.setNextPath("/main.jsp");
		req.setAttribute("paging", paging);
		req.setAttribute("pagename", "/order/viewOrder.jsp");
		
		return forward;
	}

	
	
}
