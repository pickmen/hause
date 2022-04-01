<%@page import="com.lec.account.ACVO"%>
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


<form action="/modifyAccount.do" method="post">
	
		코드 : 
		<input name="account_code" id="account_code" value="<%= request.getParameter("account_code") %>" readonly><br>
		이름 :
		<input name="account_name" value="<%= request.getParameter("account_name") %>"><br>
		대표자 :
		<input name="account_ceo" value="<%= request.getParameter("account_ceo") %>"><br>
		번호 :
		<input name="account_tell" value="<%= request.getParameter("account_tell") %>"><br>
		타입 :
		
		<select class="form-select" name="account_type" aria-label="account_type">
		 <c:set value='<%=request.getParameter("account_type")%>' var="now_type"></c:set>	
		  <option selected>거래처 타입 선택</option>
		  <option value="sale">판매처</option>
		  <option value="buy">구매처</option>
		  <option value="sale/buy">판매/구매처</option>
		</select>

		<input type="submit" value="수정">
		<input type="button"  value="삭제" id="delete"/>
		<a href="/viewAC.do">돌아가기</a>
		
	</form>
	<script type="text/javascript">
		$("#delete").click(function() {
			if(confirm("삭제하시겠습니까?")){
				location.href = "/deleteAccount.do?account_code="+document.getElementById("account_code").value
			}
		});
		
	</script>
</body>
</html>