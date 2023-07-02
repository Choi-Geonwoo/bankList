 function loginCheck(){
    var form = document.form1;
    var username = document.querySelector('#id');
    var password = document.querySelector('#pwd');
    if(isNullChek(username.value)){
        alert("아이디를 입력해주세요.");
        document.getElementById("id").focus();
    return ;
    }
    if(isNullChek(password.value)){
        alert("비밀번호를 입력해주세요.");
        document.getElementById("pwd").focus();
    return ;
    }
       form1.submit();
   }

