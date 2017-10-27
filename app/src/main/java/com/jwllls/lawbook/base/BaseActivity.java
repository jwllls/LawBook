package com.jwllls.lawbook.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by jwllls on 2017/10/23.
 */

public class BaseActivity extends AppCompatActivity {

    private static Boolean isExit = false;

    public BaseActivity getActivity() {

        return this;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void shortToast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    public void longToast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_LONG).show();
    }


//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        // TODO Auto-generated method stub
//        if(keyCode == KeyEvent.KEYCODE_BACK);
//        {
//            exitBy2Click();
//        }
//        return false;
//    }
//    private void exitBy2Click() {
//        // TODO Auto-generated method stub
//        Timer tExit = null;
//        if (isExit == false) {
//            isExit = true; // 准备退出
//            Toast.makeText(this, "再次点击退出程序", Toast.LENGTH_SHORT).show();
//            tExit = new Timer();
//            tExit.schedule(new TimerTask() {
//                public void run() {
//                    isExit = false; // 取消退出
//                }
//            }, 2000); // 如果2秒钟内没有按下返回键，则启动定时器取消掉刚才执行的任务
//
//        }
//        else {
//            finish();
//            System.exit(0);
//        }
//    }
}
