package com.lec.work.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.action.Action;
import com.lec.action.ActionForward;
import com.lec.work.WorkVO;
import com.lec.work.service.RegWorkService;

public class RegWorkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		ActionForward forward = null; // forward > (주소, 리다렉트여부)
		
		String work_code = req.getParameter("work_code");
		String item_code = req.getParameter("item_code");
		String item_name = req.getParameter("item_name");
		String work_count = req.getParameter("work_count");
		String work_time = req.getParameter("work_time");
		// 파라미터 값을 숫자로 받고싶으면
		// int i = Integer.parseInt(req.getParameter("ware_count"));
		
		WorkVO work = new WorkVO(work_code, item_code, item_name, work_count, work_time);
		RegWorkService regWorkService = new RegWorkService();
		
		boolean isSuccess = false;
		isSuccess = regWorkService.regWork(work);
		if (isSuccess) { 
			forward = new ActionForward();
			forward.setNextPath("/workListView.do");
		} else { 
			res.setContentType("text/html;charset=UTF-8");
			PrintWriter writer = res.getWriter();
			writer.println("<script> alert('등록실패'); history.go(-1); </script>");
		}
		
		return forward;
		
	}
	
	

}