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

            <div class="login-area">
                <h1 class="heading1">비밀번호 변경</h1>

                <!-- 비밀번호찾기 프로세스2 (현재 주석처리) -->
              <form action="<%=request.getContextPath()%>/my/changePw.do" method="GET">
                     <%--  <% String errorMessage = (String)request.getAttribute("errorMessage");
                      if (errorMessage != null) { %>
				            alert("<%= errorMessage %>");
				        <% } %> --%>
                    <label for="userPw1">변경할 비밀번호</label>
                    <input type="text" id="userPw1" name="userPw1" class="input" placeholder="변경할 비밀번호를 입력해주세요">

                    <label for="userPw2">비밀번호 재입력</label>
                    <input type="text" id="userPw2" name="userPw2" class="input" placeholder="변경할 비밀번호를 재입력해주세요">
                   <!--  <p class="msg-txt3">비밀번호가 일치하지 않습니다.</p> -->

                    <input type="submit" value="비밀번호 변경" class="btn-style1 mt-30 mb-30" id="change">
				</form>
                    <!-- <p class="msg-txt1">비밀번호가 성공적으로 변경되었습니다.</p>
                    <p class="msg-txt2">비밀번호 변경에 실패했습니다.</p> -->
                

            </div>

        </main>
		
		<jsp:include page="${_footer}"/>
	</div>
</body>


<script>
    $("#change").on("click",function(){
    	alert("비밀번호가 변경되었습니다");
    })
</script>

</html>
