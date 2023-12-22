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
	<script src="${_script}/pro/html.js"></script>
	<script src="${_script}/pro/proList.js"></script>
	
</head>

<body>
	<div>
		<jsp:include page="${_header}"/>
		
		<!-- sub-page 시작 -->
        <main class="sub-page">

            <div class="inner">
                <aside class="left-menu">
                    <p class="menu-tit">필터<i class="xi-filter"></i></p>
                    <div class="search-box">
                        <input id="sort_a" type="button" value="최신순">
                        <input id="sort_b" type="button" value="좋아요순">
                        <input id="sort_c" type="button" value="낮은가격순">
                        <input id="sort_d" type="button" value="높은가격순">
                    </div>

                    <div class="category-box">
                        <p class="sub-tit">카테고리 선택</p>
                        <ul class="select-group search-box">
                        	
                        	<c:forEach items="${cateList}" var="e" varStatus="loop">
                        		<li>
	                                <a href="javascript:void(0)" data-cate_id="${e.cate_id}">${e.cate_nm}</a>
	                            </li>
                        	</c:forEach>
                        </ul>
                    </div>

                </aside>

                <section class="content-area">

					<div class="item-search-box">
                        <input id="search_tit" type="text" placeholder="원하는 물품을 검색해주세요.">
                        <button id="search_btn" type="button" class="sch-btn"></button>
                    </div>
                    
                    <div class="flex-box-both">
                        <p class="current-search">
                            
                            <span id="cate_msg" class="item" style="display:none;"></span>
                            <span id="search_msg"  style="display:none;"><span class="item">" 검색 "</span> 의 검색 결과</span>
                            <span id="all_msg" class="item">전체</span>
                            <span id="rowcnt">0</span>개의 상품
                        </p>
                        <a href="javascript:void(0)" class="btn-style7 mb-20">내가 쓴 글 보기</a>
                    </div>

                    <div class="content-list">
                        <ul id="proList">
                           <!-- proLi 영역 -->
                        </ul>

                        <!-- pager 시작 -->
                        <div id="pagination" class="pager">
                        </div>
                        <!-- pager 끝 -->
                    </div>

                    <div class="btn-area">
                        <a id="href_proInsert" href="javascript:void(0);" data-path="${_ctx}/pro/proInsert.do" class="btn-style4">물품 등록하기</a>
                    </div>

                </section>
            </div>
        </main>
        <!-- sub-page 끝 -->
		
		<jsp:include page="${_footer}"/>
	</div>
</body>
</html>
