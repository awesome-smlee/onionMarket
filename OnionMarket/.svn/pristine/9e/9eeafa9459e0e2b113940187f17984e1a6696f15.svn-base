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
	<%-- $("#btnList2").on("click",function(){
		location.href="<%=request.getContextPath()%>/adm/admNotice.do";
	
	}); --%>
	
	$("#btnList1").on("click",function(){
		location.href="<%=request.getContextPath()%>/adm/admNotice.do";
		//취소 버튼을 눌럿을때의 동작을 추가하세요 (예 이전페이지로)
	});
	
	$("#btnList2").on("click", function(){
		location.href="<%=request.getContextPath()%>/adm/admNoticeInsert.do";
        $("#notice").submit(); // form을 서버에 제출
    });
	
});



</script>
	
</head>

<body>
	<div class="admin-page">
		
		<jsp:include page="${_footer_admin}"/>
		
		<div class="wrap">
			
			<jsp:include page="${_header_admin}"/>
			
			<main>
                <h1 class="heading1">공지사항 등록</h1>
				
				<form id = "notice" method="post" enctype="multipart/form-data" 
				action="<%=request.getContextPath()%>/adm/admNoticeInsert.do">
                
                <div class="board-lst">
                    <div class="board-lst-insert">
                        <ul>
                            <li class="input-group">
                                <label for="">제목</label>
                                <input type="text" name="title" id="title" placeholder="제목을 입력해주세요">
                            </li>
                            <li class="input-group">
                                <label for="">내용</label>
                                <textarea name="" id="" placeholder="내용을 입력해주세요."></textarea>
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
                    <input type="button" id="btnList2" value="등록하기" class="btn-style4">
                </div>
				
				</form>
            </main>
			
		</div>
		
	</div>
</body>
</html>