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
</head>

<body>
	<div>
		<jsp:include page="${_header}"/>
		
	        <main class="sub-page">

            <div class="sub-menu">
               <a href="<%=request.getContextPath()%>/que/QueList.do" class="active">1:1문의</a> 
                <a href="<%=request.getContextPath()%>/police/policeList.do">신고하기</a> 
            </div>

            <div class="inner">

                <section class="content-area">
                    <h1 class="heading1">신고하기</h1>
					<form action="<%=request.getContextPath()%>/police/policeInsert.do" method="post">
	                    <div class="board-lst">
	                        <ul>
	                            <li class="input-group">
	                                <label for="">제목</label>
	                                <input type="text" name="tit" placeholder="제목을 입력해주세요">
	                            </li>
	                            <li class="input-group">
	                                <label for="">내용</label>
	                                <textarea name="cont" cols="30" rows="10" placeholder="내용을 입력해주세요"></textarea>
	                            </li>
	                        </ul>
	                    </div>
                    <div class="btn-area">
                        <input type="button" value="취소하기" class="btn-style5">
                        <input type="submit" value="저장하기" class="btn-style4">
                    </div>
					</form>
                </section>
            </div>

        </main>
		
		<jsp:include page="${_footer}"/>
	</div>
</body>
</html>
