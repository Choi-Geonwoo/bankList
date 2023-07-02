package com.bank.banklist.service.bank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.banklist.dto.bank.WthdrDto;
import com.bank.banklist.dto.common.PaginationVo;
import com.bank.banklist.mapper.bank.BankMapper;

@Service
public class BankServiceImpl  implements BankService{
    @Autowired
	private BankMapper bankMapper;    
	@Override
	public List<HashMap<String, Object>> bankList(Map<String, Object> map) { 
        return bankMapper.bankList(map);
	}

	@Override
	public int bankListCount(Map<String, Object> paginationVo) {
		
		return bankMapper.bankListCount(paginationVo);
	}

	//
	@Override
	public List<HashMap<String, Object>> getListPage(PaginationVo paginationVo) {
		// TODO Auto-generated method stub
		return bankMapper.getListPage(paginationVo);
	}
   
}
