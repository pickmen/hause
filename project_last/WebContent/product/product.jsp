<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="com.lec.item.IMVO"%>
<%@page import="com.lec.ware.WareVO"%>
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
	List<IMVO> itemlist = (List<IMVO>) request.getAttribute("itemlist");
	List<WareVO> warelist = (List<WareVO>) request.getAttribute("warelist");
%>
	<form action="/regPro.do" method="post">
		<div class="container">
			<div class="row">
				<div class="col text-center">
					<h1>생산등록</h1>
				</div>
			</div>
		</div>
		<table class="mx-auto table" style="text-align: center;">
			<tr>
				<th width="20%" class="align-middle">생산코드</th>
				<td><input name="pro_code" class="form-control"></td>
			</tr>
			<tr>
				<th class="align-middle">품목코드</th>
				<<td>
					<select class="form-select" name="item_code" aria-label="item_code">
					  <option selected>등록할 제품명을 선택해주세요.</option>
					  <c:forEach items="<%= itemlist %>" var="item">
					  	<option value="${item.getItem_code()},,${item.getItem_name()}">${item.getItem_name()}(${item.getItem_code()})</option>
					  </c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<th class="align-middle">품목명</th>
				<td><input name="item_name" class="form-control"></td>
			</tr>
			<tr>
				<th class="align-middle">생산수량</th>
				<td><input name="pro_count" class="form-control"></td>
			</tr>
			<tr>
				<th class="align-middle">완료여부</th>
				<td><input name="complete" class="form-control"></td>
			</tr>
			<tr>
				<th class="align-middle">출고창고코드</th>
				<td>
					<select class="form-select" name="ware_code" aria-label="ware_code">
					  <option selected>등록할 창고명을 선택해주세요.</option>
					  <c:forEach items="<%= warelist %>" var="ware">
					  	<option value="${ware.getWare_code()}">${ware.getWare_name()}(${ware.getWare_code()})</option>
					  </c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<th class="align-middle">입고창고코드</th>
				<td>
					<select class="form-select" name="ware_code" aria-label="ware_code">
					  <option selected>등록할 창고명을 선택해주세요.</option>
					  <c:forEach items="<%= warelist %>" var="ware">
					  	<option value="${ware.getWare_code()}">${ware.getWare_name()}(${ware.getWare_code()})</option>
					  </c:forEach>
					</select>
				</td>
			</tr>
		</table>
		<div class="container">
			<div class="row">
				<div class="col text-center">
					<input type="submit" class="btn btn-primary" value="등록" />
					<a class="btn btn-primary text-lg-end" href="/proListView.do">돌아가기</a>
				</div>
			</div>
		</div>
	</form>
</body>
</html>