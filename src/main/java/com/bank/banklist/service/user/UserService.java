package com.bank.banklist.service.user;

import java.util.Map;

import com.bank.banklist.dto.user.UserDto;

public interface UserService {
    
    // 로그인
    public Map<String, Object> login(UserDto uDto);
    
    // 회원정보 등록
    public Map<String, Object> joinMembership(UserDto uDto);
    
    // 회원정보 수정
    public Map<String, Object> mdfyMminf(UserDto uDto);

    // 회원 가입 아이디 중복 확인
    public int loginIdCheck(String id);
}
