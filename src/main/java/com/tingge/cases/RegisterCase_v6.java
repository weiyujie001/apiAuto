package com.tingge.cases;

import com.alibaba.fastjson.JSONObject;
import com.tingge.Until.ExcelUntil;
import com.tingge.Until.HttpUntil;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

public class RegisterCase_v6 {
    //这个比较好,不需要创建类型
    @Test(dataProvider = "datas")
    public void test1(String apiId,String paramters) {
//        String url = "http://119.23.241.154.:8080/futrueloan/mvc/api/member/register";
        int [] rows = {2,3,4,5,6,7,8};
        int [] cells = {1,3,4};
        Object[][] datas= ExcelUntil.datas("src/main/resources/casesV1.xls","接口信息",rows,cells);
        String url ="";
        String type ="";
        for (Object[] data : datas) {
            String apiIdFromRest = data[0].toString();
            if (apiId.equals(apiIdFromRest)){
                //data = {1,post,http://120.78.128.25:8766/futureloan/member/register}
                type = data[1].toString();
                url = data[2].toString();
                break;
            }
        }
        Map<String,String> params = (Map<String,String>) JSONObject.parse(paramters);
        String result = HttpUntil.doService(url, type, params);
        System.out.println(result);

    }


    @DataProvider
    public Object[][] datas() {
        int [] rows = {2,3,4,5,6,7};
        int [] cells = {1,3};
        Object[][] datas = ExcelUntil.datas("src/main/resources/casesV1.xls", "login",rows,cells);

        return datas;
    }

}
