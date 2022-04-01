package com.lec.item;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.action.Action;
import com.lec.action.ActionForward;

public class ModifyItemAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String item_code = req.getParameter("item_code");
		String item_name = req.getParameter("item_name");
		int item_cost = Integer.parseInt(req.getParameter("item_cost"));
		int item_price = Integer.parseInt(req.getParameter("item_price"));
		String item_type = req.getParameter("item_type");
		String item_comment = req.getParameter("item_comment");
		boolean isSuccess = false;
		ActionForward forward = null;
		
		IMVO item = new IMVO(item_code, item_name, item_cost, item_price, item_type, item_comment);
		ModifyItemService modifyItemService = new ModifyItemService();
		isSuccess = modifyItemService.isModifySuccess(item);
		
		if(isSuccess) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setNextPath("/listItem.do");
		} else {
			res.setContentType("text/html;charset=UTF-8");
			PrintWriter writer = res.getWriter();
			writer.println("<script> alert('수정실패'); history.go(-1);</script>");
		}
		
		return forward;
	}

}
