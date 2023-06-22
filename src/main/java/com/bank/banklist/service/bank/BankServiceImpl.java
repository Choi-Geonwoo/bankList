package com.bank.banklist.service.bank;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.banklist.dto.bank.WthdrDto;
import com.bank.banklist.mapper.bank.WthdrMapper;

@Service
public class BankServiceImpl  implements BankService{

    @Autowired
    private WthdrMapper wthdrMapper;

    // 출금 조회
    @Override
    public List<WthdrDto> wthdrTrdtc(WthdrDto wDto) {
        return wthdrMapper.wthdrTrdtc();
    }
   
}
