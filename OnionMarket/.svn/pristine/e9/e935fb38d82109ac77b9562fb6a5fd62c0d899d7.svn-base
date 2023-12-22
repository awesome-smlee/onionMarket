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
List<ComJoinVO> comListByGu = (List<ComJoinVO>)request.getAttribute("comListByGu");
%>
</head>

<body>
	<div class="commu-list">
		<div class="history-area">
			<ul>
				<% 
                for(ComJoinVO com : comListByGu) {
                %>
				<li>
					<div class="item"
						onclick="location.href='<%=request.getContextPath()%>/com/comDetail.do?com_id=<%=com.getCom_id()%>'">
						<div class="txt-wrap">
								<p style="display: none;" class="no">No. <%=com.getCom_id() %></p>
							<p class="tit"><%=com.getTit() %></p>
							<div class="txt-lst">
							<div class="profile-area">
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
		</div>
	</div>
</body>
</html>