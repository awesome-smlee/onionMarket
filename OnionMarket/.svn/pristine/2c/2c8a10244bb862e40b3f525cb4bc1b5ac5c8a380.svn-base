
<%@page import="kr.or.ddit.vo.NoticeVO"%>
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

<jsp:include page="${_resource_admin}" />

<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-3.7.0.min.js"></script>

<script type="text/javascript">
	
</script>
</head>

<body>

	<%
		
		List<NoticeVO> noticeList = (List<NoticeVO>) request.getAttribute("noticeList");
		/* NoticeVO noticevo = (NoticeVO)request.getAttribute("notiVo");	 */
	%>

	<div class="admin-page">

		<jsp:include page="${_footer_admin}" />

		<div class="wrap">

			<jsp:include page="${_header_admin}" />

			<main>
				<div class="board-lst">
					<div class="board-lst-datail">
						<ul>


							<h1 class="heading1">공지사항 상세</h1>


							   <%
								for (NoticeVO noticevo : noticeList) {
									
								//NoticeVO noticevo = noticeList.get(0);
										
							%>   
							<li>
								<p class="num">
									공지번호 :
									<%-- <td><%=noticevo.getNoti_id()%></td> --%>
									 <td><%=noticeList.indexOf(noticevo) + 1 %></td>
									
								</p>
							</li>

							<li>
								<p class="tit"><%=noticevo.getTit()%></p>

							</li>
							<li>
								<div class="info-area">
									<p class="id">
										아이디 :
										<td> <%=noticevo.getIns_id()%> </td>
									</p>
									<p class="date">
										작성일 :
										<td> <%=noticevo.getIns_dt()%> </td>
									</p>
								</div>
							</li>
							<li>

								<p class="txt">
									<td> <%=noticevo.getCont()%> <td>
								</p>
							</li>
							<li class="input-group file"><img src="../img/noimage.png"
								alt=""></li>
							   <%
								
								}
							%>  



						</ul>
					</div>
				</div>
				<div class="btn-area">
					<input type="button" value="수정하기" class="btn-style4"> <input
						type="button" value="삭제하기" class="btn-style5">
				</div>
			</main>

		</div>

	</div>

</body>
</html>
 