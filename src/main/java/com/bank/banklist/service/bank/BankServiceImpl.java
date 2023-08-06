package com.bank.banklist.service.bank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bank.banklist.dto.common.PaginationVo;
import com.bank.banklist.mapper.bank.BankMapper;
import com.bank.banklist.mapper.bank.DpstMapper;
import com.bank.banklist.mapper.bank.WthdrMapper;



@Service
public class BankServiceImpl  implements BankService{
	
    @Autowired
	private BankMapper bankMapper;   

    @Autowired
	private DpstMapper dpstMapper;    

    @Autowired
	private WthdrMapper wthdrMapper;    

	// 페이징 카운트
	@Override
	public int bankListCount(Map<String, Object> paginationVo) {
		return bankMapper.bankListCount(paginationVo);
	}

	// 페이징 조회
	@Override
	public List<HashMap<String, Object>> getListPage(PaginationVo paginationVo) {
		return bankMapper.getListPage(paginationVo);
	}

	// 데이터 수정
	@Override
	public int bankExceUpdat(HashMap<String, Object> map, String userId) throws Exception {
		map.put("id", userId);
		int cnt = 0;
		try {
				String serial = String.valueOf(map.get("serial"));
				map.put("w_serial", serial.substring(0, serial.indexOf("_")));
				map.put("d_serial", serial.substring(serial.indexOf("_")+1));
				
				cnt = dpstMapper.dpstExceUpdat(map);
				cnt = wthdrMapper.wthdrExceUpdat(map);
			
		} catch (Exception e) {
			e.printStackTrace();
			cnt = 0;
		}
		
		return cnt;
	}
   
}
