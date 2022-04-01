package com.lec.sales.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.action.Action;
import com.lec.action.ActionForward;
import com.lec.sales.SalesVO;
import com.lec.sales.service.ViewSalesListService;

public class ViewSalesListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward = null;
		
		List<SalesVO> saleslist = null;
		
		ViewSalesListService viewSalesListService = new ViewSalesListService();
		saleslist = viewSalesListService.getSalesList();
		
		forward = new ActionForward();
		forward.setNextPath("/sales/salesmain.jsp");
		req.setAttribute("saleslist", saleslist);
		
		return forward;
	}

}