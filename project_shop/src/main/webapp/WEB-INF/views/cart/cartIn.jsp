<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../layout/header.jsp" %>  
<script src="${contextPath}/resources/js/cart/cartIn.js"></script> 
	<h1>장바구니입니다.</h1>
<div class="container my-3">
	<form id="cartForm">
		<c:if test="${empty info}">
			<h1>장바구니에 담긴 상품이 없습니다.</h1>
		</c:if>
		<c:if test="${not empty info}">
			<table class="table">
				<tr>
					<th>아이디</th>
					<th>상품이미지</th>
					<th>상품명</th>
					<th>개당가격</th>
					<th>갯수</th>
					<th>총액</th>
				</tr>
				<c:forEach items="${info}" var="b">
				<tr>	
					<td>
						${b.id}
					</td>
					<td><a href="${b.name}" class="name"><img src="${contextPath}/resources/images/${b.name}.png" alt="${b.name}" width="100"/></a></td>
					<td><a href="${b.name}" class="name">${b.name}</a></td>
					<td>${b.price}</td>
					<td>${b.cart_cnt}</td>
					<td>Null</td>
				</tr>
				</c:forEach>
			</table>
		</c:if>	
	</form>
</div>	
	
<%@ include file="../layout/footer.jsp" %>  