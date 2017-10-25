package com.jwllls.lawbook.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jwllls.lawbook.Constant;
import com.jwllls.lawbook.R;
import com.jwllls.lawbook.base.BaseActivity;
import com.jwllls.lawbook.model.UserModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

/**
 * Created by jwllls on 2017/10/23.
 */

public class LoginActivity extends BaseActivity {


    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.btn_goregister)
    Button btnGoregister;

    SharedPreferences.Editor editor;
    SharedPreferences pref;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Bmob.initialize(this, Constant.BMOB_APPID);
        ButterKnife.bind(this);
        initView();

    }

    private void initView() {

        pref = this.getSharedPreferences("data", MODE_PRIVATE);
        editor = pref.edit();
    }


    @OnClick({R.id.btn_login, R.id.btn_goregister})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                final ProgressDialog pd = new ProgressDialog(this);
                pd.show();
                BmobQuery<UserModel> query = new BmobQuery<>();
                query.setLimit(1).order("phone")
                        .findObjects(new FindListener<UserModel>() {
                            @Override
                            public void done(List<UserModel> object, BmobException e) {
                                if (e == null) {
                                    // ...
                                    if (object.get(0).getPassword().equals(etPassword.getText().toString())) {
                                        shortToast("登录成功");
                                        editor.putString("nick", object.get(0).getNick());
                                        editor.putString("phone", object.get(0).getPhone());
                                        editor.commit();
                                        pd.dismiss();
                                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                                        finish();
                                    } else {
                                        shortToast("账号或密码错误");
                                    }

                                } else {
                                    shortToast("" + e.toString());
                                }
                            }
                        });

                break;
            case R.id.btn_goregister:
                startActivity(new Intent(this, RegisterActivity.class));
                break;
        }
    }
}
