package com.lec.poor.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.action.Action;
import com.lec.action.ActionForward;
import com.lec.poor.PoorVO;
import com.lec.poor.service.RegPoorService;

public class RegPoorAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		ActionForward forward = null; // forward > (주소, 리다렉트여부)
		
		String pro_code = req.getParameter("pro_code");
		String item_code = req.getParameter("item_code");
		String poor_count = req.getParameter("poor_count");
		String bool_poor = req.getParameter("bool_poor");
		// 파라미터 값을 숫자로 받고싶으면
		// int i = Integer.parseInt(req.getParameter("ware_count"));
		
		PoorVO poor = new PoorVO(pro_code, item_code, poor_count, bool_poor);
		RegPoorService regPoorService = new RegPoorService();
		
		boolean isSuccess = false;
		isSuccess = regPoorService.regPoor(poor);
		if (isSuccess) { 
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setNextPath("/poorListView.do");
		} else { 
			res.setContentType("text/html;charset=UTF-8");
			PrintWriter writer = res.getWriter();
			writer.println("<script> alert('등록실패'); history.go(-1); </script>");
		}
		
		return forward;
		
	}
	
	

}