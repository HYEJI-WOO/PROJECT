<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../layout/header.jsp" %>  

<div class="container">
	<div class="jumbotron">
		<h1>Sign Up</h1>
	</div>
	
	<form action="${contextPath}/member/join" method="post">
		<div class="form-group">
			<h5><b>아이디</b></h5> <input type="text" class="form-control" name="id">
		</div>
		<div class="form-group">
			<h5><b>비밀번호</b></h5> <input type="password" class="form-control" name="pwd">
		</div>
		<div class="form-group">
			<h5><b>이름</b></h5> <input type="text" class="form-control" name="name">
		</div>
		<div class="form-group">
			<h5><b>이메일</b></h5> <input type="text" class="form-control" name="email">
		</div>
		<div class="form-group">
			<h5><b>년</b></h5> <input type="text" class="form-control" name="year">
		</div>
		<div class="form-group">
			<h5><b>월</b></h5> <input type="text" class="form-control" name="month">
		</div>
		<div class="form-group">
			<h5><b>일</b></h5> <input type="text" class="form-control" name="day">
		</div>
		<div class="form-group">
			<h5><b>성별</b></h5> <input type="text" class="form-control" name="gender">
		</div>
		<div class="form-group">
			<h5><b>주소</b></h5> <input type="text" class="form-control" name="address">
		</div>
		<button class="btn btn-primary">가입하기</button>
	</form>
</div>

<%@ include file="../layout/footer.jsp" %>  