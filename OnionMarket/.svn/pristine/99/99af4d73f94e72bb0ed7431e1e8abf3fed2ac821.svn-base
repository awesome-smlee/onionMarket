<%@page import="java.io.PrintWriter"%>
<%@page import="kr.or.ddit.vo.UsersVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	 <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
	<link rel="icon" type="image/png" sizes="32x32" href="${_ctx}/favicon.png">
	<title>양파마켓</title>
	
	<jsp:include page="${_resource}"/>
	
<%-- 	<%
	int tp = (int)request.getAttribute("tp");
	%>  --%>
</head>
 <%-- 회원 상태에 따른 메시지 표시 부분 --%>
            
<body>

	<div>
		<jsp:include page="${_header}"/>
		
		
		<main class="sub-page">

            <div class="login-area">
                <h1 class="heading1">로그인</h1>
              	  <form action="<%=request.getContextPath()%>/my/login.do" method="post">
                    <!-- 아이디 -->
                   
                    <label for="userID">아이디</label>
					<input type="text" id="user_id" name="user_id" class="input" placeholder="아이디를 입력해주세요">
                    <!-- 비밀번호 -->
                    <label for="userPw">비밀번호</label>
                    <input type="password" id="pw" name="pw" class="input" placeholder="비밀번호를 입력해주세요">

                    <div class="btn-area">
                        <div>
                            <input type="checkbox" id="remember" name="remember">
                            <label for="remember" class="remember">아이디 기억하기</label>
                        </div>
                        <div>
                          <a href="/my/findUser.do">아이디 찾기</a>
                            <a href="javascript:void(0)" class="join-btn">회원가입</a>
                          
                        </div>
                    </div>

                    <input type="submit" value="로그인" class="submit" id="submit">

                </form>

                <div class="kakao-area">
                    <p>SNS계정으로 간편로그인하세요.</p>
                    <a href="javascript:void(0)" class="kakao-btn">
                        <svg stroke="currentColor" fill="currentColor" stroke-width="0" viewBox="0 0 24 24" class="text-sm sm:text-base me-1.5" height="1em" width="1em" xmlns="http://www.w3.org/2000/svg">
                            <g>
                                <path fill="none" d="M0 0h24v24H0z"></path>
                                <path d="M12 3c5.799 0 10.5 3.664 10.5 8.185 0 4.52-4.701 8.184-10.5 8.184a13.5 13.5 0 0 1-1.727-.11l-4.408 2.883c-.501.265-.678.236-.472-.413l.892-3.678c-2.88-1.46-4.785-3.99-4.785-6.866C1.5 6.665 6.201 3 12 3zm5.907 8.06l1.47-1.424a.472.472 0 0 0-.656-.678l-1.928 1.866V9.282a.472.472 0 0 0-.944 0v2.557a.471.471 0 0 0 0 .222V13.5a.472.472 0 0 0 .944 0v-1.363l.427-.413 1.428 2.033a.472.472 0 1 0 .773-.543l-1.514-2.155zm-2.958 1.924h-1.46V9.297a.472.472 0 0 0-.943 0v4.159c0 .26.21.472.471.472h1.932a.472.472 0 1 0 0-.944zm-5.857-1.092l.696-1.707.638 1.707H9.092zm2.523.488l.002-.016a.469.469 0 0 0-.127-.32l-1.046-2.8a.69.69 0 0 0-.627-.474.696.696 0 0 0-.653.447l-1.661 4.075a.472.472 0 0 0 .874.357l.33-.813h2.07l.299.8a.472.472 0 1 0 .884-.33l-.345-.926zM8.293 9.302a.472.472 0 0 0-.471-.472H4.577a.472.472 0 1 0 0 .944h1.16v3.736a.472.472 0 0 0 .944 0V9.774h1.14c.261 0 .472-.212.472-.472z">
                                </path>
                            </g>
                        </svg>
                        카카오톡으로 시작하기</a>
                </div>
            </div>

        </main>
		
		<jsp:include page="${_footer}"/>
	</div>
</body>
                    <input type="text" id="userid" name="userid" class="input" placeholder="아이디를 입력해주세요">


<script>



 $(() => {
    $("#submit").on("click", function(){
    	event.preventDefault();
    	
    	var idvalue = $("#user_id").val().trim();
    	var passvalue = $("#pw").val().trim();
    	var mypath =  '<%= request.getContextPath() %>';
    	
    	console.log(idvalue, passvalue);

    	 if(idvalue.trim() == ""){
			 alert("아이디를 입력해주세요")
			 }else if(passvalue.trim() == ""){
				 alert("비밀번호를 입력해주세요")
			 }
    	 
    	$.ajax({
    		 url : `${mypath}/my/login.do`,
    		type : 'post',
    		data : { "user_id" : idvalue, "pw" : passvalue},
    		success : function(res){
             //로그인성공 	 
             if (res === "success") {
           		 location.href = `${mypath}/my/locationMy.do`;
        	} else if(res === "tp"){
           		 alert("정지된 회원입니다");
     	   }else{
     			  alert("로긘실패요");
     	   }	
    		},
    		error : function(xhr){
    				alert("다시 로그인 ")
    				 
    		},
    		dataType : 'html'
    			
    		})
    		
    	})
    	
    	})
    
  


     
  
</script>

</html>
