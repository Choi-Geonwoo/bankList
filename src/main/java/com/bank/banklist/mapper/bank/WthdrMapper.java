package com.bank.banklist.mapper.bank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.bank.banklist.dto.bank.WthdrDto;
import com.bank.banklist.dto.user.UserDto;

@Mapper
public interface WthdrMapper {
    
    public List<WthdrDto> wthdrList(WthdrDto wDto);
    
    public void wthdrExceInsert(Map<String, Object> map);

    public int wthdrdtlsInsert(Map<String, Object> map);

}
