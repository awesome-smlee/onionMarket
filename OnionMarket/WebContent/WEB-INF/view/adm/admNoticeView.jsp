<%@page import="kr.or.ddit.vo.NoticeVO"%>
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
	
	<jsp:include page="${_resource_admin}"/>
</head>


<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.7.0.min.js"></script>

<script type="text/javascript">


</script>
<body>
	<%NoticeVO notiVo = (NoticeVO)request.getAttribute("noticeVo"); %>
	<div class="admin-page">
		
		<jsp:include page="${_footer_admin}"/>
		
		<div class="wrap">
			
			<jsp:include page="${_header_admin}"/>
			
			<main>
			
			</main>
		</div>
		
		</div>
</body>
</html>