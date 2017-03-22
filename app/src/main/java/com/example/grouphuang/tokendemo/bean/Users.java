package com.example.grouphuang.tokendemo.bean;

import java.io.Serializable;

import cn.bmob.v3.BmobObject;

/**
 * Created by Group.Huang on 2017/3/19.
 */

public class Users extends BmobObject implements Serializable {

private String zhanghao;
    private String mima;
    private String token;
    private String email;

    public String getZhanghao() {
        return zhanghao;
    }

    public void setZhanghao(String zhanghao) {
        this.zhanghao = zhanghao;
    }

    public String getMima() {
        return mima;
    }

    public void setMima(String mima) {
        this.mima = mima;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
