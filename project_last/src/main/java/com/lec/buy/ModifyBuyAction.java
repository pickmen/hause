package com.lec.buy;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.action.Action;
import com.lec.action.ActionForward;

public class ModifyBuyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String buy_code = req.getParameter("buy_code");
		String account_code = req.getParameter("account_code");
		String[] item_code_name = req.getParameter("item_code").split(",,");
		String item_code = item_code_name[0];
		String item_name = item_code_name[1];
		String buy_date = req.getParameter("buy_date");
		int buy_cnt = Integer.parseInt(req.getParameter("buy_cnt"));
		double buy_cost = Double.parseDouble(req.getParameter("buy_cost"));
		double buy_price = buy_cost*buy_cnt;
		String ware_code = req.getParameter("ware_code");
		boolean isSuccess = false;
		ActionForward forward = null;
		BuyVO buy = new BuyVO(buy_code,account_code,item_code, item_name, buy_date, buy_cnt, buy_cost, buy_price, ware_code);
		ModifyBuyService modifyBuyService = new ModifyBuyService();
		isSuccess = modifyBuyService.isModifySuccess(buy);
		if(isSuccess) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setNextPath("/viewBuy.do"); //("/listBuy.do"); 
		} else {
			res.setContentType("text/html;charset=UTF-8");
			PrintWriter writer = res.getWriter();
			writer.println("<script> alert('수정실패'); history.go(-1);</script>");
		}
		
		return forward;
	}

}
