package com.tingge.cases;
import com.alibaba.fastjson.JSONObject;
import com.tingge.Until.ExcelUntil;
import com.tingge.Until.HttpUntil;

import com.tingge.pojo.RegisterParams;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import java.util.Map;

public class RegisterCase_v5 {
    //这个比较好,不需要创建类型
    @Test(dataProvider = "datas")
    public void test1(String paramters) {
        String url = "http://119.23.241.154.:8080/futrueloan/mvc/api/member/register";
        Map<String,String> params = (Map<String,String>) JSONObject.parse(paramters);
        HttpUntil.doPost(url, params);
    }

    @Test(dataProvider = "datas")
    public void test2(String paramters) {
        String url = "http://119.23.241.154.:8080/futrueloan/mvc/api/member/register";
//        Map<String,String> params = (Map<String,String>) JSONObject.parse(paramter);
//        HttpUntil.doPost(url, params);
        //转化 RegisterParams对象
        RegisterParams registerParams = JSONObject.parseObject(paramters,RegisterParams.class);
    }


    @DataProvider
    public Object[][] datas() {
        int [] rows = {2,3,4,5,6,7};
        int [] cells = {1,3};
        Object[][] datas = ExcelUntil.datas("src/main/resources/cases.xls", "login",rows,cells );

        return datas;
    }

    public static void main(String[] args) {
        String paramters = "{\"mobilephone\":\"190000000\",\"pwd\":\"\"}";
        RegisterParams registerParams = JSONObject.parseObject(paramters,RegisterParams.class);
        System.out.println(registerParams);
    }
}
