package com.bank.banklist;

import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bank.banklist.dto.bank.WthdrDto;
import com.bank.banklist.dto.common.PaginationVo;
import com.bank.banklist.service.bank.BankService;
import com.bank.banklist.service.user.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class BanklistApplicationTests2 {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private BankService bankService;
	@Test
	public void contextLoads() {
        try {
            PaginationVo paginationVo = new PaginationVo(0, 0);
        paginationVo.setId("admin");
       
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}