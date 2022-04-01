package com.lec.bom.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.action.Action;
import com.lec.action.ActionForward;
import com.lec.item.IMVO;
import com.lec.item.ViewItemService;

public class GoInsertBOMAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ActionForward forward = null;
		
		List<IMVO> itemlist = null;
		
		ViewItemService viewItemService = new ViewItemService();
		itemlist = viewItemService.getItemList();
		
		req.setAttribute("itemlist", itemlist);
		forward = new ActionForward();
		forward.setNextPath("/bom/insertBOM.jsp");
		
		
		return forward;
	}

}
