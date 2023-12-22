<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
<%@ page import="kr.or.ddit.vo.QueVO"%>
<%@ page import="java.util.List"%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>


<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="image/png" sizes="32x32"
	href="${_ctx}/favicon.png">
<title>양파마켓</title>
<script src="../js/jquery-3.7.0.min.js"></script>
<script type="text/javascript">
        $(function() {
            $("#btnDelete").on("click", function() {
 
                    var queId = $("#que_id").val();
                    deleteQuestion(queId);
                }
            );

            function deleteQuestion(queId) {
                $.ajax({
                    type: "POST",
                    url: "<%=request.getContextPath()%>/que/queDetail.do",
                    data: { que_id: queId },
                    success: function(response) {
                        window.location.href = "<%=request.getContextPath()%>/que/QueList.do";
                    },
                    error: function(xhr) {
                        alert("삭제 중 오류가 발생했습니다.");
                    }
                });
            }

            $('#btnList').on('click', function() {
                var path = "/que/QueList.do"; // 이동할 경로
                var url = window.location.origin + path; // 현재 호스트와 포트를 포함한 URL 조합
                window.location.href = url; // 새 URL로 이동
            });

	});
</script>
<jsp:include page="${_resource}" />

<%
List<QueVO> queList = (List<QueVO>) request.getAttribute("queList");
%>
</head>
<body>
	<div>
			<form name="queDetail" id="queDetail">
		<div>
			<jsp:include page="${_header}" />

			<!-- sub-page 시작 -->
			<main class="sub-page">
				<div class="sub-menu">
					<a href="javascript:void(0)" class="active">1:1문의</a> <a
						href="javascript:void(0)">신고하기</a>
				</div>

				<div class="inner">
					<section class="content-area">
						<h1 class="heading1">1:1 문의</h1>

						<div class="board-lst">
							<div class="board-lst-datail">
								<%
								String queId = request.getParameter("que_id");

								if (queId != null && !queId.isEmpty()) {
									int queIdInt = Integer.parseInt(queId);

									for (QueVO que : queList) {
										if (que.getQue_id() == queIdInt) {
								%>
								<ul>
									<li><input type="hidden" id="que_id" name="que_id"
										value="<%=que.getQue_id()%>">
										<p class="tit"><%=que.getTit()%></p></li>
									<li>
										<div class="info-area">
											<p class="id">
												아이디 :
												<%=que.getIns_id()%></p>
											<p class="date">
												작성일 :
												<%=que.getIns_dt()%></p>
										</div>
									</li>
									<li>
										<p class="txt"><%=que.getCont()%></p>
									</li>
								</ul>
								<%
										}}}else {
								%>
								<p>올바른 문의 ID가 제공되지 않았습니다.</p>
								<%
								}
								%>
							</div>
						</div>

						<div class="btn-area">
							<input type="button" value="삭제하기" class="btn-style5"
								id="btnDelete"> <input type="button" value="목록가기"
								class="btn-style4" id="btnList">
						</div>
						<br> <br>
<% boolean hasQue = false; // 결과가 있는지 여부 확인하는 플래그
%>
						<!-- 관리자 글 -->
						<span class="board-type-admin"><i class="xi-comment-o"></i>관리자
							답변</span>
						<div class="board-lst-datail type-admin">


							<%
    hasQue = false; // 기본적으로 관리자 답변이 없다고 가정

    if (queId != null && !queId.isEmpty()) {
        int queIdInt = Integer.parseInt(queId);

        for (QueVO que : queList) {
            if (que.getUp_id() == queIdInt) {
                // 관리자 답변 영역 표시
%>
                <ul>
                    <li>
                        <p class="tit"><%=que.getTit()%></p>
                    </li>
                    <li>
                        <div class="info-area">
                            <p class="id">관리자</p>
                            <p class="date">답변일 : <%=que.getIns_dt()%></p>
                        </div>
                    </li>
                    <li>
                        <p class="txt"><%=que.getCont()%></p>
                    </li>
                </ul>
<%
                hasQue = true; // 관리자 답변이 있음을 표시
            }
        }
    }

    // 관리자 답변이 없는 경우 해당 부분을 표시
    if (!hasQue) { 
%>
        <p>관리자의 답변이 없습니다.</p>
<%
    }
%>

 
						</div>
					</section>
				</div>
			</main>
		</div>

		<!--     관리자 글  -->
 
		<!-- sub-page 끝 -->

		<jsp:include page="${_footer}" />

	</form>
	</div>

</body>
</html>
