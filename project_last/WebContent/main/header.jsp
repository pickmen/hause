<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<header>
	<!-- 헤더 -->
		<div class="container mx-0" style="background-color: black; height: 50px; max-width: 3000px;" >
			<nav class="navbar navbar-dark bg-dark fixed-top">
			    <a class="navbar-brand ms-3" href="#">Main Page</a> 
			    <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar" aria-controls="offcanvasNavbar">
			      <span class="navbar-toggler-icon"></span>
			    </button>
			    <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasNavbar" aria-labelledby="offcanvasNavbarLabel">
			      <div class="offcanvas-header">
			        <h5 class="offcanvas-title" id="offcanvasNavbarLabel">Menu</h5>
			        <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
			      </div>
			      <div class="offcanvas-body">
			        <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
			          <li class="nav-item">
			            <a class="nav-link active" style="color: black;" aria-current="page" href="#">Home</a>
			          </li>
			          <li class="nav-item">
			            <a class="nav-link" style="color: black;" href="#">Log-in</a>
			          </li>
			        </ul>
		      	 </div>
		    	</div>
  
			</nav>
		</div>
</header>