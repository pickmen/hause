package com.lec.buy;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.action.Action;
import com.lec.action.ActionForward;
import com.lec.web.PageInfo;

public class ViewBuyAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		List<BuyVO> buyList = null;
		ActionForward forward = null;
		String pagestr = req.getParameter("page");
		int page = 1;
		if (pagestr != null && pagestr != "") {
			page = Integer.parseInt(pagestr);
		}
		
		
		ViewBuyService viewBuyService = new ViewBuyService();
		buyList = viewBuyService.getBuyList();
		
		PageInfo paging = null;
		paging = viewBuyService.getPaging(page);
		

			forward = new ActionForward();
			req.setAttribute("buylist", buyList);
			forward.setNextPath("/main.jsp");
			req.setAttribute("paging", paging);
			req.setAttribute("pagename", "/buy/viewBuy.jsp");
		return forward;
	}

	
	
}
