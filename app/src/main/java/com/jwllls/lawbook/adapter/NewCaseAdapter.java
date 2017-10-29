package com.jwllls.lawbook.adapter;

import android.support.annotation.LayoutRes;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jwllls.lawbook.R;
import com.jwllls.lawbook.model.CaseMain;
import com.jwllls.lawbook.model.CaseModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jwllls on 2017/10/29.
 */

public class NewCaseAdapter extends BaseQuickAdapter<CaseModel, BaseViewHolder> {


    private List<CaseMain> list  = new ArrayList<>();



    public NewCaseAdapter(@LayoutRes int layoutResId) {
        super(layoutResId);
    }

    public void setCaseMain(List<CaseMain> list){
        this.list = list;
    }

    @Override
    protected void convert(BaseViewHolder helper, CaseModel item) {


        helper.setText(R.id.item_nick,item.getNick());
        helper.setText(R.id.item_phone,item.getPhone());
        helper.setText(R.id.item_caseName,item.getCaseName());
        helper.setText(R.id.item_caseNo,item.getCaseNo());
        helper.setText(R.id.item_time,item.getCreatedAt());
    }
}
