window.onload = function(){
    // rowClicked();
 }
 
 // 검색 조건 확인
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
 
 function tableBtn(){
     //alert();
     rowClicked();
 }
 
 // 전송 데이터 생성
 function rowClicked() {
     var dataList = {};
     var table =document.getElementById('bDtoList');
     var rowList = table.rows; // *1)rows collection
     //let dataJson = ["WTHDRNAMEBANK", "WTHDRDATE", "WTHDRBRIEFS","WTHDRBRIEFSDETAIL","WTHDRPRICE",
     //               "DPSTNAMEBANK" , "DPSTDATE" , "DPSTBRIEFS" ,"DPSTBRIEFSDETAIL" ,"DPSTDATE"];
     let dataJson = ["wthdrNameBank", "wthdrDate", "wthdrBriefs", "wthdrBriefsDetail",  "wthdrPrice"
                     ,"dpstNameBank",  "dpstDate", "dpstBriefs", "dpstBriefsDetail", "dpstPrice"];
     for (i=0; i<rowList.length; i++) {//thead부분 제외.
       
         var row = rowList[i];
         var tdsNum = row.childElementCount-1;// 자식요소 갯수 구하기.
       
         row.onclick = function(){ 
             return function(){ 
           
             var str = "";  
             for (var j = 0; j < tdsNum; j++){//row안에 있는 값 순차대로 가져오기.
                 var row_value = this.cells[j].innerHTML; //*2)cells collection
                 //var data = new Object();
                 dataList[dataJson[j]] = row_value;
                 //str = dataJson[j] +":"+ row_value;//값을 하나의 text값으로 만듦
                 //data.dataJson[j] += row_value;
                 //console.log(str);
                 //console.log(data);
                 // 리스트에 생성된 객체 삽입
                 //dataList.push(str);
             };//td for
             
            document.querySelector('p').innerText =JSON.stringify(dataList);//p태그 안에 값 넣어주기.
            mdfynTrdtl(JSON.stringify(dataList));
          };//return
       }(row);//onclick
     }//for
         console.log(dataList);
         // String 형태로 변환
         //var jsonData = JSON.stringify(dataList) ;
         //console.log(jsonData);
     //mdfynTrdtl(jsonData);
    }//function
   
 // 데이터 수정
 function mdfynTrdtl(data){
     //alert(data);
     fetch("/modifyingTransactionDetails2.do",{
         method : "POST",
         headers : {
             "Content-Type": "application/json",
         },
         body : data,
     }) //fetch
     .then((response) => alert("성공 했습니다.")) // 성공
     .then((data) => console.log(data), location.reload())
     .catch((error) => alert("오류 발생.") );//실패시 error 반환
    }