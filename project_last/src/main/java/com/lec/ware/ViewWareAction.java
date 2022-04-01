package com.lec.ware;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.action.Action;
import com.lec.action.ActionForward;

public class ViewWareAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		List<WareVO> warelist = null;
		ActionForward forward = null;
		
		ViewWareService viewWareService = new ViewWareService();
		warelist = viewWareService.getWareList();
		
		
		forward = new ActionForward();
		req.setAttribute("warelist", warelist);
		forward.setNextPath("/warehouse/wareList.jsp");

		/* 리스트가 없을때 오류 발생
		if(accountList!=null && !accountList.isEmpty()) {
			forward = new ActionForward();
			req.setAttribute("warelist", warelist);
			forward.setNextPath("/warehouse/wareList.jsp");
		}else {
			res.setContentType("text/html;charset=UTF-8");
			PrintWriter writer = res.getWriter();
			writer.println("<script> alert('불러오기실패!!');history.go(-1);</script>");
		}
		*/
		
		return forward;
	}

}
