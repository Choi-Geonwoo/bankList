package com.bank.banklist.controller.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bank.banklist.service.bank.BankService;

@Controller
public class BankController {


    @Autowired
    private BankService bankService;

    // 입금
    @GetMapping("/bank/dpst")
    public String dpstTrdtcView(Model model){
        model.addAttribute("title", "입금 화면");
       
        return "view/bank/dpst";
    }

    // 출금
    @GetMapping("/bank/wthdr")
    public String wthdrTrdtcView(Model model){
        model.addAttribute("title", "출금 화면");
        model.addAttribute("wDto", bankService.wthdrTrdtc(null));
        return "view/bank/wthdr";
    }
}
