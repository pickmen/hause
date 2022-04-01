package com.lec.ware;


import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.action.Action;
import com.lec.action.ActionForward;

public class ModifyWareAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String ware_code = req.getParameter("ware_code");
		String ware_name = req.getParameter("ware_name");
		String ware_type = req.getParameter("ware_type");
		String pro_code = req.getParameter("pro_code");
		String account_code = req.getParameter("account_code");
		
		boolean isSuccess = false;
		ActionForward forward = null;
		
		
		
		WareVO ware = new WareVO(ware_code, ware_name, ware_type, pro_code, account_code);
		ModifyWareService modifyWareService = new ModifyWareService();
		isSuccess = modifyWareService.isModifySuccess(ware);
		
		if(isSuccess) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setNextPath("/listWare.do");
		} else {
			res.setContentType("text/html;charset=UTF-8");
			PrintWriter writer = res.getWriter();
			writer.println("<script> alert('수정실패'); history.go(-1);</script>");
		}
		
		return forward;
	
	
	}

}
