<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<title></title>
</head>
<body class="pt-3 px-3">
	<a class="btn btn-primary" href="/bomlistView.do">bom</a>
	<a class="btn btn-primary" href="/IVlistView.do">재고</a>
	<a class="btn btn-primary" href="/saleslistView.do">판매</a>
	<hr>
	<a class="btn btn-primary" href="/viewAC.do">거래처</a>
	<a class="btn btn-primary" href="/listWare.do" >창고</a>
	<a class="btn btn-primary" href="/listItem.do" >품목</a>
	<hr>
	<a class="btn btn-primary" href="/viewOrder.do">주문</a>
	<a class="btn btn-primary" href="/viewBuy.do">구매</a>
	<hr>
	<a class="btn btn-primary" href="/poorListView.do">불량</a>
	<a class="btn btn-primary" href="/proListView.do" >생산</a>
	<a class="btn btn-primary" href="/workListView.do" >작업</a>
</body>
</html>