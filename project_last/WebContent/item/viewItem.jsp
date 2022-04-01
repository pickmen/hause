<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.web.PageInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="com.lec.item.IMVO"%>
<%
PageInfo pageInfo = (PageInfo) request.getAttribute("pageInfo");
ArrayList<IMVO> itemlist = (ArrayList<IMVO>) request.getAttribute("itemlist");

int curPage = pageInfo.getPage();
int totalPage = pageInfo.getTotalPage();
int startPage = pageInfo.getStartPage();
int endPage = pageInfo.getEndPage();
%>
<c:set var="itemlist" value="${itemlist}"/>
<c:set var="curPage" value="<%=curPage%>"/>
<c:set var="totalPage" value="<%=totalPage%>"/>
<c:set var="startPage" value="<%=startPage%>"/>
<c:set var="endPage" value="<%=endPage%>"/>
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
<%
	//List<IMVO> itemlist = (List<IMVO>)request.getAttribute("itemlist");
%>
<table>
	<tr>
		<th>코드</th>
		<th>이름</th>
		<th>원가</th>
		<th>가격</th>
		<th>타입</th>
		<th>설명</th>
		<th>수정</th>
	</tr>
	<c:forEach items="<%=itemlist %>" var="item">
		<tr>
			<td>${item.getItem_code()}</td>
			<td>${item.getItem_name()}</td>
			<td>${item.getItem_cost()}</td>
			<td>${item.getItem_price()}</td>
			<td>${item.getItem_type()}</td>
			<td>${item.getItem_comment()}</td>
				
		<td>
			<form action="/item/modifyItemPage.jsp" method="post">
					<input type="hidden" name="item_code" value="${item.getItem_code()}" />
					<input type="hidden" name="item_name" value="${item.getItem_name()}" />
					<input type="hidden" name="item_cost" value="${item.getItem_cost()}" />
					<input type="hidden" name="item_price" value="${item.getItem_price()}" />
					<input type="hidden" name="item_type" value="${item.getItem_type()}" />
					<input type="hidden" name="item_comment" value="${item.getItem_comment()}" />
					<input type="submit" value="수정" />
		</form></td>
			
		</tr>
	</c:forEach>
	<td><a href="/index.jsp">처음으로</a></td>
	<td><a href="/item/regItem.jsp" >품목등록</a> </td>
</table>
<div class="container">
		<ul class="pagination justify-content-center">
			
				<c:if test="${startPage != 1 }">
					<li class="page-item"><a href="listItem.do?page=1" class="page-link"><i class="fas fa-fast-backward"></i></a></item></li>
					<li class="page-item"><a href="listItem.do?page=${startPage-10 }" class="page-link"><i class="fas fa-backward"></i></a></item></li>
				</c:if>
			
				<c:forEach var="page_num" begin="${startPage}" end="${endPage}">
					<li class="page-item"><a href="listItem.do?page=${page_num}" class="page-link">${page_num}</a></item></li>
				</c:forEach>
		
				
				<c:if test="${endPage < totalPage }">
					<li class="page-item"><a href="listItem.do?page=${endPage + 1}" class="page-link"><i class="fas fa-forward"></i></a></item></li>
					<li class="page-item"><a href="listItem.do?page=${totalPage }" class="page-link"><i class="fas fa-fast-forward"></i></a></item></li>
				</c:if>
			
		</ul>
	</div>
</body>
</html>