package com.bank.banklist.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new LogInterceptor())
                .order(1)	// 적용할 필터 순서 설정
				.addPathPatterns("/**")
				.excludePathPatterns("/error"); // 인터셉터에서 제외할 패턴

		registry.addInterceptor(new LoginCheckInterceptor())
                .order(2)	// 적용할 필터 순서 설정
				.addPathPatterns("/**")
				.excludePathPatterns("/","/user/**", "/user/logout.do", "/CSS/**", "/JS/**", "/mapper/**"); // 인터셉터에서 제외할 패턴

    }
}
