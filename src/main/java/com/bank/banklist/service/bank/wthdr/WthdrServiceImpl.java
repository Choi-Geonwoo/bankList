package com.bank.banklist.service.bank.wthdr;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.MapUtils;

import com.bank.banklist.dto.bank.WthdrDto;
import com.bank.banklist.dto.common.PaginationVo;
import com.bank.banklist.mapper.bank.WthdrMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class WthdrServiceImpl implements WthdrService  {
      @Autowired
	private WthdrMapper wthdrMapper;

      // 출금 조회
    @Override
    public List<WthdrDto> wthdrTrdtc(WthdrDto wDto) {      
        return wthdrMapper.wthdrList(wDto);
    }

    @Override
    public int wthdrExceInsert(List<Map<String, Object>> param, String userId) {
        int cnt = 2;
        
        for (Map<String,Object> map : param) {
            if (!MapUtils.isEmpty(map)) {
                map.put("id", userId);
                cnt += wthdrMapper.wthdrdtlsInsert(map);  
            }
        }
        return cnt;
    }

    // 페이징 처리
    @Override
    public List<HashMap<String, Object>> wthdrListPage(PaginationVo paginationVo) {
        return wthdrMapper.wthdrListPage(paginationVo);
    }

    // 페이징 처리를 위한 카운트
    @Override
    public int wthdrListCount(Map<String, Object> paginationVo) {
        return wthdrMapper.wthdrListCount(paginationVo);
    }

   
}
