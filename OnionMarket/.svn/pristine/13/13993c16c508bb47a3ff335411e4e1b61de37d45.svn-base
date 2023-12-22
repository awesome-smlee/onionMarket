<%@page import="kr.or.ddit.vo.UsersVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	UsersVO vo = (UsersVO)session.getAttribute("loginUser");
%>
<header>
	<div class="inner">
		<a href="${_ctx}/main/main.do" class="logo"><span>양파</span>마켓</a>
		<nav>
			<ul class="gnb">
				<li><a id="href_proList" data-path="${_ctx}/pro/proList.do">물품거래</a></li>
				<li><a id="href_comList" data-path="${_ctx}/com/comList.do">동네 커뮤니티</a></li>
				<li><a href="${_ctx}/not/NotList">공지사항</a></li>
				<li><a href="javascript:void(0)">고객센터</a>
					<div class="depth2">
						<ul>
							<li>
								<a id="href_queList" data-path="${_ctx}/que/QueList.do" class="link">1:1문의</a> 
							</li>
							<li>
								<a id="href_polList" data-path="${_ctx}/police/policeList.do" class="link">신고</a> 
							</li>
						</ul>
					</div>
				</li>
			</ul>
		</nav>
		<div class="util-area">
			<a id="href_proInsert" href="javascript:void(0)" 
			class="crt-prod-btn" data-path="${_ctx}/pro/proInsert.do">물품등록</a>
			<%
				if(vo == null) {
			%> 
				<a href="${_ctx}/loginView">로그인</a>
			<%
				} else {
			%> 
				<a href="${_ctx}/logout.do">로그아웃</a> 
			<%
				}
			%>					
			<a id="href_myPage" href="javascript:void(0)" class="user-btn" data-path="${_ctx}/my/mainMy.do">
				<i class="xi-user"></i>
			</a> 
			<a href="javascript:void(0)" class="alarm-btn"> 
				<i class="xi-bell"></i>
			</a>
		</div>
	</div>
</header>