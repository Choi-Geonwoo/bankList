package com.bank.banklist.service.bank;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.banklist.dto.bank.BankDto;
import com.bank.banklist.dto.bank.DpstDto;
import com.bank.banklist.dto.bank.WthdrDto;
import com.bank.banklist.dto.common.PaginationVo;
import com.bank.banklist.mapper.bank.BankMapper;
import com.bank.banklist.mapper.bank.DpstMapper;
import com.bank.banklist.utile.Common;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BankServiceImpl  implements BankService{
    @Autowired
	private BankMapper bankMapper;   

    @Autowired
	private DpstMapper dpstMapper;    

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
	public int dpstExceUpdat(HashMap<String, Object> map, String userId) throws Exception {
		map.put("id", userId);
		
		return dpstMapper.dpstExceUpdat(map);
	}
   
}
