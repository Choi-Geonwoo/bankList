package com.bank.banklist.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bank.banklist.dto.user.UserDto;
import com.bank.banklist.service.user.UserService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class UserController {
    
    @Autowired
    private UserService userService;
     // 홈 화면
    @GetMapping("/")
    public String homeView(Model model){
        model.addAttribute("title", "홈 화면");
       
        return "view/user/login";
    }
    // 로그인
    @GetMapping("/user/login")
    public String loginView(Model model){
        model.addAttribute("title", "로그인 화면");
       
        return "view/user/login";
    }

    // 로그인
    @PostMapping("/user/login.do")
    public String loginCheck(@ModelAttribute UserDto uDto,Model model) throws Exception{
        log.info("!!!!!!!!!!!!!!!!!!!!!" + uDto.toString());
        //model.addAttribute("title", "로그인 화면");
        //model.addAttribute("data", userService.login(uDto));
        model.addAttribute("message", userService.login(uDto));
        //model.addAttribute("searchUrl", "/");
        return "msg/message";
    }
}
