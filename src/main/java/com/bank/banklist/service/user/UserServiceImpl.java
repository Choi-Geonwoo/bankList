package com.bank.banklist.service.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.bank.banklist.dto.user.UserDto;
import com.bank.banklist.mapper.user.UserMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    // 로그인
    @Override
    public Map<String, Object> login(UserDto uDto) {

         Map<String, Object> param = new HashMap<>();
        Map<String, Object> returnParam = new HashMap<>();
        //param.put("username", uDto.getUsername());
        //param.put("password", uDto.getPassword());
        log.info("aaaaaaaaaaaaaaaaaaaa     " + uDto.toString());
            log.info("############################################################");
        UserDto userDto = userMapper.login(uDto);
        
        try {
            String encodePw = userDto.getPassword();
            //log.info("############################################################");
            log.info("입력 비밀번호 인코딩 : "+passwordEncoder.encode(uDto.getPassword()));
            log.info("결과 비밀번호 인코딩 : "+encodePw);
            log.info("결과 : : : "+StringUtils.isEmpty(userDto.getUsername()));
            //log.info("############################################################");
            
            
            returnParam.put("message", "성공 했습니다.");
            returnParam.put("uDto", userDto);
            returnParam.put("searchUrl", "/");
        
        return returnParam;
        } catch (Exception e) {
           System.err.println(e.toString());
            returnParam.put("message", "실패 했습니다.");
            returnParam.put("searchUrl", "/user/login");
        return returnParam;
        }
    }  
}
