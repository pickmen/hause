package com.lec.bom.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.action.Action;
import com.lec.action.ActionForward;
import com.lec.bom.BomVO;
import com.lec.bom.service.ViewBOMListService;

public class ViewBOMListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward=null;
		
		List<BomVO> bomlist = null;
		
		ViewBOMListService viewBOMListService = new ViewBOMListService();
		bomlist = viewBOMListService.getBOMList();
		
		forward = new ActionForward();
		forward.setNextPath("/main.jsp"); // 고정
		req.setAttribute("bomlist", bomlist);
		req.setAttribute("pagename", "/bom/bommain.jsp");
		return forward;
	}

}
