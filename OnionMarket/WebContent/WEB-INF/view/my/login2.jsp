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
	 <script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	 
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
                          <a href="/my/findUser.do">아이디/비밀번호 찾기</a>
                            <a href="/my/join.do" class="join-btn">회원가입</a>
                          
                        </div>
                    </div>

                    <input type="submit" value="로그인" class="submit" id="submit">

                </form>

                <div class="kakao-area">
                    <p>SNS계정으로 간편로그인하세요.</p>
                    <a id="kakao-login-btn"></a>
					<button class="api-btn" onclick="unlinkApp()">로그아웃</button> 
					<div id="result"></div>
                </div>
            </div>

        </main>
		
		<jsp:include page="${_footer}"/>
	</div>
	<script type="text/javascript">
  function unlinkApp() {
    Kakao.API.request({
      url: '/v1/user/unlink',
      success: function(res) {
        alert('success: ' + JSON.stringify(res))
      },
      fail: function(err) {
        alert('fail: ' + JSON.stringify(err))
      },
    })
  }
</script>

<script type="text/javascript">
Kakao.init('245955c2a1a7889af6bf2e4369f4bef4'); //JavaScript 키입력
console.log(Kakao.isInitialized());

  Kakao.Auth.createLoginButton({
    container: '#kakao-login-btn',
    success: function(authObj) {
      Kakao.API.request({
        url: '/v2/user/me',
        success: function(result) {
          $('#result').append(result);
          id = result.id
          connected_at = result.connected_at
          kakao_account = result.kakao_account
          $('#result').append(kakao_account);
          resultdiv="<h2>로그인 성공 !!"
          resultdiv += '<h4>id: '+id+'<h4>'
          resultdiv += '<h4>connected_at: '+connected_at+'<h4>'
          name = "";
          age = "";
          email ="";
          gender = "";
          birthday = "";
          phone_number = "";
//           profile_nickname = "";
          if(typeof kakao_account != 'undefined'){ //받을 데이터 추가 및 삭제
        	  email = kakao_account.email;
        	  gender = kakao_account.gender;
        	  name = kakao_account.name;
        	  age = kakao_account.age_range;
        	  birthyear = kakao_account.birthyear;
        	  birthday = kakao_account.birthday;
        	  phone_number = kakao_account.phone_number;
//         	  profile_nickname = kakao_account.profile_nickname;
          }
          
          resultdiv += '<h4>이름(name): '+name+'<h4>'
          resultdiv += '<h4>연령대(age): '+age+'<h4>'
          resultdiv += '<h4>이메일(email): '+email+'<h4>'
          resultdiv += '<h4>성별(gender): '+gender+'<h4>'
          resultdiv += '<h4>출생연도(birthyear): '+birthyear+'<h4>'
          resultdiv += '<h4>생일(birthday): '+birthday+'<h4>'
          resultdiv += '<h4>전화번호(	phone_number): '+phone_number+'<h4>'
//           resultdiv += '<h4>닉네임(nickname): '+profile_nickname+'<h4>'
          $('#result').append(resultdiv);
          
        },
        fail: function(error) {
          alert(
            'login success, but failed to request user information: ' +
              JSON.stringify(error)
          )
        },
      })
    },
    fail: function(err) {
      alert('failed to login: ' + JSON.stringify(err))
    },
  })
</script>
</body>


<script>

let _errorCode = '${errorCode}';

switch(_errorCode) {
	case '0': 
		alert(_msg.login.loginFailAlert);
		break;
	case '1': 
		alert(_msg.login.loginSuspendAlert);
		break;
	case '2': 
		alert(_msg.login.loginDormantAlert);
		break;
	case '3': 
		alert(_msg.login.loginWithdrawal);
		break;
}

 $(() => {
    $("#submit").on("click", function(){
    	/*  event.preventDefault(); */
    	
    	var idvalue = $("#user_id").val().trim();
    	var passvalue = $("#pw").val().trim();
    	var mypath =  '<%= request.getContextPath() %>';
    	
    	console.log(idvalue, passvalue);

    	 if(idvalue.trim() == ""){
			 alert("아이디를 입력해주세요");
			 return false;
			 }else if(passvalue.trim() == ""){
				 alert("비밀번호를 입력해주세요");
				 return false;
			 }
    	 
    	/* $.ajax({
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
    			
    		}) */
    	return true;	
    	})
    	
    	})
    
  


     
  
</script>

</html>
