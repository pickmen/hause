package com.lec.buy;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.action.Action;
import com.lec.action.ActionForward;
import com.lec.web.PageInfo;
import com.lec.buy.BuyVO;
import com.lec.buy.ViewBuyService;

public class SearchBuyAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ActionForward forward = null;
		HttpSession sess = req.getSession();
		String search_type = req.getParameter("search_type");
		String search_text = req.getParameter("search_text");
		ViewBuyService viewBuyService = new ViewBuyService();
		
		String pagestr = req.getParameter("page");
		
		int page =1;
		if (pagestr != null) {
			page = Integer.parseInt(pagestr);
		}
		
		PageInfo paging = null;
		List<BuyVO> buylist = null;
		
		
		if (search_type != null && search_text != null) {
			sess.removeAttribute("search_type");
			sess.removeAttribute("search_text");
			sess.removeAttribute("buylist");
			sess.setAttribute("search_type", search_type);
			sess.setAttribute("search_text", search_text);
			paging = viewBuyService.getPaging_search(page, search_type, search_text);
			buylist = viewBuyService.getBuyList_Search(search_type, search_text);
			sess.setAttribute("buylist", buylist);
		} else {
			search_type = (String)sess.getAttribute("search_type");
			search_text = (String)sess.getAttribute("search_text");
			paging = viewBuyService.getPaging_search(page, search_type, search_text);
		}
		
		/*
		 * List<BuyVO> buylist = null; ViewBuyService viewBuyService = new
		 * ViewBuyService(); buylist = viewBuyService.getBuyList_Search(search_type,
		 * search_text);
		 */
		forward = new ActionForward();
		forward.setNextPath("/main.jsp");
		req.setAttribute("paging", paging);
		req.setAttribute("pagename", "/buy/viewBuy.jsp");
		return forward;
	}
	
}
