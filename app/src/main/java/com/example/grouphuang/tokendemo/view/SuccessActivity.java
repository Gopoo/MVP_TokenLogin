package com.example.grouphuang.tokendemo.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.grouphuang.tokendemo.R;
import com.example.grouphuang.tokendemo.bean.Users;

public class SuccessActivity extends AppCompatActivity {
    //展示账号详细情况

    private TextView type_tv;
    private TextView zhanghao_tv;
    private TextView mima_tv;
    private TextView token_tv;
    private TextView email_tv;
    private Users user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);
       init();

    }
    void init(){

        Intent intent = this.getIntent();
         user=(Users)intent.getSerializableExtra("user");
        String token = intent.getStringExtra("Token");
        if(token==null)
            token = "否";
        email_tv = (TextView) findViewById(R.id.email_tv);
        type_tv = (TextView) findViewById(R.id.type);
        zhanghao_tv = (TextView) findViewById(R.id.zhanghao_tv);
        mima_tv = (TextView) findViewById(R.id.mm_tv);
        token_tv = (TextView) findViewById(R.id.token_tv);
    if(user!=null){
       type_tv.setText("Succesful!Token登录:"+token);
       email_tv.setText(user.getEmail());
       zhanghao_tv.setText(user.getZhanghao());
       mima_tv.setText(user.getMima());
       token_tv.setText(user.getToken());
        saveToken();
   }
    }
    void saveToken(){

//保存Token
        SharedPreferences sp = getSharedPreferences("loginToken", 0);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("token",user.getToken());
        editor.commit();

    }
}
