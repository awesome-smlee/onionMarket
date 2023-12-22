<%@page import="kr.or.ddit.vo.PoliceVO"%>
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
<%
	List<PoliceVO> policeList = (List<PoliceVO>)request.getAttribute("policeList");
%>
	<div class="admin-page">
		
		<jsp:include page="${_footer_admin}"/>
		
		<div class="wrap">
			
			<jsp:include page="${_header_admin}"/>
			
			<main>
                <h1 class="heading1">신고관리</h1>

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
                            <th>신고ID</th>
                            <th>제목</th>
                            <th>작성일</th>
                            <th>게시글번호</th>
                            <th>작성자ID</th>
                        </tr>
                    </thead>
                    <tbody>
                    
                    	 <%
                            for(PoliceVO policevo : policeList){
                           %>
                    
                    <tr>
                    		<%-- <td><a href="<%=request.getContextPath()%>/member/memberView.do?mem_id=<%=memvo.getMem_id()%>"><%=memvo.getMem_id() %></a></td>--%>                    		
                    		<td><%=policevo.getPol_id() %></td>
                    		<%-- <td><%=policevo.getTit() %></td> --%>
                    		<td><a href="<%=request.getContextPath()%>/adm/admPoliceView.do?tit=<%=policevo.getTit()%>"><%=policevo.getTit() %></a></td>
                    		<td><%=policevo.getIns_dt() %></td>
                    		<td><%=policevo.getProd_id() %></td>
                    		<td><%=policevo.getIns_id() %></td>
                    		
							
							<%
                            	}
							%>
					</tr>
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

               
            </main>
		</div>
		
	</div>

</body>
</html>