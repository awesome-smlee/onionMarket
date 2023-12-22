Kakao.init('245955c2a1a7889af6bf2e4369f4bef4'); //JavaScript 키입력
    console.log(Kakao.isInitialized());

   
   //로그인버튼생성
    Kakao.Auth.createLoginButton({
    container: '.kakao-btn',
    success: function(authObj) {
    Kakao.API.request({
    url: '/v2/user/me',

   

        //로그인성공시
        success: function(result) {
        $('#result').append(result);
        id = result.id
        connected_at = result.connected_at
        kakao_account = result.kakao_account
        $('#result').append(kakao_account);
        
        if(typeof kakao_account != 'undefined'){ //받을 데이터 추가 및 삭제
            email = kakao_account.email;
            gender = kakao_account.gender;
            name = kakao_account.name;
            age = kakao_account.age_range;
            birthyear = kakao_account.birthyear;
            birthday = kakao_account.birthday;
            phone_number = kakao_account.phone_number;
            profile_nickname = kakao_account.profile_nickname;
        }
        
        window.location.href = 'join.jsp';
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
