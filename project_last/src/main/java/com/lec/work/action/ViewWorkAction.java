package com.lec.work.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.action.Action;
import com.lec.action.ActionForward;
import com.lec.work.WorkVO;
import com.lec.work.service.ViewWorkService;

public class ViewWorkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward = null;
		
		List<WorkVO> worklist = null;
		
		ViewWorkService viewWorkService = new ViewWorkService();
		worklist = viewWorkService.getWorkList();
		
		forward = new ActionForward();
		forward.setNextPath("/work/workList.jsp");
		req.setAttribute("worklist", worklist);
		
		return forward;
	}
}