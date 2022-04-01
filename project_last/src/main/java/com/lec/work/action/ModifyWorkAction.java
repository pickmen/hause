package com.lec.work.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.action.Action;
import com.lec.action.ActionForward;
import com.lec.work.WorkVO;
import com.lec.work.service.ModifyWorkService;

public class ModifyWorkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String work_code = req.getParameter("work_code");
		String item_code = req.getParameter("item_code");
		String item_name = req.getParameter("item_name");
		String work_count = req.getParameter("work_count");
		String work_time = req.getParameter("work_time");
		boolean isSuccess = false;
		ActionForward forward = null;
		
		WorkVO work = new WorkVO(work_code,item_code, item_name, work_count, work_time);
		ModifyWorkService modifyWorkService = new ModifyWorkService();
		isSuccess = modifyWorkService.isModifySuccess(work);
		
		System.out.println(isSuccess);
		if(isSuccess) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setNextPath("/workListView.do");
		} else {
			res.setContentType("text/html;charset=UTF-8");
			PrintWriter writer = res.getWriter();
			writer.println("<script> alert('수정실패'); history.go(-1);</script>");
		}
		
		return forward;
	}

}