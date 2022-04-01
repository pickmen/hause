<%@page import="com.lec.item.IMVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<%-- <% IMVO item = (IMVO) request.getAttribute("item"); %> --%>
	
	
	<form action="/modifyItem.do" method="post">
		
			제품코드 : 
			<input name="item_code" id="item_code" value="<%= request.getParameter("item_code") %>" readonly><br>
			제품 :
			<input name="item_name" value="<%= request.getParameter("item_name") %>"><br>
			원가 :
			<input name="item_cost" value="<%= request.getParameter("item_cost") %>"><br>
			공급가 :
			<input name="item_price" value="<%= request.getParameter("item_price") %>"><br>
			구분 :
			
			<select class="form-select" name="item_type" aria-label="item_type">
				 <c:set value='<%=request.getParameter("item_type")%>' var="now_type"></c:set>	
				  <option selected>제품 타입 선택</option>
				  <option value="material">원재료</option>
				  <option value="subsidiary_materials">부자재</option>
				  <option value="part">부품</option>
				  <option value="half-finished">반제품</option>
				  <option value="product">완제품</option>
			</select><br>
			설명 :
			<input name="item_comment" value="<%= request.getParameter("item_comment") %>"><br>
			
			<input type="submit" value="수정">
			<input type="button"  value="삭제" id="delete"/>
			<a href="/listItem.do">돌아가기</a>
		</form>
		<script type="text/javascript">
			$("#delete").click(function() {
				if(confirm("삭제하시겠습니까?")){
					location.href = "/deleteItem.do?item_code="+document.getElementById("item_code").value
				}
			});
			
		</script>
	
</body>
</html>