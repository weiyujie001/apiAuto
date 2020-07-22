package com.tingge.cases;

import com.tingge.Until.caseUntil;
import com.tingge.cases.BaseProcess;
import org.testng.annotations.DataProvider;

public class RegisterCase_v8 extends BaseProcess {
    //这个比较好,不需要创建类型
    @DataProvider
    public Object[][] datas() {
//        String [] cellNames = {"CaseId","ApiId","Params"};
        Object[][] datas = caseUntil.getCaseDatasByApiId("1",cellNames);
        return datas;
    }

}
