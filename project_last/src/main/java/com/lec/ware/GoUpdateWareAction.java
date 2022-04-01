package com.lec.ware;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.account.ACVO;
import com.lec.account.ViewAccountService;
import com.lec.action.Action;
import com.lec.action.ActionForward;
import com.lec.product.ProVO;
import com.lec.product.service.ViewProService;


public class GoUpdateWareAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ActionForward forward = null;
		
		List<ProVO> prolist = null;
		List<ACVO> accountList = null;
		
		ViewProService viewProService = new ViewProService();
		prolist = viewProService.getProList();
		
		ViewAccountService viewAccountService = new ViewAccountService();
		accountList = viewAccountService.getAccountList();
		
		req.setAttribute("prolist", prolist);
		req.setAttribute("accountlist", accountList);
		forward = new ActionForward();
		forward.setNextPath("/warehouse/modifyWarePage.jsp");
		
		
		return forward;
	}
	
}
