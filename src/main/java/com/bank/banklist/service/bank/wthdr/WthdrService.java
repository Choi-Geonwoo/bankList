package com.bank.banklist.service.bank.wthdr;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bank.banklist.dto.bank.WthdrDto;
import com.bank.banklist.dto.user.UserDto;

public interface WthdrService {
    // 출금 목록 조회
    public List<WthdrDto> wthdrTrdtc(WthdrDto wDto);
    
    // 출금 엑셀 데이터 저장
    public int wthdrExceInsert(List<Map<String, Object>> param, String userId);
    
    
}
