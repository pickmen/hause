<%@page import="com.lec.work.WorkVO"%>
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
	<% List<WorkVO> worklist = (List<WorkVO>)request.getAttribute("worklist"); %>
	<h1 style="text-align: center;">불량</h1>
	<table class="mx-auto table">
		<tr>
			<th>작업코드</th>
			<th>품목코드</th>
			<th>품목명</th>
			<th>작업수량</th>
			<th>작업시간</th>
			<th>수정</th>
		</tr>
		<c:if test="<%= worklist.isEmpty() == false%>">
			<c:forEach items="<%= worklist%>" var="work">
				<tr>
					<td>
					${work.getWork_code()}
					</td>
					<td>${work.getItem_code()}</td>
					<td>${work.getItem_name()}</td>
					<td>${work.getWork_count()}</td>
					<td>${work.getWork_time()}</td>
					<td>
					<form action="/goUpdateWork.do" method="post">
						<input type="hidden" name="work_code" value="${work.getWork_code()}" />
						<input type="hidden" name="item_code" value="${work.getItem_code()}" />
						<input type="hidden" name="item_name" value="${work.getItem_name()}" />
						<input type="hidden" name="work_count" value="${work.getWork_count()}" />
						<input type="hidden" name="work_time" value="${work.getWork_time()}" />
						<input type="submit" value="수정" />
					</form></td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	<div class="container">
		<div class="row">
			<div class="col text-center">
				<a class="btn btn-primary" href="/goInsertWork.do">등록</a>
				<a class="btn btn-primary" href="index.jsp">돌아가기</a>
			</div>
		</div>
	</div>


</body>
</html>