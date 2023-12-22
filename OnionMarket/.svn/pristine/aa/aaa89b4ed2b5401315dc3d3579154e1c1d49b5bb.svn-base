<%@page import="kr.or.ddit.vo.UsersVO"%>

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



<%

	UsersVO userVo = (UsersVO)request.getAttribute("userVo");

%>



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

                            <a href="<%=request.getContextPath()%>/my/locationMy.do">내 동네 설정</a>

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

                    <form method="post" enctype="multipart/form-data"

                action="<%=request.getContextPath()%>/my/updateMy.do">

                        <div class="mypage-list">

                            <h1 class="heading2">프로필 설정</h1>

                            <ul>

                                <li>

                                    <div class="profile-area">

                                        <div class="profile">

                                            <!-- 프로필 등록시 아래 img태그 추가해주세요 -->

                                            <!-- <img src="../img/example/img1.jpg(예시)"> -->

                                        </div>

                                        <input type="file" name="" id="" class="mt-10" value="이미지변경">

                                    </div>

                                </li>

                                <li class="input-group">

                                    <label for="pw">비밀번호</label>

                                    <input type="text" id="pw" name="pw" placeholder="비밀번호를 입력해주세요">

                                </li>

                                <li class="input-group">

                                    <label for="pw2">비밀번호 확인</label>

                                    <input type="text" id="pw2" name="pw2" placeholder="입력한 비밀번호와 동일한 비밀번호를 입력해주세요">

                                 <!--    <p class="msg-txt1">인증번호가 일치합니다.</p>

                                    <p class="msg-txt2">인증번호가 일치하지 않습니다.</p> -->

                                </li>

                                <li class="input-group">

                                    <label for="nick_nm">닉네임</label>

                                    <input type="text" id="nick_nm" name="nick_nm" value="<%=userVo.getNick_nm()%>">

                                </li>

                                <li class="input-group">

                                    <label for="tel">휴대폰번호</label>

                                    <input type="text" id="tel" name="tel" value="<%=userVo.getTel()%>">

                                </li>

                                <li class="input-group">

                                    <label for="email">이메일</label>

                                    <div class="wrap">

                                        <input type="email" id="email" name="email" class="input" value="<%=userVo.getEmail()%>">

                                    </div>

                                </li>

                            </ul>

                        </div>



                        <input type="submit" value="저장하기" class="btn-style4 mt-30">

                    </form>



                </section>

            </div>



        </main>

		

		<jsp:include page="${_footer}"/>

	</div>

</body>

</html>