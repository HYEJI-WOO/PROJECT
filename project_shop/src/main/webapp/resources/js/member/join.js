$(function() {
	$('.viewMode').hide();
	
	let viewForm = $('#viewForm');
	
	let pwdObj = $('input[name="pwd"]');
	let emailObj = $('input[name="email"]');
	let yearObj = $('input[name="year"]');
	let monthObj = $('input[name="month"]');
	let dayObj = $('input[name="day"]');
	let genderObj = $('input[name="gender"]');
	let addressObj = $('input[name="address"]');
	
	let pwdVal = pwdObj.val();
	let emailVal = emailObj.val();
	let yearVal = yearObj.val();
	let monthVal = monthObj.val();
	let dayVal = dayObj.val();
	let genderVal = genderObj.val();
	let addressVal = addressObj.val(); 
	
	// 수정모드
	$('.toModForm').on('click', function(){
		$('input[name="pwd"],input[name="email"]').attr("readonly",false);
		$('input[name="year"],input[name="month"],input[name="day"]').attr("readonly",false);
		$('input[name="gender"],input[name="address"]').attr("readonly",false);
		$('.toModForm').hide();
		$('.viewMode').show();
	});
	
	// 수정 처리
	$('.modify').on('click', function(){
		viewForm.attr({
			"action" : `${contextPath}/member/modMember`,
			"method" : "post"
		}).submit();
	});
	
	// 뷰모드
	$('.backViewMode').on('click', function(){
		$('input[name="id"],input[name="name"]').attr("readonly",true);
		$('.viewMode').hide();
		$('.toModForm').show();
		pwdObj.val(pwdVal); // 수정전 내용 복원
		emailObj.val(emailVal);
		yearObj.val(yearVal);
		monthObj.val(monthVal);
		dayObj.val(dayVal);
		genderObj.val(genderVal);
		addressObj.val(addressVal);
	});
	
});
