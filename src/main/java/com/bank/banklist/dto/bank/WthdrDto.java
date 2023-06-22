package com.bank.banklist.dto.bank;


import groovy.transform.ToString;
import lombok.Data;

@Data
@ToString
public class WthdrDto {
    public int serial;
    public String id;
    public String trnscDate;
    public String nameBank;
    public String driefs;
    public String typeDtls;
    public String price;
    public String rgstrDate;
}
