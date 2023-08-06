package com.bank.banklist.dto.bank;


import org.springframework.stereotype.Component;

import groovy.transform.ToString;
import lombok.Data;

@Data
@Component
public class WthdrDto {
// 일련번호
  private Integer serial;
  // 아이디
  private String id;
  // 출금은행명
  private String wthdrNameBank;
  // 출금일자
  private String wthdrDate;
  // 출금적요
  private String wthdrBriefs;
  // 출금적요상세
  private String wthdrBriefsDetail;
  // 출금액
  private String wthdrPrice;
  // 등록일자
  private String rgstrDate;
}
