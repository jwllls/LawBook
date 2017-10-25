package com.jwllls.lawbook.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by jwllls on 2017/10/23.
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void shortToast(String str){
        Toast.makeText(this,str,Toast.LENGTH_SHORT).show();
    }

    public void longToast(String str){
        Toast.makeText(this,str,Toast.LENGTH_LONG).show();
    }
}
