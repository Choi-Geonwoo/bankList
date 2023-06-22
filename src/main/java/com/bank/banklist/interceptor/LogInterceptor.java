package com.bank.banklist.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogInterceptor  implements HandlerInterceptor {
     @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        log.info("■\u25A0\u25A0\u25A0\u25A0\u25A0\u25A0\u25A0\u25A0\u25A0");
        log.info("preHandle : REQUEST [{}][{}]",  requestURI, handler);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("■\u25A0\u25A0\u25A0\u25A0\u25A0\u25A0\u25A0\u25A0\u25A0");
        log.info("postHandle : RESPONSE [{}]", modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String requestURI = request.getRequestURI();
        log.info("■\u25A0\u25A0\u25A0\u25A0\u25A0\u25A0\u25A0\u25A0\u25A0");
        log.info("afterCompletion : RESPONSE [{}][{}]", requestURI, handler);

        if(ex != null) {
            log.error("afterCompletion error!!", ex);
        }
    }
}
