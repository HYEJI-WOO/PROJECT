$(function(){
	
	if(auth.grade != 'ROLE_ADMIN') {
		$('.pm').hide();
	}

	$('.name').on('click',function(e){
		let productForm = $('#productForm')
		e.preventDefault();
		$('[name="name"]').remove();
		//let bnoData = "<input type='hidden' name='bno' value='"+$(this).data('bno')+"'/>";
		let nameData = "<input type='hidden' name='name' value='"+$(this).attr('href')+"'/>";
		productForm.append(nameData)
				.attr("action", `${contextPath}/product/detail`)
				.submit();
	});
	
	$('.cartBtn').on('click', function() {
		let data = $(this).attr('value');
		let cnt = $('.cartCnt').val();
		if(auth.id != null && auth.id != '') {
			$.ajax({
				type : 'post',
				url : `${contextPath}/cart/addCart`,
				data : {id : auth.id, pno : data, cartCnt : cnt},
				success : function() {
					var check = confirm("상품이 장바구니에 담겼습니다. 확인하시겠습니까?");
					if(check) {
						location.assign("/project_shop/cart/cartIn")
					}
				},
				error : function() {
					alert('장바구니 담기 실패')
				}
			})
		} else {
			alert('로그인 후 이용가능합니다.')
			location.assign("/project_shop/member/loginForm")
		}
		
	})
	
});