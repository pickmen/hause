package com.lec.inventory.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.action.Action;
import com.lec.action.ActionForward;
import com.lec.item.IMVO;
import com.lec.item.ViewItemService;
import com.lec.ware.ViewWareService;
import com.lec.ware.WareVO;

public class GoInsertIVAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ActionForward forward = null;
		
		List<IMVO> itemlist = null;
		List<WareVO> warelist = null;
		ViewItemService viewItemService = new ViewItemService();
		itemlist = viewItemService.getItemList();
		
		ViewWareService viewWareService = new ViewWareService();
		warelist = viewWareService.getWareList();
		req.setAttribute("warelist", warelist);
		req.setAttribute("itemlist", itemlist);
		forward = new ActionForward();
		forward.setNextPath("/inventory/insertIV.jsp");
		
		
		return forward;
	}

}
