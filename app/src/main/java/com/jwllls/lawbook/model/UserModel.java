package com.jwllls.lawbook.model;

import cn.bmob.v3.BmobObject;

/**
 * Created by jwllls on 2017/10/23.
 */

public class UserModel extends BmobObject {

    private String nick;
    private String phone;
    private String password;

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
