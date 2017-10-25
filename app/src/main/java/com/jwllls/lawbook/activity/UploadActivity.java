package com.jwllls.lawbook.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.EditText;

import com.jwllls.lawbook.R;
import com.jwllls.lawbook.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jwllls on 2017/10/23.
 */

public class UploadActivity extends BaseActivity {


    @BindView(R.id.et_title)
    EditText etTitle;
    @BindView(R.id.et_content)
    EditText etContent;
    @BindView(R.id.btn_upload)
    Button btnUpload;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_upload)
    public void onViewClicked() {


    }
}
