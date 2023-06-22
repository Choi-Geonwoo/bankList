package com.bank.banklist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.bank.banklist.dto.user.UserDto;
import com.bank.banklist.mapper.user.UserMapper;
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

	@Test
	void contextLoads() {
		log.info("테스트 코드");
		UserDto uDto = new UserDto();
		uDto.setUsername("user");
		uDto.setPassword("1234");
		UserDto uDtoList = userMapper.login(uDto);
        log.info("입력 비밀번호 인코딩 : "+passwordEncoder.encode(uDto.getPassword()));
		log.info("입력 비밀번호 인코딩 : "+ passwordEncoder.matches(uDto.getPassword(),uDtoList.getPassword()));
		//
		//$2a$10$JAL2yVxJHso4aYikwe8M0uoFM2w9j2e2es8CV4YmYUVCsP0bOtoTq
		//$2a$10$/6C3bG14gqbSPOa14mcCuOZLVaRwZLgybZarM9iNKwf8v.GrzS/VO
		//$2a$10$sQo/hKtaeMuEBmjPAHcHuObfObjK7pbDv4prnneXLPQtuFU3JBpYa
		//log.info("결과 :: " + uDtoList.toString());
	}

}
