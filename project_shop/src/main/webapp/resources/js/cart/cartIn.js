$(function(){
	
	var checkBoxArr = [];

	$('.name').on('click',function(e){
		let cartForm = $('#cartForm')
		e.preventDefault();
		$('[name="name"]').remove();
		//let bnoData = "<input type='hidden' name='bno' value='"+$(this).data('bno')+"'/>";
		let nameData = "<input type='hidden' name='name' value='"+$(this).attr('href')+"'/>";
		cartForm.append(nameData)
				.attr("action", `${contextPath}/product/detail`)
				.submit();
	});
	
	$('.delAllCart').on('click', function() {
		$.ajax({
			type : 'post',
			url : `${contextPath}/cart/delAllCart`,
			data : {id : auth.id},
			success : function() {
				alert("모든 상품이 삭제되었습니다.")
				location.assign("/project_shop/cart/cartIn")
			},
			error : function() {
				alert("삭제 실패")
			}
		})
	});
	
	$('.delCheckCart').on('click', function() {
		console.log(checkBoxArr);
/*		$.ajax({
			type : 'post',
			url : `${contextPath}/cart/delCheckCart`,
			data : {id : auth.id, data : checkBoxArr},
			success : function() {
				alert("모든 상품이 삭제되었습니다.")
				location.assign("/project_shop/cart/cartIn")
			},
			error : function() {
				alert("삭제 실패")
			}
		})*/
		
	}); 
	
	$('.cartCheckBox').on('click', function() {
		$("input[name=chk]:checked").each(function(i){
			checkBoxArr.push($(this).val());
		})
	})
	
});	