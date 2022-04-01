<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.lec.work.WorkVO"%>
<%@page import="com.lec.item.IMVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta charset="UTF-8">
     <meta name="viewport" content="width=device-width, initial-scale=1">
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
     <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
     <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>   
</head>
<body>
	<% 
	List<WorkVO> worklist = (List<WorkVO>)request.getAttribute("worklist"); 
	List<IMVO> itemlist = (List<IMVO>) request.getAttribute("itemlist");
	%>
	
	<form action="/regWork.do" method="post">
		<div class="container">
			<div class="row">
				<div class="col text-center">
					<h1>작업등록</h1>
				</div>
			</div>
		</div>
		<table class="mx-auto table" style="text-align: center;">
			<tr>
				<th width="20%" class="align-middle">품목코드</th>
				<td>
					<select class="form-select" name="item_code" aria-label="item_code">
					  <option selected>등록할 제품명을 선택해주세요.</option>
					  <c:forEach items="<%= itemlist %>" var="item">
					  	<option value="${item.getItem_code()},,${item.getItem_name()}">${item.getItem_name()}(${item.getItem_code()})</option>
					  </c:forEach>
					</select>
				</td>
			</tr>
			<!-- <tr>
				<th class="align-middle">품목코드</th>
				<td><input name="item_code" class="form-control"></td>
			</tr> -->
			<tr>
				<th class="align-middle">품목명</th>
				<td><input name="item_name" class="form-control"></td>
			</tr>
			<tr>
				<th class="align-middle">작업수량</th>
				<td><input name="work_count" class="form-control"></td>
			</tr>
			<tr>
				<th class="align-middle">작업시간</th>
				<td><input type="date" name="work_time" class="form-control"></td>
			</tr>
			<tr>
				<th class="align-middle">작업코드</th>
				<td><input name="work_code" class="form-control"></td>
			</tr>
		</table>
		<div class="container">
			<div class="row">
				<div class="col text-center">
					<input type="submit" class="btn btn-primary" value="등록" />
					<a class="btn btn-primary text-lg-end" href="workListView.do">돌아가기</a>
				</div>
			</div>
		</div>
	</form>
</body>
</html>