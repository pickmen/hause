package com.lec.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.account.DeleteAccountAction;
import com.lec.account.ModifyAccountAction;
import com.lec.account.ModifyPageAccountAction;
import com.lec.account.ViewAccountAction;
import com.lec.account.regAccountAction;
import com.lec.action.ActionForward;
import com.lec.bom.action.DeleteBOMAction;
import com.lec.bom.action.GoInsertBOMAction;
import com.lec.bom.action.GoUpdateBOMAction;
import com.lec.bom.action.InsertBOMAction;
import com.lec.bom.action.UpdateBOMAction;
import com.lec.bom.action.ViewBOMListAction;
import com.lec.buy.DeleteBuyAction;
import com.lec.buy.GoUpdateBuyAction;
import com.lec.buy.GoinsertBuyAction;
import com.lec.buy.ModifyBuyAction;
import com.lec.buy.SearchBuyAction;
import com.lec.buy.ViewBuyAction;
import com.lec.buy.regBuyAction;
import com.lec.inventory.action.DeleteIVAction;
import com.lec.inventory.action.GoInsertIVAction;
import com.lec.inventory.action.GoUpdateIVAction;
import com.lec.inventory.action.InsertIVAction;
import com.lec.inventory.action.SearchIVAction;
import com.lec.inventory.action.UpdateIVAction;
import com.lec.inventory.action.ViewIVListAction;
import com.lec.item.DeleteItemAction;
import com.lec.item.ModifyItemAction;
import com.lec.item.ModifyPageItemAction;
import com.lec.item.ViewItemAction;
import com.lec.item.regItemAction;
import com.lec.order.DeleteOrderAction;
import com.lec.order.GoUpdateOrderAction;
import com.lec.order.GoinsertOrderAction;
import com.lec.order.ModifyOrderAction;
import com.lec.order.SearchOrderAction;
import com.lec.order.ViewOrderAction;
import com.lec.order.regOrderAction;
import com.lec.poor.action.DeletePoorAction;
import com.lec.poor.action.GoInsertPoorAction;
import com.lec.poor.action.GoUpdatePoorAction;
import com.lec.poor.action.ModifyPoorAction;
import com.lec.poor.action.RegPoorAction;
import com.lec.poor.action.ViewPoorAction;
import com.lec.product.action.DeleteProAction;
import com.lec.product.action.GoInsertProAction;
import com.lec.product.action.GoUpdateProAction;
import com.lec.product.action.ModifyProAction;
import com.lec.product.action.RegProAction;
import com.lec.product.action.ViewProAction;
import com.lec.sales.action.DeleteSalesAction;
import com.lec.sales.action.GoInsertSalesAction;
import com.lec.sales.action.GoUpdateSalesAction;
import com.lec.sales.action.InsertSalesAction;
import com.lec.sales.action.UpdateSalesAction;
import com.lec.sales.action.ViewSalesListAction;
import com.lec.ware.DeleteWareAction;
import com.lec.ware.GoInsertWareAction;
import com.lec.ware.GoUpdateWareAction;
import com.lec.ware.ModifyPageWareAction;
import com.lec.ware.ModifyWareAction;
import com.lec.ware.RegWareAction;
import com.lec.ware.ViewWareAction;
import com.lec.work.action.DeleteWorkAction;
import com.lec.work.action.GoInsertWorkAction;
import com.lec.work.action.GoUpdateWorkAction;
import com.lec.work.action.ModifyWorkAction;
import com.lec.work.action.RegWorkAction;
import com.lec.work.action.ViewWorkAction;

@WebServlet("*.do")
public class WebController extends HttpServlet {

	private static final long serialVersionUID = 139893095689268259L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		process(req, res);
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		process(req, res);
	}
	
	private void process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String reqURI = req.getRequestURI();
		int cmdIdx = reqURI.lastIndexOf("/")+1;
		String command = reqURI.substring(cmdIdx);
		System.out.println(command);
		
		ActionForward forward = null;
		
		switch (command) {
		
		// BOM
		case "insertBOM.do":
			try {forward = new InsertBOMAction().execute(req,res);} catch (Exception e) {}
			break;
		case "bomlistView.do":
			try {forward = new ViewBOMListAction().execute(req,res);} catch (Exception e) {}
			break;
		case "updateBOM.do":
			try {forward = new UpdateBOMAction().execute(req,res);} catch (Exception e) {}
			break;
		case "goUpdateBOM.do":
			try {forward = new GoUpdateBOMAction().execute(req,res);} catch (Exception e) {}
			break;
		case "deleteBOM.do":
			try {forward = new DeleteBOMAction().execute(req,res);} catch (Exception e) {}
			break;
		case "goInsertBOM.do":
			try {forward = new GoInsertBOMAction().execute(req,res);} catch (Exception e) {}
			break;
		// 재고
		case "insertIV.do":
			try {forward = new InsertIVAction().execute(req,res);} catch (Exception e) {}
			break;
		case "IVlistView.do":
			try {forward = new ViewIVListAction().execute(req,res);} catch (Exception e) {}
			break;
		case "updateIV.do":
			try {forward = new UpdateIVAction().execute(req,res);} catch (Exception e) {}
			break;
		case "goUpdateIV.do":
			try {forward = new GoUpdateIVAction().execute(req,res);} catch (Exception e) {}
			break;
		case "deleteIV.do":
			try {forward = new DeleteIVAction().execute(req,res);} catch (Exception e) {}
			break;
		case "goInsertIV.do":
			try {forward = new GoInsertIVAction().execute(req,res);} catch (Exception e) {}
			break;
		case "searchIV.do":
			try {forward = new SearchIVAction().execute(req,res);} catch (Exception e) {}
			break;
			
		// 판매
		case "insertSales.do":
			try {forward = new InsertSalesAction().execute(req,res);} catch (Exception e) {}
			break;
		case "saleslistView.do":
			try {forward = new ViewSalesListAction().execute(req,res);} catch (Exception e) {}
			break;
		case "updateSales.do":
			try {forward = new UpdateSalesAction().execute(req,res);} catch (Exception e) {}
			break;
		case "goUpdateSales.do":
			try {forward = new GoUpdateSalesAction().execute(req,res);} catch (Exception e) {}
			break;
		case "deleteSales.do":
			try {forward = new DeleteSalesAction().execute(req,res);} catch (Exception e) {}
			break;
		case "goInsertSales.do":
			try {forward = new GoInsertSalesAction().execute(req,res);} catch (Exception e) {}
			break; 
			
		// 아이템
		case "regItem.do":
			try { forward = new regItemAction().execute(req, res);} catch (Exception e) {}
			break;
		case "listItem.do":
			try { forward = new ViewItemAction().execute(req, res);} catch (Exception e) {}
			break;
		case "modifyPageItem.do":
			try { forward = new ModifyPageItemAction().execute(req, res);} catch (Exception e) {}
			break;
		case "modifyItem.do" :
			try { forward = new ModifyItemAction().execute(req, res);} catch (Exception e) {}
			break;
		case "deleteItem.do" :
			try { forward = new DeleteItemAction().execute(req, res);} catch (Exception e) {}
			break;
			
		//창고
		case "regWare.do":
			try{ forward = new RegWareAction().execute(req, res); } catch (Exception e) {}
			break;
		case "listWare.do":
			try{ forward = new ViewWareAction().execute(req, res); } catch (Exception e) {}
			break;
		case "modifyPageWare.do":
			try { forward = new ModifyPageWareAction().execute(req, res);} catch (Exception e) {}
			break;
		case "modifyWare.do" :
			try { forward = new ModifyWareAction().execute(req, res);} catch (Exception e) {}
			break;
		case "deleteWare.do" :
			try { forward = new DeleteWareAction().execute(req, res);} catch (Exception e) {}
			break;
		case "goUpdateWare.do":
			try {forward = new GoUpdateWareAction().execute(req,res);} catch (Exception e) {}
			break;
		case "goInsertWare.do":
			try {forward = new GoInsertWareAction().execute(req,res);} catch (Exception e) {}
			break;
		
		// 거래처
		case "regAccount.do":
			try { forward = new regAccountAction().execute(req, res);} catch (Exception e) {}
			break;
		case "viewAC.do":
			try { forward = new ViewAccountAction().execute(req, res);} catch (Exception e) {}
			break;
		case "modifyAccountpage.do":
			try { forward = new ModifyPageAccountAction().execute(req, res);} catch (Exception e) {}
			break;
		case "modifyAccount.do" :
			try { forward = new ModifyAccountAction().execute(req, res);} catch (Exception e) {}
			break;
		case "deleteAccount.do" :
			try { forward = new DeleteAccountAction().execute(req, res);} catch (Exception e) {}
			break;
			
		// 주문
		case "regOrder.do":
			try { forward = new regOrderAction().execute(req, res);} catch (Exception e) {}
			break;
		case "goRegOrder.do":
			try { forward = new GoinsertOrderAction().execute(req, res);} catch (Exception e) {}
			break;
		case "goModifyOrder.do":
			try { forward = new GoUpdateOrderAction().execute(req, res);} catch (Exception e) {}
			break;
		case "viewOrder.do":
			try { forward = new ViewOrderAction().execute(req, res);} catch (Exception e) {}
			break;
		case "modifyOrder.do" :
			try { forward = new ModifyOrderAction().execute(req, res);} catch (Exception e) {}
			break;
		case "deleteOrder.do" :
			try { forward = new DeleteOrderAction().execute(req, res);} catch (Exception e) {}
			break;
		case "searchOrder.do":
			try {forward = new SearchOrderAction().execute(req,res);} catch (Exception e) {}
			break;
		
		// 구매
		case "regBuy.do":
			try { forward = new regBuyAction().execute(req, res);} catch (Exception e) {}
			break;
		case "goUpdateBuy.do":
			try { forward = new GoUpdateBuyAction().execute(req, res);} catch (Exception e) {}
			break;
		case "goInsertBuy.do":
			try { forward = new GoinsertBuyAction().execute(req, res);} catch (Exception e) {}
			break;
		case "viewBuy.do":
			try { forward = new ViewBuyAction().execute(req, res);} catch (Exception e) {}
			break;
		case "modifyBuy.do" :
			try { forward = new ModifyBuyAction().execute(req, res);} catch (Exception e) {}
			break;
		case "deleteBuy.do" :
			try { forward = new DeleteBuyAction().execute(req, res);} catch (Exception e) {}
			break;	
		case "searchBuy.do":
			try {forward = new SearchBuyAction().execute(req,res);} catch (Exception e) {}
			break;
			
		// 불량
		case "regPoor.do":
			try{ forward = new RegPoorAction().execute(req, res); } catch (Exception e) {}
			break;
		case "poorListView.do":
			try{ forward = new ViewPoorAction().execute(req, res); } catch (Exception e) {}
			break;
		case "modifyPoor.do":
			try{ forward = new ModifyPoorAction().execute(req, res); } catch (Exception e) {}
			break;
		case "deletePoor.do":
			try{ forward = new DeletePoorAction().execute(req, res); } catch (Exception e) {}
			break;
		case "goUpdatePoor.do":
			try {forward = new GoUpdatePoorAction().execute(req,res);} catch (Exception e) {}
			break;
		case "goInsertPoor.do":
			try {forward = new GoInsertPoorAction().execute(req,res);} catch (Exception e) {}
			break;
		
		// 작업
		case "regWork.do":
			try{ forward = new RegWorkAction().execute(req, res); } catch (Exception e) {}
			break;
		case "workListView.do":
			try{ forward = new ViewWorkAction().execute(req, res); } catch (Exception e) {}
			break;
		case "modifyWork.do":
			try{ forward = new ModifyWorkAction().execute(req, res); } catch (Exception e) {}
			break;
		case "deleteWork.do":
			try{ forward = new DeleteWorkAction().execute(req, res); } catch (Exception e) {}
			break;
		case "goUpdateWork.do":
			try {forward = new GoUpdateWorkAction().execute(req,res);} catch (Exception e) {}
			break;
		case "goInsertWork.do":
			try {forward = new GoInsertWorkAction().execute(req,res);} catch (Exception e) {}
			break;
		
		// 생산	
		case "regPro.do":
			try{ forward = new RegProAction().execute(req, res); } catch (Exception e) {}
			break;
		case "proListView.do":
			try{ forward = new ViewProAction().execute(req, res); } catch (Exception e) {}
			break;
		case "modifyPro.do":
			try{ forward = new ModifyProAction().execute(req, res); } catch (Exception e) {}
			break;
		case "deletePro.do":
			try{ forward = new DeleteProAction().execute(req, res); } catch (Exception e) {}
			break;	
		case "goUpdatePro.do":
			try {forward = new GoUpdateProAction().execute(req,res);} catch (Exception e) {}
			break;
		case "goInsertPro.do":
			try {forward = new GoInsertProAction().execute(req,res);} catch (Exception e) {}
			break;
			
		default:
			forward = new ActionForward(); forward.setNextPath("./index.jsp");
		}
		
		
		if(forward != null) {
			if(forward.isRedirect()) {
				res.sendRedirect(forward.getNextPath());
			} else {
				RequestDispatcher dispatcher = req.getRequestDispatcher(forward.getNextPath());
				dispatcher.forward(req, res);
			}
		}
		
	}
	

}
