<%@page import="kr.or.ddit.vo.ProdMyAllVO"%>
<%@page import="java.util.List"%>
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
</head>

<body>
	<div>
		<jsp:include page="${_header}"/>
		
		<main class="sub-page">

            <div class="inner">
                <aside class="left-menu border-r">
                    <p class="menu-tit">마이페이지</p>

                    <ul class="mypage-menu">
                        <li>
                            <div class="profile-area">
                                <div class="profile">
                                    <!-- 프로필 등록시 아래 img태그 추가해주세요 -->
                                    <!-- <img src="../img/example/img1.jpg(예시)"> -->
                                </div>

                                <a href="javascript:void(0)">프로필 설정</a>
                            </div>
                        </li>
                        <li>
                            <p class="tit">나의 거래</p>
                            <a href="javascript:void(0)">판매내역</a>
                            <a href="javascript:void(0)" class="active">구매내역</a>
                            <a href="javascript:void(0)">위시리스트</a>
                            <a href="javascript:void(0)">내 동네 설정</a>
                            <a href="javascript:void(0)">알림 키워드 설정</a>
                        </li>
                        <li>
                            <p class="tit">내 동네 활동</p>
                            <a href="javascript:void(0)">커뮤니티</a>
                        </li>
                        <li>
                            <a href="javascript:void(0)">회원정보 탈퇴</a>
                        </li>
                    </ul>
                </aside>

                <section class="content-area">
                    <div class="mypage-list">
                        <h1 class="heading2">후기 상세</h1>
<%
	 List<ProdMyAllVO> review = (List<ProdMyAllVO>)request.getAttribute("review");

%>
                        <!-- review-area 시작-->
                        <div class="review-area">
<% 
	for(ProdMyAllVO prodmyvo : review){
%>
                            <ul class="review-view">
                                <li>
                                    <p class="board-tit"><%=prodmyvo.getTit() %></p>
                                </li>
                                <li>
                                    <hr class="hr">
                                </li>
                                <li>
                                    <div class="star-grade-view">
                                        <div>별점<%=prodmyvo.getStar() %></div>
                                    </div>
                                </li>
                                <li>
                                    <p class="board-txt"> <%=prodmyvo.getCont() %> </p>
                                </li>
                                <li>
                                    <img src="../img/noimage.png" alt="">
                                </li>

                            </ul>

                            <div class="btn-area">
                                <input type="button" value="뒤로가기" class="btn-style5">
                            </div>

                        </div>
                        <%} %>
                        <!-- review-area 끝-->
                    </div>

                </section>
            </div>
        </main>
		
		<jsp:include page="${_footer}"/>
	</div>
</body>
</html>
