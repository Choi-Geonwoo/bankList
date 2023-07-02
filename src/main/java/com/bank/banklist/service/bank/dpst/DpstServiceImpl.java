package com.bank.banklist.service.bank.dpst;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.MapUtils;

import com.bank.banklist.dto.bank.DpstDto;
import com.bank.banklist.mapper.bank.DpstMapper;


@Service
public class DpstServiceImpl implements DpstService {

    @Autowired
	private DpstMapper dpstMapper;

    // 입금 목록 조회
    @Override
    public List<HashMap<String, Object>> dpstTrdtc(DpstDto wDto) {
        return dpstMapper.dpstList(wDto);
    }

    
    // 입금 엑셀 데이터 등록
    @Override
    public int dpstExceInsert(List<Map<String, Object>> param, String userId) {
        int cnt = 0;
        for (Map<String,Object> map : param) {
            if (!MapUtils.isEmpty(map)) {
                map.put("id", userId);
                System.out.println(map.toString());
                System.out.println(map.toString());
                System.out.println(map.toString());
                System.out.println(map.toString());
                System.out.println(map.toString());
                System.out.println(map.toString());
                cnt += dpstMapper.dpstExceInsert(map);  
            }
        }
        return cnt;
    }
    
}
