<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>  
<h1>BEST</h1>
<div class="container my-3">
   <ul class="nav nav-pills justify-content-center">
	    <li class="nav-item">
	      <a class="nav-link" href="${contextPath}/product/list">ALL</a>
	    </li>
	    <li class="nav-item">
	      <a class="nav-link" href="${contextPath}/product/best">BEST</a>
	    </li>
	    <li class="nav-item">
	    <a class="nav-link" href="${contextPath}/product/sale">SALE</a>
	    </li>
  </ul>
<form id="listForm">
	<div class="container" style="margin-top:30px">
	 	<div class="row">
		    
			<div class="col-sm-3">
		    	<a href="${contextPath}/product/detail"><img src="${contextPath}/resources/images/채소세트.png" alt="채소세트" width="200" /></a><br>
				<td>채소세트</td><br>
				<td>6990원</td><br><br>
			</div>
			<div class="col-sm-3">
		    	<a href="${contextPath}/product/detail"><img src="${contextPath}/resources/images/쿠키.png" alt="쿠키" width="200" /></a><br>
				<td>쿠키</td><br>
				<td>79000원</td><br><br>
			</div>
			<div class="col-sm-3">
		    	<a href="${contextPath}/product/detail"><img src="${contextPath}/resources/images/소고기.png" alt="소고기" width="200" /></a><br>
				<td>소고기</td><br>
				<td>340000원</td><br><br>
			</div>
			<div class="col-sm-3">
		    	<a href="${contextPath}/product/detail"><img src="${contextPath}/resources/images/계란.png" alt="계란" width="200" /></a><br>
				<td>계란</td><br>
				<td>19000원</td><br><br>
			</div>
	    </div>
 	</div>
</form>
</div>
<%@ include file="../layout/footer.jsp" %> 