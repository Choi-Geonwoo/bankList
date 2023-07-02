package com.bank.banklist;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.web.WebAppConfiguration;

import com.bank.banklist.dto.bank.WthdrDto;
import com.bank.banklist.dto.common.PaginationVo;
import com.bank.banklist.dto.user.UserDto;
import com.bank.banklist.mapper.bank.WthdrMapper;
import com.bank.banklist.mapper.user.UserMapper;
import com.bank.banklist.service.bank.BankService;
import com.bank.banklist.service.user.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class BanklistApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private WthdrMapper wthdrMapper;
    @Autowired
    private BankService bankService;

	@Test
	void contextLoads() {
        try {
            PaginationVo paginationVo = new PaginationVo(2, 1);
            paginationVo.setId("admin");
            paginationVo.setPage(1);
       
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
