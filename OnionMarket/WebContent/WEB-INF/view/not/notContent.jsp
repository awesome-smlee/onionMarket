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
<script type="text/javascript">
$(function() {
	$('#List').on('click', function() {
		window.location.href = "<%=request.getContextPath()%>/not/NotList";	
	});	
});

</script>
<%
	List<NotVO> notList = (List<NotVO>) request.getAttribute("notList");
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
<% 
String notiId = request.getParameter("noti_id"); // URL 파라미터로부터 noti_id 값을 가져옴

for (NotVO not : notList) {
	if (not.getNoti_id() == Integer.parseInt(notiId)) {
			%>
				<input type="hidden" id="not_num" name="not_num" value="<%=not.getNoti_id() %>">
			
					<div class="board-lst">
						<div class="board-lst-datail">
							<ul>
								<li>
									<p class="num">공지번호 : <%=not.getNoti_id() %></p>
								</li>
								<li>
									<p class="tit"><%=not.getTit() %></p>
								</li>
								<li>
									<div class="info-area">
										<p class="id">아이디 : <%=not.getIns_id() %></p>
										<p class="date">작성일 : <%=not.getIns_dt() %></p>
									</div>
								</li>
								<li>
									<p class="txt" style="text-align: left;"><%=not.getCont() %></p>
								</li>
								<li class="input-group file">
								<img src="<%=request.getContextPath() %>/images/imageView.do?fileId=<%=not.getFile_id() %>" alt=""></li>
									
							</ul>
						</div>
					</div>
					<%
						}}
					%>
					<div class="btn-area">
						<input type="button" value="목록가기" class="btn-style5" id="List">
					</div>

				</section>
			</div>

		</main>
		<!-- sub-page 끝 -->


		<jsp:include page="${_footer}" />
	</div>
</body>
</html>
