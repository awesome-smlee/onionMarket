
/**
 * 페이지 이동 핸들러
 * @Author leesm
 * @Description: 
 * 로그인이 필요한 페이지의 이동버튼들에 로그인 여부를 판단하여 페이지 이동을 제어하는 핸들러
 */
$(function() {
	$('a[id^=href_]').click((e) => {
		let path = $(e.currentTarget).data('path');
		
		// 로그인 되었을 때
		if(_user_id != '') {
			location.href = path;
		}
		// 로그인 안되었을 때
		else {
			if(confirm(_msg.common.pageMoveConfirm)) {
				location.href = `${_ctx}/loginView`;
			}
		}
	});
});