<%@page import="com.lec.work.WorkVO"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.lec.item.IMVO"%>
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
	List<WorkVO> worklist = (List<WorkVO>) request.getAttribute("worklist");
	List<IMVO> itemlist = (List<IMVO>) request.getAttribute("itemlist");
%>
	<form action="/modifyWork.do" method="post">
		<div class="container">
			<div class="row">
				<div class="col text-center">
					<h1>작업수정</h1>
				</div>
			</div>
		</div>
		<table class="mx-auto table" style="text-align: center;">
			<tr>
				<th width="20%" class="align-middle">작업코드</th>
				<td><input id="work_code" name="pro_code" class="form-control" readonly="readonly" value="<%= request.getParameter("work_code")%>"></td>
			</tr>
			<tr>
				<th class="align-middle">품목코드</th>
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
			</tr>
			<tr>
				<th class="align-middle">품목명</th>
				<td><input name="item_name" class="form-control" value="<%= request.getParameter("item_name")%>"></td>
			</tr>
			<tr>
				<th class="align-middle">작업수량</th>
				<td><input name="work_count" class="form-control" value="<%= request.getParameter("work_count")%>"></td>
			</tr> 
			<tr>
				<th class="align-middle">작업시간</th>
				<td><input type="date" name="work_time" class="form-control" value="<%= request.getParameter("work_time")%>"></td>
			</tr> 
		</table>
		<div class="container">
			<div class="row">
				<div class="col text-center">
					<input type="submit" class="btn btn-primary" value="수정" />
					<input type="button" class="btn btn-danger" value="삭제" id="delete"/>
					<a class="btn btn-primary text-lg-end" href="/workListView.do">돌아가기</a>
				</div>
			</div>
		</div>
	</form>
	<script type="text/javascript">
		$("#delete").click(function() {
			if(confirm("삭제하시겠습니까?")){
				location.href = "/deleteWork.do?work_code="+document.getElementById("work_code").value
			}
		});
	</script>
</body>
</html>