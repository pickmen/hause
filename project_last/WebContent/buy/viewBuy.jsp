<%@page import="com.lec.web.PageInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
<%@page import="com.lec.buy.BuyVO"%>

<h1>구매</h1>
<form action="/searchBuy.do" method="post">
	<div class="container px-0">
		<div class="row col-12">
			<div class="col-6"></div>
			<div class="col-2">
				<select class="form-select" name="search_type">
					<option selected value="item_name">품목명</option>
					<option value="item_code">품목코드</option>
					<option value="buy_code">구매코드</option>
					<option value="account_code">거래처코드</option>
					<option value="ware_code">창고코드</option>
				</select>
			</div>
			<div class="col-3 px-0">
				<input type="text" class="form-control mx-0" name="search_text"
					placeholder="검색..." />
			</div>
			<div class="col-1">
				<input type="submit" class="btn btn-primary" value="검색" />
			</div>
		</div>
	</div>
</form>
<%
List<BuyVO> buylist = (List<BuyVO>) request.getAttribute("buylist");
PageInfo paging = (PageInfo) request.getAttribute("paging");
int search = 0;
// 서치로 받아올 경우 session으로 리스트 받음
if (buylist == null) {
	buylist = (List<BuyVO>) session.getAttribute("buylist");
	search = 1;
}
%>
<table class="mx-auto table">
	<tr>
		<th>구매코드</th>
		<th>거래처코드</th>
		<th>품목코드</th>
		<th>품목명</th>
		<th>구매일</th>
		<th>구매수량</th>
		<th>구매금액</th>
		<th>단가</th>
		<th>창고코드</th>
		<th>수정</th>


	</tr>

	<c:if test="<%=buylist.isEmpty() == false%>">
		<c:set value="<%=buylist%>" var="buylist"></c:set>
		<c:forEach var="i" begin="<%=paging.getStartRow()%>"
			end="<%=paging.getEndRow()%>">
			<c:set value="${buylist.get(i)}" var="buy"></c:set>

			<tr>
				<td>${buy.getBuy_code()}</td>
				<td>${buy.getAccount_code()}</td>
				<td>${buy.getItem_code()}</td>
				<td>${buy.getItem_name()}</td>
				<td>${buy.getBuy_date()}</td>
				<td>${buy.getBuy_cnt()}</td>
				<td>${buy.getBuy_cost()}</td>
				<td>${buy.getBuy_price()}</td>
				<td>${buy.getWare_code()}</td>
				<td>
					<form action="/goUpdateBuy.do" method="post">
						<input type="hidden" name="buy_code" value="${buy.getBuy_code()}" />
						<input type="hidden" name="account_code"
							value="${buy.getAccount_code()}" /> <input type="hidden"
							name="item_code" value="${buy.getItem_code()}" /> <input
							type="hidden" name="item_name" value="${buy.getItem_name()}" />
						<input type="hidden" name="buy_date" value="${buy.getBuy_date()}" />
						<input type="hidden" name="buy_cnt" value="${buy.getBuy_cnt()}" />
						<input type="hidden" name="buy_cost" value="${buy.getBuy_cost()}" />
						<input type="hidden" name="buy_price"
							value="${buy.getBuy_price()}" /> <input type="hidden"
							name="ware_code" value="${buy.getWare_code()}" /> <input
							type="submit" value="수정" />
					</form>
				</td>
			</tr>
		</c:forEach>
	</c:if>

</table>
<div class="container">
	<div class="row">
		<div class="col text-center">
			<a class="btn btn-primary" href="/goInsertBuy.do">등록</a>
		</div>
	</div>
</div>

<c:set value="searchBuy.do?page=" var="searchpage"></c:set>
<c:set value="viewBuy.do?page=" var="viewpage"></c:set>

<div class="container mt-3">
		<ul class="pagination justify-content-center">
		<c:set value="<%=paging %>" var="page" ></c:set>
			<c:choose>
				<c:when test="<%=search==1 %>">
					<c:if test="${page.getStartPage() != 1 }">
						<li class="page-item"><a href="${searchpage}1" class="page-link"><i class="fas fa-fast-backward"></i></a></item></li>
						<li class="page-item"><a href="${searchpage}${page.getPage()-1}" class="page-link"><i class="fas fa-backward"></i></a></item></li>
					</c:if>
					<c:forEach var="page_num" begin="${page.getStartPage()}" end="${page.getEndPage()}">
						<li class="page-item"><a href="${searchpage}${page_num}" class="page-link">${page_num}</a></item></li>
					</c:forEach>
					<c:if test="${page.getEndPage() < page.getTotalPage() }">
						<li class="page-item"><a href="${searchpage}${page.getNextPage()}" class="page-link"><i class="fas fa-forward"></i></a></item></li>
						<li class="page-item"><a href="${searchpage}${page.getTotalPage()}" class="page-link"><i class="fas fa-fast-forward"></i></a></item></li>
					</c:if>
				</c:when>
				<c:otherwise>
					<c:if test="${page.getStartPage() != 1 }">
						<li class="page-item"><a href="${viewpage}1" class="page-link"><i class="fas fa-fast-backward"></i></a></item></li>
						<li class="page-item"><a href="${viewpage}${page.getPage()-1}" class="page-link"><i class="fas fa-backward"></i></a></item></li>
					</c:if>
					<c:forEach var="page_num" begin="${page.getStartPage()}" end="${page.getEndPage()}">
						<li class="page-item"><a href="${viewpage}${page_num}" class="page-link">${page_num}</a></item></li>
					</c:forEach>
					<c:if test="${page.getEndPage() < page.getTotalPage() }">
						<li class="page-item"><a href="${viewpage}${page.getNextPage()}" class="page-link"><i class="fas fa-forward"></i></a></item></li>
						<li class="page-item"><a href="${viewpage}${page.getTotalPage()}" class="page-link"><i class="fas fa-fast-forward"></i></a></item></li>
					</c:if>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>