<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
<%@page import="kr.or.ddit.vo.NotVO"%>
<%@page import="java.util.List"%>

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
	List<NotVO> notList = (List<NotVO>) request.getAttribute("notList");
	int count = (int)request.getAttribute("count");
%>
</head>

<body>
	<div>
		<jsp:include page="${_header}" />

		<!-- sub-page 시작 -->
		<main class="sub-page">

			<div class="inner">

				<section class="content-area">
					<h1 class="heading1">공지사항</h1>

					<div class="search-info">
						<div class="total">
						
							전체 <span><%=count %></span>건
						</div>
						<div class="form-area">
							<div class="search-form">
								<select name="" id="">
									<option value="all">전체</option>
									<option value="title">제목</option>
									<option value="contents">내용</option>
								</select>
							</div>
							<div class="input-form">
								<input type="text" placeholder="검색할 내용을 입력하세요">
							</div>
							<a href="javascript:void(0)" class="search-btn"> <iclass="xi-search"></i></a>
						</div>
					</div>
					<table class="board-table">
						<colgroup>
							<col style="width: auto;">
							<col style="width: auto;">
							<col style="width: auto;">
							<col style="width: auto;">
							<col style="width: auto;">
						</colgroup>
						<thead>
							<tr>
								<th>번호</th>
								<th>제목</th>
								<th>아이디</th>
								<th>등록날짜</th>
								<th>조회수</th>
							</tr>
						</thead>
						<tbody>
							<%
								for (NotVO not : notList) {
							%>
							<tr>
								<td><%=not.getNoti_id()%></td>
								<td onclick="location.href='<%=request.getContextPath() 
								%>/not/notContent.do?noti_id=<%=not.getNoti_id() %>'"><%=not.getTit() %></td>
								<td><%=not.getIns_id()%></td>
								<td><%=not.getIns_dt()%></td>
								<td><%=not.getVw_cnt()%></td>
							</tr>
							<%
								}
							%>
						</tbody>
					</table>

					<!-- pager 시작 -->
					<div class="pager">
						<a href="javascript:void(0);" class="arr prev"></a> <strong
							class="active">1</strong> <a href="javascript:void(0);">2</a> <a
							href="javascript:void(0);">3</a> <a href="javascript:void(0);">4</a>
						<a href="javascript:void(0);">5</a> <a href="javascript:void(0);">6</a>
						<a href="javascript:void(0);">7</a> <a href="javascript:void(0);">8</a>
						<a href="javascript:void(0);" class="arr next"></a>
					</div>
					<!-- pager 끝 -->

				</section>
			</div>

		</main>
		<!-- sub-page 끝 -->

		<jsp:include page="${_footer}" />
	</div>
</body>
</html>
