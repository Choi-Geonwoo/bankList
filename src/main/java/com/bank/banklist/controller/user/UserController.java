package com.bank.banklist.controller.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

import ch.qos.logback.core.util.SystemInfo;
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
    public String loginCheck(@ModelAttribute UserDto uDto,Model model, HttpServletRequest request) throws Exception{
		if ("성공 했습니다.".equals(userService.login(uDto).get("message"))) {
            // 로그인 성공 => 세션 생성

            // 세션을 생성하기 전에 기존의 세션 파기
            request.getSession().invalidate();
            HttpSession session = request.getSession(true);  // Session이 없으면 생성
            // 세션에 userId를 넣어줌
            session.setAttribute("userId", uDto.getId());

        }
        
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
        int cnt  = userService.loginIdCheck(id);
        return cnt;
    }
    // 로그아웃
    @GetMapping("/user/logout.do")
    public String logout(HttpServletRequest request, Model model) {
        
        Map<String, Object> returnParam = new HashMap<>();
        HttpSession session = request.getSession(false);  // Session이 없으면 null return

        if(session != null) {
            session.invalidate();
        }
        
        returnParam.put("message", "로그아웃 되었습니다.");
        returnParam.put("searchUrl", "/");
        model.addAttribute("message", returnParam);
        return "msg/message";
    }

}
