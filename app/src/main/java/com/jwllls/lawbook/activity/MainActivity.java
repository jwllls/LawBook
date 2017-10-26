package com.jwllls.lawbook.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
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

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

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

    private CaseAdapter adapter;
    private List<CaseModel> cases = new ArrayList<>();


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
                    cases = object;
                    setData();
                    refresh_layout.setRefreshing(false);
                } else {
                    Log.i("bmob", "失败：" + e.getMessage() + "," + e.getErrorCode());
                }
            }


        });


    }


    private void setData() {
        adapter = new CaseAdapter(this, cases);
        recyclerList.setAdapter(adapter);
    }

    @SuppressLint("NewApi")
    private void initViews() {

        titleName.setText("");

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RecordActivity.class));
            }
        });

        recyclerList.setLayoutManager(new LinearLayoutManager(this));

        refresh_layout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getData();
            }
        });

    }



}
