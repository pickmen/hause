package com.lec.poor.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.action.Action;
import com.lec.action.ActionForward;
import com.lec.poor.service.DeletePoorService;

public class DeletePoorAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws IOException {
		ActionForward forward = null;
		String pro_code = req.getParameter("pro_code");
		
		DeletePoorService deletePoorService = new DeletePoorService();
		boolean is_success = false;
		is_success = deletePoorService.isDeletePoor(pro_code);
		if (is_success) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setNextPath("/poorListView.do");
		} else {
			res.setContentType("text/html;charset=UTF-8");
			PrintWriter writer = res.getWriter();
			writer.println("<script> alert('삭제실패'); history.go(-1);</script>");
		}
		
		return forward;
	}

}

