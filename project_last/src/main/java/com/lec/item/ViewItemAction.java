package com.lec.item;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.action.Action;
import com.lec.action.ActionForward;
import com.lec.web.PageInfo;

public class ViewItemAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ArrayList<IMVO> itemList = new ArrayList<IMVO>();
		ActionForward forward = new ActionForward();
		
		int page = 1;
		int limit = 10;
		if(req.getParameter("page") != null) page = Integer.parseInt(req.getParameter("page"));
		
		ViewItemService viewItemService = new ViewItemService();
		int listCount = ViewItemService.getListCount();
		itemList = viewItemService.getItemList(page, limit);
		
		// 총페이지수
		int totalPage = (int)((double)listCount / limit + 0.95);
		// 현재페이지의 시작페이지수(1, 11, 21, ....)
		int startPage = (((int)((double)page / 10 + 0.9)) -1) * 10 + 1;
		// 현재페이지에 보여줄 마지막페이지수
		int endPage = startPage + 10 - 1;
		if(endPage > totalPage) endPage = totalPage;
		
		PageInfo pageInfo = new PageInfo();
		pageInfo.setListCount(listCount);
		pageInfo.setPage(page);
		pageInfo.setTotalPage(totalPage);
		pageInfo.setStartPage(startPage);
		pageInfo.setEndPage(endPage);

		req.setAttribute("pageInfo", pageInfo);
		req.setAttribute("boardList", itemList);
	
		forward = new ActionForward();
		req.setAttribute("itemlist", itemList);
		forward.setNextPath("/item/viewItem.jsp");
		
		/* 리스트가 없을때 오류 발생
		if(itemList!=null && !itemList.isEmpty()) {
			forward = new ActionForward();
			req.setAttribute("itemlist", itemList);
			forward.setNextPath("/item/viewItem.jsp");
		} else {
			res.setContentType("text/html;charset=UTF-8");
			PrintWriter writer = res.getWriter();
			writer.println("<script> alert('불러오기실패'); history.go(-1);</script>");
		}
		*/
		return forward;
	}

}
