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

public class GoinsertOrderAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ActionForward forword = null;
		
		List<ACVO> accountlist =null;
		List<IMVO> itemlist =null;
		ViewAccountService viewAccountService = new ViewAccountService();
		accountlist = viewAccountService.getAccountList();
		ViewItemService viewItemService = new ViewItemService();
		itemlist = viewItemService.getItemList();
				
		req.setAttribute("accountlist", accountlist);
		
		req.setAttribute("itemlist", itemlist);
		
		forword = new ActionForward();
		
		forword.setNextPath("/main.jsp");
		req.setAttribute("pagename", "/order/regOrder.jsp");
		
		return forword;
	}

}
