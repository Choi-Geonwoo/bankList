package com.bank.banklist.service.bank.dpst;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bank.banklist.dto.bank.DpstDto;
import com.bank.banklist.dto.common.PaginationVo;


public interface DpstService {
    
    // 입금 목록 조회
    public List<HashMap<String, Object>> dpstTrdtc(DpstDto wDto);
    
    // 입금 엑셀 데이터 저장
    public int dpstExceInsert(List<Map<String, Object>> param, String userId);

    // 페이징 처리
    public List<HashMap<String, Object>> dpstListPage(PaginationVo paginationVo);
    
    // 페이징 카운트
    public int dpstListCount(Map<String, Object> paginationVo);
    
    
}
