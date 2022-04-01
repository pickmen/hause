package com.lec.bom.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.action.Action;
import com.lec.action.ActionForward;
import com.lec.bom.BomVO;
import com.lec.bom.service.InsertBOMService;

public class InsertBOMAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward=null;
		
		String[] item_code_name = req.getParameter("item_code").split(",,");
		
		System.out.println(req.getParameter("item_code"));
		String item_code = item_code_name[0];
		String item_name = item_code_name[1];
		int item_cnt = Integer.parseInt(req.getParameter("item_cnt"));
		String prt_item_code = req.getParameter("prt_item_code");
		
		BomVO bom = new BomVO(item_code, item_name, item_cnt, prt_item_code);
		InsertBOMService insertBOMService = new InsertBOMService();
		boolean isSuccessInsert = insertBOMService.insert(bom);
		
		if(isSuccessInsert) {
			forward = new ActionForward();
			forward.setNextPath("/bomlistView.do");
			forward.setRedirect(true);
		} else {
			res.setContentType("text/html;charset=UTF-8");
			PrintWriter writer = res.getWriter();
			writer.println("<script> alert('등록실패'); history.go(-1);</script>");
		}
		
		return forward;
	}

}
