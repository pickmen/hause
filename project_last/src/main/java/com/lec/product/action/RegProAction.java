package com.lec.product.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.action.Action;
import com.lec.action.ActionForward;
import com.lec.product.ProVO;
import com.lec.product.service.RegProService;

public class RegProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		ActionForward forward = null; // forward > (주소, 리다렉트여부)
		
		String pro_code = req.getParameter("pro_code");
		String item_code = req.getParameter("item_code");
		String item_name = req.getParameter("item_name");
		String pro_count = req.getParameter("pro_count");
		String complete = req.getParameter("complete"); // 0,1
		String outware_code = req.getParameter("outware_code");
		String inware_code = req.getParameter("inware_code");
		// 파라미터 값을 숫자로 받고싶으면
		// int i = Integer.parseInt(req.getParameter("ware_count"));
		
		ProVO pro = new ProVO(pro_code, item_code, item_name, pro_count, complete, outware_code, inware_code);
		RegProService regProService = new RegProService();
		
		boolean isSuccess = false;
		isSuccess = regProService.regPro(pro);
		if (isSuccess) { 
			forward = new ActionForward();
			forward.setNextPath("/proListView.do");
		} else { 
			res.setContentType("text/html;charset=UTF-8");
			PrintWriter writer = res.getWriter();
			writer.println("<script> alert('등록실패'); history.go(-1); </script>");
		}
		
		return forward;
		
	}
	
	

}