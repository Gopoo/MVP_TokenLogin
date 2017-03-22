package com.example.grouphuang.tokendemo.view;

import android.content.Context;

import com.example.grouphuang.tokendemo.bean.Users;

/**
 * Created by Group.Huang on 2017/3/22.
 */

public interface InfoView {

    String getUserName();
    String getUserPassword();
    Context getContext();
    void showToast(String text);
    void toSuccessActivity(Users user);
}
