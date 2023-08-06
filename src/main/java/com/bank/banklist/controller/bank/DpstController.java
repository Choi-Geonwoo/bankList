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

import com.bank.banklist.dto.bank.DpstDto;
import com.bank.banklist.dto.common.PaginationVo;
import com.bank.banklist.service.bank.dpst.DpstService;
import com.bank.banklist.utile.Common;

import lombok.extern.slf4j.Slf4j;
import oracle.net.aso.q;

@Slf4j
@Controller
public class DpstController {

    @Autowired
    private DpstService dpstService;
 
    // 입금 조회 화면
/*
    @GetMapping("/bank/dpst")
    public String dpstTrdtcView(Model model , @SessionAttribute(name = "userId", required = false) String userId){
        DpstDto dto = new DpstDto();
        dto.setId(userId);
        model.addAttribute("title", "입금 화면");
        model.addAttribute("dDto", dpstService.dpstTrdtc(dto));
        log.info("입금 화면 호출");
        return "view/bank/dpst";
    }
*/
    // 입금 조회 화면 페이징 처리
    @GetMapping("/bank/dpstListPage")
    public String dpstListPageView(Model model 
    , @SessionAttribute(name = "userId", required = false) String userId
    , @RequestParam(value = "page", defaultValue = "1") final int page
    ,String keyword
    ,String searchType
    ){
        Map<String, Object> map = new HashMap<>();
        DpstDto dto = new DpstDto();
        dto.setId(userId);
        map.put("id", userId);
        map.put("keyword", Common.NullCheck(keyword, ""));
        map.put("searchType", Common.NullCheck(searchType,""));
        
        PaginationVo paginationVo = new PaginationVo(dpstService.dpstListCount(map), page); // 모든 게시글 개수 구하기.
        paginationVo.setPage(page);
        paginationVo.setId(userId); // 이용자 아이디
        paginationVo.setKeyword(Common.NullCheck(keyword, "")); // 검색 조건
        paginationVo.setSearchType(Common.NullCheck(searchType,"")); //검색 타입
        
        List<HashMap<String, Object>> list = dpstService.dpstListPage(paginationVo);
        model.addAttribute("title", "입금 화면");
        model.addAttribute("dDtoCount", dpstService.dpstListCount(map));
        model.addAttribute("dDto", list);
        model.addAttribute("page", page);
        model.addAttribute("pageVo", paginationVo);
        //log.info("입금 화면 호출");
        return "view/bank/dpstListPage";
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
