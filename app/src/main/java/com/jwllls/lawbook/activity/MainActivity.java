package com.jwllls.lawbook.activity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jwllls.lawbook.R;
import com.jwllls.lawbook.adapter.CaseAdapter;
import com.jwllls.lawbook.base.BaseActivity;
import com.jwllls.lawbook.model.CaseModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

import static com.jwllls.lawbook.Constant.editor;
import static com.jwllls.lawbook.Constant.pref;
import static java.lang.System.exit;

public class MainActivity extends BaseActivity {


    @BindView(R.id.recycler_list)
    RecyclerView recyclerList;
    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout refresh_layout;

    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.btn_cancle)
    TextView btnCancle;
    @BindView(R.id.title_name)
    TextView titleName;
    @BindView(R.id.dl_face)
    ImageView dlFace;
    @BindView(R.id.dl_nick)
    TextView dlNick;
    @BindView(R.id.dl_phone)
    TextView dlPhone;
    @BindView(R.id.dl_setting)
    TextView dlSetting;
    @BindView(R.id.dl_logout)
    TextView dlLogout;


    private CaseAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getData();
        initViews();

    }

    private void getData() {
        BmobQuery<CaseModel> query = new BmobQuery<CaseModel>();
        query.setLimit(50);
        query.findObjects(new FindListener<CaseModel>() {
            @Override
            public void done(List<CaseModel> object, BmobException e) {
                if (e == null) {
                    shortToast("查询成功：共" + object.size() + "条数据。");
                    adapter = new CaseAdapter(MainActivity.this, object);
                    recyclerList.setAdapter(adapter);
                    refresh_layout.setRefreshing(false);
                } else {
                    Log.i("bmob", "失败：" + e.getMessage() + "," + e.getErrorCode());
                }
            }


        });


    }


    @SuppressLint("NewApi")
    private void initViews() {

        titleName.setText("");

        dlNick.setText(pref.getString("nick", ""));
        dlPhone.setText(pref.getString("phone", ""));

        recyclerList.setLayoutManager(new LinearLayoutManager(this));

        refresh_layout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getData();
            }
        });

    }




    @OnClick({R.id.btn_cancle, R.id.fab, R.id.dl_setting, R.id.dl_logout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_cancle:
                finish();
                break;
            case R.id.fab:
                startActivity(new Intent(this, RecordActivity.class));
                break;
            case R.id.dl_setting:
                startActivity(new Intent(this, SettingActivity.class));
                break;
            case R.id.dl_logout:
                new AlertDialog.Builder(this)
//                        .setTitle("退出登录")
                        .setMessage("是否退出登录?")
                        .setNegativeButton("取消",null)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                editor.clear();
                                exit(0);
                            }
                        })
                        .show();
                break;
        }
    }
}
