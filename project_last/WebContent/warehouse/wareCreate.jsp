<%@page import="com.lec.account.ACVO"%>
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
     <link rel="stylesheet" href="/jsp300_board/css/bootstrap.css">
    
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
     <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
     <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>  
<title>Insert title here</title>
</head>

<% List<ProVO> prolist = (List<ProVO>)request.getAttribute("prolist");
   List<ACVO> accountlist = (List<ACVO>)request.getAttribute("accountlist");
%>

	
	<form action="/regWare.do" method="post">
	
	<table>
		<tr>
			<th>창고코드 : </th>
			<td> <input name="ware_code"><br> </td>
		</tr>
		<tr>
			<th>창고명 : </th>
			<td> <input name="ware_name"><br> </td>
		</tr>
		<tr>
			<th>창고구분 : </th>
			<td> <input name="ware_type"><br> </td>
		</tr>
		<tr>	
			<th>생산공정코드 : </th>
			<td> 
			<select class="form-select" name="pro_code" aria-label="prt_pro_code">
			  <option selected>등록할 생산코드 선택해주세요.</option>
			  <c:forEach items="<%= prolist %>" var="pro">
			  	<option value="${pro.getPro_code()}">(${pro.getPro_code()})</option>
			  </c:forEach>
			</select>
			<br> </td>
		</tr>
		<tr>	
			<th>외주거래처코드 : </th>
			<td> <select class="form-select" name="account_code" aria-label=prt_ac_code>
			  <option selected>거래처 선택해주세요.</option>
			  <c:forEach items="<%= accountlist %>" var="account">
			  	<option value="${account.getAccount_code()}">${account.getAccount_name()}(${account.getAccount_code()})</option>
			  </c:forEach>
			</select>
			<br> </td>
			
		</tr>	
	</table>	
		
		<input type="submit" value="등록">
		<a href="/index.jsp">처음으로</a>			
		<a href="/listWare.do">목록보기</a>
					
	</form>
	

	

	
				
	
	
</body>
</html>