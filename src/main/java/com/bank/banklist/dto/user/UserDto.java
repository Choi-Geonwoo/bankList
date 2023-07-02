package com.bank.banklist.dto.user;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserDto {
    private String serial;    //일련번호
    private String id ;    //아이디
    private String pwd ;    //비밀번호
    private String ncknm ;    //닉네임
    private String email ;    //이메일
    private String phone ;    //전화번호
    private String stateedcode ;    //상태구분코드
    private String rgstrdate ;    //등록일자
}
