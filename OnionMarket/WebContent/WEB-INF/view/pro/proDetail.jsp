<%@page import="kr.or.ddit.vo.UsersVO"%>
<%@page import="kr.or.ddit.util.AmountUtil"%>
<%@page import="kr.or.ddit.vo.ProAndCateVO"%>
<%@page import="kr.or.ddit.vo.FileInfoVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
<% 
	ProAndCateVO proVo = (ProAndCateVO)request.getAttribute("proVo");
	UsersVO vo = (UsersVO)session.getAttribute("loginUser");
%>

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
	<script src="${_script}/pro/proDetail.js"></script>
</head>

<body>
	<div>
		<jsp:include page="${_header}"/>
		
	        <main class="sub-page">
			
			<input id="prod_id" type="hidden" value="<%= proVo.getProd_id() %>">
			<input id="lat" type="hidden" value="<%= proVo.getLat() %>">
            <input id="lng" type="hidden" value="<%= proVo.getLng() %>">
			
			
            <div class="inner">
                <section class="content-area">

                    <div class="product-view-area">
                        <div class="product-item">
                            <div class="img-box">
                                <div class="swiper prodViewSwiper">
                                    <div class="swiper-wrapper">

                                   	    <% for(FileInfoVO file : proVo.getFile_list()) { %>
											<div class="swiper-slide">	
                                        		<img src="${_ctx}/imageView?stored_nm=<%= file.getStored_nm() %>">
                                    		</div>
                                        <% } %>

                                    </div>
                                    <div class="swiper-pagination"></div>
                                </div>
                            </div>
                            <div class="txt-wrap">
                                <a href="<%=request.getContextPath()%>/pro/proList.do" class="item-home">
                                    <i class="xi-home-o"></i>
                                  	  물품 더보기
                                </a>
                                <br>
                            	<p class="like">좋아요<span id="likeCnt" class="num"><%=proVo.getLike_cnt()%></span></p>
                                <p class="cate"><%=proVo.getCate_nm()%></p>
                                <p class="tit"><%=proVo.getTit() %></p>
                                <p class="price"><%=AmountUtil.FormatUtil(proVo.getPrice()) %></p>
                                <div class="txt-hr"></div>
                                <div class="txt-info">
                                    <p>조회수<span class="num" id="viewCnt"><%=proVo.getVw_cnt() %></span></p>
                                    <p>등록일<span class="num"><%=proVo.getIns_dt()%></span></p>
                                    <p>거래 장소<span class="num"><%= proVo.getPro_gu() + " " + proVo.getPro_dong() %></span></p>
                                </div>
                            </div>
                        </div>
                        <div class="product-area">
                            <select id="proStatus" class="product-select"
                            <% if(!vo.getUser_id().equals(proVo.getIns_id())) { %>
                            disabled
                            <% } %>
                            >
                                <option value="0" <c:if test="${proVo.status eq 0}">selected</c:if>>판매중</option>
                                <option value="1" <c:if test="${proVo.status eq 1}">selected</c:if>>예약중</option>
                                <option value="2" <c:if test="${proVo.status eq 2}">selected</c:if>>거래완료</option>
                            </select>
                            
                            <%
							if(!vo.getUser_id().equals(proVo.getIns_id())) {
							%>
		                        <a id="chatBtn" href="javascript:void(0)" class="btn-style8">채팅하기</a>
	                            <a id="policeBtn" href="javascript:void(0)" class="btn-style9">신고하기</a>
	                        	<button id="likeBtn" type="button" class="like-btn
	                        	<c:if test="${proVo.is_like eq 1}">active</c:if>
	                        	"></button>
							<%
							} 
							%>
                        </div>

                        <div class="product-detail">
                            <p><%=proVo.getCont() %></p>
                        </div>
                        
                        <div class="location-map">
                         	<div id="map"></div>
							<div id="clickLatlng"></div>
                        </div>
						
						<%
						if(vo.getUser_id().equals(proVo.getIns_id())) {
						%>
	                        <div class="btn-area">
	                            <input id="updateBtn" type="button" value="수정하기" class="btn-style6">
	                            <input id="deleteBtn" type="button" value="삭제하기" class="btn-style5">
	                        </div>
						<%
						} 
						%>
                    </div>
                </section>
            </div>
        </main>
		
		<jsp:include page="${_footer}"/>
	</div>
	
     <!-- 모달시작  -->
      <div class="modal" id="modal1">
          <div class="modal-cont">
              <h1 class="modal-tit">거래자 선택</h1>

              <div class="modal-txt-area">
                  <ul class="member-choice">
                      <li>
                          <input type="checkbox" name="" id="aa">
                          <label class="profile-area" for="aa">
                              <span class="profile">
                                  <!-- 프로필 등록시 아래 img태그 추가해주세요 -->
                                  <!-- <img src="../img/example/img1.jpg(예시)"> -->
                              </span>
                              <span class="nikname">홍길동</span>
                          </label>
                      </li>
                      <li>
                          <input type="checkbox" name="" id="aa">
                          <label class="profile-area" for="aa">
                              <span class="profile">
                                  <!-- 프로필 등록시 아래 img태그 추가해주세요 -->
                                  <!-- <img src="../img/example/img1.jpg(예시)"> -->
                              </span>
                              <span class="nikname">닉네임</span>
                          </label>
                      </li>
                      <li>
                          <input type="checkbox" name="" id="aa">
                          <label class="profile-area" for="aa">
                              <span class="profile">
                                  <!-- 프로필 등록시 아래 img태그 추가해주세요 -->
                                  <!-- <img src="../img/example/img1.jpg(예시)"> -->
                              </span>
                              <span class="nikname">비타민</span>
                          </label>
                      </li>
                  </ul>

              </div>

              <div class="modal-btn-area">
                  <input type="button" value="취소하기" class="btn-style5">
                  <input type="button" value="거래확정하기" class="btn-style4">
              </div>

              <button class="close-btn"></button>
          </div>
      </div>
      <!-- 모달 끝  -->
</body>
</html>
