<%@page import="com.lec.inventory.IVVO"%>
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
<% 
	List<IVVO> IVlist = (List<IVVO>) request.getAttribute("IVlist"); 
%>
	<h1>IV</h1>
	<form action="/searchIV.do" method="post">
	<div class="container px-0">
		<div class="row col-12">
			<div class="col-6">
			</div>
			<div class="col-2">
				<select class="form-select" name="search_type">
					  <option selected value="item_name">품목명</option>
					  <option value="item_code">품목코드</option>
					  <option value="ware_code">창고코드</option>
				</select>
			</div>
			<div class="col-3 px-0">
				<input type="text" class="form-control mx-0" name="search_text" placeholder="검색..."/>
			</div>
			<div class="col-1">
				<input type="submit" class="btn btn-primary" value="검색"/>
			</div>
		</div>
	</div>
	</form>
	<table class="mx-auto table">
		<tr>
			<th>품목코드</th>
			<th>품목명</th>
			<th>창고코드</th>
			<th>품목개수</th>
			<th>수정</th>
		</tr>
		<c:choose>
		<c:when test="<%= IVlist.isEmpty() == false%>">
			<c:forEach items="<%= IVlist%>" var="IV">
				<tr>
					<td>${IV.getItem_code()}</td>
					<td>${IV.getItem_name()}</td>
					<td>${IV.getWare_code()}</td>
					<td>${IV.getInven_cnt()}</td>
					<td>
					<form action="/goUpdateIV.do" method="post">
						<input type="hidden" name="item_code" value="${IV.getItem_code()}" />
						<input type="hidden" name="item_name" value="${IV.getItem_name()}" />
						<input type="hidden" name="ware_code" value="${IV.getWare_code()}" />
						<input type="hidden" name="inven_cnt" value="${IV.getInven_cnt()}" />
						<input type="submit" value="수정" />
					</form></td>
				</tr>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<tr>
				<td rowspan="5"><h3 class="text-danger">검색된 내용이 없습니다!!</h3></td>
			</tr>
		</c:otherwise>
		</c:choose>
	</table>
	<div class="container">
		<div class="row">
			<div class="col text-center">
				<a class="btn btn-primary" href="/goInsertIV.do">등록</a>
				<a class="btn btn-primary" href="index.jsp">돌아가기</a>
				<a class="btn btn-primary" href="/IVlistView.do">전체보기</a>
			</div>
		</div>
	</div>
	
</body>
</html>