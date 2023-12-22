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
</head>

<body>
	<div>
		<jsp:include page="${_header}"/>
		
		<!-- 콘텐츠 들어갈 영역 (퍼블리싱 파일 내 main 태그 전체 복사 붙여넣기!!)-->
		
		<jsp:include page="${_footer}"/>
	</div>
</body>
</html>
