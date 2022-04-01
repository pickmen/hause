<%@page import="com.lec.account.ACVO"%>
<%@page import="com.lec.ware.WareVO"%>
<%@page import="java.util.List"%>
<%@page import="com.lec.product.ProVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
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

<% List<ProVO> prolist = (List<ProVO>)request.getAttribute("prolist"); 
List<ACVO> accountlist = (List<ACVO>)request.getAttribute("accountlist");%>
	
	<form action="/modifyWare.do" method="post">
		
	<table>
		<tr>
			<th>창고코드 : </th>
			<td> <input name="ware_code" id="ware_code" value="<%= request.getParameter("ware_code") %>" readonly><br> </td>
		</tr>
		<tr>
			<th>창고명 : </th>
			<td> <input name="ware_name" value="<%= request.getParameter("ware_name") %>"><br></td>
		</tr>
		<tr>
			<th>창고구분 : </th>
			<td> <input name="ware_type" value="<%= request.getParameter("ware_type" ) %>"> </td>
		</tr>
		<tr>	
			<th>생산공정코드 : </th>
			<td> 
			<select class="form-select" name="pro_code" aria-label="prt_pro_code">
			   <c:set value='<%=request.getParameter("pro_code")%>' var="now_code"></c:set>
			   <c:forEach items="<%= prolist %>" var="pro">
				   	<c:choose>
				  		<c:when test="${pro.getPro_code() == now_code}">
				  			<option selected value="${pro.getPro_code()}">(${pro.getPro_code()})</option>
				  		</c:when>
				  		<c:otherwise>
				  			<option value="${pro.getPro_code()}">(${pro.getPro_code()})</option>
				  		</c:otherwise>
			  		</c:choose>
		  		</c:forEach>
			</select>
			  
			<br> </td>
		</tr>
		<tr>	
			<th>외주거래처코드 : </th>
			<td> <select class="form-select" name="account_code" aria-label="prt_ac_code">
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
			<br> </td>
		</tr>	
	</table>	
	
		<input type="submit" value="수정">
		
		<input type="button"  value="삭제" id="delete"/>
		<a href="/listWare.do">돌아가기</a>
	</form>

	
	
	<script type="text/javascript">
		$("#delete").click(function() {
			if(confirm("삭제하시겠습니까?")){
				location.href = "/deleteWare.do?ware_code="+document.getElementById("ware_code").value
			}
		});
		
	</script>
	
</body>
</html>