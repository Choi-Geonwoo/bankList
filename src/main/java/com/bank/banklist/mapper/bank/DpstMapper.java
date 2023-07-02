package com.bank.banklist.mapper.bank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.bank.banklist.dto.bank.DpstDto;


@Mapper
public interface DpstMapper {
    
    public List<HashMap<String, Object>> dpstList(DpstDto map);

    // 입금 내역 등록
    public int dpstExceInsert(Map<String, Object> map);
}
