package com.example.grouphuang.tokendemo.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.grouphuang.tokendemo.R;
import com.example.grouphuang.tokendemo.bean.Users;
import com.example.grouphuang.tokendemo.presenter.Presenter;

import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;

public class MainActivity extends AppCompatActivity implements InfoView {
    private EditText zhanghao;
    private EditText mima;
    private Button zhuce;
    private Button denglu;
    private Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bmob.initialize(this, "36a953351f9fab046df1fe697310a79f");
        presenter = new Presenter(this);
        init();

    }
    private void init(){
        zhanghao = (EditText) findViewById(R.id.zhanghao_et);
        mima= (EditText) findViewById(R.id.mima_et);
        denglu = (Button) findViewById(R.id.login_bt);
        zhuce = (Button) findViewById(R.id.resigner_bt);
        presenter.tokenLogin();
        denglu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.login();

          }
        });
        zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.resigner();

            }
        });
    }




    @Override
    public String getUserName() {
        return zhanghao.getText().toString();
    }

    @Override
    public String getUserPassword() {
        return mima.getText().toString();
    }

    @Override
    public Context getContext() {
        return MainActivity.this;
    }


    @Override
    public void showToast(String text) {

        Toast.makeText(MainActivity.this,text+"",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void toSuccessActivity(Users user) {

        Intent intent = new Intent();
        intent.setClass(MainActivity.this,SuccessActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("user",user);
        intent.putExtras(bundle);
        intent.putExtra("Token","");
        startActivity(intent);

    }
}
