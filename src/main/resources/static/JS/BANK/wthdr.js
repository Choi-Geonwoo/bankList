
// --------------------------------------------------------------------------------
var excelHandler = {
    getExcelFileName : function(){
        return '출금_내역'+dateFormat(today)+'.xlsx';
    },
    getSheetName : function(){
        return '출금_내역';
    },
    getExcelData : function(){
        return document.getElementById('wthdrList'); 
    },
    getWorksheet : function(){
        return XLSX.utils.table_to_sheet(this.getExcelData());
    }
}
//공통
// 참고 출처 : https://redstapler.co/sheetjs-tutorial-create-xlsx/
function s2ab(s) { 
    var buf = new ArrayBuffer(s.length); //convert s to arrayBuffer
    var view = new Uint8Array(buf);  //create uint8array as viewer
    for (var i=0; i<s.length; i++) view[i] = s.charCodeAt(i) & 0xFF; //convert to octet
    return buf;    
}
function exportExcel(){ 
    // step 1. workbook 생성
    var wb = XLSX.utils.book_new();

    // step 2. 시트 만들기 
    var newWorksheet = excelHandler.getWorksheet();
    
    // step 3. workbook에 새로만든 워크시트에 이름을 주고 붙인다.  
    XLSX.utils.book_append_sheet(wb, newWorksheet, excelHandler.getSheetName());

    // step 4. 엑셀 파일 만들기 
    var wbout = XLSX.write(wb, {bookType:'xlsx',  type: 'binary'});

    // step 5. 엑셀 파일 내보내기 
    saveAs(new Blob([s2ab(wbout)],{type:"application/octet-stream"}), excelHandler.getExcelFileName());
    
    //alert("완료 되었습니다.");
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


function searchBtn() {
    searchForm.submit();
}

function wthdrUpdate(wDtoList){
    fetch("/wthdrExceUpdat.do", {
        method : "POST",
        headers  :{
            "Content-Type": "application/json",
        },
        body : JSON.stringify(wDtoList),
    }) //fetch
    .then((response) => alert("성공 했습니다." + response)) // 성공
    .then((data) => console.log(data), location.reload())
    .catch((error) => alert("오류 발생.") );//실패시 error 반환
    
}