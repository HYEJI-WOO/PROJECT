<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../layout/header.jsp" %>  
	<div class="jumbotron">
		<h1>상품등록</h1>
	</div>
	
	<form action="${contextPath}/product/addProduct" method="post">
		<div class="form-group">
			상품명 <input type="text" class="form-control" name="name">
		</div>
		<div class="form-group">
			가격 <input type="text" class="form-control" name="price">
		</div>
		<div class="form-group">
			중량X수량 <input type="text" class="form-control" name="weight">
		</div>
		<div class="form-group">
			상품설명 <input type="text" class="form-control" name="info">
		</div>
		<div class="form-group">
			<select class="form-control" name="category">
				<option value="채소/과일">채소/과일</option>
				<option value="정육/계란">정육/계란</option>
				<option value="간식/베이커리">간식/베이커리</option>
				<option value="커피/음료">커피/음료</option>
			</select>
		</div>
		<button class="btn btn-primary">상품등록</button>
	</form>
	
<%@ include file="../layout/footer.jsp" %>  
