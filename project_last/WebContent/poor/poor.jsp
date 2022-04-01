<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.lec.item.IMVO"%>
<%@page import="com.lec.work.WorkVO"%>
<%@page import="java.util.List"%>
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
	List<WorkVO> worklist = (List<WorkVO>) request.getAttribute("worklist");
%>
	<form action="/regPoor.do" method="post">
		<div class="container">
			<div class="row">
				<div class="col text-center">
					<h1>불량등록</h1>
				</div>
			</div>
		</div>
		<table class="mx-auto table" style="text-align: center;">
			<tr>
				<th width="20%" class="align-middle">생산코드</th>
				<select class="form-select" name="work_code" aria-label="work_code">
					  <option selected>등록할 작업명을 선택해주세요.</option>
					  <c:forEach items="<%= worklist %>" var="work">
					  	<option value="${work.getWork_code()}">${work.getItem_name()}(${work.getWork_code()})</option>
					  </c:forEach>
				</select>
			</tr>
			<tr>
				<th class="align-middle">품목코드</th>
				<select class="form-select" name="item_code" aria-label="item_code">
					  <option selected>등록할 제품명을 선택해주세요.</option>
					  <c:forEach items="<%= itemlist %>" var="item">
					  	<option value="${item.getItem_code()},${item.getItem_name()}">${item.getItem_name()}(${item.getItem_code()})</option>
					  </c:forEach>
				</select>
			</tr>
			<tr>
				<th class="align-middle">불량수량</th>
				<td><input name="poor_count" class="form-control"></td>
			</tr>
			<tr>
				<th class="align-middle">불량구분</th>
				<td><input name="bool_poor" class="form-control"></td>
			</tr>
		</table>
		<div class="container">
			<div class="row">
				<div class="col text-center">
					<input type="submit" class="btn btn-primary" value="등록" />
					<a class="btn btn-primary text-lg-end" href="/poorListView.do">돌아가기</a>
				</div>
			</div>
		</div>
	</form>
</body>
</html>