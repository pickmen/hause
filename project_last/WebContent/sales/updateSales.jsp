<%@page import="com.lec.account.ACVO"%>
<%@page import="com.lec.ware.WareVO"%>
<%@page import="com.lec.item.IMVO"%>
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
	List<IMVO> itemlist = (List<IMVO>) request.getAttribute("itemlist");
	List<WareVO> warelist = (List<WareVO>) request.getAttribute("warelist");
	List<ACVO> accountlist = (List<ACVO>) request.getAttribute("accountlist");
%>
	<form action="/updateSales.do" method="post">
		<div class="container">
			<div class="row">
				<div class="col text-center">
					<h1>판매수정</h1>
				</div>
			</div>
		</div>
		<table class="mx-auto table" style="text-align: center;">
			<tr>
				<th width="20%" class="align-middle">판매코드</th>
				<td><input name="sale_code" id="sale_code" class="form-control" readonly="readonly" value="<%= request.getParameter("sale_code")%>"></td>
			</tr>
			<tr>
				<th class="align-middle">거래처코드</th><%-- 
				<td><input name="account_code" class="form-control" value="<%= request.getParameter("account_code")%>"></td> --%>
				<td>
					<select class="form-select" name="account_code" aria-label="account_code">
					  <c:set value='<%=request.getParameter("account_code")%>' var="now_code"></c:set>
					  <c:forEach items="<%= accountlist %>" var="account">
					  	<c:choose>
					  		<c:when test="${account.getAccount_code() == now_code}">
					  			<option selected value="${account.getAccount_code()}">${account.getAccount_name()}(${account.getAccount_code()})</option>
					  		</c:when>
					  		<c:otherwise>
					  			<option value="${account.getAccount_code()}">${account.getAccount_name()}(${account.getAccount_code()})</option>
					  		</c:otherwise>
					  	</c:choose>
					  </c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<th class="align-middle">품목코드</th>
				<%-- <td><input name="item_code" class="form-control" value="<%= request.getParameter("item_code")%>"></td> --%>
				<td>
					<select class="form-select" name="item_code" aria-label="prt_item_code">
						  <c:set value='<%=request.getParameter("item_code")%>' var="now_code"></c:set>
						  <c:forEach items="<%= itemlist %>" var="item">
						  	<c:choose>
						  		<c:when test="${item.getItem_code() == now_code}">
						  			<option selected value="${item.getItem_code()},,${item.getItem_name()}">${item.getItem_name()}(${item.getItem_code()})</option>
						  		</c:when>
						  		<c:otherwise>
						  			<option value="${item.getItem_code()},,${item.getItem_name()}">${item.getItem_name()}(${item.getItem_code()})</option>
						  		</c:otherwise>
						  	</c:choose>
						  </c:forEach>
					</select>
				</td>
			</tr><%-- 
			<tr>
				<th class="align-middle">품목명</th>
				<td><input name="item_name" class="form-control" value="<%= request.getParameter("item_name")%>"></td>
			</tr> --%>
			<tr>
				<th class="align-middle">판매일</th>
				<td><input type="date" name="sale_date" class="form-control" value="<%= request.getParameter("sale_date")%>"></td>
			</tr>
			<tr>
				<th class="align-middle">판매수량</th>
				<td><input type="number" name="sale_cnt" class="form-control" value="<%= request.getParameter("sale_cnt")%>"></td>
			</tr>
			<%-- <tr>
				<th class="align-middle">판매금액</th>
				<td><input name="sale_price" class="form-control" value="<%= request.getParameter("sale_price")%>"></td>
			</tr> --%>
			<tr>
				<th class="align-middle">단가</th>
				<td><input name="sale_cost" class="form-control" value="<%= request.getParameter("sale_cost")%>"></td>
			</tr>
			<tr>
				<th class="align-middle">창고코드</th><%-- 
				<td><input name="ware_code" class="form-control" value="<%= request.getParameter("ware_code")%>"></td> --%>
				<td>
					<select class="form-select" name="ware_code" aria-label="ware_code">
					  <c:set value='<%=request.getParameter("ware_code")%>' var="now_code"></c:set>
					  <c:forEach items="<%= warelist %>" var="ware">
					  	<c:choose>
					  		<c:when test="${ware.getWare_code() == now_code}">
					  			<option selected value="${ware.getWare_code()}">${ware.getWare_name()}(${ware.getWare_code()})</option>
					  		</c:when>
					  		<c:otherwise>
					  			<option value="${ware.getWare_code()}">${ware.getWare_name()}(${ware.getWare_code()})</option>
					  		</c:otherwise>
					  	</c:choose>
					  </c:forEach>
					</select>
				</td>
			</tr>
		</table>
		<div class="container">
			<div class="row">
				<div class="col text-center">
					<input type="submit" class="btn btn-primary" value="수정" />
					<input type="button" class="btn btn-danger" id="delete" value="삭제" />
					<a class="btn btn-primary text-lg-end" href="/SaleslistView.do">돌아가기</a>
				</div>
			</div>
		</div>
	</form>
	<script type="text/javascript">
		$("#delete").click(function() {
			if(confirm("삭제하시겠습니까?")){
				location.href = "/deleteSales.do?sale_code="+document.getElementById("sale_code").value
			}
		});
	</script>
</body>
</html>