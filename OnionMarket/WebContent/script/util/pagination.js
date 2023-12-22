(function(window, jQuery){
	/* constructor */
	function Pagination({search={}, pagination={}, paginationHTML={}, sort={}}) {
		this.search = {};
		this.pagination = {
			page: 1,
			rowSize: 10,
			rowCount: 0,
			pageSize: 10,
			// target
			rowSizeTarget: null,
			pageListTarget: null,
			// parameter key
			pageParameterKey: 'page',
			rowSizeParameterKey: 'rowsize',
			rowCountParameterKey: 'rowcnt',
			// callback 
			onChangeRowSize: null,
			onChangeRowSizeParam: [],
			onClickFrst: null,
			onClickFrstParam: [],
			onClickPrev: null,
			onClickPrevParam: [],
			onClickPrevdot: null,
			onClickPrevdotParam: [],
			onClickPage: null,
			onClickPageParam: [],
			onClickNextdot: null,
			onClickNextdotParam: [],
			onClickNext: null,
			onClickNextParam: [],
			onClickLast: null,
			onClickLastParam: [],
			onClickAll: null,
			onClickAllParam: [],
		};
		this.paginationTarget = {
			frst: null,
			prev: null,
			prevdot: null,
			nextdot: null,
			next: null,
			last: null,	
		};
		this.paginationHTML = {
			frst: (page) => { return `<a href="javascript:void(0);" class="arr first"><span class="sr-only" style="display:none;">처음</span></a>` },
			prev: (page) => { return `<a href="javascript:void(0);" class="arr prev"><span class="sr-only" style="display:none;">이전</span></a>` },
			prevdot: (page) => { return `<a href="javascript:void(0);" class="arr dot"><span class="sr-only" style="display:none;">이전장</span></a>` },
			page: (page, isActive) => { return `<a href="javascript:void(0);" class="page ${isActive ? 'active' : ''}">${page}</a>`},
			nextdot: (page) => { return `<a href="javascript:void(0);" class="arr dot"><span class="sr-only" style="display:none;">다음장</span></a>`},
			next: (page) => { return `<a href="javascript:void(0);" class="arr next"><span class="sr-only" style="display:none;">다음</span></a>` },
			last: (page) => { return `<a href="javascript:void(0);" class="arr last"><span class="sr-only" style="display:none;">마지막</span></a>` },
		};
		this.sort = {};
		/* init search */ 
		Object.entries(search).forEach(([k,v]) => this.search[k] = Object.assign({
			value: null,
			preValue: null,
			target: null,
			onChangeTarget: null,
			onChangeTargetParam: [],
			autoSet: true,
		}, v));
		// set target change event
		Object.entries(this.search).forEach(([k,v]) => {
			$(v.target).on('input', {_this: this, search:v}, changeSearchTarget);
		});
		
		/* init pagination */
		this.pagination = Object.assign(this.pagination, pagination);
		this.paginationHTML = Object.assign(this.paginationHTML, paginationHTML);
		// set row size, change event
		if(this.pagination.rowSizeTarget) {
			var tagName = $(this.pagination.rowSizeTarget).prop('tagName');
			if(tagName === 'SELECT') this.pagination.rowSize = parseInt($(this.pagination.rowSizeTarget).find('option:selected').val()); 
			$(this.pagination.rowSizeTarget).on('input', this, changeRowSize);
		}
		//$(this.pagination.rowSizeTarget).on('input', this, changeRowSize);
		
		/* init sort */
		Object.entries(sort).forEach(([k,v]) => this.sort[k] = Object.assign({
			value: null,
			target: null,
			onChangeTarget: null,
			onChangeTargetParam: [],
			autoSet: true,
			event: 'click',
			
			type: 3 // 2: null, true vs 3: null, asc, desc
		}, v));
		// set target click event
		Object.entries(this.sort).forEach(([k,v]) => {
			$(v.target).on(v.event, {_this:this, sort:v}, eventSortButton);
		});
	};
	
	// search target change event
	var changeSearchTarget = function(e) {
		var _this = e.data._this, _s = e.data.search;
		// set value 
		if(_s.autoSet) {
			// input
			_s.value = this.value || null;
			// select
			if($(_s.target).prop('tagName') === 'SELECT') {
				if (!this.options.selectedIndex || this.options.selectedIndex < 0) {
					this.options[0].selected = true;
				}
				_s.text = this.options[this.options.selectedIndex].text;
				if(!this.options.selectedIndex) _s.value = null;
			}
		}
		// run callback 
		if(_s.onChangeTarget && typeof _s.onChangeTarget === 'function') _s.onChangeTarget(_this, ..._s.onChangeTargetParam);
	};
	
	// row size change event
	var changeRowSize = function(e) {
		var _this = e.data, _p = _this.pagination;

		// set row size
		if($(this).prop('tagName') === 'SELECT') _p.rowSize = parseInt($(this).find('option:selected').val()); 
		
		// 생성 될 수 있는 전체 페이지 수 
		var pageCount = parseInt(_p.rowCount / _p.rowSize);
		pageCount = _p.rowCount % _p.rowSize > 0 ? ++pageCount : pageCount;
		// 마지막 page 판별
		_p.page = _p.page <= pageCount ? _p.page : pageCount;
		_p.page = Math.max(_p.page, 1);
		
		// run callback
		if(_p.onChangeRowSize && typeof _p.onChangeRowSize === 'function') _p.onChangeRowSize(_this, ..._p.onChangeRowSizeParam);
	};
	
	// page button click event 
	var clickPaginationButton = function(e) {
		
		var _this = e.data, _p = _this.pagination, _pt = _this.paginationTarget
			process = $(this).prop('process'), 
			movePage = $(this).prop('page'), 
			firstPage = $(_pt.frst).prop('page'), lastPage = $(_pt.last).prop('page');
		
		//	
		if(_p.page === movePage) return;
//		switch(process) {
//			case 'frst':
//				break;
//			case 'prev':
//				break;
//			case 'prevdot':
//				break;
//			case 'page':
//				break;
//			case 'nextdot':
//				break;
//			case 'next':
//				break;
//			case 'last':
//				break;
//		}
		// set page, prev, next
		_p.page = movePage;
		$(_pt.prev).prop('page', movePage === firstPage ? movePage : movePage-1);
		$(_pt.next).prop('page', movePage === lastPage ? movePage : movePage+1);
		// run process callback 
		var func = `onClick${process.charAt(0).toUpperCase() + process.slice(1)}`, param = `onClick${process.charAt(0).toUpperCase() + process.slice(1)}Param`;
		if(_p[func] && typeof _p[func] === 'function') _p[func](_this, ..._p[param]);
		// run all callback
		else if(_p.onClickAll && typeof _p.onClickAll === 'function') _p.onClickAll(_this, ..._p.onClickAllParam); 
		
		// log, test  
		// console.log(process, _p.page);
		_this.makePagination();
	};
	
	// sort click event
	var eventSortButton = function(e) {
		var _this = e.data._this, _s = e.data.sort;
		// set value
		if(_s.autoSet) {
			Object.entries(_this.sort).forEach(([k,v]) => {
				// 3가지 타입 
				if(_s.type == 3) {
					// 자신 값 변경 
					if(_s === v) {
						switch(v.value) {
							case null:
								// console.log(k, v.value, '=>', 'DESC');
								v.value = 'DESC';
								break;
							case 'DESC':
								// console.log(k, v.value, '=>', 'ASC');
								v.value = 'ASC';
								break;
							case 'ASC':
								// console.log(k, v.value, '=>', null);
								v.value = null;
								break;
						}
					}
					// 자신 외 null 
					else v.value = null;
				} 
				else {
					v.value = _s === v ? true : null; 
				}
			});
		} 
		// run callback 
		if(_s.onChangeTarget && typeof _s.onChangeTarget === 'function') _s.onChangeTarget(_this, ..._s.onChangeTargetParam);
	};

	/********* Pagination prototype function *********/
	Pagination.prototype.setPage = function(v) {
		if(typeof v === 'number') this.pagination.page = v;
		return this;
	}
	Pagination.prototype.setRowSize = function(v) {
		if(typeof v === 'number') this.pagination.rowSize = v;
		return this;
	}
	Pagination.prototype.setRowCount = function(v) {
		if(typeof v === 'number') this.pagination.rowCount = v;
		return this;
	}
	Pagination.prototype.makePagination = function() {
		// 
		var _p = this.pagination, _pHTML = this.paginationHTML, _pt = this.paginationTarget;
		var {page, rowSize, rowCount, pageSize} = _p;
		
		// pageListTarget clear
		$(_p.pageListTarget).children().remove();
		
		// 생성 될 수 있는 전체 페이지 수 
		var pageCount = parseInt(rowCount / rowSize);
		pageCount = rowCount % rowSize > 0 ? ++pageCount : pageCount;
		
		// 생성 될 페이지 수 제한 (pageSize)
		var mok = parseInt(page / pageSize);
		mok = page % pageSize > 0 ? mok : mok -1;
		
		// start, end page
		var s = (mok*pageSize)+1;
		var e = (mok+1)*pageSize > pageCount ? pageCount : (mok+1)*pageSize;
		
		if(pageCount) {
			// 
			var [frstHTML, prevHTML, nextHTML, lastHTML] = [
				$(_pHTML.frst(1)).click(this, clickPaginationButton).prop('process', 'frst').prop('page', 1),
				$(_pHTML.prev(page === 1 ? page : page-1)).click(this, clickPaginationButton).prop('process', 'prev').prop('page', page === 1 ? page : page-1),
				$(_pHTML.next(page === pageCount ? page : page+1)).click(this, clickPaginationButton).prop('process', 'next').prop('page', page === pageCount ? page : page+1),
				$(_pHTML.last(pageCount)).click(this, clickPaginationButton).prop('process', 'last').prop('page', pageCount)
			]; 
			_pt.frst = frstHTML, _pt.prev = prevHTML,
			_pt.next = nextHTML, _pt.last = lastHTML;
			_p.pageListTarget.append(frstHTML, prevHTML, nextHTML, lastHTML);
			
			
			// page 추가 
			for(var i=s; i<=e; i++) {
				$(_pt.next).before($(_pHTML.page(i, i === _p.page)).click(this, clickPaginationButton).prop('process', 'page').prop('page', i));
			}
			// 다음 page가 있을 경우
			if(e < pageCount) {
				_pt.nextdot = $(_pHTML.nextdot(e+1)).click(this, clickPaginationButton).prop('process', 'nextdot').prop('page', e+1);
				$(_pt.next).before(_pt.nextdot);
			} 
			// 이전 page가 있을 경우
			if(page > pageSize) {
				_pt.prevdot = $(_pHTML.prevdot(s-1)).click(this, clickPaginationButton).prop('process', 'prevdot').prop('page', s-1);
				$(_pt.prev).after(_pt.prevdot);
			}
		}
		return this;
	}
	
	/********* Search prototype function *********/
	/* auto setting (target value => value) */
	Pagination.prototype.autoSet = function() {
		Object.entries(this.search).forEach(([k,v]) => {
			switch($(this.search[k].target).prop('tagName')) {
				case 'INPUT':
					this.search[k].value = $(v.target).val() || null;
					break;
				case 'SELECT': 
					this.search[k].value = $(v.target).find('option:gt(0):selected').val() || null;
					break;
			}
		});
		return this;
	}
	/* reset target */
	Pagination.prototype.resetTarget = function(k) {
		let reset = (k) => {
			var target = $(this.search[k].target);
			switch(target.prop('tagName')) {
				case 'INPUT':
					target.val('');
					break;
				case 'SELECT': 
					target.find('option:eq(0)').prop('selected', true);
					break;
			}
		}
		if(this.search.hasOwnProperty(k)) reset(k);
		if(!k) Object.entries(this.search).forEach(([k,v]) => reset(k));
		return this;
	}
	/* reset value */
	Pagination.prototype.resetValue = function(k) {
		if(this.search.hasOwnProperty(k)) this.search[k].value = null;
		if(!k) Object.entries(this.search).forEach(([k,v]) => v.value = null);
		return this;
	}
	/* set value */
	Pagination.prototype.setValue = function(k, v) {
		if(this.search.hasOwnProperty(k)) this.search[k].value = v;
		return this;
	}
	/* get value */
	Pagination.prototype.getValue = function(k) {
		if(this.search.hasOwnProperty(k)) return this.search[k].value; 
	}
	/* get all parameter */
	Pagination.prototype.getParameter = function() {
		var pagination = this.pagination;
		return Object.assign(Object.fromEntries([
			[pagination.pageParameterKey, pagination.page],
			[pagination.rowSizeParameterKey, pagination.rowSize],
			[pagination.rowCountParameterKey, pagination.rowCount]
		]), Object.entries(this.search).reduce((acc, [k,v]) => {
			// 이전 검색 값과 현재 검색 값 다를 경우 page 초기화  
			if(v.preValue !== v.value) {
				this.pagination.page = 1;
				acc[pagination.pageParameterKey] = 1; // 앞의 PAGE 값 덮어 씌움 
			}
			// 
			v.preValue = v.value;
			//
			if(v.value) acc[k] = v.value;
			return acc;
		}, {}), Object.entries(this.sort).reduce((acc, [k,v]) => {
			if(v.value) acc[k] = v.value;
			return acc;
		}, {}));
	}
	
	/*
	 * # jquery prototype .val() 함수 수정
	 * - 현재 select 태그의 값 변경 후 callback 함수 실행이 필요함 (rowSizeTarget, search property target(select tag 인것))
	 * - change event로 직접 클릭하여 변경시 적용 되지만, option의 selected 프로퍼티로 값을 바꿀 경우 event 트리거가 안됨
	 * - change => input event로 변경
	 * - 기존 prototype val 함수 수정 
	 * - 현재 validation-check.js에 val 함수를 변경 해놨으므로 주석 (주석해제시 2번 실행됨) 
	 */
	var originVal = $.prototype.val;
    $.prototype.val = function(v) {
        var result = originVal.apply(this, arguments);
        //if(this.is('input:text') && arguments.length > 0) this.trigger('input');
        if(arguments.length > 0) this.trigger('input');
        return result;
    };
	
	window.Pagination = Pagination;
})(window, jQuery);