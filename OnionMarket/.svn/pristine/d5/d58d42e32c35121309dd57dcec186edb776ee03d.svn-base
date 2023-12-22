
let _map, _marker, _info, _geocoder;

const {proImage} = _html.proInsert;
$(function() {
	
	// 파라미터 조회
	let uriParam = _util.getUriParameter();
	
	// 등록 버튼 클릭
	$('#savaBtn').click((e) => {
		if($('#tit').val() === '') {
			$('#tit').focus();
			alert(_msg.pro.emptyTitleAlert);
			return;
		}
		
		if($('#cont').val() === '') {
			$('#cont').focus();
			alert(_msg.pro.emptyContenstAlert);
			return;
		}
		
		if(confirm(_msg.common.insertConfirm)) {
			$('form').submit();
		}
	});
	
	// 파일 이벤트
	$('#file').changeFile((files) => {
		files.forEach((file) => {
			var html = proImage(file);
			
			// file input 복사 및 숨김 
			let copyInput = _util.copyTag($('#file').get(0), {
				id: null,
				name: 'file',
				style: 'display:none;'
			});
			html = $(html).append(copyInput);
			
			// 삭제 버튼 클릭 이벤트
			html = $(html).find('.delete-btn').click((e) => {
				$(e.currentTarget).closest('.file-item').remove();
			}).end();
			
			$('#imageList').append(html);
		});
	});
	
	// 무료나눔 버튼 클릭시 금액 입력 인풋 토글 이벤트
	$("#freeBtn").click(function() {
		
    	let priceInput = $(this).siblings("#price");
		priceInput.val(0); // 0 초기화
    
	    if (priceInput.prop("disabled")) {
	        // #price가 이미 disabled인 경우, 다시 enabled로 변경
	        priceInput.prop("disabled", false);
	        priceInput.attr("placeholder", "금액 입력(0원~무한대)");
			$(this).css("background", "#8f8f8f");
	    } else {
	        // #price가 enabled인 경우, disabled로 변경하고 placeholder를 "무료나눔"으로 설정
	        priceInput.prop("disabled", true);
			priceInput.css("background", "#f0f0f0");
			$(this).css("background", "#ff9800");
	    }
	});
	
	// 금액 입력 9자리까지 제한
	$("#price").on("input", function() {
	    let inputValue = $(this).val();
	    if (inputValue.length > 9) {
	        $(this).val(inputValue.slice(0, 9));
	    }
	});
	
	
	// 물품 수정 일 경우 
	if(uriParam.prod_id) {
		let data = _util.ajax(`${_ctx}/pro/proUpdateData.do`, uriParam);
		console.log(data);
		
		// 기존 등록 값 세팅
		$('#cate_id').val(data.cate_id);
		$('#tit').val(data.tit);
		$('#cont').text(data.cont);
		$('#price').val(data.price);
		
		// 맵 초기화 
		initMap(data.lat, data.lng);
		
		
		data.file_list.forEach((e)=> {
			console.log(e);
			
			_util.convertToFileByURL(
					`${_ctx}/imageView?stored_nm=${e.stored_nm}`,
					e.upload_nm.replace('.' + e.extension, ''),
					e.extension)
			.then((realfile) => {
			
				let dtf = new DataTransfer();
				dtf.items.add(realfile);
				
				let inputFile = $('.file-area #file').get(0);
				
				inputFile.files = dtf.files;
				$(inputFile).trigger('change');
			});
		});
	}
	// 물품 등록 일 경우
	else {
		// 맵 초기화
		initMap();
	}
    
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
    
    // 지도 클릭 이벤트
    kakao.maps.event.addListener(_map, 'click', function (e) {

        // 위도, 경도 콘솔 출력
    	console.log(e.latLng.getLat(), e.latLng.getLng());
        
    	// 마커, 윈포윈도우 를 클릭 위치로 이동
    	_marker.setPosition(e.latLng);
    	_info.open(_map, _marker);
    	
    	// input value
    	$('#lat').val(e.latLng.getLat());
    	$('#lng').val(e.latLng.getLng());
    	
    	// 좌표 값 => 주소
    	_geocoder.coord2Address(e.latLng.getLng(), e.latLng.getLat(), function(data, status) {
    		console.log(data);
    		if(status === 'OK') {
    			let {address_name, region_2depth_name, region_3depth_name} = data[0].address;
    			
				$('#pro_gu').val(region_2depth_name);
		    	$('#pro_dong').val(region_3depth_name);

    			_info.setContent(`<div style="padding:5px; text-align:center; width: 150px;">${address_name}</div>`)
    		}
    	});
    });
}