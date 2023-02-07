<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../layout/header.jsp" %>  

<form id="adminForm" class="container" action="${contextPath}/product/modproduct" method="post">	
	<table class="table">
			<div>
				<button type="button" class="btn btn-outline-dark float-right delAllCart">전체삭제</button>
				<button type="button" class="btn btn-outline-dark float-right delCheckCart">선택삭제</button>
				<input type="submit" class="btn btn-primary float-right" value="수정처리"> 
			</div>
				<tr>
					<th>상품번호</th>
					<th>상품이미지</th>
					<th>상품명</th>
					<th>상품가격</th>
					<th>상품정보</th>
					<th>중량</th>
					<th>카테고리</th>
					<th><input type="checkbox" class="cartAllCheckBox" ></th>
				</tr>
				<c:forEach items="${list}" var="b">
				<tr>	
					<td>
						${b.pno}
					</td>
					<td>
						<img src="${contextPath}/resources/images/${b.name}.png" alt="${b.name}" width="100"/>
					</td>
					<td>
						<input type="text" class="form-control" id="name" name="name" value="${b.name}">
					</td>
					<td>
						<input type="text" class="form-control" id="price" name="price" value="${b.price}">
					</td>
					<td>
						<input type="text" class="form-control" id="info" name="info" value="${b.info}">
					</td>
					<td>
						<input type="text" class="form-control" id="weight" name="weight" value="${b.weight}">
					</td>
					<td>
						<select class="form-control" name="gender" class="form-control" value="${b.category}" style="width:100px; height:30px; font-size:13px;" required>
							<option value="${b.category}" hidden>${b.category}</option>
							<option value="채소/과일">채소/과일</option>
							<option value="정육/계란">정육/계란</option>
							<option value="간식/베이커리">간식/베이커리</option>
							<option value="커피/음료">커피/음료</option>
						</select>
					</td>
					<td>
						<input type="checkbox" name="chk" class="cartCheckBox" value="${b.pno}">
					</td>

				</tr>
				</c:forEach>
			</table>
	
<%@ include file="../layout/footer.jsp" %>  
<script>
$(function(){
	$('.delMod').on('click', function(){
		
	})
})
</script>