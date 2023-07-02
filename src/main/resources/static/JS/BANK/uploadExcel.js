function readExcel() {
    let input = event.target;
    let reader = new FileReader();
    let htmlTable = "<table id='new_table'>\n ";
    const childElement = document.querySelector('#scrollDiv');
    // #child 요소 제거
    // 자식 노드 삭제
    childElement.innerHTML = "";
    reader.onload = function () {
        let data = reader.result;
        let workBook = XLSX.read(data, { type: 'binary' });
        workBook.SheetNames.forEach(function (sheetName) {
            let rows = XLSX.utils.sheet_to_json(workBook.Sheets[sheetName]);
            let json = JSON.stringify(rows)
            let obj = JSON.parse(json);
            
            for(let i =0; i <= obj.length; i ++){
                htmlTable += "<tr>\n";
               for(key in obj[i]){
                
                htmlTable += " <td> "+ obj[i][key] +" </td> \n";
               }
               htmlTable += "</tr>\n";
            }
        })
        htmlTable += "</table> ";
        $("#scrollDiv").append(htmlTable);
    };
    reader.readAsBinaryString(input.files[0]);
}

function homzzang() {
	var jsonObj = tableToJson(document.getElementById("new_table")); // table id를 던지고 함수를
    let urlData = location.pathname;
    var url;
    if (urlData.includes("wthdr")) {
        url = '/wthdrExceInsert.do';
    }else{
        url = '/dpstExceInsert.do';
    }
    console.log("url " + url);
    //console.log(JSON.stringify(jsonObj));
    $.ajax({
        type:'post'
        , contentType:'application/json'
        , data: JSON.stringify(jsonObj)
        , url: url
        , success: function(data) {
        if(0 < data){
        alert("성공");
        // Post 데이터는 포함하지 않으며 페이지를 새로 고침 합니다.
        // 이 때 현재 이력을 수정하여 페이지를 불러오기때문에 history에 새로은 이력은 추가되지 않습니다.
        location.replace("/bank/wthdr");
        }else{
          alert("오류");
        }
        }, error:function(e) {
            alert("error: " + e);
        }
    });
}
	
function tableToJson(table) { // 변환 함수
    var data = [];
    let urlData = location.pathname;
    var headersData;
    if (urlData.includes("wthdr")) {
        headersData = ['wthdrNameBank', 'wthdrDate','wthdrBriefs','wthdrBriefsDetail', 'wthdrPrice'];
    }else{
        headersData = ['dpstNameBank', 'dpstDate','dpstBriefs','dpstBriefsDetail', 'dpstPrice'];
    }
    console.log(headersData);
    var headers = [];
    for(var i=0; i<table.rows[0].cells.length; i++) {
        headers[i] = headersData[i];
    }

    for(var i=0; i<table.rows.length; i++) {
        var tableRow = table.rows[i];
        var rowData = {};
        for(var j=0; j<tableRow.cells.length; j++) {
            rowData[headers[j]] = tableRow.cells[j].innerHTML;
        }
        data.push(rowData);
    }

    return data;
}