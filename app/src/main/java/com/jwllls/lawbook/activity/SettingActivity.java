package com.jwllls.lawbook.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jwllls.lawbook.R;
import com.jwllls.lawbook.base.BaseActivity;
import com.jwllls.lawbook.utils.CacheUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jianwen on 2017/10/27.
 */

public class SettingActivity extends BaseActivity {


    @BindView(R.id.btn_cancle)
    TextView btnCancle;
    @BindView(R.id.title_name)
    TextView titleName;
    @BindView(R.id.btn_cleanCache)
    Button btnCleanCache;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        titleName.setText("设置");
    }

    @OnClick({R.id.btn_cancle, R.id.btn_cleanCache})
    public void onViewClicked(View view)   {
        switch (view.getId()) {
            case R.id.btn_cancle:
                finish();
                break;
            case R.id.btn_cleanCache:
                String cache = null;
                try {
                    cache = CacheUtil.getTotalCacheSize(this);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                new AlertDialog.Builder(this).setTitle("清除缓存").setMessage("当前存储："+cache).setNegativeButton("取消",null).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        CacheUtil.clearAllCache(SettingActivity.this);
                        shortToast("已经清理缓存");
                    }
                }).show();

                break;
        }
    }
}
