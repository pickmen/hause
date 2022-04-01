package com.lec.work.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.action.Action;
import com.lec.action.ActionForward;
import com.lec.work.service.DeleteWorkService;

public class DeleteWorkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws IOException {
		ActionForward forward = null;
		String work_code = req.getParameter("work_code");
		
		DeleteWorkService deleteWorkService = new DeleteWorkService();
		boolean is_success = false;
		is_success = deleteWorkService.isDeleteWork(work_code);
		if (is_success) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setNextPath("/workListView.do");
		} else {
			res.setContentType("text/html;charset=UTF-8");
			PrintWriter writer = res.getWriter();
			writer.println("<script> alert('삭제실패'); history.go(-1);</script>");
		}
		
		return forward;
	}

}
