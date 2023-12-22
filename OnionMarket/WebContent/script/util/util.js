const _util = {
	ajax: function(url, param={}, options={}) {
		
	    let result;

	    $.ajaxSettings.traditional = true;
	    $.ajax(Object.assign({
	    	url : url,
	    	type : 'get',
	    	traditional: true,
	    	data : param,
	    	async : false,	// 동기화
	    	error : function (req, status, err) {
	    		console.log(req, status, err);
	    	},
	    	success : function(data) {
	    		result = data;
	    	},
	    }, options));
	    return result;
	},
	ajaxFile: function(url, param) {
		let result;

	    $.ajaxSettings.traditional = true;
	    $.ajax({
	    	url : url,
	    	async : false,	// 동기화
	    	data : param,
	    	dataType: 'json',
	    	// 파일 전송시
	    	type: 'POST',
	    	processData: false,	// data를 String으로 변환하지 않음
	    	contentType: false, // content-type 헤더가 multipart/form-data로
								// 전송되게 함
	    	cache: false,		// 갱신된 데이터 받으려면
	    	error: function(req, status, err){
	    		console.log(req, status, err);
	    	},
	    	success : function(data){
	    		result = data;
	    	}
	    });
	    return result;
	},
	/*
	 * 파라미터 변환
	 * - 2depth 이상 object, array => JSON string
	 * - File 객체 있을 경우, {} => formData
	 */
	convertParam: function(param={}) {
		// 파일 포함 여부
		let hasFile = Object.entries(param).filter(([k,v]) => v instanceof File).length > 0;
		return Object.entries(param).reduce((acc, [k,v]) => {
			let type = Object.prototype.toString.call(v).slice(8, -1).toLowerCase();
			let newValue = ['object', 'array'].includes(type) ? JSON.stringify(v) : v;
			
			if(!hasFile) acc[k] = newValue;
			else acc.append(k, newValue);

			return acc;
		}, !hasFile ? {} : new FormData);
	},
	
	/* type 체크 */
	// string, number, array, object, null, undifined, function...
	getType: function(t) {
		return Object.prototype.toString.call(t).slice(8, -1).toLowerCase();
	},
	
	/* 쿠키 관련 */
	cookie: {
	    /* array 구분자 */
	    arrSeparator: '||array||',
	    set: function(key, value, expire=1, type='hour') {

	    	/* expire time */
	    	var date = new Date();
	    	if(type === 'day') date.setTime(date.getTime() + expire * 24 * 60 * 60 * 1000);
	    	if(type === 'hour') date.setTime(date.getTime() + expire * 60 * 60 * 1000);
	    	if(type === 'min') date.setTime(date.getTime() + expire * 60 * 1000);
	    	if(type === 'sec') date.setTime(date.getTime() + expire * 1000);

	    	/* convert */
	    	var type = _util.getType(value);
	    	// json
	    	if(type === 'object') value = JSON.stringify(value);
	    	// array
	    	else if(type === 'array') value = value.join(_util.cookie.arrSeparator);
	    	document.cookie = key + '=' + encodeURI(value) + ';expires=' + date.toUTCString() + ';path=/';
	    },
	    get: function(key) {
	    	var result = null,
	          	value = document.cookie.match('(^|;) ?' + key + '=([^;]*)(;|$)');
	    	value = value ? decodeURI(value[2]) : null;

	    	/* convert */
	    	var type = _util.getType(value);
	    	// json
	    	if(type === 'string' && value.isJSONString()) result = JSON.parse(value);
	    	// array
	    	else if(type === 'array' && value.includes(_util.cookie.arrSeparator)) result = value.split(_util.cookie.arrSeparator);
	    	else result = value;
	    	return result;
	    },
	    remove: function(key) {
	    	document.cookie = key + '=; expires=Thu, 01 Jan 1999 00:00:10 GMT;path=/';
	    },
	    has: function(key) {
	    	return document.cookie.match('(^|;) ?' + key + '=([^;]*)(;|$)') ? true : false;
	    },
	},
	/* html tag 복사 */
	copyTag : function(e, attr) {
		let copy = $(e).clone();
	    Object.entries(attr).forEach(([k, v]) => copy.attr(k, v));
	    return copy;
	},
	getUriParameter: function() {
		return decodeURI(location.search).replace(/^\?/, '').split('&').reduce((acc, e) => {
			let [k, v] = e.split('=');
			acc[k] = v;
			return acc;
		},{});
	},
	/* URL로 Base64 Data를 받아 File 객체로 변환 */
	convertToFileByURL: async function(url, filename='temp', extension='png') {
		let file;
		await new Promise((resolve, reject) => {

			let xhr = new XMLHttpRequest();

			xhr.onload = () => {
				let reader = new FileReader();
				reader.onloadend = function() {
					resolve(reader.result);
					let img = new Image();
					img.src = reader.result;

				}
				reader.readAsDataURL(xhr.response);
			}
			xhr.open('GET', url);
			xhr.responseType = 'blob';
			xhr.send();
		}).then((e) => e.split(',')[1]).then((base64) => {
			let type = {png: 'image/png', jpg: 'image/jpg', jpeg: 'image/jpeg', gif: 'image/gif'};
			type = type[extension] || type.png;
			let byteString = atob(base64);
			let ab = new ArrayBuffer(byteString.length);
			let ua = new Uint8Array(ab);
			for(let i = 0; i < byteString.length; i++) {
				ua[i] = byteString.charCodeAt(i);
			}
			let blob = new Blob([ab], {type: type});
			let fd = new FormData();
			fd.append('file', blob, `${filename}.${type.replaceAll('image/', '')}`);
			file = fd.get('file');
		});
	    return file;
	},
}
