package com.bank.banklist.controller.bank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.bank.banklist.dto.bank.WthdrDto;
import com.bank.banklist.dto.common.PaginationVo;
import com.bank.banklist.service.bank.BankService;
import com.bank.banklist.service.bank.wthdr.WthdrService;
import com.bank.banklist.utile.Common;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class WthdrController {
    
    @Autowired
    private BankService bankService;
    
    @Autowired
    private WthdrService wthdrService;

     // 출금
     /*
    @GetMapping("/bank/wthdr")
    public String wthdrTrdtcView(Model model , @SessionAttribute(name = "userId", required = false) String userId){
        WthdrDto wDto = new WthdrDto();
        wDto.setId(userId);
        model.addAttribute("title", "출금 화면");
        model.addAttribute("wDto", wthdrService.wthdrTrdtc(wDto));
        return "view/bank/wthdr";
    }
    */
    // 출금 화면 페이징 처리
    @GetMapping("/bank/wthdrPage")
    public String wthdrTrdtcView(
    Model model 
    ,@SessionAttribute(name = "userId", required = false) String userId
    ,@RequestParam(value = "page", defaultValue = "1") final int page
    ,String keyword
    ,String searchType
    ){
        WthdrDto wDto = new WthdrDto();
        Map<String, Object> map = new HashMap<>();
        wDto.setId(userId);
        map.put("id", userId);
        map.put("keyword", Common.NullCheck(keyword, ""));
        map.put("searchType", Common.NullCheck(searchType,""));
        PaginationVo paginationVo = new PaginationVo(wthdrService.wthdrListCount(map), page); // 모든 게시글 개수 구하기.
        
        paginationVo.setPage(page);
        paginationVo.setId(userId); // 이용자 아이디
        paginationVo.setKeyword(Common.NullCheck(keyword, "")); // 검색 조건
        paginationVo.setSearchType(Common.NullCheck(searchType,"")); //검색 타입
        List<HashMap<String, Object>> list = null;
        //wthdrService.wthdrListPage(paginationVo);
        model.addAttribute("title", "출금 화면");

        //model.addAttribute("wDtoCount", wthdrService.wthdrListCount(map));
        model.addAttribute("wDtoCount", null);
        model.addAttribute("wDto", list);
        model.addAttribute("page", page);
        model.addAttribute("pageVo", paginationVo);
        return "view/bank/wthdrPage";
    }
    // 출금 등록 화면
    @GetMapping("/bank/wthdrInsert")
    public String wthdrInsertlView(Model model){
        model.addAttribute("title", "엑셀 업로드 화면");
       
        return "view/bank/wthdrInsert";
    }

    // 엑셀 거래내역 등록
		@ResponseBody
		@PostMapping(value = "/wthdrExceInsert.do")
		public String wthdrExceInsert(@RequestBody List<Map<String, Object>> param , @SessionAttribute(name = "userId", required = false) String userId) throws Exception {
			//log.info("은행 거랙 내역 등록 " );
			
			int fileInsert = wthdrService.wthdrExceInsert(param, userId);
			//int commCnt = commonItemService.commonItemTableInsert(param);
			//int bankCnt = bankService.bankRackDetailsTableInsert(param);
			return String.valueOf(fileInsert);
		}
}
