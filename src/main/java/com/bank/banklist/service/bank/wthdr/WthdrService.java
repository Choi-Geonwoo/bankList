package com.bank.banklist.service.bank.wthdr;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bank.banklist.dto.bank.WthdrDto;
import com.bank.banklist.dto.common.PaginationVo;

public interface WthdrService {
    // 출금 목록 조회
    public List<WthdrDto> wthdrTrdtc(WthdrDto wDto);
    
    // 출금 엑셀 데이터 저장
    public int wthdrExceInsert(List<Map<String, Object>> param, String userId);
    
        // 페이징 처리
    public List<HashMap<String, Object>> wthdrListPage(PaginationVo paginationVo);
    
    // 페이징 카운트
    public int wthdrListCount(Map<String, Object> paginationVo);
    
    // 출금 내역 수정
    public int wthdrExceUpdat(Map<String, Object> map);
}
