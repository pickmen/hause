<%@page import="com.lec.account.ACVO"%>
<%@page import="com.lec.item.IMVO"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<%
		List<ACVO> accountlist = (List<ACVO>)request.getAttribute("accountlist");
		List<IMVO> itemlist = (List<IMVO>)request.getAttribute("itemlist");
	%>
	<form action="/regOrder.do" method="post">
		<div class="container">
			<div class="row">
				<div class="col text-center">
					<h1>주문등록</h1>
				</div>
			</div>
		</div>
		<table class="mx-auto table" style="text-align: center;">
			<tr>
				<th width="20%" class="align-middle">주문코드</th>
				<td><input name="order_code" class="form-control"></td>
			</tr>
			<tr>
				<th class="align-middle">거래처코드</th>
				<!-- <td><input name="account_code" class="form-control"></td> -->
				<td>
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
				<!-- <td><input name="item_code" class="form-control"></td> -->
				<td>
					<select class="form-select" name="item_code" aria-label="item_code">
					  <option selected>등록할 제품명을 선택해주세요.</option>
					  <c:forEach items="<%= itemlist %>" var="item">
					  	<option value="${item.getItem_code()},,${item.getItem_name()}">${item.getItem_name()}(${item.getItem_code()})</option>
					  </c:forEach>
					</select>
				</td>
			</tr><!-- 
			<tr>
				<th class="align-middle">품목명</th>
				<td><input name="item_name" class="form-control"></td>
			</tr> -->
			<tr>
				<th class="align-middle">주문일자</th>
				<td><input type="date" name="order_date" class="form-control"></td>
			</tr>
			<tr>
				<th class="align-middle">주문수량</th>
				<td><input type="number" name="order_cnt" class="form-control"></td>
			</tr>
			<tr>
				<th class="align-middle">단가</th>
				<td><input type="number" name="order_cost" class="form-control"></td>
			</tr>
			<!-- <tr>
				<th class="align-middle">주문금액</th>
				<td><input type="number" name="order_price" class="form-control"></td>
			</tr> -->

		</table>
	<div class="container">
		<div class="row">
			<div class="col text-center">
				<input type="submit" class="btn btn-primary" value="등록" />
				<a class="btn btn-primary text-lg-end" href="/viewOrder.do">돌아가기</a>
			</div>
		</div>
	</div>
	</form>