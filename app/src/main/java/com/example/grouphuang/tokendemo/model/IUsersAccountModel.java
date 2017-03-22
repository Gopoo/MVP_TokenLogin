package com.example.grouphuang.tokendemo.model;

import android.content.Context;

import com.example.grouphuang.tokendemo.bean.Users;

/**
 * Created by Group.Huang on 2017/3/22.
 */

public interface IUsersAccountModel {

    void resignerUser(String zhanghao,String mima,OnResignerListener listener);
    void loginUser(String zhanghao,String mima,OnLoginListener listener);
    void saveToken(String token, Context context);
    void tokenLogin(Context context,OnTokenLoginListener listener);

}
