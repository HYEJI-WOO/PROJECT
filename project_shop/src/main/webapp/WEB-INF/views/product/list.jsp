<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>  
<script src="${contextPath}/resources/js/product/list.js"></script> 
<h1>PRODUCT</h1>
<div class="container my-3">
	<form id="listForm">
	<div class="container" style="margin-top:30px">
	 	<div class="row">
		    <div class="col-sm-3">
		    	<a href="${contextPath}/product/detail"><img src="${contextPath}/resources/images/사과.jpg" alt="사과" width="150" /></a><br><br>
		    	<td>사과</td>
			</div>
		    <div class="col-sm-3">
		    	<a href="${contextPath}/product/detail"><img src="${contextPath}/resources/images/바나나.jpg" alt="바나나" width="150" /></a><br>
				<td>바나나</td>
			</div>
			<div class="col-sm-3">
		    	<a href="${contextPath}/product/detail"><img src="${contextPath}/resources/images/크로와상.jpg" alt="크로와상" width="150" /></a><br>
				<td>크로와상</td>
			</div>
			<div class="col-sm-3">
		    	<a href="${contextPath}/product/detail"><img src="${contextPath}/resources/images/오렌지쥬스.jpg" alt="오렌지쥬스" width="150" /></a><br>
				<td>오렌지쥬스</td>
			</div>
			<div class="col-sm-3">
		    	<a href="${contextPath}/product/detail"><img src="${contextPath}/resources/images/채소세트.jpg" alt="채소세트" width="150" /></a><br>
				<td>채소세트</td>
			</div>
			<div class="col-sm-3">
		    	<a href="${contextPath}/product/detail"><img src="${contextPath}/resources/images/쿠키.jpg" alt="쿠키" width="150" /></a><br>
				<td>쿠키</td>
			</div>
			<div class="col-sm-3">
		    	<a href="${contextPath}/product/detail"><img src="${contextPath}/resources/images/소고기.jpg" alt="소고기" width="150" /></a><br>
				<td>소고기</td>
			</div>
			<div class="col-sm-3">
		    	<a href="${contextPath}/product/detail"><img src="${contextPath}/resources/images/계란.jpg" alt="계란" width="150" /></a><br>
				<td>계란</td>
			</div>
	    </div>
 	</div>


<%@ include file="../layout/footer.jsp" %> 