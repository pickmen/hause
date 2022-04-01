package com.lec.order;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.account.ACVO;
import com.lec.account.ViewAccountService;
import com.lec.action.Action;
import com.lec.action.ActionForward;
import com.lec.item.IMVO;
import com.lec.item.ViewItemService;
import com.lec.ware.ViewWareService;
import com.lec.ware.WareVO;

public class GoUpdateOrderAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ActionForward forward = null;
		
		List<WareVO> warelist = null;
		List<ACVO> accountlist = null;
		List<IMVO> itemlist = null;

		
		ViewWareService viewWareService = new ViewWareService();
		warelist = viewWareService.getWareList();
		
		ViewAccountService viewAccountService = new ViewAccountService();
		accountlist = viewAccountService.getAccountList();
		
		ViewItemService viewItemService = new ViewItemService();
		itemlist = viewItemService.getItemList();
		
		req.setAttribute("warelist", warelist);
		req.setAttribute("itemlist", itemlist);
		req.setAttribute("accountlist", accountlist);
		
		forward = new ActionForward();
		forward.setNextPath("/main.jsp");
		req.setAttribute("pagename", "/order/modifyOrderpage.jsp");

		
		return forward;
	}

	
}
