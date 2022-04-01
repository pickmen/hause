package com.lec.poor.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.action.Action;
import com.lec.action.ActionForward;
import com.lec.poor.PoorVO;
import com.lec.poor.service.ViewPoorService;

public class ViewPoorAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward = null;
		
		List<PoorVO> poorlist = null;
		
		ViewPoorService viewPoorService = new ViewPoorService();
		poorlist = viewPoorService.getPoorList();
		
		forward = new ActionForward();
		forward.setNextPath("/poor/poorList.jsp");
		req.setAttribute("poorlist", poorlist);
		
		return forward;
	}
}