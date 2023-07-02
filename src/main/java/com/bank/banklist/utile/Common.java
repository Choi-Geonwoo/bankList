package com.bank.banklist.utile;

import org.springframework.stereotype.Component;

@Component
public class Common {
    
    private Common() { }
    // null 치환
    public static String NullCheck(Object obj,String defaultStr) {
	String result = defaultStr;
	System.out.println((String.valueOf(obj)).length() );
	if((obj != null) && (!"".equals(obj)) && !"null".equals(obj)){
		result = String.valueOf(obj);
	}
	return result;
}
}
