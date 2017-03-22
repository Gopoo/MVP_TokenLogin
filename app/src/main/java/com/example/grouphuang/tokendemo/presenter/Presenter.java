package com.example.grouphuang.tokendemo.presenter;

import com.example.grouphuang.tokendemo.bean.Users;
import com.example.grouphuang.tokendemo.model.CUserAccountModel;
import com.example.grouphuang.tokendemo.model.IUsersAccountModel;
import com.example.grouphuang.tokendemo.model.OnLoginListener;
import com.example.grouphuang.tokendemo.model.OnResignerListener;
import com.example.grouphuang.tokendemo.model.OnTokenLoginListener;
import com.example.grouphuang.tokendemo.view.InfoView;

/**
 * Created by Group.Huang on 2017/3/22.
 */

public class Presenter {
    private String token = null;
    private IUsersAccountModel model;
    private InfoView infoView;

    public Presenter(InfoView infoView) {
        this.infoView = infoView;
        model = new CUserAccountModel();
    }

    public void login(){

        model.loginUser(infoView.getUserName(), infoView.getUserPassword(), new OnLoginListener() {
            @Override
            public void loginSuccess(Users user) {
                infoView.showToast("登录成功");
                infoView.toSuccessActivity(user);
                token= user.getToken();
                saveToken();
            }

            @Override
            public void loginFailed() {
                infoView.showToast("登录失败");
            }
        });


    }
    public void resigner(){
        model.resignerUser(infoView.getUserName(), infoView.getUserPassword(), new OnResignerListener() {
            @Override
            public void resignerSuccess(Users user) {
                infoView.showToast("注册成功");
                infoView.toSuccessActivity(user);
                token= user.getToken();
                saveToken();
            }

            @Override
            public void resignerFailed() {
                infoView.showToast("注册失败");
            }
        });


    }
    public void tokenLogin(){
    model.tokenLogin(infoView.getContext(), new OnTokenLoginListener() {
        @Override
        public void loginSuccess(Users user) {
            infoView.toSuccessActivity(user);
            infoView.showToast("Token登录成功");
        }

        @Override
        public void loginFailed() {
            infoView.showToast("Token登录失败");
        }
    });


    }

        public void saveToken(){
            if(token!=null)
         model.saveToken(token,infoView.getContext());


         }
}
