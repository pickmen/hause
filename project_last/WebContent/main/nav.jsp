<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="container mx-0 pt-3" style="background-color: white; height: 70px; max-width: 3000px;" >
			<ul class="nav nav-pills">
			  <li class="nav-item">
			    <a class="nav-link active" id="basic" aria-current="page" href="#">기초등록</a>
			  </li>
			  <li class="nav-item">
			    <a class="nav-link" id="sales" href="#">영업관리</a>
			  </li>
			  <li class="nav-item">
			    <a class="nav-link" id="prod" href="#">생산관리</a>
			  </li>
			  <li class="nav-item">
			    <a class="nav-link" id="inven" href="#">재고관리</a>
			  </li>
			</ul>
</div>
<script type="text/javascript">
		$("#basic").click(function() {
			document.getElementById("basic").className += " active";
			document.getElementById("sales").classList.remove("active");
			document.getElementById("prod").classList.remove("active");
			document.getElementById("inven").classList.remove("active");
			$("#sidebar").load("/main/sidebar.jsp");
		});
		$("#sales").click(function() {
			document.getElementById("sales").className += " active";
			document.getElementById("basic").classList.remove("active");
			document.getElementById("prod").classList.remove("active");
			document.getElementById("inven").classList.remove("active");
			$("#sidebar").load("/main/sidebar2.jsp");
		});
		$("#prod").click(function() {
			document.getElementById("prod").className += " active";
			document.getElementById("sales").classList.remove("active");
			document.getElementById("basic").classList.remove("active");
			document.getElementById("inven").classList.remove("active");
			$("#sidebar").load("/main/sidebar3.jsp");
		});
		$("#inven").click(function() {
			document.getElementById("inven").className += " active";
			document.getElementById("sales").classList.remove("active");
			document.getElementById("prod").classList.remove("active");
			document.getElementById("basic").classList.remove("active");
			$("#sidebar").load("/main/sidebar4.jsp");
		});
	</script>