package com.example.grouphuang.tokendemo.model;

import com.example.grouphuang.tokendemo.bean.Users;

/**
 * Created by Group.Huang on 2017/3/22.
 */

public interface OnLoginListener {
    void loginSuccess(Users user);

    void loginFailed();
}
