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
	List<WareVO> warelist = (List<WareVO>) request.getAttribute("warelist");
%>
	<form action="/updateIV.do" id="update_form" method="post">
		<div class="container">
			<div class="row">
				<div class="col text-center">
					<h1>재고수정</h1>
				</div>
			</div>
		</div>
		<table class="mx-auto table" style="text-align: center;">
			<tr>
				<th width="20%" class="align-middle">품목코드</th>
				<td><input name="item_code" class="form-control" readonly="readonly" value="<%= request.getParameter("item_code")%>"></td>
			</tr>
			<tr>
				<th class="align-middle">품목명</th>
				<td><input name="item_name" class="form-control" readonly="readonly" value="<%= request.getParameter("item_name")%>"></td>
			</tr>
			<tr>
				<th class="align-middle">창고코드</th>
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
				<%-- <td><input name="ware_code" class="form-control" value="<%= request.getParameter("ware_code")%>"></td> --%>
			</tr>
			<tr>
				<th class="align-middle">수량</th>
				<td><input type="number" name="inven_cnt" class="form-control" value="<%= Integer.parseInt(request.getParameter("inven_cnt"))%>"></td>
			</tr> 
		</table>
		</form>
		<div class="container">
			<div class="row">
				<div class="col text-center">
					<form action="deleteIV.do" method="post" id="delete_form">
						<input type="hidden" name="item_code" value="<%= request.getParameter("item_code")%>" />
						<input type="hidden" name="item_name" value="<%= request.getParameter("item_name")%>" />
						<input type="hidden" name="ware_code" value="<%= request.getParameter("ware_code")%>" />
						<input type="hidden" name="inven_cnt" value="<%= Integer.parseInt(request.getParameter("inven_cnt"))%>" />
						<input type="button" class="btn btn-primary pull-right" value="수정" id="update" />
						<input class="btn btn-danger" type="button" value="삭제" id="delete" />
						<a class="btn btn-primary text-lg-end" href="/IVlistView.do">돌아가기</a>
					</form>
				</div>
			</div>
		</div>
		
		
		
	
	<script type="text/javascript">
		$("#delete").click(function() {
			if(confirm("삭제하시겠습니까?")) {
				document.getElementById("delete_form").submit();
			};
		});
		$("#update").click(function() {
			document.getElementById("update_form").submit();
		});
	</script>
</body>
</html>