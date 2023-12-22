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
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=245955c2a1a7889af6bf2e4369f4bef4&libraries=services"></script>
	<script src="${_script}/pro/html.js"></script>
	<script src="${_script}/pro/proInsert.js"></script>
</head>

<body>
	<div>
		<jsp:include page="${_header}"/>
		
	     <main class="sub-page">
            <div class="inner">
                <section class="content-area">
                    <h1 class="heading1">
            		<c:choose>
						<c:when test="${ isUpdate }">
							물품 수정	
						</c:when>
						<c:otherwise>
							물품 등록
						</c:otherwise>
					</c:choose>
                    </h1>

					<!-- enctype="multipart/form-data" => 파일 전송 -->
                    <form action="${_ctx}/pro/proInsertForm.do" method="post" enctype="multipart/form-data">
                    
                    	<!-- 수정 일 경우 prod_id -->
                    	<input type="hidden" id="prod_id" name="prod_id" value="${prod_id}">
                    
                    	<!-- 위도, 경도 -->
                    	<input type="hidden" id="lat" name="lat">
                    	<input type="hidden" id="lng" name="lng">
                    	<input type="hidden" id="pro_gu" name="pro_gu">
                    	<input type="hidden" id="pro_dong" name="pro_dong">
                    	
                        <div class="commu-list">
                            <ul class="insert-cont">
                                <li class="input-group">
                                    <label for="cate_id">카테고리 선택</label>
                                    <select name="cate_id" id="cate_id">
                                    	<c:forEach items="${cateList}" var="e" varStatus="loop">
                                        	<option value="${e.cate_id}">${e.cate_nm}</option>
                                        </c:forEach>
                                    </select>
                                </li>
                                <li class="input-group">
                                    <label for="tit">제목</label>
                                    <input type="text" name="tit" id="tit" placeholder="제목을 입력해주세요">
                                </li>
                            	 <li class="input-group">
                                    <div id="imageList" class="file-wrap">
                                        <div class="file-area">
                                            <input id="file" type="file" accept=".jpg,.jpeg,.png">
                                        </div>
                                        <!-- image 목록 영역 -->
                                    </div>
                                </li>
                                <li class="input-group">
                                    <label for="cont">내용</label>
                                    <textarea name="cont" id="cont" cols="30" rows="10" placeholder="내용을 입력해주세요"></textarea>
                                </li>
                                <li class="input-group">
                                    <label for="price">금액</label>
                                    <div class="free-area">
                                        <input type="number" name="price" id="price" placeholder="금액 입력(0원~1억)" size="9" value="0">
                                        <input type="button" id="freeBtn" value="무료나눔" class="btn-style3">
                                    </div>
                                </li>
                                <li class="location input-group">
                                	<label>거래 장소 선택</label>
                                    <div class="location-map">
                                   	    <div id="map"></div>
										<div id="clickLatlng"></div>
                                    </div>
                                </li>
                            </ul>
                        </div>
	                    <div class="btn-area">
	                        <input id="savaBtn" type="button" value="저장하기" class="btn-style4">
	                    </div>
                    </form>

                </section>
            </div>
        </main>
		
		<jsp:include page="${_footer}"/>
	</div>
</body>
</html>
