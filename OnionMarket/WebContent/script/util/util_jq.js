(function(jQuery, $) {
	
	jQuery.prototype.changeFile = function(callback, emptyFiles=true) {
		
		this.each((i, html) => {
			if($(html).is('input:file')) {
				$(html).change((e) => {
					let files = Object.values(e.currentTarget.files).reduce((acc, e) => {
						
						acc.push({
							name: e.name,
							extension: e.name.substring(e.name.lastIndexOf('.')+1),
							size: e.size,
							lastModified: e.lastModified,
							url: URL.createObjectURL(e),
							file: e
						});
						
						return acc;
					}, []);
					
					if(callback instanceof Function) {
						callback(files);
					}
					
					// 파일 비우기 옵션
					if(typeof emptyFiles === 'boolean' && emptyFiles) {
						e.currentTarget.value = null;
					}
				});
			}
		});
		
	}
	
})(jQuery, $);


