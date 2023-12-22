<%@page import="kr.or.ddit.vo.ProdMyAllVO"%>
<%@page import="kr.or.ddit.vo.UsersVO"%>
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

<% UsersVO userVo = (UsersVO)session.getAttribute("loginUser");
//ProdMyAllVO proVo = (ProdMyAllVO)session.getAttribute("loginUser");
%>


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

                                <a href="<%=request.getContextPath()%>/my/updateMy.do">프로필 설정</a>
                            </div>
                        </li>
                        <li>
                            <p class="tit">나의 거래</p>
                            <a href="<%=request.getContextPath()%>/my/sellListMy.do">판매내역</a>
                            <a href="<%=request.getContextPath()%>/my/buyListMy.do">구매내역</a>
                            <a href="<%=request.getContextPath()%>/my/wishlistMy.do">위시리스트</a>
                            <a href="<%=request.getContextPath()%>/my/locationStart.do">내 동네 설정</a>
                            <a href="<%=request.getContextPath()%>/my/keywordMy.do">알림 키워드 설정</a>
                        </li>
                        <li>
                            <p class="tit">내 동네 활동</p>
                            <a href="<%=request.getContextPath()%>/my/communityMy.do">커뮤니티</a>
                        </li>
                        <li>
                            <a href="<%=request.getContextPath()%>/my/deleteMy.do">회원정보 탈퇴</a>
                        </li>
                    </ul>
                </aside>

                <section class="content-area">
                    <form action="/my/updateMy.do">
                        <div class="mypage-list">
                            <h1 class="heading2 txt-center">프로필 조회</h1>
                            <ul class="type-view">
                                <li>
                                    <div class="profile-area">
                                        <div class="profile"></div>
                                    </div>
                                </li>
                                <li>
                                    <p class="sub-tit">닉네임</p>
                                    <p class="sub-txt"><%=userVo.getNick_nm()%></p>
                                </li>
                                <li>
                                    <p class="sub-tit">휴대폰번호</p>
                                    <p class="sub-txt"><%=userVo.getTel()%></p>
                                </li>
                                <li>
                                    <p class="sub-tit">이메일</p>
                                    <p class="sub-txt"><%=userVo.getEmail()%></p>
                                </li>
                                <li>
                                    <p class="sub-tit">내 동네</p>
                                    <p class="sub-txt"><%=userVo.getDong() %></p>
                                </li>

                            </ul>
                        </div>

                        <div class="btn-area txt-center">
                            <input type="submit" value="수정하기" class="btn-style4 mt-30">
                        </div>
                    </form>

                </section>
            </div>

        </main>
		
		<jsp:include page="${_footer}"/>
	</div>
</body>
</html>
