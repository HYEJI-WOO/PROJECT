<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="${contextPath}/resources/js/member/join.js"></script>  
 
<div class="container">
	<div class="jumbotron">
		<h1>주문내역</h1>
	</div>
	
	 <div class="col-sm-3">
      <ul class="nav nav-pills flex-column">
        <li class="nav-item">
          <a class="nav-link" href="${contextPath}/member/myPage">개인정보수정</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${contextPath}/member/orderList">주문내역</a>
        </li>
      </ul>
    </div>
    <h1>주문내역이 없습니다.</h1>
</div>
<%@ include file="../layout/footer.jsp" %>