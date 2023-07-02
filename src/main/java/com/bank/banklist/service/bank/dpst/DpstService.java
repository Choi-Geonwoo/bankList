package com.bank.banklist.service.bank.dpst;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bank.banklist.dto.bank.DpstDto;


public interface DpstService {
    
    // 입금 목록 조회
    public List<HashMap<String, Object>> dpstTrdtc(DpstDto wDto);
    
    // 입금 엑셀 데이터 저장
    public int dpstExceInsert(List<Map<String, Object>> param, String userId);
    
    
}
