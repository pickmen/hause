package com.lec.inventory.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.action.Action;
import com.lec.action.ActionForward;
import com.lec.inventory.IVVO;
import com.lec.inventory.service.DeleteIVService;

public class DeleteIVAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward = null;
		
		String item_code = req.getParameter("item_code");
		String item_name = req.getParameter("item_name");
		String ware_code = req.getParameter("ware_code");
		int inven_cnt = Integer.parseInt(req.getParameter("inven_cnt"));
		
		IVVO IV = new IVVO(item_code, item_name, ware_code, inven_cnt);
		
		DeleteIVService deleteIVService = new DeleteIVService();
		boolean isSuccessDelete = deleteIVService.delete(IV);
		
		if(isSuccessDelete) {
			forward = new ActionForward();
			forward.setNextPath("/IVlistView.do");
			forward.setRedirect(true);
		} else {
			res.setContentType("text/html;charset=UTF-8");
			PrintWriter writer = res.getWriter();
			writer.println("<script> alert('삭제실패'); history.go(-1);</script>");
		}
		
		return forward;
	}

}
