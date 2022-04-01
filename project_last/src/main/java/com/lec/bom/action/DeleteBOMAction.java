package com.lec.bom.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.action.Action;
import com.lec.action.ActionForward;
import com.lec.bom.service.DeleteBOMService;

public class DeleteBOMAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward = null;
		
		String item_code = req.getParameter("item_code");
		DeleteBOMService deleteBOMService = new DeleteBOMService();
		boolean isSuccessDelete = deleteBOMService.delete(item_code);
		if(isSuccessDelete) {
			forward = new ActionForward();
			forward.setNextPath("/bomlistView.do");
			forward.setRedirect(true);
		} else {
			res.setContentType("text/html;charset=UTF-8");
			PrintWriter writer = res.getWriter();
			writer.println("<script> alert('삭제실패'); history.go(-1);</script>");
		}
		return forward;
	}

}
