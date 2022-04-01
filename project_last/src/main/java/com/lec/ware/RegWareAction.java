package com.lec.ware;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.action.Action;
import com.lec.action.ActionForward;

public class RegWareAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		ActionForward forward = null; // forward > (주소, 리다렉트여부)
		
		String ware_code = req.getParameter("ware_code");
		String ware_name = req.getParameter("ware_name");
		String ware_type = req.getParameter("ware_type");
		String pro_code = req.getParameter("pro_code");
		String account_code = req.getParameter("account_code");
		// 파라미터 값을 숫자로 받고싶으면
		// int i = Integer.parseInt(req.getParameter("ware_count"));
		
		WareVO ware = new WareVO(ware_code, ware_name, ware_type, pro_code, account_code);
		
		RegWareService regWareService = new RegWareService();
		boolean isSuccess =  regWareService.insertWare(ware);
		
		if (isSuccess) { 
			forward = new ActionForward();
			forward.setNextPath("/listWare.do");
		} else { 
			res.setContentType("text/html;charset=UTF-8");
			PrintWriter writer = res.getWriter();
			writer.println("<script> alert('등록실패'); history.go(-1); </script>");
		}
		
		return forward;
		
	}
	
	

}
