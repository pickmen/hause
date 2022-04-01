<%@page import="com.lec.bom.BomVO"%>
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
	<% List<BomVO> bomlist = (List<BomVO>)request.getAttribute("bomlist"); %>
	<h1 style="text-align: center;">BOM</h1>
	<table class="mx-auto table">
		<tr>
			<th>품목코드</th>
			<th>품목명</th>
			<th>필요수량</th>
			<th>부모제품코드</th>
			<th>수정</th>
		</tr>
		<c:if test="<%= bomlist.isEmpty() == false%>">
			<c:forEach items="<%= bomlist%>" var="bom">
				<tr>
					<td>
					${bom.getItem_code()}
					</td>
					<td>${bom.getItem_name()}</td>
					<td>${bom.getItem_cnt()}</td>
					<td>${bom.getPrt_item_code()}</td>
					<td>
					<form action="/goUpdateBOM.do" method="post">
						<input type="hidden" name="item_code" value="${bom.getItem_code()}" />
						<input type="hidden" name="item_name" value="${bom.getItem_name()}" />
						<input type="hidden" name="item_cnt" value="${bom.getItem_cnt()}" />
						<input type="hidden" name="prt_item_code" value="${bom.getPrt_item_code()}" />
						<input type="submit" value="수정" />
					</form></td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	<div class="container">
		<div class="row">
			<div class="col text-center">
				<a class="btn btn-primary" href="/goInsertBOM.do">등록</a>
				<a class="btn btn-primary" href="index.jsp">돌아가기</a>
			</div>
		</div>
	</div>
	
</body>
</html>