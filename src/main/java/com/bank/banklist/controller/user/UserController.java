package com.bank.banklist.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    // 회원가입 페이지
    @GetMapping("/user/joinMembership")
    public String joinMembershipView(Model model){
        model.addAttribute("title", "회원 화면");
       
        return "view/user/joinMembership";
    }

    // 회원가입
    @PostMapping("/user/joinMembership.do")
    public String joinMembership(Model model, @ModelAttribute UserDto uDto){
        //model.addAttribute("title", "회원 화면");
       
        model.addAttribute("message", userService.joinMembership(uDto));
        return "msg/message";
    }

        // 아이디 중복 체크
    @GetMapping("/user/loginIdCheck.do")
    @ResponseBody
    public int loginIdCheck(@RequestParam("id") String id){
        log.debug("############################");
        log.debug("############################");
        log.debug("############################");
        log.debug("############################");
        log.debug("############################");
        log.debug("############################");
        int cnt  = userService.loginIdCheck(id);
        log.debug("############# | | | "+cnt+"##############");
        log.debug("############################");
        log.debug("############################");
        log.debug("############################");
        log.debug("############################");
        return cnt;
    }

}
