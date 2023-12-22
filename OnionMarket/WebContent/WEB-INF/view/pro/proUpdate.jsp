<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="icon" type="image/png" sizes="32x32" href="${_ctx}/favicon.png">
	<title>양파마켓</title>
	
	<jsp:include page="${_resource}"/>
	
		<!-- 카카오맵 api 불러오기(APP KEY) -->
    <script type="text/javascript"
        src="//dapi.kakao.com/v2/maps/sdk.js?appkey=245955c2a1a7889af6bf2e4369f4bef4"></script>
        
</head>

<body>
	<div>
		<jsp:include page="${_header}"/>
		
		  <main class="sub-page">
            <div class="inner">
                <section class="content-area">
                    <h1 class="heading1">물품 수정</h1>

                    <form action="<%= request.getContextPath()%>" method="post">
                        <div class="commu-list">
                            <ul class="insert-cont">
                                <li class="input-group">
                                    <label for="cateId">카테고리 선택</label>
                                    <select name="cateId" id="cateId">
                                        <option value="1">의류</option>
                                        <option value="2">가전</option>
                                        <option value="3">식량</option>
                                        <option value="4">생활</option>
                                        <option value="5">신발</option>
                                        <option value="6">나눔</option>
                                        <option value="7">주방</option>
                                        <option value="8">스포츠</option>
                                        <option value="9">패션</option>
                                        <option value="10">기타</option>
                                    </select>
                                </li>
                                <li class="input-group">
                                    <label for="tit">제목</label>
                                    <input type="text" name="tit" id="tit" placeholder="제목을 입력해주세요">
                                </li>
                            	 <li class="input-group">
                                    <div class="file-wrap">
                                        <div class="file-area">
                                            <input type="file" name="" id="">
                                        </div>
                                        <div class="file-area file-item">
                                            <img src="../img/example/img4.jpg" alt="">
                                            <button type="button" class="delete-btn"></button>
                                        </div>
                                        <div class="file-area file-item">
                                            <img src="../img/example/img4.jpg" alt="">
                                            <button type="button" class="delete-btn"></button>
                                        </div>
                                    </div>
                                </li>
                                <li class="input-group">
                                    <label for="cont">내용</label>
                                    <textarea name="cont" id="cont" cols="30" rows="10" placeholder="내용을 입력해주세요"></textarea>
                                </li>
                                <li class="input-group">
                                    <label for="price">금액</label>
                                    <div class="free-area">
                                        <input type="number" name="price" id="price" placeholder="금액 입력(0원~1억)">
                                        <input type="button" id="freeBtn" value="무료나눔" class="btn-style3">
                                    </div>
                                </li>
                                <li class="location input-group">
                                	<label>거래 장소 선택</label>
                                    <!-- <input type="button" value="장소추가" class="btn-style2"> -->
                                     <div class="location-map">
                                   	    <div id="map"></div>
										<div id="clickLatlng"></div>
                                    </div>
                                </li>
                            </ul>
                        </div>
	                    <div class="btn-area">
	                        <input type="submit" value="저장하기" class="btn-style4">
	                    </div>
                    </form>

                </section>
            </div>
        </main>
		
		<jsp:include page="${_footer}"/>
	</div>
	
	<script src="${_script}/pro/map.js"></script>
</body>
</html>
