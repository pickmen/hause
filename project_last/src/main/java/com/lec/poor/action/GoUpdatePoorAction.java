package com.lec.poor.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.action.Action;
import com.lec.action.ActionForward;
import com.lec.work.WorkVO;
import com.lec.work.service.ViewWorkService;

public class GoUpdatePoorAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ActionForward forward = null;
		
		List<WorkVO> worklist = null;
		
		ViewWorkService viewWorkService = new ViewWorkService();
		worklist = viewWorkService.getWorkList();
		
		req.setAttribute("worklist", worklist);
		forward = new ActionForward();
		forward.setNextPath("/poor/modifypoor.jsp");
		
		
		return forward;
	}
	
}
