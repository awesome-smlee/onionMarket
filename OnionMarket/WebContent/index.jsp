<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>

<%
//response.sendRedirect(request.getContextPath() + "/example");
response.sendRedirect(request.getContextPath() + "/main/main.do");
%>  
<%--  
<a href="<%=request.getContextPath() %>/users/usersList.do">유저 목록 보기</a>  
<a href="<%=request.getContextPath() %>/adm/admNotice.do">공지 목록 보기</a>
 --%>