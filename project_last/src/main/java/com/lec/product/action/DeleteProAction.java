package com.lec.product.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.action.Action;
import com.lec.action.ActionForward;
import com.lec.product.service.DeleteProService;

public class DeleteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws IOException {
		ActionForward forward = null;
		String pro_code = req.getParameter("pro_code");
		
		DeleteProService deleteProService = new DeleteProService();
		boolean is_success = false;
		is_success = deleteProService.isDeletePro(pro_code);
		if (is_success) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setNextPath("/proListView.do");
		} else {
			res.setContentType("text/html;charset=UTF-8");
			PrintWriter writer = res.getWriter();
			writer.println("<script> alert('삭제실패'); history.go(-1);</script>");
		}
		
		return forward;
	}

}
