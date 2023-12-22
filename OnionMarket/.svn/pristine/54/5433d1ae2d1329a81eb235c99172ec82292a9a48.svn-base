<%@page import="kr.or.ddit.vo.NoticeVO"%>
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
	
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.7.0.min.js"></script>

<script type="text/javascript">
$(function(){

	$("#btnList1").on("click",function(){
		location.href="<%=request.getContextPath()%>/adm/admNotice.do";
		
	});
	
	$("#noticeInsertForm").on("submit", function(){
		var title = $("input[name='tit']").val();
		var content = $("textarea[name='cont']").val();	
		
		if(title.trim()==""){
			alert("제목을 입력하세요.");
			return false;
		}
		
		if(content.trim()==""){
			alert("내용을 입력하세요.");
			return false;
		}
		var formData = new FormData(this);
		formData.append('file',$('#file')[0].files[0]);
		
		$.ajax({
			url : '<%=request.getContextPath()%>/adm/admNoticeInsert.do',
			method: 'POST',
			//data : new FormData(this), // 파일 업로드를 위해 FormData 사용
			data : formData,
			contentType: false,
			processData: false,
			success : function(result){
				// 성공한 결과를 처리하는 부분
				alert("등록되었습니다.");
				location.href="<%=request.getContextPath()%>/adm/admNotice.do";
			}, 
			error : function(xhr){
				alert("status:"+xhr.status);
			}
			
		});
		
		return false;
		
	});
	
});



</script>
	
</head>

<body>
<%-- <form id = "noticeInsertForm" method = "post" enctype = "multipart/form-data"
	action="<%=request.getContextPath() %>/adm/admInsert.do"> --%>
	
	<form id="noticeInsertForm" method="post" enctype="multipart/form-data" 
		action="<%=request.getContextPath() %>/adm/admNoticeInsert.do">
	<div class="admin-page">
		
		<jsp:include page="${_footer_admin}"/>
		
		<div class="wrap">
			
			<jsp:include page="${_header_admin}"/>
			
			<main>
                <h1 class="heading1">공지사항 등록</h1>
                
                <div class="board-lst">
                    <div class="board-lst-insert">
                        <ul>
                            <li class="input-group">
                                <label for="">제목</label>
                                <input type="text" name="tit" id="" placeholder="제목을 입력해주세요">
                            </li>
                            <li class="input-group">
                                <label for="">내용</label>
                                <textarea name="cont" id="" placeholder="내용을 입력해주세요."></textarea>
                            </li>
                            <li class="input-group file">
                                <img src="../img/noimage.png" alt="">
                                <input type="file" name="file" id="file">
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="btn-area">
                    <input type="button" id="btnList1" value="취소하기" class="btn-style5">
                    <input type="submit" id="btnList2" value="등록하기" class="btn-style4">
                </div>
			
            </main>
			
		</div>
		
	</div>
	</form>
</body>
</html>