$(function () {
	$("#proStatus").change(function() {
	    // 선택된 거래상태 value 가져오기
	    let status = $("#proStatus option:selected").val();
	    console.log(status);
	    
		// ★ prod_id도 같이 보내야할것같은데
		let data = _util.ajax(_ctx+'/pro/proStatusUpdate.do', status);
		console.log(data);
	});
});