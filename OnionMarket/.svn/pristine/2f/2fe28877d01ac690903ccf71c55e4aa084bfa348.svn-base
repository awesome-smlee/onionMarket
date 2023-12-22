<%@page import="kr.or.ddit.users.controller.usersList"%>
<%@page import="kr.or.ddit.vo.UsersVO"%>
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
	
	<jsp:include page="${_resource}"/>
<%
	List<UsersVO> list = (List<UsersVO>)request.getAttribute("list");
System.out.println("List Size: " + (list != null ? list.size() : 0));
%> 
</head>

<body>
	<div>
		<jsp:include page="${_header}"/>
		
		<main class="sub-page">

            <div class="login-area">
                <h1 class="heading1">아이디 / 비밀번호 찾기</h1>

                <div class="tab-wrap">
                    <div class="tab-type tab-type2">
                        <div class="tab-menu">
                            <button data-tab="tab1" class="tab-btn active">아이디 찾기</button>
                            <button data-tab="tab2" class="tab-btn">비밀번호 찾기</button>
                            <div class="tab-indicator"></div>
                        </div>

                        <!-- 아이디찾기 -->
                        <div data-tab="tab1" class="tab-content active">
                            <div class="tab-board-lst">
                            <form action="<%=request.getContextPath()%>/my/findUser.do" method="GET">
                            
                                    <label for="userName">이름</label>
                                    <input type="text" id="userName" name="userName" class="input" placeholder="이름을 입력해주세요">

                                    <label for="userPhone">휴대폰번호</label>
                                    <input type="text" id="userPhone" name="userPhone" class="input" placeholder="휴대폰번호를 입력해주세요">

                                    <input type="submit" value="아이디 찾기" class="btn-style1 mt-30 mb-30" id="findid">

                                </form>

                                <!-- 아이디 찾기 후 아래 코드가 나와야함 (현재 주석처리) -->
    								 <div class="result-area">                    
	                    <%-- <% for(UsersVO vo : list) { %> 
                                    <p>아이디 : <%=vo.getUser_id() %></p>
                                    <p>가입일 : <%=vo.getUser_tp() %></p>
                        <%}%>  --%>
                        
                        <div class="result-area">
                        <%System.out.println("리스트다" + list) ; %>
					    <% if (list != null && !list.isEmpty()) { %>
					        <% for (UsersVO vo : list) { %>
					            <p>아이디 : <%= vo.getUser_id() %></p>
					            <p>가입일 : <%= vo.getIns_dt() %></p>
					        <% } %>
					    <% } else { %>
					        <p>일치하는 사용자가 없습니다.</p>
					    <% } %>
					    
                                <input type="button" value="확인" class="btn-style1 mt-30 mb-30"> 
                            </div>
                        </div>

                        <!-- 비번찾기 -->
                        <div data-tab="tab2" class="tab-content">
                            <div class="tab-board-lst">

                                <!-- 비밀번호찾기 프로세스1 -->
                                <form action="">
                                    <label for="username">이름</label>
                                    <input type="text" id="username" name="username" class="input" placeholder="이름을 입력해주세요">

                                    <label for="userid">아이디</label>
                                    <input type="text" id="userid" name="userid" class="input" placeholder="아이디를 입력해주세요">

                                    <input type="button" value="인증번호 받기" class="btn-style2 mt-20 mb-20">
                                    <p class="msg-txt1 mt-10 mb-30">
                                        <i class="xi-mail"></i>&nbsp;
                                       		 가입시 등록했던 이메일로 전송했습니다.
                                        <br>
                                        asfs***@naver.com
                                    </p>

                                    <label for="cc">인증번호 입력</label>
                                    <input type="text" id="cc" name="cc" class="input" placeholder="인증번호를 입력해주세요">

                                    <input type="button" value="인증번호 확인" class="btn-style1 mt-30 mb-30">

                                    <p class="msg-txt1">인증번호가 일치합니다.</p>
                                    <p class="msg-txt2">인증번호가 불일치합니다.</p>

                                </form>

                                <!-- 비밀번호찾기 프로세스2 (현재 주석처리) -->
                                <!-- <form action="">
                                    <label for="userPw1">변경할 비밀번호</label>
                                    <input type="password" id="userPw1" name="userPw1" class="input"
                                        placeholder="변경할 비밀번호를 입력해주세요">

                                    <label for="userPw1">비밀번호 재입력</label>
                                    <input type="password" id="userPw1" name="userPw1" class="input"
                                        placeholder="변경할 비밀번호를 재입력해주세요">

                                    <input type="button" value="비밀번호 변경" class="btn-style1 mt-30 mb-30">

                                    <p class="msg-txt1">비밀번호가 성공적으로 변경되었습니다.</p>
                                    <p class="msg-txt2">비밀번호 변경에 실패했습니다.</p>
                                </form> -->
                            </div>
                        </div>

                    </div>
                </div>
            </div>

        </main>
		
		<jsp:include page="${_footer}"/>
	</div>
</body>
<script>

$(() => {
	$("#findid").on("click", function(){
		var namevalue = $("#userName").val().trim();
    	var telvalue = $("#userPhone").val().trim();
    	var mypath =  '<%= request.getContextPath() %>';
    	event.preventDefault();
    	  	
    	/* $.ajax({
    		url : `${mypath}/my/findUser.do`,
    		type : "post",
    		data : formData,
    		success : function(result){
    			console.log(result);
    			
    			 if(namevalue == null || namevalue.trim() == ""){
    				alert("이름을 입력해주세요 ");
    				
    			}else if(telvalue == null || telvalue.trim() == ""){
    				alert("번호를 입력해주세요");
    			}else {
    				alert("메롱");
    			} 
    				
    			
    			// 서버에서 전달한 데이터를 가공하여 결과 영역에 출력
    			  /* if (result > 0) {
    				$("#findid").html(user.user_id);
    			}else if(result <= 0){
    				alert("일치하는 사용자가 없습니다.");
    			}    */
    		},
    		error : function(xhr){
    			alert("일치하는 사용자가 없습니다.");
    		},
    		dataType : 'html'
    		
    	})
	}) */
	 
	
})



</script>
</html>
