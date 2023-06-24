 var bool = false;
 function joinMembershipCheck(){
    var form = document.form1;
    var id = document.querySelector('#id');
    var pwd = document.querySelector('#pwd');
    var ncknm = document.querySelector('#ncknm');
    var email = document.querySelector('#email');
    var phone = document.querySelector('#phone');
    if(isNullChek(id.value)){
        alert("아이디 필수 항목 입니다.");
        document.getElementById("id").focus();
        return ;
    }
    if(isNullChek(pwd.value)){
        alert("비밀번호 필수 항목 입니다.");
        document.getElementById("pwd").focus();
        return ;
    }
    if(isNullChek(ncknm.value)){
        alert("닉네임 필수 항목 입니다.");
        document.getElementById("ncknm").focus();
        return ;
    }
    if(isNullChek(email.value) || isNullChek(phone.value)){
        alert("이메일/전화번호 필수 항목 입니다.");
        return ;
    }
    if(bool){
        alert("아이디 중복 체크 해주세요.");
        return ;
    }
       form1.submit();
   }

   // 로그인 중복 체크
function loginIdCheck() {
    var id = document.querySelector('#id');
    if(isNullChek(id.value)){
        alert("아이디를 입력해주세요.");
        document.getElementById("id").focus();
        return;
    }
     // 아이디를 서버로 전송 > DB 유효성 검사 > 결과 반환받기
     $.ajax({
        type: 'GET',
        url: '/user/loginIdCheck.do',
        data: 'id=' + id.value,
        dataType: 'json',
        success: function(result) {
            if (result == '0') {
                alert('사용 가능한 아이디입니다.');
                bool = true;
            } else {
                alert('사용 불가능한 아이디입니다.');
                bool = false;
            }
        },
        error: function(a, b, c) {
            console.log(a, b, c);
        }
                   
    });
}
