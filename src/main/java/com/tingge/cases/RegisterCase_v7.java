package com.tingge.cases;

import com.alibaba.fastjson.JSONObject;
import com.tingge.Until.RestUntil;
import com.tingge.Until.caseUntil;
import com.tingge.Until.HttpUntil;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

public class RegisterCase_v7 {
    //这个比较好,不需要创建类型
    @Test(dataProvider = "datas")
    public void test1(String apiId,String paramters) {
        //url
        String url = RestUntil.getUrlByApiId(apiId);
        //type
        String type =RestUntil.getTypeByApiId(apiId);

        //需要的参数
        Map<String,String> params = (Map<String,String>) JSONObject.parse(paramters);
        String result = HttpUntil.doService(url, type, params);
        System.out.println(result);

    }


    @DataProvider
    public Object[][] datas() {
        String [] cellNames = {"ApiId","Params"};
        Object[][] datas = caseUntil.getCaseDatasByApiId("1",cellNames);
        return datas;
    }

}
