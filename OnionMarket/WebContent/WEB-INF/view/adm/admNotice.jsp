<%@page import="kr.or.ddit.vo.NotVO"%>
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

$(function(){
	
	$("#btnInsert").on("click", function(){
		location.href = "<%=request.getContextPath()%>/adm/admNoticeInsert.do";
	});
	
});


</script>



<body>
<%
	List<NotVO> notList = (List<NotVO>)request.getAttribute("notList");
%>
	<div class="admin-page">
		
		<jsp:include page="${_footer_admin}"/>
		
		<div class="wrap">
			
			<jsp:include page="${_header_admin}"/>
			
			<main>
                <h1 class="heading1">공지사항</h1>

                <div class="search-info">
                    <div class="total">전체 <span>100</span>건</div>
                    <div class="form-area">
                        <div class="search-form">
                            <select name="" id="">
                                <option value="">전체</option>
                                <option value="">제목</option>
                                <option value="">내용</option>
                                <option value="">제목 + 내용</option>
                            </select>
                        </div>
                        <div class="input-form">
                            <input type="text" placeholder="검색할 내용을 입력하세요">
                        </div>
                        <a href="javascript:void(0)" class="search-btn">
                            <i class="xi-search"></i>
                        </a>
                    </div>
                </div>
                <table class="table">
                    <colgroup>
                        <col style="width: 10%;">
                        <col style="width: 50%;">
                        <col style="width: 20%;">
                        <col style="width: 20%;">
                    </colgroup>
                    <thead>
                        <tr>
                            <th>번호</th>
                            <th>제목</th>
                            <th>아이디</th>
                            <th>날짜</th>
                        </tr>
                    </thead>
                    <tbody>
                    
                    <%
								for (NotVO not : notList) {
							%>
							<tr onclick="location.href='<%=request.getContextPath() 
								%>/not/notContent.do?noti_id=<%=not.getNoti_id() %>'">
								<td><%=not.getNoti_id()%></td>
								<td ><%=not.getTit() %></td>
								<td><%=not.getIns_id()%></td>
								<td><%=not.getIns_dt()%></td>
<%-- 								<td><%=not.getVw_cnt()%></td> --%>
							</tr>
							<%
								}
							%>
                    </tbody>
                </table>

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

                <div class="btn-area">
                    <input type="button" value="등록하기" id="btnInsert" class="btn-style4">
                </div>
            </main>
		</div>
		
	</div>

</body>
</html>