<%@page import="com.lec.poor.PoorVO"%>
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
	<% List<PoorVO> poorlist = (List<PoorVO>)request.getAttribute("poorlist"); %>
	<h1 style="text-align: center;">불량</h1>
	<table class="mx-auto table">
		<tr>
			<th>생산코드</th>
			<th>품목코드</th>
			<th>불량수량</th>
			<th>불량여부</th>
			<th>수정</th>
		</tr>
		<c:if test="<%= poorlist.isEmpty() == false%>">
			<c:forEach items="<%= poorlist%>" var="poor">
				<tr>
					<td>
					${poor.getPro_code()}
					</td>
					<td>${poor.getItem_code()}</td>
					<td>${poor.getPoor_count()}</td>
					<td>${poor.getBool_poor()}</td>
					<td>
					<form action="/goUpdatePoor.do" method="post">
						<input type="hidden" name="pro_code" value="${poor.getPro_code()}" />
						<input type="hidden" name="item_code" value="${poor.getItem_code()}" />
						<input type="hidden" name="poor_count" value="${poor.getPoor_count()}" />
						<input type="hidden" name="bool_poor" value="${poor.getBool_poor()}" />
						<input type="submit" value="수정" />
					</form></td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	<div class="container">
		<div class="row">
			<div class="col text-center">
				<a class="btn btn-primary" href="/goInsertPoor.do">등록</a>
				<a class="btn btn-primary" href="index.jsp">돌아가기</a>
			</div>
		</div>
	</div>

</body>
</html>