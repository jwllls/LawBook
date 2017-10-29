package com.jwllls.lawbook.model;

import java.util.List;

import cn.bmob.v3.BmobObject;

/**
 * Created by jwllls on 2017/10/28.
 */

public class CaseWarp extends BmobObject {

    private List<CaseModel> caseModel;
    private List<CaseMain> caseMain;

    public List<CaseModel> getCaseModel() {
        return caseModel;
    }

    public void setCaseModel(List<CaseModel> caseModel) {
        this.caseModel = caseModel;
    }

    public List<CaseMain> getCaseMain() {
        return caseMain;
    }

    public void setCaseMain(List<CaseMain> caseMain) {
        this.caseMain = caseMain;
    }
}
