<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>  
<script src="${contextPath}/resources/js/product/list.js"></script> 
<h1>PRODUCT</h1>
<div class="container my-3">
	<form id="listForm">
		<table class="table">
			<tr>
				<th>상품번호</th>
				<th>상품명</th>
				<th>가격</th>
				<th>상품설명</th>
			</tr>
			<c:forEach items="${list}" var="b">
			<tr>
				<td>
					${b.pno}
				</td>
				<td>
					<a href="${b.pno}" class="title">${b.name}</a>
				</td>
				<td>${b.price}</td>
				<td>${b.info}</td>
			</tr>
			</c:forEach>
		</table>
	</form>
	
</div>


<%@ include file="../layout/footer.jsp" %> 