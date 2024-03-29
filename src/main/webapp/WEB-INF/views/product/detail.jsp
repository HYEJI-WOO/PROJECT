<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<script src="${contextPath}/resources/js/reply/ProductReply.js"></script>
<script src="${contextPath}/resources/js/product/detail.js"></script>
<script src="${contextPath}/resources/js/product/list.js"></script> 

<style>
  .input-group {
    border: 1px solid #ccc;
    display: flex;
    align-items: center;
    border-radius: 4px;
  }

  .minus, .plus {
    border: none;
    margin: 0;
    padding: 0.5rem;
    background-color: transparent;
  }

  .cartCnt {
    text-align: center;
    font-size: 14px;
    padding: 6px;
    border: none;
    margin: 0;
  }
</style>


<div class="container" style="margin-top:80px; margin-left: 25%;">
    <div class="row">
        <div class="col-sm-5">
            <div class="fakeimg">
                <img src="${contextPath}/fileDownload?no=${product.pno}&imageFileName=${product.imageFileName}&path=product" alt="${product.name}" width="90%" height="370" />
                <br>
            </div>
        </div>
        <div class="col-sm-7">
            <h2><b>${product.name}</b></h2>
            <hr align="left" style="border: solid 1px grey; width: 70%;">
            <div class="row">
                <div class="col-md-2">
                    <font size="2em" color="grey">가격</font>
                </div>
                <div class="col-md-10">
                    <h5><p><b><fmt:formatNumber value="${product.price}" pattern="#,###원"/></b></p></h5>
                </div>
            </div>
            <div class="row">
                <div class="col-md-2">
                    <font size="2em" color="grey">중량X수량</font>
                </div>
                <div class="col-md-10">
                    <p><b><font size="3em">${product.weight}</font></b></p>
                </div>
            </div>
			<div class="row">
			    <div class="col-md-2">
			        <font size="2em" color="grey">상품설명</font>
			    </div>
			<div class="col-md-7" style="display: flex; flex-wrap: wrap;">
			    <p style="width: 100%; white-space: pre-wrap;">${product.info}</p>
			</div>
			
			</div>


            <div class="row">
                <div class="col-md-2">
                    <font size="2em" color="grey">수량</font>
                </div>
                <div class="col-md-4">
                    <div class="input-group mb-3">
                        <button type="button" class="btn btn-outline-secondary minus">-</button>
                        <input type="text" class="cartCnt form-control" name="cartCnt" value="${list.cart_cnt}1" readonly="readonly" style="text-align: center; background-color: white;" />
                        <button type="button" class="btn btn-outline-secondary plus">+</button>
                    </div>
                </div>
            </div>

			<div class="row">
			  <div class="col-sm-6">
			    <c:set var="total" value="${total + product.price*list.cart_cnt}"/>
			    <div class="form-group" style="display: flex; align-items: center;">
			      <span style="display: inline-flex; align-items: center; margin-left: 95px;">
			        <label style="width: 300px; font-weight: bold; margin-right: 5px; text-align: right; margin-top: 8px;">합계금액 :</label>
			        <input type="text" name="totalPrice" class="form-control totalPrice" value="<fmt:formatNumber value="${total}" pattern="#,###원"/>" style="font-size:23px; text-align:right; font-weight :bold; background-color: white; border: none; text-indent: calc(100% - 150px); padding-left: 0%;">
			      </span>
			      <input type="hidden" class="hdTotal" value="${total}">
			    </div>
			  </div>
			</div>
  
            <input type="hidden" value="${product.weight}">
            <input type="hidden" value="${product.imageFileName}">
            <input type="hidden" value="${product.name}">
            <input type="hidden" class="price" value="${product.price}">
            <button type="button" id="button" value="${product.pno}" class="cartBtn" style="background-color: #bd6abc; color: #FFFFFF; border: 1px solid white; width: 400px; height: 50px; font-size: 20px;">Cart</button>
        </div>
    </div>
</div>
<input type="hidden" name="pno" value="${product.pno}">

<div class="container" style="margin-left: 20%; margin-top: 10%;">
 	<div class="productReplyForm" style="margin-top: 30px;">
		<table class="table" style="width: 84%; margin-left: 8%;">
			<tr>
				<th colspan="2">
					<ul class="d-flex justify-content-between">
						<li>리뷰를 작성해주세요</li>
						<li class="form-inline">작성자 : <input type="text" class="reply_writer form-control ml-2" value="${auth.id}" readonly="readonly"></li>
					</ul>
				</th>
			</tr>
			<tr>
				<td class="col-1 text-center"><b>내용</b></td>
				
				<td>
					<textarea rows="5" class="form-control reply_content"></textarea>
				</td>
			</tr>
			<tr class="text-right">
				<td colspan="2"><button class="btn btn-light reply_write" >리뷰등록</button></td>
			</tr>
		</table>
	</div> 
	
	
 	<div class="productReplyList" style="margin-top: 30px;">
		<div class="replyListContainer"></div>
	</div> 
	
	
	<div class="modal fade productReplyBtn" id="reply">
	  <div class="modal-dialog">
	    <div class="modal-content">
	
	      <!-- Modal Header -->
	      <div class="modal-header">
	        <h4 class="modal-title">리뷰 등록</h4>
	        <button type="button" class="close" data-dismiss="modal">&times;</button>
	      </div>
	
	      <!-- Modal body -->
	      <div class="modal-body">
	        Modal body..
	      </div>
	
	      <!-- Modal footer -->
	      <div class="modal-footer">
	        <button type="button" class="btn btn-danger" data-dismiss="modal">확인</button>
	      </div>
	    </div>
	  </div>
	</div>
	</div>


<%@ include file="../layout/footer.jsp" %> 