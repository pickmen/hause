<%@page import="com.lec.product.ProVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<% List<ProVO> prolist = (List<ProVO>)request.getAttribute("prolist"); %>
	<h1 style="text-align: center;">생산</h1>
	<table class="mx-auto table">
		<tr>
			<th>생산코드</th>
			<th>품목코드</th>
			<th>품목명</th>
			<th>생산수량</th>
			<th>완료여부</th>
			<th>출고창고코드</th>
			<th>입고창고코드</th>
			<th>수정</th>
		</tr>
		<c:if test="<%= prolist.isEmpty() == false%>">
			<c:forEach items="<%= prolist%>" var="pro">
				<tr>
					<td>
					${pro.getPro_code()}
					</td>
					<td>${pro.getItem_code()}</td>
					<td>${pro.getItem_name()}</td>
					<td>${pro.getPro_count()}</td>
					<td>${pro.getComplete()}</td>
					<td>${pro.getOutware_code()}</td>
					<td>${pro.getInware_code()}</td>
					<td>
					<form action="/goUpdatePro.do" method="post">
						<input type="hidden" name="pro_code" value="${pro.getPro_code()}" />
						<input type="hidden" name="item_code" value="${pro.getItem_code()}" />
						<input type="hidden" name="item_name" value="${pro.getItem_name()}" />
						<input type="hidden" name="pro_count" value="${pro.getPro_count()}" />
						<input type="hidden" name="complete" value="${pro.getComplete()}" />
						<input type="hidden" name="outware_code" value="${pro.getOutware_code()}" />
						<input type="hidden" name="inware_code" value="${pro.getInware_code()}" />
						<input type="submit" value="수정" />
					</form></td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	<div class="container">
		<div class="row">
			<div class="col text-center">
				<a class="btn btn-primary" href="/goInsertPro.do">등록</a>
				<a class="btn btn-primary" href="index.jsp">돌아가기</a>
			</div>
		</div>
	</div>

</body>
</html>