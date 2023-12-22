<%@page import="kr.or.ddit.vo.PoliceVO"%>
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
	
	<jsp:include page="${_resource}"/>
<%
List<PoliceVO> polList = (List<PoliceVO>)request.getAttribute("polList");
%>
<script type="text/javascript">
$(function() {	
	$('#insert').on('click', function() {
		location.href = "<%=request.getContextPath()%>/police/policeInsertForm.do";
	});
});
</script>
</head>

<body>
	<div>
		<jsp:include page="${_header}"/>
		
		        <!-- sub-page 시작 -->
        <main class="sub-page">

            <div class="sub-menu">
               <a href="<%=request.getContextPath()%>/que/QueList.do">1:1문의</a> 
                <a href="<%=request.getContextPath()%>/police/policeList.do" class="active">신고하기</a> 
            </div>

            <div class="inner">
                <section class="content-area">
                    <h1 class="heading1">신고 게시판</h1>

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
                                <th>처리여부</th>
                            </tr>
                        </thead>
                        <tbody>
                        <%
                        for(PoliceVO polVo : polList) {
                        %>
                            <tr>
                                <td><%=polVo.getPol_id() %></td>
                                <td><span class="txt-overflow"><%=polVo.getTit() %></span></td>
                                <td><%=polVo.getIns_id() %></td>
                                <td><%=polVo.getIns_dt() %></td>
                                <td><%=polVo.getStatus() %></td>
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
                        <input type="button" value="신고하기" class="btn-style4" id="insert">
                    </div>
                </section>
            </div>

        </main>
        <!-- sub-page 끝 -->     
		
		<jsp:include page="${_footer}"/>
	</div>
</body>
</html>
