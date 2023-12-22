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

<body>
	<div class="admin-page">
		
		<jsp:include page="${_footer_admin}"/>
		
		<div class="wrap">
			
			<jsp:include page="${_header_admin}"/>
			
			<main>
                <h1 class="heading1">문의관리 상세</h1>

                <div class="board-lst">
                    <!-- 사용자글 -->
                    <div class="board-lst-datail type-user">
                        <!-- <span class="badge1">처리완료</span> -->
                        <span class="badge2">미접수</span>
                        <ul>
                            <li>
                                <p class="tit">제목이 들어갑니다.</p>
                            </li>
                            <li>
                                <div class="info-area">
                                    <p class="id">아이디 : dditislove</p>
                                    <p class="date">문의접수일 : 2023-10-12</p>
                                    <p class="date">피드백날짜 : 2023-10-12</p>
                                </div>
                            </li>
                            <li>
                                <p class="txt">처리해주세요. 처리해주세요.처리해주세요.처리해주세요.처리해주세요.처리해주세요.</p>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="btn-area">
                    <input type="button" value="뒤로가기" class="btn-style5">
                    <input type="button" value="답변하기" class="btn-style4" modal-id="modal1">
                </div>

            </main>
			
		</div>
		
	</div>

</body>
</html>