package com.tingge.day2;

import com.tingge.Until.HttpUntil;

import java.util.HashMap;
import java.util.Map;

public class HttpPos_Get {
    public static void main(String[] args) throws Exception {
        // 提供接口地址
        String url = "http://119.23.241.154.:8080/futrueloan/mvc/api/member/register";
        //准备数据
        String mobilphone = "1557366209";
        String pwd = "123456";

       Map<String, String> map = new HashMap<String, String>();
       map.put("mobilphone",mobilphone);
       map.put("pwd",pwd);
       System.out.println(HttpUntil.doGet(url,map));

    }
}
