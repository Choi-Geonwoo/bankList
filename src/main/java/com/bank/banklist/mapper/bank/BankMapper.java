package com.bank.banklist.mapper.bank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.bank.banklist.dto.common.PaginationVo;

@Mapper
public interface BankMapper {
    // 페이징 카운트
    public int bankListCount(Map<String, Object> paginationVo);

    // 페이징 처리
    public List<HashMap<String, Object>> getListPage(PaginationVo paginationVo);
}
