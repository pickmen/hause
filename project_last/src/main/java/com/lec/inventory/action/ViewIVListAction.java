package com.lec.inventory.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.action.Action;
import com.lec.action.ActionForward;
import com.lec.inventory.IVVO;
import com.lec.inventory.service.ViewIVListService;

public class ViewIVListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward = null;
		
		List<IVVO> IVlist = null;
		
		ViewIVListService viewIVListService = new ViewIVListService();
		IVlist = viewIVListService.getIVList();
		
    	forward = new ActionForward();
    	forward.setNextPath("/inventory/inventorymain.jsp");
    	req.setAttribute("IVlist", IVlist);
		
		return forward;
	}

}
