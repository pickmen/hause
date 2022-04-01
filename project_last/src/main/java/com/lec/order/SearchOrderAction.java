package com.lec.order;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.action.Action;
import com.lec.action.ActionForward;
import com.lec.order.OrderVO;
import com.lec.web.PageInfo;

public class SearchOrderAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ActionForward forward = null;
		HttpSession sess = req.getSession();
		String search_type = req.getParameter("search_type");
		String search_text = req.getParameter("search_text");
		ViewOrderService viewOrderService = new ViewOrderService();
		
		String pagestr = req.getParameter("page");
		
		int page =1;
		if (pagestr != null) {
			page = Integer.parseInt(pagestr);
		}
		
		PageInfo paging = null;
		List<OrderVO> orderlist = null;
		
		if (search_type != null && search_text != null) {
			sess.removeAttribute("search_type");
			sess.removeAttribute("search_text");
			sess.removeAttribute("orderlist");
			sess.setAttribute("search_type", search_type);
			sess.setAttribute("search_text", search_text);
			paging = viewOrderService.getPaging_search(page, search_type, search_text);
			orderlist = viewOrderService.getOrderList_Search(search_type, search_text);
			sess.setAttribute("orderlist", orderlist);
		} else {
			search_type = (String)sess.getAttribute("search_type");
			search_text = (String)sess.getAttribute("search_text");
			paging = viewOrderService.getPaging_search(page, search_type, search_text);
		}
		
		/*
		 * List<OrderVO> orderlist = null; orderlist =
		 * viewOrderService.getOrderList_Search(search_type, search_text);
		 */
		forward = new ActionForward();
		forward.setNextPath("/main.jsp");
		req.setAttribute("paging", paging);
		req.setAttribute("pagename", "/order/viewOrder.jsp");
		return forward;
	}

}
