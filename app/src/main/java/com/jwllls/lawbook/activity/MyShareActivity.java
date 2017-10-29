package com.jwllls.lawbook.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.jwllls.lawbook.R;
import com.jwllls.lawbook.adapter.CaseAdapter;
import com.jwllls.lawbook.base.BaseActivity;
import com.jwllls.lawbook.model.CaseMain;
import com.jwllls.lawbook.model.CaseModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.UpdateListener;

import static com.jwllls.lawbook.Constant.pref;

/**
 * Created by jwllls on 2017/10/28.
 */

public class MyShareActivity extends BaseActivity {


    @BindView(R.id.recycler_list)
    RecyclerView recyclerList;
    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout refresh_layout;
    @BindView(R.id.btn_cancle)
    TextView btnCancle;
    @BindView(R.id.title_name)
    TextView titleName;

    private CaseAdapter adapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myshare);
        ButterKnife.bind(this);
        initView();
        initData();


    }

    private void initData() {

        BmobQuery<CaseModel> query = new BmobQuery<CaseModel>();
        final BmobQuery<CaseMain> q = new BmobQuery<CaseMain>();
        query.addWhereEqualTo("phone", pref.getString("phone", ""));
        query.order("-createdAt");
        q.setLimit(50);
        query.setLimit(50);
        query.findObjects(new FindListener<CaseModel>() {
            @Override
            public void done(final List<CaseModel> object, BmobException e) {
                if (e == null) {
                    shortToast("查询成功：共" + object.size() + "条数据。");
                    q.findObjects(new FindListener<CaseMain>() {
                        @Override
                        public void done(List<CaseMain> list, BmobException e) {
                            adapter.setCaseData(object, list);
                            recyclerList.setAdapter(adapter);
                            refresh_layout.setRefreshing(false);
                        }
                    });

                } else {
                    Log.i("bmob", "失败：" + e.getMessage() + "," + e.getErrorCode());
                }
            }
        });

    }


    private void initView() {
        titleName.setText("我的分享");
        recyclerList.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CaseAdapter(MyShareActivity.this);

        refresh_layout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initData();
            }
        });

        adapter.setMyLongClickListener(new CaseAdapter.MyLongClickListener() {
            @Override
            public void mylongClick(View view, int postion, final CaseModel cmodel, final CaseMain cMain) {


                new AlertDialog.Builder(MyShareActivity.this).setMessage("是否删除该条数据？").setNegativeButton("取消", null).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        cmodel.setObjectId(cmodel.getObjectId());
                        cMain.setObjectId(cMain.getObjectId());
                        cmodel.delete(new UpdateListener() {
                            @Override
                            public void done(BmobException e) {
                                if (e == null) {
                                    cMain.delete(new UpdateListener() {
                                        @Override
                                        public void done(BmobException e) {
                                            if (e == null) {
                                                shortToast("删除成功:" + cmodel.getUpdatedAt());
                                                initData();
                                            }

                                        }
                                    });
                                } else {
                                    shortToast("删除失败：" + e.getMessage());
                                }
                            }
                        });
                    }
                }).show();

            }
        });

    }


    @OnClick(R.id.btn_cancle)
    public void onViewClicked() {
        finish();
    }
}
