package com.bank.banklist.mapper.bank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.bank.banklist.dto.bank.DpstDto;
import com.bank.banklist.dto.common.PaginationVo;


@Mapper
public interface DpstMapper {
    
    public List<HashMap<String, Object>> dpstList(DpstDto map);

    // 입금 내역 등록
    public int dpstExceInsert(Map<String, Object> map);
    
    // 입금 내역 수정
    public int dpstExceUpdat(Map<String, Object> map);

    // 페이징 처리
    public List<HashMap<String, Object>> dpstListPage(PaginationVo paginationVo);
    
    // 페이징 카운트
    public int dpstListCount(Map<String, Object> paginationVo);
    
}
