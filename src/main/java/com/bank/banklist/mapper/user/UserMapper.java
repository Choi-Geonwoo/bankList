package com.bank.banklist.mapper.user;

import org.apache.ibatis.annotations.Mapper;

import com.bank.banklist.dto.user.UserDto;

@Mapper
public interface UserMapper {
    
    // 로그인
    public UserDto login(UserDto uDto);

    // 회원 가입
    public int joinMembership(UserDto uDto);

    // 아이디 중복 체크
    public int loginIdCheck(String id);
}
