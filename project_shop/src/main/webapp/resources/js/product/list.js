$(function(){

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
	
});