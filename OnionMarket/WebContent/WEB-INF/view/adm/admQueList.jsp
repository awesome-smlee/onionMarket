<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
<%@page import="kr.or.ddit.vo.QueVO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.Comparator"%>


<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="icon" type="image/png" sizes="32x32" href="${_ctx}/favicon.png">
	
	<title>양파마켓</title>
	<script type="text/javascript">
	
	</script>
	<%
List<QueVO> admQueList = (List<QueVO>) request.getAttribute("admQueList");
	Collections.sort(admQueList, new Comparator<QueVO>() {
        @Override
        public int compare(QueVO que1, QueVO que2) {
            return Integer.compare(que2.getQue_id(), que1.getQue_id());
        }
    });
	int queCount = (int)request.getAttribute("queCount");


%>
	
	<jsp:include page="${_resource_admin}"/>
</head>

<body>
	<div class="admin-page">
		
		<jsp:include page="${_footer_admin}"/>
		
		<div class="wrap">
			
			<jsp:include page="${_header_admin}"/>
			
			 <main>
                <h1 class="heading1">문의 관리</h1>

                <div class="search-info">
                    <div class="total">전체 <span><%=queCount %></span>건</div>
                    <div class="form-area">
                        <div class="search-form">
                            <select name="" id="">
                                <option value="">전체</option>
                                <option value="">아이디</option>
                                <option value="">이름</option>
                                <option value="">아이디+이름</option>
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
                        <col style="width: auto;">
                        <col style="width: auto;">
                        <col style="width: auto;">
                        <col style="width: auto;">
                        <col style="width: auto;">
                        <col style="width: auto;">
                    </colgroup>
                    <thead>
                        <tr>
                            <th>문의번호</th>
                            <th>문의 제목</th>
                            <th>아이디</th>
                            <th>문의 접수일</th>
                            <th>답변여부</th>
                         </tr>
                    </thead>
                    <tbody>
                    <%
String userID = "test01";
// String userID = (String) session.getAttribute("userID"); // 세션에서 아이디 값을 가져옴
if (admQueList != null && !admQueList.isEmpty()) {
    Collections.sort(admQueList, new Comparator<QueVO>() {
        @Override
        public int compare(QueVO que1, QueVO que2) {
            // 내림차순 정렬 (큰 값이 먼저 오도록)
            return Integer.compare(que2.getQue_id(), que1.getQue_id());
        }
    });

    for (QueVO que : admQueList) {
        if (que.getUp_id() == 0) { // up_id가 0인 경우에만 행을 출력합니다.
            boolean hasSameId = false; // que_id와 up_id가 같은 경우를 확인하는 플래그

            for (QueVO otherQue : admQueList) {
                if (que.getQue_id() != otherQue.getQue_id() && que.getQue_id() == otherQue.getUp_id()) {
                    hasSameId = true; // que_id와 up_id가 같으면 플래그를 true로 변경
                    break; // 일치하는 경우가 있으면 루프 중단
                }
            }
%>
    <!-- 여기에 테이블의 각 행을 나타내는 코드 -->
<tr onclick="location.href='<%=request.getContextPath()%>/adm/admQueDetail.do?adm_id=<%=que.getQue_id()%>'">        <td><%=que.getQue_id()%></td>
        <td><%=que.getTit()%></td>
        <td><%=que.getIns_id()%></td>
        <td><%=que.getIns_dt()%></td>
        <td><%= hasSameId ? "Y" : "N" %></td> <!-- 수정된 부분 -->
    </tr>
<%
        }
    }
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
            </main>
			
		</div>
		
	</div>

</body>
</html>