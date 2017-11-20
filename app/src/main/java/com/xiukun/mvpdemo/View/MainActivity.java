package com.xiukun.mvpdemo.View;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.xiukun.mvpdemo.Presenter.LoginPresenterImpl;
import com.xiukun.mvpdemo.R;

public class MainActivity extends AppCompatActivity implements ILoginView{

    private static final String TAG = "MainActivity";
    private Button mLogin;
    private EditText mEtName;
    private EditText mEtpwd;
    private TextView mTvUser;
    private LoginPresenterImpl login;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLogin = findViewById(R.id.btn_login);
        mEtName = findViewById(R.id.et_name);
        mEtpwd = findViewById(R.id.et_pwd);
        mTvUser = findViewById(R.id.tv_user);

        login = new LoginPresenterImpl(this);
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = login.login();
                mTvUser.setText(msg);
            }
        });


    }


    @Override
    public String getName() {
        return mEtName.getText().toString();
    }

    @Override
    public String getPwd() {
        return mEtpwd.getText().toString();
    }

    @Override
    public void loading(boolean showProgress) {

        if (showProgress){
            Log.e(TAG,"show");
            progressDialog = new ProgressDialog(MainActivity.this,ProgressDialog.STYLE_SPINNER);
            progressDialog.setTitle("正在登录...");
            progressDialog.show();
        }else{

           if (progressDialog!=null &&progressDialog.isShowing() ){
               Log.e(TAG,"cancel");
               progressDialog.cancel();

           }
        }
    }


}
