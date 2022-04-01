package com.lec.product.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.action.Action;
import com.lec.action.ActionForward;
import com.lec.product.ProVO;
import com.lec.product.service.ViewProService;

public class ViewProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward = null;
		
		List<ProVO> prolist = null;
		
		ViewProService viewProService = new ViewProService();
		prolist = viewProService.getProList();
		
		forward = new ActionForward();
		forward.setNextPath("/product/productList.jsp");
		req.setAttribute("prolist", prolist);
		
		return forward;
	}
}