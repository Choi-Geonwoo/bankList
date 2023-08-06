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

            Map<String, Object> returnParam = new HashMap<>();
            //Map<String, Object> param = new HashMap<>();
            //param.put("id", uDto.getId());
            //param.put("pwd", uDto.getPwd());
            UserDto userDto = userMapper.login(uDto);
        
        try {
            String encodePw = uDto.getPwd();
            if(passwordEncoder.matches(encodePw , userDto.getPwd())){

                System.out.println("결과 : : : "+StringUtils.isEmpty(userDto.getId()));
                returnParam.put("message", "성공 했습니다.");
                returnParam.put("uDto", userDto);
                returnParam.put("searchUrl", "/");
        
                return returnParam;
            
            }
                returnParam.put("message", "비밀번호가 다릅니다.");
                returnParam.put("uDto", userDto);
                returnParam.put("searchUrl", "/user/login");
                return returnParam;
        } catch (Exception e) {
                System.err.println(e.toString());
                returnParam.put("message", "실패 했습니다.");
                returnParam.put("uDto", userDto);
                returnParam.put("searchUrl", "/user/login");
                return returnParam;
        }
    }  

    // 회원 가입
     @Override
    public Map<String, Object> joinMembership(UserDto uDto) {
        Map<String, Object> returnParam = new HashMap<>();
        int cnt = 0;
        try {
            String password = passwordEncoder.encode(uDto.getPwd());
            // 비밀번호 암호화
            uDto.setPwd(password);
            //System.out.println("+ " +uDto.toString());
            
            cnt = userMapper.joinMembership(uDto);
            log.info("결과값 : : : " + cnt);
            System.out.println("결과값 : : : " + cnt);
            returnParam.put("message", "성공 했습니다.");
            returnParam.put("uDto", uDto);
            returnParam.put("searchUrl", "/");
            
            return returnParam;

        } catch (Exception e) {
            log.error(e.toString());
            System.out.println(e.toString());
            returnParam.put("message", "실패 했습니다.\n 다시 시도해주세요.");
            returnParam.put("uDto", uDto);
            returnParam.put("searchUrl", "/user/joinMembership");
        return returnParam;
        }
    }

    // 아이디 중복 체크
    @Override
    public int loginIdCheck(String id) {
        int cnt = userMapper.loginIdCheck(id);
        log.info("어떻게 나오나 :ㅣ : " + cnt);
        return cnt;
    }

    // 회원정보 수정
    @Override
    public Map<String, Object> mdfyMminf(UserDto uDto) {
        Map<String, Object> returnParam = new HashMap<>();
        try {
            
            int cnt = userMapper.mdfyMminf(uDto);
            if(cnt != 0 ){ 
                returnParam.put("message", "성공 했습니다.");
                returnParam.put("uDto", uDto);
                returnParam.put("searchUrl", "/bank/bankList");
            }else{
                returnParam.put("message", "실패 했습니다.\n 다시 시도해주세요.");
                returnParam.put("uDto", uDto);
                returnParam.put("searchUrl", "/");
            }
        } catch (Exception e) {
            log.error(e.toString());
            System.out.println(e.toString());
            returnParam.put("message", "실패 했습니다.\n 다시 시도해주세요.");
            returnParam.put("uDto", uDto);
            returnParam.put("searchUrl", "/user/joinMembership");
        }
        return returnParam;
    }
}
