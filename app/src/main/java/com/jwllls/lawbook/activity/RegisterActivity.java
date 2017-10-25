package com.jwllls.lawbook.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jwllls.lawbook.R;
import com.jwllls.lawbook.base.BaseActivity;
import com.jwllls.lawbook.model.UserModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by jwllls on 2017/10/23.
 */

public class RegisterActivity extends BaseActivity {


    @BindView(R.id.et_nick)
    EditText etNick;
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.et_psw)
    EditText etPsw;
    @BindView(R.id.sure_psw)
    EditText surePsw;
    @BindView(R.id.btn_register)
    Button btnRegister;
    @BindView(R.id.btn_cancle)
    Button btnCancle;


    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.btn_register, R.id.btn_cancle})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_register:
                progressDialog = new ProgressDialog(this);
                progressDialog.show();
                if (!etNick.getText().toString().equals("") || !etPsw.getText().toString().equals("") || !surePsw.getText().toString().equals("")) {
                    if (surePsw.getText().toString().equals(etPsw.getText().toString())) {
                        UserModel user = new UserModel();
                        user.setNick(etNick.getText().toString());
                        user.setPhone(etPhone.getText().toString());
                        user.setPassword(etPsw.getText().toString());

                        user.save(new SaveListener<String>() {
                            @Override
                            public void done(String s, BmobException e) {
                                if (e == null) {
                                    progressDialog.dismiss();
                                    shortToast("注册成功");
                                    finish();
                                } else {
                                    shortToast("创建数据失败：" + e.getMessage());
                                }
                            }
                        });
                    }
                }
                break;
            case R.id.btn_cancle:
                finish();
                break;


        }
    }
}

