package com.jwllls.lawbook.activity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jwllls.lawbook.R;
import com.jwllls.lawbook.adapter.CaseAdapter;
import com.jwllls.lawbook.adapter.NewCaseAdapter;
import com.jwllls.lawbook.base.BaseActivity;
import com.jwllls.lawbook.model.CaseMain;
import com.jwllls.lawbook.model.CaseModel;
import com.jwllls.lawbook.model.CaseWarp;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

import static com.jwllls.lawbook.Constant.REFRESH_DATA;
import static com.jwllls.lawbook.Constant.editor;
import static com.jwllls.lawbook.Constant.pref;

public class MainActivity extends BaseActivity {


    @BindView(R.id.recycler_list)
    RecyclerView recyclerList;
    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout refresh_layout;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.btn_dl)
    TextView btn_dl;
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
    @BindView(R.id.dl_myShare)
    TextView dlMyShare;
    @BindView(R.id.main_dl)
    DrawerLayout main_dl;

    private CaseAdapter adapter;
    private CaseWarp caseWarp;
    private NewCaseAdapter caseAdapter;
    private List<CaseModel> cModels = new ArrayList<>();
    private List<CaseMain> cMains = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
        //       queryData(0,STATE_REFRESH);
        initViews();
    }

    private void initData() {
        BmobQuery<CaseModel> query = new BmobQuery<CaseModel>();
        final BmobQuery<CaseMain> q = new BmobQuery<CaseMain>();
        query.order("-createdAt");
        query.findObjects(new FindListener<CaseModel>() {
            @Override
            public void done(final List<CaseModel> object, BmobException e) {
                if (e == null) {
                    shortToast("查询成功：共" + object.size() + "条数据。");
                    q.findObjects(new FindListener<CaseMain>() {
                        @Override
                        public void done(List<CaseMain> list, BmobException e) {
//                            caseWarp.setCaseModel(object);
//                            caseWarp.setCaseMain(list);
                            //adapter.setCaseData(object, list);
                            cModels = object;
                            cMains = list;
                            caseAdapter.setNewData(cModels);
                            caseAdapter.setCaseMain(cMains);
                            recyclerList.setAdapter(caseAdapter);
                            refresh_layout.setRefreshing(false);

                        }
                    });

                } else {
                    Log.i("bmob", "失败：" + e.getMessage() + "," + e.getErrorCode());
                }
            }
        });
    }


    /*private static final int STATE_REFRESH = 0;// 下拉刷新
    private static final int STATE_MORE = 1;// 加载更多
    String lastTime = null;
    private int limit = 5; // 每页的数据是10条
    private int curPage = 0; // 当前页的编号，从0开始
    private void queryData(int page, final int actionType) {

        BmobQuery<CaseModel> query = new BmobQuery<>();
        // 按时间降序查询
        query.order("-createdAt");
        int count = 0;
        // 如果是加载更多
        if (actionType == STATE_MORE) {
            // 处理时间查询
            Date date = null;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                date = sdf.parse(lastTime);
                Log.i("0414", date.toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            // 只查询小于等于最后一个item发表时间的数据
            query.addWhereLessThanOrEqualTo("createdAt", new BmobDate(date));
            // 跳过之前页数并去掉重复数据
            query.setSkip(page * count + 1);
        } else {
            // 下拉刷新
            page = 0;
            query.setSkip(page);
        }
        // 设置每页数据个数
        query.setLimit(limit);
        // 查找数据
        query.findObjects(new FindListener<CaseModel>() {
            @Override
            public void done(List<CaseModel> list, BmobException e) {
                if (e == null) {
                    if (list.size() > 0) {
                        if (actionType == STATE_REFRESH) {
                            // 当是下拉刷新操作时，将当前页的编号重置为0，并把bankCards清空，重新添加
                            curPage = 0;
                            cModels.clear();
                            // 获取最后时间
                            lastTime = list.get(list.size() - 1).getCreatedAt();
                        }
                        // 将本次查询的数据添加到bankCards中
                        for (CaseModel td : list) {
                            cModels.add(td);
                        }

                        // 这里在每次加载完数据后，将当前页码+1，这样在上拉刷新的onPullUpToRefresh方法中就不需要操作curPage了
                        curPage++;
//					 showToast("第"+(page+1)+"页数据加载完成");
                    } else if (actionType == STATE_MORE) {
                        shortToast("没有更多数据了");
                    } else if (actionType == STATE_REFRESH) {
                        shortToast("没有数据");
                    }
                    caseAdapter.loadMoreEnd();
                } else {
                    shortToast("查询失败:" + e.toString());
                    caseAdapter.loadMoreFail();
                }
            }
        });

    }*/


    @SuppressLint("NewApi")
    private void initViews() {

        titleName.setText("LawBook");

        dlNick.setText(pref.getString("nick", ""));
        dlPhone.setText(pref.getString("phone", ""));

        recyclerList.setLayoutManager(new LinearLayoutManager(this));

        refresh_layout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initData();
            }
        });

        adapter = new CaseAdapter(this);

        caseAdapter = new NewCaseAdapter(R.layout.item_case);


        caseAdapter.setNewData(cModels);

        recyclerList.setAdapter(caseAdapter);

        caseAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent it = new Intent(MainActivity.this, RecordActivity.class);
                it.putExtra("caseModel", cModels.get(position));
                it.putExtra("caseMain", cMains.get(position));
                startActivity(it);
            }
        });


//        caseAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
//            @Override
//            public void onLoadMoreRequested() {
//                recyclerList.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        if (mCurrentCounter >= TOTAL_COUNTER) {
//                            //数据全部加载完毕
//                            caseAdapter.loadMoreEnd();
//                        } else {
//                            if (isErr) {
//                                //成功获取更多数据
//                                //  caseAdapter.addData(DataServer.getSampleData(PAGE_SIZE));
//                                mCurrentCounter = caseAdapter.getData().size();
//                                caseAdapter.loadMoreComplete();
//                            } else {
//                                //获取更多数据失败
//                                isErr = true;
//                                shortToast("加载更多失败");
//                                caseAdapter.loadMoreFail();
//
//                            }
//                        }
//
//                        queryData(curPage,STATE_MORE);
//                    }
//
//                }, 3000);
//            }
//        }, recyclerList);
//
//        caseAdapter.setLoadMoreView(new CustomLoadMoreView());

        caseAdapter.setOnItemLongClickListener(new BaseQuickAdapter.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(BaseQuickAdapter adapter, View view, int position) {
                return false;
            }
        });


    }


    @OnClick({R.id.btn_dl, R.id.fab, R.id.dl_setting, R.id.dl_logout, R.id.dl_myShare})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_dl:
                main_dl.openDrawer(Gravity.LEFT);
                break;
            case R.id.fab:
                startActivityForResult(new Intent(this, RecordActivity.class), REFRESH_DATA);
                break;
            case R.id.dl_myShare:
                startActivity(new Intent(this, MyShareActivity.class));
                break;
            case R.id.dl_setting:
                startActivity(new Intent(this, SettingActivity.class));
                break;
            case R.id.dl_logout:
                new AlertDialog.Builder(this)
                        .setMessage("是否退出登录?")
                        .setNegativeButton("取消", null)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                editor.clear().commit();
                                finish();
                                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                            }
                        })
                        .show();
                break;
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == REFRESH_DATA && requestCode == REFRESH_DATA) {
            initData();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
