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

<script type="text/javascript">
$(function() {$('#userForm').on('submit', function() {
		alert("회원 탈퇴 완료 ");
		location.href = "/main/main.do";

	});
});

</script>
<body>

<%

	UsersVO userVo = (UsersVO)session.getAttribute("loginUser");

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
                    <div class="mypage-list">
                        <h1 class="heading2">회원정보 탈퇴</h1>

                        <form id="userForm" action="<%=request.getContextPath()%>/my/deleteMy.do" method="post" >
                            <div class="user-out-area">
                                <ul>
                                    <li class="input-group">
                                        <label for="user_id">아이디</label>
                                        <input type="text" id="user_id" name="user_id" value="<%=userVo.getUser_id()%>">
                                    </li>
                                    <li class="input-group">
                                        <label for="pw">비밀번호</label>
                                        <input type="password" id="pw" name="pw" placeholder="비밀번호를 입력하세요">
                                    </li>
                                    <li class="input-group">
                                        <label for="reason">탈퇴사유</label>
                                        <select name="reason" id="reason">
                                            <option>사고 싶은 물품이 없어요</option>
                                            <option>물품이 안팔려요<!-- option-->
                                            </option><option>비매너 사용자를 만났어요</option>
                                            <option>새 계정을 만들고 싶어요</option>
                                            <option>기타</option>
                                        </select>
                                       <!--  <input type="text" placeholder="기타 사유 입력" class="mt-10"> -->
                                    </li>
                                </ul>
                                <div class="btn-area">
                                    <input type="submit" value="탈퇴하기" class="btn-style4" modal-id="modal1">
                                </div>
                            </div>

                        </form>


                    </div>

                </section>
            </div>
        </main>
		
		<jsp:include page="${_footer}"/>
	</div>
</body>
</html>
