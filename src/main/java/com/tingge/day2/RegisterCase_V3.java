package com.tingge.day2;

import com.tingge.Until.ExcelUntil;
import com.tingge.Until.HttpUntil;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

public class RegisterCase_V3 {
    //mobilephone:"15573662209" pwd:""
    //mobilephone:"" pwd:"123456"
    //mobilephone:"123" pwd:"123456"
    //mobilephone:"15573662209" pwd:"12345"
    //mobilephone:"15573662209" pwd:"123456"
    //mobilephone:"15573662209" pwd:"123456"
    @Test(dataProvider = "datas")
    public void test1(String mobilephone,String pwd)  {
        String url = "http://119.23.241.154.:8080/futrueloan/mvc/api/member/register";
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("mobilephone", mobilephone);
        map.put("pwd", pwd);
        HttpUntil.doPost(url, map);
    }
    @DataProvider
    public Object[][] datas(){
        Object[][] datas = ExcelUntil.datas("src/main/resources/cases.xls",1,6,2,6);

        return  datas;
    }
}
