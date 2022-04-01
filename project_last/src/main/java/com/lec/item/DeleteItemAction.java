package com.lec.item;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.action.Action;
import com.lec.action.ActionForward;

public class DeleteItemAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ActionForward forward = null;
		
		String item_code = req.getParameter("item_code");
		DeleteItemService deleteItemService = new DeleteItemService();
		boolean is_success = deleteItemService.isDeleteItem(item_code);
		
		if (is_success) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setNextPath("/listItem.do");
		} else {
			res.setContentType("text/html;charset=UTF-8");
			PrintWriter writer = res.getWriter();
			writer.println("<script> alert('삭제실패'); history.go(-1);</script>");
		}
		
		return forward;
	}

}
