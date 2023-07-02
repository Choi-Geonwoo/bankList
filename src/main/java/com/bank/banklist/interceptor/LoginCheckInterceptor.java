package com.bank.banklist.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		String requestURI = request.getRequestURI();
        HttpSession session = request.getSession(false);
		log.info("■ □ \u25A0 \u25A1\u25A0 \u25A1\u25A0 \u25A1\u25A0 \u25A1\u25A0 \u25A1\u25A0 \u25A1\u25A0 \u25A1\u25A0 \u25A1\u25A0 \u25A1\u25A0 \u25A1");
		log.info(" [interceptor] : " + requestURI);
        log.info(" [session] : " + session.getAttribute("userId"));
        log.info("■ □ \u25A0 \u25A1\u25A0 \u25A1\u25A0 \u25A1\u25A0 \u25A1\u25A0 \u25A1\u25A0 \u25A1\u25A0 \u25A1\u25A0 \u25A1\u25A0 \u25A1\u25A0 \u25A1");
		
		if(session == null || session.getAttribute("userId") == null) {
       		// 로그인 되지 않음
			System.out.println("[미인증 사용자 요청]");
			//session.setAttribute("message", "Hello world");
			//로그인으로 redirect
			response.sendRedirect("msg/message?message="+"/");
			return false;
		}
        // 로그인 되어있을 떄
		return true;
	}
}
