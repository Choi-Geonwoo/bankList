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

import com.bank.banklist.dto.common.PaginationVo;
import com.bank.banklist.service.bank.BankService;
import com.bank.banklist.utile.Common;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BankController {

@Autowired
private BankService bankService;

    @GetMapping("/bank/bankList")
    public String bankListView(
         Model model
        ,@SessionAttribute(name = "userId", required = false) String userId
        ,@RequestParam(value = "page", defaultValue = "1") final int page
        ,String keyword
        ,String searchType){
            Map<String, Object> map = new HashMap<>();
            map.put("id", userId);
            map.put("keyword", Common.NullCheck(keyword, ""));
            map.put("searchType", Common.NullCheck(searchType,""));
            PaginationVo paginationVo = new PaginationVo(bankService.bankListCount(map), page); // 모든 게시글 개수 구하기.
            //log.info("전체 내역 화면 호출");
            //log.info("검색 조건");
            paginationVo.setPage(page);
            paginationVo.setId(userId); // 이용자 아이디
            paginationVo.setKeyword(Common.NullCheck(keyword, "")); // 검색 조건
            paginationVo.setSearchType(Common.NullCheck(searchType,"")); //검색 타입
            
            List<HashMap<String, Object>> list = bankService.getListPage(paginationVo);
            model.addAttribute("title", "은행 전체 내역 화면");
            model.addAttribute("bDtoCount", bankService.bankListCount(map));
            model.addAttribute("bDto", list);
            model.addAttribute("page", page);
            model.addAttribute("pageVo", paginationVo);
            return "view/bank/bankList";
    }

    
    @ResponseBody
    @PostMapping("/modifyingTransactionDetails2.do")
    public String modifyingTransactionDetails2(@RequestBody  HashMap<String, Object> map, @SessionAttribute(name = "userId", required = false) String userId) throws Exception{
        
        bankService.bankExceUpdat(map, userId);
	    
        return "데이터 받음";
    }

}
