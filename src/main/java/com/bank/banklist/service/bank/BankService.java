package com.bank.banklist.service.bank;

import java.util.List;

import com.bank.banklist.dto.bank.WthdrDto;

public interface BankService {
    
    public List<WthdrDto> wthdrTrdtc(WthdrDto wDto);
    
}
