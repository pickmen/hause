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
	<% List<IMVO> itemlist = (List<IMVO>)request.getAttribute("itemlist"); %>
	<form action="/updateBOM.do" method="post">
		<div class="container">
			<div class="row">
				<div class="col text-center">
					<h1>BOM수정</h1>
				</div>
			</div>
		</div>
		<table class="mx-auto table" style="text-align: center;">
			<tr>
				<th width="20%" class="align-middle">품목코드</th>
				<td><input id="item_code" name="item_code" class="form-control" readonly="readonly" value="<%= request.getParameter("item_code")%>"></td>
			</tr>
			<tr>
				<th class="align-middle">품목명</th>
				<td><input name="item_name" class="form-control" value="<%= request.getParameter("item_name")%>" readonly></td>
			</tr>
			<tr>
				<th class="align-middle">필요수량</th>
				<td><input type="number" name="item_cnt" class="form-control" value="<%= Integer.parseInt(request.getParameter("item_cnt"))%>"></td>
			</tr>
			<tr>
				<th class="align-middle">부모제품명(코드)</th>
				<td>
					<select class="form-select" name="prt_item_code" aria-label="prt_item_code">
					  <c:set value='<%=request.getParameter("prt_item_code")%>' var="now_code"></c:set>
					  <c:forEach items="<%= itemlist %>" var="item">
					  	<c:choose>
					  		<c:when test="${item.getItem_code() == now_code}">
					  			<option selected value="${item.getItem_code()}">${item.getItem_name()}(${item.getItem_code()})</option>
					  		</c:when>
					  		<c:otherwise>
					  			<option value="${item.getItem_code()}">${item.getItem_name()}(${item.getItem_code()})</option>
					  		</c:otherwise>
					  	</c:choose>
					  </c:forEach>
					</select>
				</td>
				<%-- <th class="align-middle">부모제품코드</th>
				<td><input name="prt_item_code" class="form-control" value="<%= request.getParameter("prt_item_code")%>"></td> --%>
			</tr> 
		</table>
	<div class="container">
		<div class="row">
			<div class="col text-center">
				<input type="submit" class="btn btn-primary" value="수정" />
				<input type="button" class="btn btn-danger" value="삭제" id="delete"/>
				<a class="btn btn-primary text-lg-end" href="/bomlistView.do">돌아가기</a>
			</div>
		</div>
	</div>
	</form>
	<script type="text/javascript">
		$("#delete").click(function() {
			if(confirm("삭제하시겠습니까?")){
				location.href = "/deleteBOM.do?item_code="+document.getElementById("item_code").value
			}
		});
	</script>
</body>
</html>