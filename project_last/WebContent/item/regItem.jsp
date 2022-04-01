<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="/regItem.do" method="post">
	
		코드 : 
		<input name="item_code"><br>
		이름 :
		<input name="item_name"><br>
		원가 :
		<input name="item_cost"><br>
		가격 :
		<input name="item_price"><br>
		구분 :
		<select class="form-select" name="item_type" aria-label="item_type">
		  <option selected>제품 타입 선택</option>
		  <option value="material">원재료</option>
		  <option value="subsidiary_materials">부자재</option>
		  <option value="part">부품</option>
		  <option value="half-finished">반제품</option>
		  <option value="product">완제품</option>
		</select><br>

		설명 :
		<input name="item_comment"><br>
		<input type="submit" value="등록">
	</form>
	<a href="/index.jsp">처음으로</a>
	<a href="/listItem.do" >목록보기</a> 
</body>
</html>