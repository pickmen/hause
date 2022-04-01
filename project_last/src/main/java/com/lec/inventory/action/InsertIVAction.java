package com.lec.inventory.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.action.Action;
import com.lec.action.ActionForward;
import com.lec.inventory.IVVO;
import com.lec.inventory.service.InsertIVService;

public class InsertIVAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward = null;
		
		String[] item_code_name = req.getParameter("item_code").split(",,");
		
		String item_code = item_code_name[0];
		String item_name = item_code_name[1];
		String ware_code = req.getParameter("ware_code");
		int inven_cnt = Integer.parseInt(req.getParameter("inven_cnt"));
		
		IVVO IV = new IVVO(item_code, item_name, ware_code, inven_cnt);
		InsertIVService insertIVService = new InsertIVService();
		boolean isSuccessInsert = insertIVService.insert(IV);
		
		if(isSuccessInsert) {
			forward = new ActionForward();
			forward.setNextPath("/IVlistView.do");
			forward.setRedirect(true);
		} else {
			res.setContentType("text/html;charset=UTF-8");
			PrintWriter writer = res.getWriter();
			writer.println("<script> alert('등록실패'); history.go(-1);</script>");
		}
		return forward;
	}

}
