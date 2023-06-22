package com.bank.banklist.mapper.user;

import java.util.Map;
import org.apache.ibatis.annotations.Mapper;

import com.bank.banklist.dto.user.UserDto;

@Mapper
public interface UserMapper {
    
    public UserDto login(UserDto uDto);
}
