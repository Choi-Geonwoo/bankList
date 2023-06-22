package com.bank.banklist.service.user;

import java.util.Map;

import com.bank.banklist.dto.user.UserDto;

public interface UserService {
    
    public Map<String, Object> login(UserDto uDto);
}
