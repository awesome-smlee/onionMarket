<%@page import="kr.or.ddit.vo.ComJoinVO"%>
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
<%
List<ComJoinVO> comSearchList = (List<ComJoinVO>)request.getAttribute("comSearchList");
List<ComJoinVO> cateList = (List<ComJoinVO>)request.getAttribute("cateList");
%>
</head>

<body>
	<div>
		<jsp:include page="${_header}"/>
		
		<main class="sub-page">

            <!-- sub-menu 시작 -->
            <div class="sub-menu">
                <a href="javascript:void(0)" class="active">동네 커뮤니티</a>
                <a href="javascript:void(0)">동네 소식</a>
            </div>
            <!-- sub-menu 끝 -->

            <div class="inner">
                <aside class="left-menu">	
                    <p class="menu-tit">필터<i class="xi-filter"></i></p>

                    <div class="category-box">
                        <p class="sub-tit">카테고리 선택</p>
                        <ul class="select-group">
                        <%
                        	for(ComJoinVO cate : cateList) {
                        %>
                            <li>
                                <input style="font-size: 18px; padding: 10px 0px; background: white;" type="button" value="<%=cate.getCate_nm() %>" id="cate">
                            </li>
                          <%
                        	}
                          %>
                        </ul>
                    </div>

                    <div class="category-box">
                        <p class="sub-tit">지역별</p>
                        <ul class="select-group">
                            <li>
                                <a href="javascript:void(0)">대덕구</a>
                            </li>
                            <li>
                                <a href="javascript:void(0)">유성구</a>
                            </li>
                            <li>
                                <a href="javascript:void(0)">중구</a>
                            </li>
                            <li>
                                <a href="javascript:void(0)">서구</a>
                            </li>
                            <li>
                                <a href="javascript:void(0)">동구</a>
                            </li>
                        </ul>
                    </div>

                    <div class="keyword-search-area">
                        <p class="sub-tit">키워드</p>
                        <form action="<%=request.getContextPath()%>/com/comListBySearch.do">
                          <div class="box-wrap">
                            <input type="text" placeholder="검색어 입력" name="searchText">
                            <input type="submit" value="검색" id="search" style="width: 70px">
                          </div>
                        </form>
                    </div>

                </aside>

                <section class="content-area">

                    <div class="flex-box-both">
                        <h1 class="heading1">우리 동네 커뮤니티</h1>
                        <a href="javascript:void(0)" class="btn-style7 mb-20">내가 쓴 글 보기</a>
                    </div>

                    <div class="commu-list">
                        <div class="history-area">
                            <ul>
                            	<% 
                            		for(ComJoinVO com : comSearchList) {
                            	%>
                                <li>
                                    <div class="item" 
                                    	onclick="location.href='<%=request.getContextPath()%>/com/comDetail.do?com_id=<%=com.getCom_id()%>'">
                                        <div class="txt-wrap">
                                              <p style="display: none;" class="no">No. <%=com.getCom_id() %></p>
                                            <p class="tit"><%=com.getTit() %></p>
                                            <div class="profile-area">
                                            <div class="txt-lst">
                                                <div class="profile">
                                                    <!-- 프로필 등록시 아래 img태그 추가해주세요 -->
                                                    <!-- <img src="../img/example/img1.jpg(예시)"> -->
                                                </div>
                                                <p class="nikname"><%=com.getNick_nm() %></p>
                                            </div>
                                                <p class="cate"><%=com.getCate_nm() %></p>
                                                <p class="dong"><%=com.getDong() %></p>
                                                <p class="date"><%=com.getIns_dt() %></p>
                                                <p class="cnt"><%=com.getVw_cnt() %></p>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                                <%
                            		}
                                %>
                              
                            </ul>

                            <!-- pager 시작 -->
                            <div class="pager">
                                <a href="javascript:void(0);" class="arr prev"></a>
                                <strong class="active">1</strong>
                                <a href="javascript:void(0);">2</a>
                                <a href="javascript:void(0);">3</a>
                                <a href="javascript:void(0);">4</a>
                                <a href="javascript:void(0);">5</a>
                                <a href="javascript:void(0);">6</a>
                                <a href="javascript:void(0);">7</a>
                                <a href="javascript:void(0);">8</a>
                                <a href="javascript:void(0);" class="arr next"></a>
                            </div>
                            <!-- pager 끝 -->
                        </div>
                    </div>

                    <div class="btn-area">
                        <input type="button" value="게시글 등록하기" class="btn-style4" id="insert">
                    </div>

                </section>
            </div>

        </main>
		
		<jsp:include page="${_footer}"/>
	</div>
</body>
</html>