<%@page import="kr.or.ddit.util.AmountUtil"%>
<%@page import="kr.or.ddit.vo.ProAndCateVO"%>
<%@page import="kr.or.ddit.vo.ComJoinVO"%>
<%@page import="kr.or.ddit.vo.ProCateVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
<%
	List<ProAndCateVO> proList = (List<ProAndCateVO>)request.getAttribute("proList");
	List<ProAndCateVO> proPopulList = (List<ProAndCateVO>)request.getAttribute("proPopulList");
	List<ProAndCateVO> proNewList = (List<ProAndCateVO>)request.getAttribute("proNewList");
	List<ComJoinVO> comList = (List<ComJoinVO>)request.getAttribute("comList");
	
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="icon" type="image/png" sizes="32x32" href="${_ctx}/favicon.png">
	<title>양파마켓</title>
	
	<jsp:include page="${_resource}"/>
	
	
	<script src="${_script}/main/main.js"></script>
	
</head>

<body>
	<div>
		<jsp:include page="${_header}"/>
		
        <!-- main-page 시작 -->
        <main class="main-page">
            <section class="search-area">
                <div class="inner">
                    <div class="search-box-wrap">
                    	<h1 class="tit">어떤 물품을 원하시나요?</h1>
                        <div class="search-box">
                        	<input id="searchInput" type="text" placeholder="원하는 물품을 검색해주세요!" autocomplete="off">
	                        <a id="searchBtn" href="javascript:void(0)" class="search-btn">
	                            <i class="xi-search"></i>
	                        </a>
                        </div>
                    </div>
                </div>
            </section>
            <section class="product-area">
                <div class="inner">
                    <div class="tit-area">
                        <h1 class="main-heading">우리 동네 물품</h1>
                        <a href="${_ctx}/pro/proList.do" class="more-btn">더보기</a>
                    </div>
                    <div class="cont-area">
                        <div class="swiper mySwiper">
                            <div class="swiper-wrapper">
                            	<!-- swiper-slide 시작 -->
                            	<%
                            		for(ProAndCateVO proVo : proList) {
                            	%>
                                <div class="swiper-slide">
				                    <img src="../img/example/img1.jpg" alt="예시이미지">
				                    <div class="txt-box">
				                        <p class="dong"><%= proVo.getPro_gu() %> <%= proVo.getPro_dong() %></p>
				                        <p class="tit"><%= proVo.getTit() %></p>
				                    	<p class="price"><%= AmountUtil.FormatUtil(proVo.getPrice()) %></p>
				                    </div>
				                </div>
								<%
                            		}
								%>                            			
                              	<!-- swiper-slide 끝 -->
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <section class="product-area product-area2">
                <div class="inner">
                    <div class="tit-area">
                        <h1 class="main-heading">실시간 인기 물품</h1>
                        <a href="${_ctx}/pro/proList.do" class="more-btn">더보기</a>
                    </div>
                    <div class="cont-area">
                        <div class="swiper mySwiper">
                            <div class="swiper-wrapper">
                            	<!-- swiper-slide 시작 -->
                            	<%
                            		for(ProAndCateVO proVo : proPopulList) {
                            	%>
                                <div class="swiper-slide">
				                    <img src="../img/example/img1.jpg" alt="예시이미지">
				                    <div class="txt-box">
				                        <p class="dong"><%= proVo.getPro_gu() %> <%= proVo.getPro_dong() %></p>
				                        <p class="tit"><%= proVo.getTit() %></p>
				                        <p class="price"><%= AmountUtil.FormatUtil(proVo.getPrice()) %></p>
				                        <p class="view">
				                        	<i class="xi-eye"></i>
				                        	<%= proVo.getVw_cnt() %>
			                        	</p>
				                    </div>
				                </div>
								<%
                            		}
								%>                            			
                              	<!-- swiper-slide 끝 -->
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <section class="product-area product-area3">
                <div class="inner">
                    <div class="tit-area">
                        <h1 class="main-heading">방금 등록된 물품</h1>
                        <a href="${_ctx}/pro/proList.do" class="more-btn">더보기</a>
                    </div>
                    <div class="cont-area">
                        <div class="swiper mySwiper">
                            <div class="swiper-wrapper">
                            	<!-- swiper-slide 시작 -->
                            	<%
                            		for(ProAndCateVO proVo : proList) {
                            	%>
                                <div class="swiper-slide">
				                    <img src="../img/example/img1.jpg" alt="예시이미지">
				                    <div class="txt-box">
				                        <p class="dong"><%= proVo.getPro_gu() %> <%= proVo.getPro_dong() %></p>
				                        <p class="tit"><%= proVo.getTit() %></p>
				                        <p class="price"><%= AmountUtil.FormatUtil(proVo.getPrice()) %></p>
				                    </div>
				                </div>
								<%
                            		}
								%>                            			
                              	<!-- swiper-slide 끝 -->
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <section class="town-area">
                <div class="inner">
                    <div class="tit-area">
                        <h1 class="main-heading">우리 동네 커뮤니티</h1>
                        <a href="${_ctx}/com/comList.do" class="more-btn">더보기</a>
                    </div>
                    <div class="cont-area">
                        <div class="swiper mySwiper">
                            <div class="swiper-wrapper">
	                            <!-- swiper-slide 시작 -->
	                            <%
	                            	for(ComJoinVO comVo : comList) {
	                            %>
                              <div class="swiper-slide">
			                    <div class="txt-box">
			                        <p class="dong"><%= comVo.getGu() %> <%= comVo.getDong() %></p>
			                        <p class="tit"><%= comVo.getTit() %></p>
			                        <p>닉네임 :<%=comVo.getNick_nm()%></p>
			                        <p>조회수 : <%=comVo.getVw_cnt()%></p>
			                        <p>등록일자 : <%=comVo.getIns_dt() %></p>
			                    </div>
			              	  </div>
								<%								
	                            	}
								%>	                            		
								<!-- swiper-slide 끝 -->                            
							</div>
                        </div>
                    </div>
                </div>
            </section>
            <section class="notice-area">
                <div class="inner">
                    <div class="tit-area">
                        <h1 class="main-heading">공지사항</h1>
                        <a href="javascript:void(0)" class="more-btn">더보기</a>
                    </div>
                    <div class="cont-area">
                        <div class="swiper noticeSwiper">
                            <div class="swiper-wrapper">
                                <div class="swiper-slide">
                                    <div class="tit"><span>양파마켓 공지사항입니다1 </span><span>2023-12-10</span></div>
                                </div>
                                <div class="swiper-slide">
                                    <div class="tit"><span>양파마켓 공지사항입니다2</span><span>2023-12-10</span></div>
                                </div>
                                <div class="swiper-slide">
                                    <div class="tit"><span>양파마켓 공지사항입니다3</span><span>2023-12-10</span></div>
                                </div>
                                <div class="swiper-slide">
                                    <div class="tit"><span>양파마켓 공지사항입니다4</span><span>2023-12-10</span></div>
                                </div>
                                <div class="swiper-slide">
                                    <div class="tit"><span>양파마켓 공지사항입니다5</span><span>2023-12-10</span></div>
                                </div>
                                <div class="swiper-slide">
                                    <div class="tit"><span>양파마켓 공지사항입니다6</span><span>2023-12-10</span></div>
                                </div>
                                <div class="swiper-slide">
                                    <div class="tit"><span>양파마켓 공지사항입니다.</span><span>2023-12-10</span></div>
                                </div>
                                <div class="swiper-slide">
                                    <div class="tit"><span>양파마켓 공지사항입니다.</span><span>2023-12-10</span></div>
                                </div>
                                <div class="swiper-slide">
                                    <div class="tit"><span>양파마켓 공지사항입니다.</span><span>2023-12-10</span></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </main>
        <!-- main-page 끝 -->
		
		<jsp:include page="${_footer}"/>
	</div>
</body>
</html>
