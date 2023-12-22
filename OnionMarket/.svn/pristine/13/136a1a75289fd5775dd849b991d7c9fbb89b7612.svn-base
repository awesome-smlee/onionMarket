const _html = {
	/* 사용할 페이지명 */
	proList: {
		/* 요소 네이밍 */
		proLi: function(param) {
			return `
				<li>
				    <div class="img-box">
				        <img src="../img/example/img1.jpg" alt="예시 이미지">
				    </div>
				    
				    <p class="cate">${param.cate_nm}</p>
				    <p class="tit">${param.tit}</p>
				    <p class="dong">${param.pro_gu} ${param.pro_dong}</p>
				    <p class="price">${param.price.toWonString()}</p>
				    <p class="like">좋아요<span class="like-num">${param.like_cnt}</span></p>
				</li>
			`;
		}
	},
	proInsert: {
		proImage: function(param) {
			return `
				<div class="file-area file-item">
		            <img src="${param.url}" alt="">
		            <button type="button" class="delete-btn"></button>
		        </div>
			`;
		}
	}
}