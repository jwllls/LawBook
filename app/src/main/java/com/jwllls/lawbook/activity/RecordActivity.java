package com.jwllls.lawbook.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.jwllls.lawbook.R;
import com.jwllls.lawbook.base.BaseActivity;
import com.jwllls.lawbook.model.CaseMain;
import com.jwllls.lawbook.model.CaseModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

import static com.jwllls.lawbook.Constant.REFRESH_DATA;
import static com.jwllls.lawbook.Constant.pref;

/**
 * Created by jwllls on 2017/10/25.
 */

public class RecordActivity extends BaseActivity {

    @BindView(R.id.btn_cancle)
    TextView btnCancle;
    @BindView(R.id.btn_save)
    TextView btnSave;
    @BindView(R.id.et_initialRecord)
    EditText etInitialRecord;
    @BindView(R.id.et_caseName)
    EditText etCaseName;
    @BindView(R.id.et_caseNo)
    EditText etCaseNo;
    @BindView(R.id.et_clientName)
    EditText etClientName;
    @BindView(R.id.et_clientContact)
    EditText etClientContact;
    @BindView(R.id.et_clientAddress)
    EditText etClientAddress;
    @BindView(R.id.et_lawsuitStatus)
    EditText etLawsuitStatus;
    @BindView(R.id.et_quertPassword)
    EditText etQuertPassword;
    @BindView(R.id.et_quertAddress)
    EditText etQuertAddress;
    @BindView(R.id.et_attenEvent)
    EditText etAttenEvent;
    @BindView(R.id.et_procedure)
    EditText etProcedure;
    @BindView(R.id.et_firstSummons)
    EditText etFirstSummons;
    @BindView(R.id.et_firstSession)
    EditText etFirstSession;
    @BindView(R.id.et_rightStop)
    EditText etRightStop;
    @BindView(R.id.et_quoteStop)
    EditText etQuoteStop;
    @BindView(R.id.et_appealStop)
    EditText etAppealStop;
    @BindView(R.id.et_counterclaimStop)
    EditText etCounterclaimStop;
    @BindView(R.id.sealupDate)
    EditText etSealupDate;
    @BindView(R.id.judgeContact)
    EditText judgeContact;
    @BindView(R.id.clertContact)
    EditText clertContact;
    @BindView(R.id.et_lawsuitAddress)
    EditText etLawsuitAddress;
    @BindView(R.id.et_lawyerContact)
    EditText etLawyerContact;
    @BindView(R.id.et_litigantContact)
    EditText etLitigantContact;
    @BindView(R.id.et_backlog)
    EditText etBacklog;
    @BindView(R.id.et_eventTimeLine)
    EditText etEventTimeLine;
    @BindView(R.id.et_occurDate)
    EditText etOccurDate;
    @BindView(R.id.et_eventType)
    EditText etEventType;
    @BindView(R.id.et_updateContent)
    EditText etUpdateContent;
    @BindView(R.id.et_remark)
    EditText etRemark;
    @BindView(R.id.title_name)
    TextView titleName;


    private CaseModel caseModel;
    private CaseMain caseMain;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {

        titleName.setText("案件记录");

        pref = getSharedPreferences("data", MODE_PRIVATE);

        caseModel = (CaseModel) getIntent().getSerializableExtra("caseModel");
        caseMain = (CaseMain) getIntent().getSerializableExtra("caseMain");
        if (caseModel != null && caseMain != null) {
            initData(caseModel, caseMain);
        }


    }

    private void initData(CaseModel caseModel, CaseMain caseMain) {

        etInitialRecord.setText(caseModel.getInitialRecord());
        etCaseName.setText(caseModel.getCaseName());
        etCaseNo.setText(caseModel.getCaseNo());
        etClientName.setText(caseModel.getClientName());
        etClientAddress.setText(caseModel.getClientAddress());
        etLawsuitStatus.setText(caseModel.getLawsuitStatus());
        etQuertPassword.setText(caseModel.getQueryPassword());
        etQuertAddress.setText(caseModel.getQueryAddress());
        etAttenEvent.setText(caseModel.getAttenEvent());

        etProcedure.setText(caseModel.getProcedure());
        etFirstSummons.setText(caseModel.getFirstSummons());
        etFirstSession.setText(caseModel.getFirstSession());
        etRightStop.setText(caseModel.getRightStop());
        etQuoteStop.setText(caseModel.getQuoteStop());
        etAppealStop.setText(caseModel.getAppealStop());
        etCounterclaimStop.setText(caseModel.getCounterclaimStop());
        etSealupDate.setText(caseModel.getSealupDate());

        judgeContact.setText(caseMain.getJudgeContact());
        clertContact.setText(caseMain.getClerkContact());
        etLawsuitAddress.setText(caseMain.getLawsuitAddress());
        etLawyerContact.setText(caseMain.getLawyerContact());
        etLitigantContact.setText(caseMain.getLitigantContact());
        etBacklog.setText(caseMain.getBacklog());

        etEventTimeLine.setText(caseMain.getEventTimeLine());
        etOccurDate.setText(caseMain.getOccurDate());
        etEventType.setText(caseMain.getEventType());
        etUpdateContent.setText(caseMain.getUpDateContent());
        etRemark.setText(caseMain.getRemark());

    }

    @OnClick({R.id.btn_cancle, R.id.btn_save, R.id.et_firstSummons})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_cancle:
                finish();
                break;
            case R.id.btn_save:
                setResult(REFRESH_DATA);
                uploadData();
                break;
            case R.id.et_firstSummons:

                break;
        }
    }

    private void uploadData() {

        CaseModel c = new CaseModel();
        final CaseMain m = new CaseMain();

        c.setNick(pref.getString("nick", ""));
        c.setPhone(pref.getString("phone", ""));
        c.setInitialRecord(etInitialRecord.getText().toString());
        c.setCaseName(etCaseName.getText().toString());
        c.setCaseNo(etCaseNo.getText().toString());
        c.setClientName(etClientName.getText().toString());
        c.setClientAddress(etClientAddress.getText().toString());
        c.setLawsuitStatus(etLawsuitStatus.getText().toString());
        c.setQueryPassword(etQuertPassword.getText().toString());
        c.setQueryAddress(etQuertAddress.getText().toString());
        c.setAttenEvent(etAttenEvent.getText().toString());

        c.setProcedure(etProcedure.getText().toString());
        c.setFirstSummons(etFirstSummons.getText().toString());
        c.setFirstSession(etFirstSession.getText().toString());
        c.setRightStop(etRightStop.getText().toString());
        c.setQuoteStop(etQuoteStop.getText().toString());
        c.setAppealStop(etAppealStop.getText().toString());
        c.setCounterclaimStop(etCounterclaimStop.getText().toString());
        c.setSealupDate(etSealupDate.getText().toString());


        m.setJudgeContact(judgeContact.getText().toString());
        m.setClerkContact(clertContact.getText().toString());
        m.setLawsuitAddress(etLawsuitAddress.getText().toString());
        m.setLawyerContact(etLawyerContact.getText().toString());
        m.setLitigantContact(etLitigantContact.getText().toString());
        m.setBacklog(etBacklog.getText().toString());

        m.setEventTimeLine(etEventTimeLine.getText().toString());
        m.setOccurDate(etOccurDate.getText().toString());
        m.setEventType(etEventType.getText().toString());
        m.setUpDateContent(etUpdateContent.getText().toString());
        m.setRemark(etRemark.getText().toString());


//        CaseWarp f = new CaseWarp();
//        f.setCaseModel(c);
//        f.setCaseMain(m);
//
//        f.save(new SaveListener<String>() {
//            @Override
//            public void done(String s, BmobException e) {
//                if (e == null){
//                    shortToast("保存成功");
//                }
//            }
//        });


        c.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                if (e == null) {

                    m.save(new SaveListener<String>() {
                        @Override
                        public void done(String s, BmobException e) {
                            shortToast("保存成功");
                        }
                    });
                    finish();
                } else {
                    shortToast(s + e.toString());
                }
            }
        });
    }


}
