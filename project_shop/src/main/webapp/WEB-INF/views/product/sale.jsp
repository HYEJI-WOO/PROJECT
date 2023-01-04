<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>  
<h1>SALE</h1>
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
		    	<a href="${contextPath}/product/detail"><img src="${contextPath}/resources/images/사과.jpg" alt="사과" width="200"/></a><br>
		    	<td>사과</td><br>
		    	<td>1500원</td><br><br>
		    	
			</div>
		    <div class="col-sm-3">
		    	<a href="${contextPath}/product/detail"><img src="${contextPath}/resources/images/바나나.jpg" alt="바나나" width="200" /></a><br>
				<td>바나나</td><br>
				<td>2000원</td><br><br>
			</div>
	
	    </div>
 	</div>
</form>
</div>
<%@ include file="../layout/footer.jsp" %> 