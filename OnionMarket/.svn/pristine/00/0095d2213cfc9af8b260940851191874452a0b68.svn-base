<%@page import="kr.or.ddit.vo.ProdMyAllVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="image/png" sizes="32x32"
	href="${_ctx}/favicon.png">
<title>양파마켓</title>

<jsp:include page="${_resource}" />
</head>
<%List<ProdMyAllVO> myList = (List<ProdMyAllVO>)request.getAttribute("myList");%>
<%List<ProdMyAllVO> myList2 = (List<ProdMyAllVO>)request.getAttribute("myList2");%>


<body>
	<div>
		<jsp:include page="${_header}" />

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

								<a href="<%=request.getContextPath()%>/my/updateMy.do">프로필
									설정</a>
							</div>
						</li>
						<li>
							<p class="tit">나의 거래</p> <a
							href="<%=request.getContextPath()%>/my/sellListMy.do">판매내역</a> <a
							href="<%=request.getContextPath()%>/my/buyListMy.do">구매내역</a> <a
							href="<%=request.getContextPath()%>/my/wishlistMy.do">위시리스트</a> <a
							href="<%=request.getContextPath()%>/my/locationMy.do">내 동네 설정</a>
							<a href="<%=request.getContextPath()%>/my/keywordMy.do">알림
								키워드 설정</a>
						</li>
						<li>
							<p class="tit">내 동네 활동</p> <a
							href="<%=request.getContextPath()%>/my/communityMy.do">커뮤니티</a>
						</li>
						<li><a href="<%=request.getContextPath()%>/my/deleteMy.do">회원정보
								탈퇴</a></li>
					</ul>
				</aside>

				<section class="content-area">
					<div class="mypage-list">
						<h1 class="heading2">판매내역</h1>

						<div class="tab-wrap">
							<div class="tab-type tab-type1">
								<div class="tab-menu">
									<button data-tab="tab1" class="tab-btn active">판매중</button>
									<button data-tab="tab2" class="tab-btn">거래완료</button>
									<!-- <div class="tab-indicator"></div> -->
								</div>

								<!-- 아이디찾기 -->
								<div data-tab="tab1" class="tab-content active">
									<div class="tab-board-lst">
										<div class="history-area">
											<ul>
												<%for(ProdMyAllVO pvo : myList){ %>
												<li>
													<div class="item">
														<div class="img-box">
															<img src="../img/example/img4.jpg" alt="이미지설명">
														</div>
														<div class="txt-wrap">
															<p class="cate"><%=pvo.getCate_nm() %></p>
															<p class="tit"><%=pvo.getTit() %></p>
															<p class="price"><%=pvo.getPrice() %></p>
														</div>
													</div>
												</li>
												<%
                            }
                                %>
											</ul>
										</div>
									</div>
								</div>

<!-- 아이디찾기 -->
								<div data-tab="tab2" class="tab-content active">
									<div class="tab-board-lst">
										<div class="history-area">
											<ul>
												<%for(ProdMyAllVO pvo2 : myList2){ %>
												<li>
													<div class="item">
														<div class="img-box">
															<img src="../img/example/img4.jpg" alt="이미지설명">
														</div>
														<div class="txt-wrap">
															<p class="cate"><%=pvo2.getCate_nm()%></p>
															<p class="tit"><%=pvo2.getTit()%></p>
															<p class="price"><%=pvo2.getPrice()%></p>
														</div>
													</div>
												</li>
												<%
                            }
                                %>
											</ul>
										</div>
									</div>
								</div>

							</div>
						</div>
					</div>
					
				<!-- 아이디찾기 -->
								

		</main>

		<jsp:include page="${_footer}" />
	</div>
</body>
</html>
