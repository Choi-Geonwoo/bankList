function searchBtn() {
    //var form = document.searchForm;
    var keyword = document.querySelector('#keyword');
    // 아이디 확인
    if(keyword.value == ""){
        // 아이디 입력 알림
        alert("검색조건 입력해주세요.");
        // 포커스 아이디 입력칸으로 이동
        document.getElementById("keyword").focus();
        // 아이디 미입력시 정지
        return ;
    }
    //alert(document.querySelector('#searchType > option:checked').value);
    searchForm.submit();
}



function rowClicked() {
 
    var table =document.getElementById('bDtoList');
    var rowList = table.rows; // *1)rows collection
    
    for (i=1; i<rowList.length; i++) {//thead부분 제외.
      
        var row = rowList[i];
        var tdsNum = row.childElementCount;// 자식요소 갯수 구하기.
      
        row.onclick = function(){ 
            return function(){ 
          
            var str = "";  
            for (var j = 0; j < tdsNum; j++){//row안에 있는 값 순차대로 가져오기.
            
              var row_value = this.cells[j].innerHTML; //*2)cells collection
              str += row_value+' ';//값을 하나의 text값으로 만듦
              
           };//td for
              
           document.querySelector('p').innerText =str;//p태그 안에 값 넣어주기.
           
         };//return
      }(row);//onclick
    }//for
            
   }//function
  
  window.onload = function(){
      rowClicked();
      }