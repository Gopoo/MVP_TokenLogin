package com.example.grouphuang.tokendemo.model;


import android.content.Context;

import android.content.SharedPreferences;


import com.example.grouphuang.tokendemo.bean.Users;


import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by Group.Huang on 2017/3/22.
 */

public class CUserAccountModel implements IUsersAccountModel {



    @Override
    public void resignerUser(String zhanghao, String mima, final OnResignerListener listener) {
        final Users  user = new Users();
        user.setEmail("null@qq.com");
        user.setMima(mima);
        user.setZhanghao(zhanghao);
        user.setToken("");
        user.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                if (e == null) {

                    listener.resignerSuccess(user);
                }else{


                    listener.resignerFailed();
                }
            }
        });
    }

    @Override
    public void loginUser(String zhanghao, String mima, final OnLoginListener listener) {


        BmobQuery<Users> query = new BmobQuery<>();
        query.addWhereEqualTo("zhanghao", zhanghao);
        query.addWhereEqualTo("mima", mima);
        query.setLimit(1);
        query.findObjects(new FindListener<Users>() {
            @Override
            public void done(List<Users> list, BmobException e) {
                if(e==null&&list.size()==1){

                    listener.loginSuccess(list.get(0));

                }else{
                    listener.loginFailed();

                }
            }
        });
    }

    @Override
    public void saveToken(String token, Context context) {

        SharedPreferences sp = context.getSharedPreferences("loginToken", 0);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("token",token);
        editor.commit();
    }

    @Override
    public void tokenLogin(Context context, final OnTokenLoginListener listener) {
        SharedPreferences sp = context.getSharedPreferences("loginToken", 0);
        String token = sp.getString("token", null);
        if(token!=null){

            BmobQuery<Users> query = new BmobQuery<>();
            query.addWhereEqualTo("token", token);
            query.setLimit(1);
            query.findObjects(new FindListener<Users>() {
                @Override
                public void done(List<Users> list, BmobException e) {
                    if(e==null&&list.size()==1){
                        listener.loginSuccess(list.get(0));
                    }else {

                        listener.loginFailed();
                    }
                }
            });
        }
    }




}
