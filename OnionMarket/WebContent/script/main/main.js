$(function() {
	
	$('#searchInput').keypress((e, isTrigger) => {
		let value = e.currentTarget.value;
		
		if((e.keyCode === 13 || isTrigger) && value !== '') {
			location.href = `${_ctx}/pro/proList.do?search=${value}`;
		}
	});
	
	$('#searchBtn').click((e) => {
		$('#searchInput').trigger('keypress', true);
	});
	
});



