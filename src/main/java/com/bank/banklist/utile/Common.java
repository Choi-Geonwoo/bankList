package com.bank.banklist.utile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

@Component
public class Common {
    
    private Common() { }
    // null 치환
    public static String NullCheck(Object obj,String defaultStr) {
		String result = defaultStr;
		//System.out.println((String.valueOf(obj)).length() );
		if((obj != null) && (!"".equals(obj)) && !"null".equals(obj)){
			result = String.valueOf(obj);
            System.out.println(String.valueOf(obj) );
		}
		return result;
	}
	//body 읽는 메소드
	public static String readBody(HttpServletRequest request) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(request.getInputStream()));
        StringBuilder builder = new StringBuilder();
        String buffer;
        while ((buffer = input.readLine()) != null) {
            if (builder.length() > 0) {
                builder.append("\n");
            }
            System.out.println("++++++++  "+buffer);
            builder.append(buffer);
            try {
                
            encoding(builder.toString());
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        return builder.toString();
	}

public static void encoding(String data) throws Exception{
        // 인코딩 변환
        String charset[] = {"utf-8", "euc-kr", "ksc5601", "iso-8859-1", "8859_1", "ascii"};
  
        for (String before : charset){
            for (String after : charset){
                if (!before.equals(after)){
                    System.out.println("ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ");
                    System.out.println("ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ");
                    System.out.println("ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ");

                    System.out.println(before + " -> " + after + " = " + new String(data.getBytes(before), after));
                    System.out.println("ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ");
                    System.out.println("ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ");
                    System.out.println("ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ");
                    System.out.println("ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ");
                }
            }
        }
    }

    
}
