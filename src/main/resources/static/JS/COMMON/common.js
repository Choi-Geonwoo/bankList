// 입력값 공백 체크
function chcvlBlank(params) {
    if(params !== null && params !== undefined) {
        // null 및 undefined가 아닌 경우 실행되는 로직
        return true;
      } else {
        // null 및 undefined인 경우 실행되는 로직
        return false;
      }
}
// 입력값 중 공백 체크
function noSpaces(params) {
    var blank_pattern = /[\s]/g;
if( blank_pattern.test( str.value) == true){
    //alert(' 공백은 사용할 수 없습니다. ');
    return false;
}else{
    return true;
}
}

// 입력값 특수문자 확인
function spclChchc(params){
    var special_pattern = /[`~!@#$%^&*|\\\'\";:\/?]/gi;

    if( special_pattern.test(params.value) == true ){
        //alert('특수문자는 사용할 수 없습니다.');
        return false;
    }else{
        return true;
    }
}


 // null 체크	
 function isNullChek(val){
	if(val == null || typeof(val) == "undefined" || '' == val ) {
	return true;
	}
	return false;
}


function dateFormat(date) {
    let month = date.getMonth() + 1;
    let day = date.getDate();
    let hour = date.getHours();
    let minute = date.getMinutes();
    let second = date.getSeconds();

    month = month >= 10 ? month : '0' + month;
    day = day >= 10 ? day : '0' + day;
    hour = hour >= 10 ? hour : '0' + hour;
    minute = minute >= 10 ? minute : '0' + minute;
    second = second >= 10 ? second : '0' + second;

    return date.getFullYear() + '' + month + '' + day + '' + hour + '' + minute + '' + second;
}