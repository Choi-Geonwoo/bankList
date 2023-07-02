package com.bank.banklist.dto.bank;

import lombok.Data;

@Data
public class DpstDto {
    // 일련번호
  private Integer serial;
  // 아이디
  private String id;
  // 입금은행명
  private String dpstNameBank;
  // 입금일자
  private String dpstDate;
  // 입금적요
  private String dpstBriefs;
  // 입금작요상세
  private String dpstBriefsDetail;
  // 입금액
  private String dpstPrice;
  // 등록일자
  private String rgstrDate;
  // 검색 필터
  private String type; 
  // 검색 내용
  private String keyword;
}
