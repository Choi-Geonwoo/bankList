package com.bank.banklist.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogInterceptor  implements HandlerInterceptor {

   @Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String requestURI = request.getRequestURI();
		log.info("■ □ \u25A0 \u25A1\u25A0 \u25A1\u25A0 \u25A1\u25A0 \u25A1\u25A0 \u25A1\u25A0 \u25A1\u25A0 \u25A1\u25A0 \u25A1\u25A0 \u25A1\u25A0 \u25A1");
		log.info("■ □ \u25A0 \u25A1\u25A0 \u25A1\u25A0 \u25A1\u25A0 \u25A1\u25A0 \u25A1\u25A0 \u25A1\u25A0 \u25A1\u25A0 \u25A1\u25A0 \u25A1\u25A0 \u25A1");
		
		log.info("[interceptor] requestURI : " + requestURI);
		
		return true;  // false -> 이후에 진행을 하지 않는다.
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		log.info("■ □ \u25A0 \u25A1\u25A0 \u25A1\u25A0 \u25A1\u25A0 \u25A1\u25A0 \u25A1\u25A0 \u25A1\u25A0 \u25A1\u25A0 \u25A1\u25A0 \u25A1\u25A0 \u25A1");
		log.info("■ □ \u25A0 \u25A1\u25A0 \u25A1\u25A0 \u25A1\u25A0 \u25A1\u25A0 \u25A1\u25A0 \u25A1\u25A0 \u25A1\u25A0 \u25A1\u25A0 \u25A1\u25A0 \u25A1");
		
				log.info("[interceptor] postHandle");
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		log.info("■ □ \u25A0 \u25A1\u25A0 \u25A1\u25A0 \u25A1\u25A0 \u25A1\u25A0 \u25A1\u25A0 \u25A1\u25A0 \u25A1\u25A0 \u25A1\u25A0 \u25A1\u25A0 \u25A1");
		log.info("■ □ \u25A0 \u25A1\u25A0 \u25A1\u25A0 \u25A1\u25A0 \u25A1\u25A0 \u25A1\u25A0 \u25A1\u25A0 \u25A1\u25A0 \u25A1\u25A0 \u25A1\u25A0 \u25A1");
		
				log.info("[interceptor] afterCompletion");
	}
}
