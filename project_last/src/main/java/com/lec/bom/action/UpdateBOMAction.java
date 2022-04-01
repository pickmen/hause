package com.lec.bom.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.action.Action;
import com.lec.action.ActionForward;
import com.lec.bom.BomVO;
import com.lec.bom.service.UpdateBOMService;

public class UpdateBOMAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward = null;
		
		String item_code = req.getParameter("item_code");
		String item_name = req.getParameter("item_name");
		int item_cnt = Integer.parseInt(req.getParameter("item_cnt"));
		String prt_item_code = req.getParameter("prt_item_code");
		
		BomVO bom = new BomVO(item_code, item_name, item_cnt, prt_item_code);
		UpdateBOMService updateBOMService = new UpdateBOMService();
		boolean isSuccessUpdate = updateBOMService.Update(bom);
		
		if(isSuccessUpdate) {
			forward = new ActionForward();
			forward.setNextPath("/bomlistView.do");
			forward.setRedirect(true);
		} else {
			res.setContentType("text/html;charset=UTF-8");
			PrintWriter writer = res.getWriter();
			writer.println("<script> alert('수정실패'); history.go(-1);</script>");
		}
		
		return forward;
	}

}
