package com.bank.banklist.controller.file;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class FileController {
    // 입금
    @GetMapping("/file/uploadExcel")
    public String uploadExcelView(Model model){
        model.addAttribute("title", "엑셀 업로드 화면");
       
        return "view/file/uploadExcel";
    }
    // 엑셀 거래내역 등록
		@ResponseBody
		@PostMapping(value = "/excelUpload.do")
		public String excelUploadInsert(@RequestBody List<Map<String, Object>> param) throws Exception {
			//log.info("은행 거랙 내역 등록 " );
			for (Map<String, Object> str : param) {
				log.info(": : :  " + str.toString());
			}
			//int commCnt = commonItemService.commonItemTableInsert(param);
			//int bankCnt = bankService.bankRackDetailsTableInsert(param);
			return "2";
		}
}
