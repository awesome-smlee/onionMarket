let _map, _marker, _info, _geocoder;
$(function () {
	
	// 조회수 증가
	let data = _util.ajax(`${_ctx}/pro/proUpdateViewCnt.do`, {
		prod_id : $('#prod_id').val(),
	});
	
	// 등록 후 리다이렉트로 넘어온 경우 등록 성공 메시지 출력 
	let uriParam = _util.getUriParameter();
	if(uriParam.isInsert === 'true') {
		alert(_msg.common.insertSuccessAlert);
	}
	
	// 판매 물품 상태 변경
	$("#proStatus").change((e) => {
	    // 선택된 거래상태 value 가져오기
	    let status = $("#proStatus option:selected").val();
	    
	    // 상태 변경 요청
	    let data = _util.ajax(`${_ctx}/pro/proDetailStatus.do`, {
	    	prod_status: status,
	    	prod_id: $('#prod_id').val(),
	    });
	    
	    // 상태 변경 메시지 출력
	    alert(
	    	data.result > 0 ? _msg.pro.updateStatusSuccessAlert
	    		: _msg.pro.updateStatusFailAlert
	    );
	    
	});
	
	// 좋아요 버튼 클릭
	$("#likeBtn").click((e) => {
		let isLike = $(e.currentTarget).hasClass('active');
		console.log(isLike);
		$(e.currentTarget).toggleClass('active');
		
		// 좋아요 요청
		let data = _util.ajax(`${_ctx}/pro/proDetailLike.do`, {
	    	prod_status: status,
	    	prod_id: $('#prod_id').val(),
	    	process: isLike ? 1 : 0 // 0: insert, 1: delete
	    });
		
		let likeCnt = Number($('#likeCnt').text());
		
		switch(data.result) {
			case 1:
				alert(_msg.pro.insertLikeSuccessAlert);
				$('#likeCnt').text(++likeCnt);
				break;
			case 2:
				alert(_msg.pro.insertLikeFailAlert);
				break;
			case 3:
				alert(_msg.pro.deleteLikeSuccessAlert);
				$('#likeCnt').text(--likeCnt);
				break;
			case 4:
				alert(_msg.pro.deleteLikeFailAlert);
				break;
		}
	});
	
	// 채팅하기 버튼 클릭
	$('#chatBtn').click((e) => {
		
	});
	
	
	$('#updateBtn').click((e) => {
		location.href = `${_ctx}/pro/proInsert.do?prod_id=${uriParam.prod_id}`;
	});
	
	// 삭제하기
	$('#deleteBtn').click((e) => {
		if(confirm(_msg.common.deleteConfirm)) {
			let data = _util.ajax(`${_ctx}/pro/proDelete.do`, {prod_id: $('#prod_id').val()});
			
			if(data.result > 0) {
				alert(_msg.common.deleteSuccessAlert);
				location.href = `${_ctx}/pro/proList.do`;
			} else {
				alert(_msg.common.deleteFailAlert);
			}
		}
	});
	
	initMap($('#lat').val(), $('#lng').val());
});

function initMap(lat=36.325, lng=127.4089) {
	/* 지도 */
	
	// 좌표값 => 주소값 객체
    _geocoder = new kakao.maps.services.Geocoder();
    // default center
	let center = new kakao.maps.LatLng(lat, lng);
	
	// 기본 위도 경도 채우기
	$('#lat').val(center.getLat());
	$('#lng').val(center.getLng());
	
	// 지도 생성
    _map = new kakao.maps.Map(document.getElementById('map'), {
    	center: center, // 위도, 경도
        level: 3 // zoom level
    });
	
    // 마커 생성
    _marker = new kakao.maps.Marker({
        position: center,
        // 마커이미지 설정
        image: new kakao.maps.MarkerImage(
        	_ctx + '/img/favicon.png',
        	new kakao.maps.Size(64, 69),
        	{ offset: new kakao.maps.Point(27, 69) }
        )
    });
    // 마커 세팅
    _marker.setMap(_map);
    
    // 인포윈도우 생성
    _info = new kakao.maps.InfoWindow({
    	position : center, 
    	content : `<div style="padding:5px; text-align:center; width: 150px;"></div>`,
    	width: 100,
    });
    // 인포윈도우 세팅
    _info.open(_map, _marker);
    // 인포윈도우 콘텐츠
    _geocoder.coord2Address(center.getLng(), center.getLat(), function(data, status) {
		console.log(data);
		if(status === 'OK') {
			let {address_name, region_2depth_name, region_3depth_name} = data[0].address;
			
			$('#pro_gu').val(region_2depth_name);
	    	$('#pro_dong').val(region_3depth_name);
			
			_info.setContent(`<div style="padding:5px; text-align:center; width: 150px;">${address_name}</div>`)
		}
	});
    
    // 지도 컨트롤 세팅 (맵타입, 줌)
    _map.addControl(new kakao.maps.MapTypeControl(), kakao.maps.ControlPosition.TOPRIGHT);
    _map.addControl(new kakao.maps.ZoomControl(), kakao.maps.ControlPosition.RIGHT);
}