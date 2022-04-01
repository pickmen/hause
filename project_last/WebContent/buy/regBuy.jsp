<%@page import="java.util.List"%>
<%@page import="com.lec.account.ACVO"%>
<%@page import="com.lec.ware.WareVO"%>
<%@page import="com.lec.item.IMVO"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% 
	List<IMVO> itemlist = (List<IMVO>) request.getAttribute("itemlist");
	List<WareVO> warelist = (List<WareVO>) request.getAttribute("warelist");
	List<ACVO> accountlist = (List<ACVO>) request.getAttribute("accountlist");
%>
	<form action="/regBuy.do" method="post">
		<div class="container">
			<div class="row">
				<div class="col text-center">
					<h1>구매등록</h1>
				</div>
			</div>
		</div>
		<table class="mx-auto table" style="text-align: center;">
			<tr>
				<th width="20%" class="align-middle">구매코드</th>
				<td><input name="buy_code" class="form-control"></td>
			</tr>
			<tr>
				<th class="align-middle">거래처코드</th>
<!-- 				<td><input name="account_code" class="form-control"></td>
 -->				<td>
						<select class="form-select" name="account_code" aria-label="account_code">
					  	<option selected>등록할 제품명을 선택해주세요.</option>
					  	<c:forEach items="<%= accountlist %>" var="account">
					  		<option value="${account.getAccount_code()}">${account.getAccount_name()}(${account.getAccount_code()})</option>
					  </c:forEach>
					</select>
				</td>
 			</tr>
			<tr>
				<th class="align-middle">품목코드</th>
<!-- 				<td><input name="item_code" class="form-control"></td>
 -->			
 				<td>
					<select class="form-select" name="item_code" aria-label="item_code">
					  <option selected>등록할 제품명을 선택해주세요.</option>
					  <c:forEach items="<%= itemlist %>" var="item">
					  	<option value="${item.getItem_code()},,${item.getItem_name()}">${item.getItem_name()}(${item.getItem_code()})</option>
					  </c:forEach>
					</select>
				</td>
 			</tr>
			<!-- <tr>
				<th class="align-middle">품목명</th>
				<td><input name="item_name" class="form-control"></td>
			</tr> -->
			<tr>
				<th class="align-middle">구매일</th>
				<td><input type = "date" name="buy_date" class="form-control"></td>
			</tr>
			<tr>
				<th class="align-middle">구매수량</th>
				<td><input type="number" name="buy_cnt" class="form-control"></td>
			</tr>
			 <tr>
				<th class="align-middle">단가</th>
				<td><input type="number" name="buy_cost" class="form-control"></td>
			</tr> 
			<!-- <tr>
				<th class="align-middle">구매금액</th>
				<td><input type="number" name="buy_price" class="form-control"></td>
			</tr> -->
			<tr>
						<th class="align-middle">창고코드</th>
				<!-- <td><input name="ware_code" class="form-control"></td> -->
				<td>
					<select class="form-select" name="ware_code" aria-label="ware_code">
					  <option selected>등록할 창고명을 선택해주세요.</option>
					  <c:forEach items="<%= warelist %>" var="ware">
					  	<option value="${ware.getWare_code()}">${ware.getWare_name()}(${ware.getWare_code()})</option>
					  </c:forEach>
					</select>
				</td>
			</tr>
		</table>
	<div class="container">
		<div class="row">
			<div class="col text-center">
				<input type="submit" class="btn btn-primary" value="등록" />
				<a class="btn btn-primary text-lg-end" href="/viewBuy.do">돌아가기</a>
			</div>
		</div>
	</div>
	</form>
