<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="com.lec.account.ACVO"%>
<!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	List<ACVO> accountlist = (List<ACVO>)request.getAttribute("accountlist"); %>


<table>
	<tr>
		<th>거래처코드</th>
		<th>거래처명</th>
		<th>대표자</th>
		<th>전화번호</th>
		<th>구분</th>
	</tr>
	<c:if test="<%= accountlist.isEmpty() == false %>">
	<c:forEach items="<%= accountlist%>" var="account">
		<tr>
			<td>${account.getAccount_code()}</td>
			<td>${account.getAccount_name()}</td>
			<td>${account.getAccount_ceo()}</td>
			<td>${account.getAccount_tell()}</td>
			<td>${account.getAccount_type()}</td>
		
		
		<td>
			<form action="/account/modifyAccountpage.jsp" method="post">
					<input type="hidden" name="account_code" value="${account.getAccount_code()}" />
					<input type="hidden" name="account_name" value="${account.getAccount_name()}" />
					<input type="hidden" name="account_ceo" value="${account.getAccount_ceo()}" />
					<input type="hidden" name="account_tell" value="${account.getAccount_tell()}" />
					<input type="hidden" name="account_type" value="${account.getAccount_type()}" />
					<input type="submit" value="수정" />
		</form></td>
		
		
		</tr>
	</c:forEach>
	</c:if>
	<td><a href="/index.jsp">처음으로</a></td>
	<td><a href="/account/regAccount.jsp">거래처등록</a></td>
</table>



</body>
</html>