package com.bank.banklist.service.bank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bank.banklist.dto.bank.WthdrDto;
import com.bank.banklist.dto.common.PaginationVo;

public interface BankService {
    
    public List<HashMap<String, Object>> bankList(Map<String, Object> map);
    
   public List<HashMap<String, Object>> getListPage(PaginationVo paginationVo);
    
   public int bankListCount(Map<String, Object> paginationVo);
    
}
