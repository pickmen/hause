<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="/regAccount.do" method="post">
	
		코드 : 
		<input name="account_code"><br>
		이름 :
		<input name="account_name"><br>
		대표 :
		<input name="account_ceo"><br>
		번호 :
		<input name="account_tell"><br>
		구분 :
		
		<select class="form-select" name="account_type" aria-label="account_type">
		  <option selected>거래처 타입 선택</option>
		  <option value="sale">판매처</option>
		  <option value="buy">구매처</option>
		  <option value="asle/buy">판매/구매처</option>
		</select>
		
		<input type="submit" value="등록">
	</form>
	<a href="/index.jsp">처음으로</a>
	<a href="/viewAC.do">목록보기</a>
</body>
</html>