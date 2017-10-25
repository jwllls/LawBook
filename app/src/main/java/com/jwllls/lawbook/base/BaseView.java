package com.jwllls.lawbook.base;

/**
 * Created by jwllls on 2017/10/23.
 */

public interface BaseView {
    void onBegin();

    void onFinish();

    //错误信息
    void onMessageShow(String msg);

}
