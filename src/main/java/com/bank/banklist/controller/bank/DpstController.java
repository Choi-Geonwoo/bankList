package com.bank.banklist.controller.bank;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.bank.banklist.dto.bank.DpstDto;
import com.bank.banklist.service.bank.dpst.DpstService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class DpstController {

    @Autowired
    private DpstService dpstService;

    // 입금
    @GetMapping("/bank/dpst")
    public String dpstTrdtcView(Model model , @SessionAttribute(name = "userId", required = false) String userId){
        DpstDto dto = new DpstDto();
        dto.setId(userId);
        model.addAttribute("title", "입금 화면");
        model.addAttribute("dDto", dpstService.dpstTrdtc(dto));
        log.info("입금 화면 호출");
        return "view/bank/dpst";
    }

    // 입금 등록 화면
    @GetMapping("/bank/dpstInsert")
    public String dpstInsertlView(Model model){
        model.addAttribute("title", "입금 엑셀 업로드 화면");
        return "view/bank/dpstInsert";
    }
        // 엑셀 거래내역 등록
		@ResponseBody
		@PostMapping(value = "/dpstExceInsert.do")
		public String dpstExceInsert(@RequestBody List<Map<String, Object>> param , @SessionAttribute(name = "userId", required = false) String userId) throws Exception {
			//log.info("은행 거랙 내역 등록 " );
			
			int fileInsert = dpstService.dpstExceInsert(param, userId);
			//int commCnt = commonItemService.commonItemTableInsert(param);
			//int bankCnt = bankService.bankRackDetailsTableInsert(param);
			return String.valueOf(fileInsert);
		}
}
