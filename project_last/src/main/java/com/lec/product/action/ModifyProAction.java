package com.lec.product.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.action.Action;
import com.lec.action.ActionForward;
import com.lec.product.ProVO;
import com.lec.product.service.ModifyProService;

public class ModifyProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String pro_code = req.getParameter("pro_code");
		String item_code = req.getParameter("item_code");
		String item_name = req.getParameter("item_name");
		String pro_count = req.getParameter("pro_count");
		String complete = req.getParameter("complete");
		String outware_code = req.getParameter("outware_code");
		String inware_code = req.getParameter("inware_code");
		boolean isSuccess = false;
		ActionForward forward = null;
		
		ProVO pro = new ProVO(pro_code,item_code, item_name, pro_count, complete, outware_code, inware_code);
		ModifyProService modifyProService = new ModifyProService();
		isSuccess = modifyProService.isModifySuccess(pro);
		
		System.out.println(isSuccess);
		if(isSuccess) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setNextPath("/proListView.do");
		} else {
			res.setContentType("text/html;charset=UTF-8");
			PrintWriter writer = res.getWriter();
			writer.println("<script> alert('수정실패'); history.go(-1);</script>");
		}
		
		return forward;
	}

}