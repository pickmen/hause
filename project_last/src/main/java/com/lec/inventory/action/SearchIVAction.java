package com.lec.inventory.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.action.Action;
import com.lec.action.ActionForward;
import com.lec.inventory.IVVO;
import com.lec.inventory.service.ViewIVListService;

public class SearchIVAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ActionForward forward = null;
		
		String search_type = req.getParameter("search_type");
		String search_text = req.getParameter("search_text");
		
		List<IVVO> IVList = null;
		ViewIVListService viewIVListService = new ViewIVListService();
		IVList = viewIVListService.getIVList_Search(search_type, search_text);
		
		
	    forward = new ActionForward();
	    forward.setNextPath("/inventory/inventorymain.jsp");
	    req.setAttribute("IVlist", IVList);
		return forward;
	}

}
