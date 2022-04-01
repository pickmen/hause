<%@page import="java.util.Map"%>
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
<% String pagename = (String) request.getAttribute("pagename");
	if (pagename==null){
		pagename = "";
	}
	%>
	<c:import url="/main/header.jsp"></c:import>
	<c:import url="/main/nav.jsp"></c:import>
	
	<div class="row mb-auto" style="min-height: 800px; max-height: 3000px ;">
		<div class="col-sm-2" style="background-color: white;" id="sidebar">
			<c:import url="/main/sidebar.jsp"></c:import>
		</div>
		<div class="col-sm-10" style="background-color: #ffffff;">
			<c:if test='<%= pagename != "" %>'>
				<c:import url="<%= pagename %>"></c:import>
			</c:if>
		</div>
	</div>
	<c:import url="/main/footer.jsp"></c:import>
</body>
</html>