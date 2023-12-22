let _pagination;
let {proLi} = _html.proList;

$(function() {
	// 페이지네이션 초기화
	_pagination = new Pagination({
		pagination: {
			rowSize: 6,
			pageListTarget: $('#pagination'),
			onClickAll: onSearch,
		},
		search: {
			search_tit: {
				target: $('#search_tit'),
			},
		},
		sort: {
			sort_a: {
				target: $('#sort_a'),
				type: 2,
				onChangeTarget: function() {
					$(this.target).addClass('active').siblings().removeClass('active');
					onSearch();
				},
			},
			sort_b: {
				target: $('#sort_b'),
				type: 2,
				onChangeTarget: function() {
					$(this.target).addClass('active').siblings().removeClass('active');
					onSearch();
				},
			},
			sort_c: {
				target: $('#sort_c'),
				type: 2,
				onChangeTarget: function() {
					$(this.target).addClass('active').siblings().removeClass('active');
					onSearch();
				},
			},
			sort_d: {
				target: $('#sort_d'),
				type: 2,
				onChangeTarget: function() {
					$(this.target).addClass('active').siblings().removeClass('active');
					onSearch();
				},
			},
		},
	});
	
	// 최신순 정렬 버튼 클릭 => 콜백에서 onSearch 실행
	$('.search-box input:eq(0)').trigger('click');
	//onSearch();
	
	// 검색 입력창 키 이벤트
	$('input#search_tit').keypress((e, isSearch) => {
		
		if(e.keyCode === 13 || isSearch) {
			
			let value = e.currentTarget.value;
			
			if(value === '') {
				$('#search_msg').hide();
				$('#all_msg').show();
			}
			else {
				$('#search_msg').show().find('.item').text(`" ${value} "`);
				$('#all_msg').hide();
			}
			
			onSearch();
		}
	});
	
	// 카테고리 버튼 클릭
	$('.select-group a').click((e) => {
		let target = $(e.currentTarget);
		let cate_id = target.data('cate_id');
		let cate_nm = target.text();
		let li = target.closest('li');
		let isActive = li.hasClass('active');
		let msg = $('#cate_msg');
		let all_msg = $('#all_msg');

		if(isActive) {
			li.removeClass('active');
			msg.hide();
			if(!$('#search_msg').is(':visible')) {
				all_msg.show();
			}
		}
		else {
			li.addClass('active').siblings('li').removeClass('active');
			msg.text(cate_nm).show();
			if($('#search_msg').is(':visible')) {
				all_msg.hide();
			}
		}
		onSearch();
	});
	
	// 검색 버튼 클릭 
	$('button#search_btn').click(onSearch);
	
	// 메인페이지 검색 연동
	let {search} = _util.getUriParameter();
	if(search != undefined) {
		$('input#search_tit').val(search);
		$('input#search_tit').trigger('keypress', true);
	}
});

function onSearch() {
	
	// parameter 생성 
	let param = _pagination.getParameter();
	
	// 선택된 카테고리가 있다면 
	if($('.select-group li.active').length > 0) {
		param.cate_id = $('.select-group li.active a').data('cate_id');
	}
	
	console.log(param);
	
	// pagination 조회
	let {list, page, rowcnt, rowsize} = data = _util.ajax(_ctx+'/pro/proListData.do', param);
	
	// 총 갯수 표시
	$('#rowcnt').text(rowcnt);
	
	// 페이지네이션 세팅 
	_pagination.setPage(parseInt(page)).setRowCount(rowcnt).makePagination(rowsize);
	
	// 목록 비우기
	$('#proList').empty();
	
	// 목록 null, array 체크
	if(list != null && Array.isArray(list)) {
		
		list.forEach((e) => {
			
			console.log(e);
			
			// html 생성
			let html = proLi(e);
			
			// 클릭 이벤트 및 프로퍼티 추가
			html = $(html).click((e) => {
				
				// 추가한 프로퍼티 찾기
				let info = $(e.currentTarget).prop('info');
				
				// 상세 페이지 이동
				location.href = _ctx + '/pro/proDetail.do?prod_id=' + info.prod_id;
			}).prop('info', e);
			
			// 목록 추가
			$('#proList').append(html);
		});
	}
}



