package com.tingge.cases;

import com.tingge.Until.caseUntil;
import org.testng.annotations.DataProvider;

public class RechargeCase extends BaseProcess {
    @DataProvider
    public Object[][] datas() {
//        String [] cellNames = {"CaseId","ApiId","Params"};
        Object[][] datas = caseUntil.getCaseDatasByApiId("3",cellNames);
        return datas;
    }

}
