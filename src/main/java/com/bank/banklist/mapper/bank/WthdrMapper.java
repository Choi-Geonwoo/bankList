package com.bank.banklist.mapper.bank;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bank.banklist.dto.bank.WthdrDto;

@Mapper
public interface WthdrMapper {
    
    public List<WthdrDto> wthdrTrdtc();
}
