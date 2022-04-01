package com.lec.poor.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.action.Action;
import com.lec.action.ActionForward;
import com.lec.poor.PoorVO;
import com.lec.poor.service.ModifyPoorService;

public class ModifyPoorAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String pro_code = req.getParameter("pro_code");
		String item_code = req.getParameter("item_code");
		String poor_count = req.getParameter("poor_count");
		String bool_poor = req.getParameter("bool_poor");
		boolean isSuccess = false;
		ActionForward forward = null;
		
		PoorVO poor = new PoorVO(pro_code,item_code,poor_count,bool_poor);
		ModifyPoorService modifyPoorService = new ModifyPoorService();
		isSuccess = modifyPoorService.isModifySuccess(poor);
		
		System.out.println(isSuccess);
		if(isSuccess) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setNextPath("/poorListView.do");
		} else {
			res.setContentType("text/html;charset=UTF-8");
			PrintWriter writer = res.getWriter();
			writer.println("<script> alert('수정실패'); history.go(-1);</script>");
		}
		
		return forward;
	}

}
