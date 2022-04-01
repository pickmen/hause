<%@page import="com.lec.ware.WareVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
 	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" 
		integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
		crossorigin="anonymous">    	
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>	

<title>Insert title here</title>
</head>
<body>
	<% List<WareVO> warelist = (List<WareVO>)request.getAttribute("warelist"); %>
	<table>
		<tr>
			<th>창고코드</th>
			<th>창고명</th>
			<th>창고구분</th>
			<th>생산공정코드</th>
			<th>외주거래처코드</th>
			<th>수정</th>
		</tr>
		<c:if test="<%= warelist.isEmpty() == false %>">
		<c:forEach items="<%= warelist %>" var="ware">
			<tr>
				
				<td>${ware.getWare_code()}</td>
				<td>${ware.getWare_name()}</td>
				<td>${ware.getWare_type()}</td>
				<td>${ware.getPro_code()}</td>
				<td>${ware.getAccount_code()}</td>
				
				
				<td>
				<form action="/goUpdateWare.do" method="post">
						<input type="hidden" name="ware_code" value="${ware.getWare_code()}" />
						<input type="hidden" name="ware_name" value="${ware.getWare_name()}" />
						<input type="hidden" name="ware_type" value="${ware.getWare_type()}" />
						<input type="hidden" name="pro_code" value="${ware.getPro_code()}" />
						<input type="hidden" name="account_code" value="${ware.getAccount_code()}" />
						<input type="submit" value="수정" />
				</form></td>
					
			</tr>
		</c:forEach>
		</c:if>
		<td><a href="/index.jsp">처음으로</a></td>
		<td><a href="goInsertWare.do" >창고등록</a> </td>
	</table>

</body>
</html>