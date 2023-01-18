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
			<div>
				<button type="button" class="btn btn-outline-dark float-right delAllCart">전체삭제</button>
				<button type="button" class="btn btn-outline-dark float-right delCheckCart">선택삭제</button>
			</div>
				<tr>
					<th>번호</th>
					<th>이미지</th>
					<th>상품명</th>
					<th>가격</th>
					<th>수량</th>
					<th>합계</th>
					<th>선택</th>
				</tr>
				<c:forEach items="${info}" var="b">
				<tr>	
					<td>
						<c:set var="cno" value="${cno+1}"/>
						<c:out value="${cno}"></c:out>
					</td>
					<td><a href="${b.name}" class="name"><img src="${contextPath}/resources/images/${b.name}.png" alt="${b.name}" width="100"/></a></td>
					<td><a href="${b.name}" class="name">${b.name}</a></td>
					<td><fmt:formatNumber value="${b.price}" pattern="#,###원"/></td>
					<td>${b.cart_cnt}</td>
					<td><fmt:formatNumber value="${b.price * b.cart_cnt}" pattern="#,###원"/></td>
					<td><input type="checkbox" class="cartCheckBox" value="${b.name}"></td>
				</tr>
				<c:set var="total" value="${total + b.price*b.cart_cnt}"/>
				</c:forEach>
			</table>
			<div class="form-group" align="right">
				합계금액 : <input type="text" class="form-control" value="<fmt:formatNumber value="${total}" pattern="#,###원"/>" style="width:130px; height:30px;font-size:15px;text-align:right;font-weight : bold ;" readonly="readonly">
			</div>
			<div>
				<button type="button" class="btn btn-info float-right toBuyForm">주문하기</button>
			</div>
		</c:if>	
	</form>
</div>	
	
<%@ include file="../layout/footer.jsp" %>  