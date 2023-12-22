<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>

<aside>
	<ul class="menu">
		<li><a href="<%=request.getContextPath() %>/adm/admMain">회원관리</a></li>
		
		<li><a href="<%=request.getContextPath() %>/adm/admNotice.do">공지사항</a></li>
		
		<li><a href="<%=request.getContextPath() %>/adm/admPolice.do">신고관리</a></li>
		
		<li><a href="<%=request.getContextPath() %>/adm/AdmQueList">문의관리</a></li>
 	</ul>

	<a href="javascript:void(0)" class="link"> 
		<i class="xi-external-link"></i>양파마켓 메인
	</a>
</aside>