(function() {
	/* JSON string 여부 판단 */
	String.prototype.isJSONString = function() {
		try {
			JSON.parse(this.toString());
			return true;
		} catch(err) {
			return false;
		}
	};
	/* timezone offset 여부 판단 (+09:00, -09:00) */
	String.prototype.isZString = function() {
		return /^(\+|\-)(\d{2}):(\d{2})$/.test(this.toString());
	};
	/* 원화 표기(3자리수 마다 ,) */
	String.prototype.toWonString = function() {
		var [a, ...b] = this.toString().split('.');
	    return a.replace(/\B(?=(\d{3})+(?!\d))/g, ",") + (b.length ? '.' : '') + b.join('.');
	};
	String.prototype.toCeil = function(decimalPlace=0) {
		var a = '1';
		if(decimalPlace>0) while(decimalPlace--){a+='0'}
		a = parseInt(a);
		return Math.ceil(this.valueOf() * a) / a;
	};
	String.prototype.toFloor = function(decimalPlace=0) {
		var a = '1';
		if(decimalPlace>0) while(decimalPlace--){a+='0'}
	    a = parseInt(a);
	    return Math.floor(this.valueOf() * a) / a;
	};
	String.prototype.toRound = function(decimalPlace=0) {
		var a = '1';
		if(decimalPlace>0) while(decimalPlace--){a+='0'}
		a = parseInt(a);
	    return Math.round(this.valueOf() * a) / a;
	};
	String.prototype.toCharArray = function() {
		let charArray= [];

		for (let c of this) {
			charArray.push(c);
	    }
		return charArray;
	};
	String.prototype.toNumber = function(b = null) {
		return toNumber(this);
	}
	String.prototype.replaceAt = function(i, str) {
		if(!(typeof i === 'number' && ['number', 'string'].includes(typeof str))) return this.toString();
		return this.substr(0, i) + str + this.substr(i+1, this.length);
	}
	String.prototype.addAt = function(i, str) {
		if(!(typeof i === 'number' && ['number', 'string'].includes(typeof str))) return this.toString();
	    return this.substr(0, i) + str + this.substr(i,this.length);
	}
	String.prototype._HTMLSpecialChar = {
		'&': '&amp;',
		'>': '&gt;',
		'<': '&lt;',
		' ': '&nbsp;',
		'\"': '&quot;',
	}
	String.prototype.encodeHTMLSpecialChar = function() {
		let exceptions = Object.values(''._HTMLSpecialChar).map((e) => e.replace('&', ''));
		return Object.entries(this._HTMLSpecialChar).reduce((acc, [k, v]) => acc.replace(new RegExp(`${k}(?!${exceptions.join('|')})`), v), this);
	}
	String.prototype.decodeHTMLSpecialChar = function() {
		return Object.entries(this._HTMLSpecialChar).reduce((acc, [k, v]) => acc.replace(v, k), this); 
	}
	/* 원화 표기(3자리수 마다 ,) */
	Number.prototype.toWonString = function() {
		var [a, ...b] = this.toString().split('.');
		return a.replace(/\B(?=(\d{3})+(?!\d))/g, ",") + (b.length ? '.' : '') + b.join('.');
	};
	/* 소수점 올림 decimalPlace=자릿수 */
	Number.prototype.toCeil = function(decimalPlace=0) {
		var a = '1';
		if(decimalPlace>0) while(decimalPlace--){a+='0'}
		a = parseInt(a);
		return Math.ceil(this.valueOf() * a) / a;
	};
	/* 소수점 버림 decimalPlace=자릿수 */
	Number.prototype.toFloor = function(decimalPlace=0) {
		var a = '1';
		if(decimalPlace>0) while(decimalPlace--){a+='0'}
		a = parseInt(a);
		return Math.floor(this.valueOf() * a) / a;
	};
	/* 소수점 반올림 decimalPlace=자릿수 */
	Number.prototype.toRound = function(decimalPlace=0) {
		var a = '1';
		if(decimalPlace>0) while(decimalPlace--){a+='0'}
		a = parseInt(a);
		return Math.round(this.valueOf() * a) / a;
	};
	/* 파일 사이즈 문자열로 변환 */
	Number.prototype.toFileSizeString = function(decimalPlace=0, format='%s %u') {
		let size = this.valueOf();
		if(isNaN(size) || size === Infinity || size === -Infinity) return this.valueOf().toString();

		decimalPlace = typeof decimalPlace === 'number' ? decimalPlace : 0;
		format = typeof format === 'string' ? format : '%s %u';

		let units = ['bytes', 'KB', 'MB', 'GB', 'TB', 'PB', 'EB', 'ZB', 'YB'];
		let unit;
		for(var i=0; i<units.length; i++) {
			unit = units[i];
			if(Number.parseInt(size/1024) > 0) size = size / 1024;
			else break;
		}

		size = size.toFixed(decimalPlace).replace(/\.[0]{1,}$/, '');

		if(format && typeof format === 'string')
			return format.replaceAll('%s', size).replaceAll('%u', unit);
	    else
	    	return `${size} ${unit}`;
	};
	
	/* json deep parse - JSON.parse는 1depth 만 변환, JSON.deepParse는 전체 depth 변환 */
	// ex) JSON.deepParse({a:1, b:JSON.stringify({a:'12345'}), c:'12345678', d:['12345678910', '2', '1234567']}, 7, 10);
	JSON.deepParse = function(t, notToParseLimitNumberAboveLength=8, notToParseLimitNumberBelowLength) {
		function getType(t) {
			return Object.prototype.toString.call(t).slice(8, -1).toLowerCase();
		}

	    /*
	     * 	# 숫자 문자열 변환 여부 설정
	     *  : 예를들어 '20221001010000879' 과 같은 key 값으로 사용하는 숫자문자열을 숫자로 치환하기 싫은 경우
	     *    notToParseLimitNumberAboveLength(이상), notToParseLimitNumberBelowLength(이하) 설정 값으로 설정 가능함
	     *    설정 된 값으로 특정 자릿수의 숫자 문자열을 number로 파싱을 제한 할 수 있음
	     *
	     *   [!] JSON.parse('20221001010000879') => 20221001010000880
	     *   : 일정 길이 이상의 숫자문자열을 파싱할 경우 반올림, 버림 현상이 발생하는 이슈가 있음
	     */
	    let above = notToParseLimitNumberAboveLength
	    below = notToParseLimitNumberBelowLength;
	    above = getType(above) === 'number' && above > 0 ? above : '';
	    below = getType(below) === 'number' && below > 0 ? below : '';
	    let numberRegex = new RegExp(`^\\d{${above},${below}}$`);
	    let numberSalt = '!NOTNUMBER!;';

	    let type = getType(t);
	    if(['object', 'array'].includes(type)) {
	    	let list = type === 'object' ? Object.entries(t) : t;
	    	return list.reduce((acc, e, i, arr) => {
	    		if(type === 'object') {
	    			let [k,v] = e;
	    			acc[k] = JSON.deepParse(v, above, below);
	    		}
	    		else if(type === 'array') {
	    			let type2 = getType(e);
	    			if(['object', 'array'].includes(type2))
	    				acc.push(JSON.deepParse(e), above, below);
	    			else if(['string'].includes(type2)) {
	    				e = e.replace(numberRegex, `${numberSalt}${e.match(numberRegex)}`);
	    				acc.push(e.isJSONString() ? JSON.deepParse(JSON.parse(e), above, below) : e.replaceAll(numberSalt, ''));
	    			}
	    			else
	    				acc.push(e);
	    		}
	    		return acc;
	      }, type === 'object' ? {} : []);
	    }
	    else if(['string'].includes(type)) {
	    	t = t.replace(numberRegex, `${numberSalt}${t.match(numberRegex)}`);
	    	return t.isJSONString() ? JSON.deepParse(JSON.parse(t), above, below) : t.replaceAll(numberSalt, '');
	    }
	    else
	    	return t;
	};
})();

function isNull(...args) {
	const checkIsNull = (e) => {
		let b = false;
		if (e == null || typeof e === 'undefined') {
			b = true;
	    } else {
	    	if (e instanceof jQuery) {
	    		b = (e.length === 0);
	    	}
	    }
	    return b;
	};

	return args.some(checkIsNull);
}

function nvl(a, b) {
	return isNull(a) ? b : a;
}

function nvl2(a, b, c) {
	return isNull(a) ? b : c;
}

function nvl3(a, b) {
	return isNullOrEmpty(a) ? b : a;
}

function nvl4(a, b, c) {
	return isNullOrEmpty(a) ? b : c;
}

function toNumber(a, b = null) {
	let result;
	if (isNaN(a)) {
		result = b;
	} else {
		result = Number(a);
	}
	return result;
}

function isNullOrEmpty(...args) {
	const checkIsNullOrEmpty = (e) => {
		if(e == null || typeof e === 'undefined') {
			return true;
		} else {
			if(typeof e === 'string') {
				return (isNull(e) || e.trim() === '');
			} else if (Array.isArray(e)) {
				return (isNull(e) || e.length === 0);
			} else {
				if(e.hasOwnProperty('length') && e.length > 0) {
					return (isNull(e) || e.length === 0);
				} else {
					return isNull(e);
				}
			}
		}
	};
	return args.some(checkIsNullOrEmpty);
}