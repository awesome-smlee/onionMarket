<%@page import="kr.or.ddit.vo.ComJoinVO"%>
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

<%
	List<ComJoinVO> cateList = (List<ComJoinVO>)request.getAttribute("cateList");
	String tit = (String)request.getAttribute("tit");
	String cont = (String)request.getAttribute("cont");
	int comId = (int)request.getAttribute("comId");
%>
</head>

<body>
	<div>
		<jsp:include page="${_header}" />

		<main class="sub-page">

			<!-- sub-menu 시작 -->
			<div class="sub-menu">
				<a href="javascript:void(0)" class="active">동네 커뮤니티</a> <a
					href="javascript:void(0)">동네 소식</a>
			</div>
			<!-- sub-menu 끝 -->

			<div class="inner">
				<aside class="left-menu">
					<p class="menu-tit">
						필터<i class="xi-filter"></i>
					</p>

					<div class="category-box">
						<p class="sub-tit">카테고리 선택</p>
						<ul class="select-group">
							<%
                        for(ComJoinVO cate : cateList) {
                        %>
							<li><a href="javascript:void(0)"><%=cate.getCate_nm() %></a>
							</li>
							<%
                        }
                        %>
						</ul>
					</div>

					<div class="category-box">
						<p class="sub-tit">지역별</p>
						<ul class="select-group">
							<li><a href="javascript:void(0)">대덕구</a></li>
							<li><a href="javascript:void(0)">유성구</a></li>
							<li><a href="javascript:void(0)">중구</a></li>
							<li><a href="javascript:void(0)">서구</a></li>
							<li><a href="javascript:void(0)">동구</a></li>
						</ul>
					</div>

					<div class="keyword-search-area">
						<p class="sub-tit">키워드</p>
						<div class="box-wrap">
							<input type="text" placeholder="검색어 입력"> <a
								href="javascript:void(0)" class="search-btn"></a>
						</div>
					</div>

				</aside>

				<section class="content-area">
					<form action="<%=request.getContextPath()%>/com/comInsert.do" method="get">
					  <input type="hidden" name="comId" value="<%= comId %>">
						<h1 class="heading1">게시글 수정</h1>
						<div class="commu-list">
							<ul class="insert-cont">
								<li class="input-group"><label for="">카테고리 선택</label> 
									<select name="cate">
										<%
				                        for(ComJoinVO cate : cateList) {
				                        %>
											<option><%=cate.getCate_nm() %></option>
										<%
				                        }
		                                %>
									</select>
								</li>
								<li class="input-group"><label for="">제목</label> 
								  <input type="text" name="title" value="<%=tit %>">
								</li>
								<li class="input-group"><label for="">내용</label> <textarea
										name="content" cols="30" rows="10" placeholder="내용을 입력해주세요"><%=cont %></textarea>
								</li>
							</ul>
						</div>

						<div class="btn-area">
							<input type="submit" value="게시글 수정하기" class="btn-style4">
						</div>
					</form>
				</section>
			</div>

		</main>

		<jsp:include page="${_footer}" />
	</div>
</body>
</html>