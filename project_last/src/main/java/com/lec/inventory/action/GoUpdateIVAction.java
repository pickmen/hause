package com.lec.inventory.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.action.Action;
import com.lec.action.ActionForward;
import com.lec.ware.ViewWareService;
import com.lec.ware.WareVO;

public class GoUpdateIVAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ActionForward forward = null;
		
		List<WareVO> warelist = null;
		
		ViewWareService viewWareService = new ViewWareService();
		warelist = viewWareService.getWareList();
		req.setAttribute("warelist", warelist);
		forward = new ActionForward();
		forward.setNextPath("/inventory/updateIV.jsp");
		
		
		return forward;
	}

}
