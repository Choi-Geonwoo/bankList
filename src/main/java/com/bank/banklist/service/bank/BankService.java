package com.bank.banklist.service.bank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.bank.banklist.dto.common.PaginationVo;

public interface BankService {
   
    // 페이징 
   public List<HashMap<String, Object>> getListPage(PaginationVo paginationVo);
   
   // 페이징 카운트
   public int bankListCount(Map<String, Object> paginationVo);
   
    // 은행 엑셀 데이터 수정
    public int bankExceUpdat(HashMap<String, Object> map, String userId) throws Exception;
    
}
