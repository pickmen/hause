<%@page import="com.lec.sales.SalesVO"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>	<title></title>
	<title></title>
</head>
<body>
	<% List<SalesVO> saleslist = (List<SalesVO>)request.getAttribute("saleslist"); %>
	<h1>판매</h1>
	<table class="mx-auto table">
		<tr>
			<th>판매코드</th>
			<th>거래처코드</th>
			<th>품목코드</th>
			<th>품목명</th>
			<th>판매일</th>
			<th>판매수량</th>
			<th>판매금액</th>
			<th>단가</th>
			<th>창고코드</th>
			<th>수정</th>
		</tr>
		<c:if test="<%= saleslist.isEmpty() == false%>">
			<c:forEach items="<%= saleslist%>" var="sales">
				<tr>
					<td>${sales.getSale_code()}</td>
					<td>${sales.getAccount_code()}</td>
					<td>${sales.getItem_code()}</td>
					<td>${sales.getItem_name()}</td>
					<td>${sales.getSale_date()}</td>
					<td>${sales.getSale_cnt()}</td>
					<td>${sales.getSale_price()}</td>
					<td>${sales.getSale_cost()}</td>
					<td>${sales.getWare_code()}</td>
					<td>
					<form action="/goUpdateSales.do" method="post">
						<input type="hidden" name="sale_code" value="${sales.getSale_code()}" />
						<input type="hidden" name="account_code" value="${sales.getAccount_code()}" />
						<input type="hidden" name="item_code" value="${sales.getItem_code()}" />
						<input type="hidden" name="item_name" value="${sales.getItem_name()}" />
						<input type="hidden" name="sale_date" value="${sales.getSale_date()}" />
						<input type="hidden" name="sale_cnt" value="${sales.getSale_cnt()}" />
						<input type="hidden" name="sale_price" value="${sales.getSale_price()}" />
						<input type="hidden" name="sale_cost" value="${sales.getSale_cost()}" />
						<input type="hidden" name="ware_code" value="${sales.getWare_code()}" />
						<input type="submit" value="수정" />
					</form></td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	<div class="container">
		<div class="row">
			<div class="col text-center">
				<a class="btn btn-primary" href="/goInsertSales.do">등록</a>
				<a class="btn btn-primary" href="index.jsp">돌아가기</a>
			</div>
		</div>
	</div>
	
	
</body>
</html>