<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
 <%@page import="kr.or.ddit.vo.QueVO"%>
<%@page import="java.util.List"%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="icon" type="image/png" sizes="32x32" href="${_ctx}/favicon.png">
	<link rel="stylesheet" href="../css/reset.css">
    <link rel="stylesheet" href="../css/modal.css">
      <script src="../js/jquery-3.7.0.min.js"></script>
     <script src="../js/modal.js"></script>
	<title>양파마켓</title>
	
	<script type="text/javascript">
	$('#btnList').on('click', function() {
	    var path = "/que/QueList.do"; // 이동할 경로
	    var url = window.location.origin + path; // 현재 호스트와 포트를 포함한 URL 조합
	    window.location.href = url; // 새 URL로 이동
	});

// 	$(function() {
// 		$('#btnList').on('click', function() {
<%-- 			window.location.href = "<%=request.getContextPath()%>/not/NotList";	 --%>
// 		});	
// 	});

// 	$(document).ready(function() {
// 	    $('#btnList').on('click', function() {
// 	        window.location.href = "/adm/AdmQueList";   
// 	    });
//         $(function() {

// 	    $('#btnList').on('click', function() {
//             window.location.href = "http://localhost:8080/que/QueList.do";
// 					});
	    // 닫기 버튼으로 모달 닫기
	    $('.close-btn').on('click', function() {
	        $(this).closest('.modal').removeClass('active');
	        $(this).closest('.modal').find('input[type="text"], textarea').val('');
	    });

	    // 취소 버튼으로 모달 닫기
	    $(document).on('click', '.close-modal', function() {
	        $(this).closest('.modal').removeClass('active');
	        $(this).closest('.modal').find('input[type="text"], textarea').val('');
	    });
	});

	function confirmSave() {
	    var shouldSave = confirm("저장하시겠습니까?");
	    if (shouldSave) {
	        $('#modal1').modal('hide'); // 모달을 닫습니다.
	        window.location.href = "/adm/AdmQueList"; // 페이지 이동
	    }
	    return shouldSave;
	}


 
$(document).ready(function() {
	var up_id = $("#up_id").val();

    // up_id를 정수형으로 변환합니다.
    var upIdValue = parseInt(up_id);

    if (up_id == 0) { 
        $('.type-admin').show(); // up_id가 0보다 크면 관리자 글 영역을 표시합니다.
        $('.badge1').show(); // up_id가 0보다 크면 관리자 글 영역을 표시합니다.
        $('.badge2').hide(); // up_id가 0이면 미접수 숨기기
    } else {
        $('.btn-area').hide(); // up_id가 0이면 관리자 글 영역을 숨깁니다.
        $('.type-admin').hide(); // up_id가 0이면 관리자 글 영역을 숨깁니다.
        $('.badge1').hide(); // up_id가 0이면 처리완료 숨기기
        
    }
});

$(function() {
    $("#btnDelete").on("click", function() {

            var upId = $("#up_id").val();
            deleteQuestion(upId);
        }
    );

 
</script>

<style type="text/css">
.btn-area1 {
  	 text-align: right;
    margin-top: 30px;
    display: flex;
    gap: 10px;
    justify-content: end;
}
</style>

		<%
List<QueVO> queList = (List<QueVO>) request.getAttribute("queList");
%>
	
	
	<jsp:include page="${_resource_admin}"/>
</head>

<body>
	<div class="admin-page">
		
		<jsp:include page="${_footer_admin}"/>
		
		<div class="wrap">
			
			<jsp:include page="${_header_admin}"/>
			
			       <main>
                <h1 class="heading1">문의관리 상세</h1>

                <div class="board-lst">
                    <!-- 사용자글 -->
                     <%
                     String userID = "test01";

                     // String userID = (String) session.getAttribute("userID"); // 세션에서 아이디 값을 가져옴

                     String queId = request.getParameter("adm_id");
                     String up_Id = request.getParameter("up_id");

                     if (queId != null && !queId.isEmpty()) {
                         int queIdInt = Integer.parseInt(queId);

                         for (QueVO que : queList) { 
                             if (que.getQue_id() == queIdInt) {

                            %>
                    <div class="board-lst-datail type-user">
                     <input type="hidden" id="que_id" name="que_id" value="<%=que.getQue_id() %>">
                     <input type="hidden" id="up_id" name="up_id" value="<%=que.getUp_id() %>">
                    
                        <span class="badge1">처리완료</span>
                        <span class="badge2">미접수</span>
                        <ul>
                            <li>
                                <p class="tit"><%=que.getTit()%></p>
                            </li>
                            <li>
                                <div class="info-area">
                                
                                    <p class="id">아이디 : <%=que.getIns_id()%></p>
                                    <p class="date">문의접수일 : <%=que.getIns_dt()%></p>
<!--                                     <p class="date">피드백날짜 :  </p> -->
                                </div>
                            </li>
                            <li>
                                <p class="txt"><%=que.getCont()%></p>
                            </li>
                        </ul>
                    </div>
                    <%}} }%>
                </div>
                <div class="btn-area">
                    <input type="button" value="뒤로가기" class="btn-style5" id="btnList">
                    <input type="button" value="답변하기" class="btn-style4" modal-id="modal1">
                </div>
<br>
 	  <!-- 관리자 글 -->
                    <div class="board-lst-datail type-admin">
                    
                        <span class="type">관리자 답변</span>   
                        
        <% 
        if (queId != null && !queId.isEmpty()) {
            int queIdInt = Integer.parseInt(queId);

            for (QueVO que : queList) { 
                if (que.getUp_id() == queIdInt) {
      %>
    <!-- 관리자 답변 영역 -->
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
            }}}
 
%>


                        <div class="btn-area1">
                            <input type="button" value="수정하기" class="btn-style4">
                            <input type="button" value="삭제하기" class="btn-style5" id="btnDelete" name="btnDelete">
                        </div>
                    </div>
            </main>
        </div>
    </div>
<!--     관리자 글  -->


    <!-- 모달 시작-->
    <div class="modal" id="modal1">
        <div class="modal-cont">
            <h1 class="modal-tit">답변 등록</h1>

                    <form action="${pageContext.request.contextPath}/adm/admQueDetail.do" method="post" onsubmit="return confirmSave()">
                <div class="modal-txt-area">
                        <input type="hidden" id="que_id" name="que_id" value="<%=queId %>">
                
                    <div class="input-group">
                        <input type="text" id="queAnsTit" name="queAnsTit" placeholder="제목을 입력해주세요">
                    </div>
                    <div class="input-group">
                        <textarea type="text"  id="queAnsCont" name="queAnsCont" placeholder="내용을 입력해주세요"></textarea>
                    </div>
                </div>

                <div class="modal-btn-area">
  		  	<input type="button" value="취소하기" class="btn-style6 close-modal">
            <input type="submit" value="등록하기" class="btn-style7" id="submitAnswer" >
</div>
            </form>

            <button class="close-btn"></button>
        </div>
    </div>
    <!-- 모달 끝-->
</body>
</html>