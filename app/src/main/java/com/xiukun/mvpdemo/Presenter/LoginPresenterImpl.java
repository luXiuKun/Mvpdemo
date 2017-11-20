package com.xiukun.mvpdemo.Presenter;

import android.text.TextUtils;

import com.xiukun.mvpdemo.Model.LoginModelImpl;
import com.xiukun.mvpdemo.View.ILoginView;

/**
 * Created by ASUS on 2017/11/20.
 */

public class LoginPresenterImpl implements LoginPresenter {


    private final ILoginView mIlogin;
    private final LoginModelImpl loginModel;

    public LoginPresenterImpl(ILoginView iLogin) {
        this.mIlogin = iLogin;
        loginModel = new LoginModelImpl();
    }

    @Override
    public String login() {
        mIlogin.loading(true);
        if (!TextUtils.isEmpty(mIlogin.getName()) && !TextUtils.isEmpty(mIlogin.getPwd())){
            loginModel.save(mIlogin.getName(),mIlogin.getPwd());
            mIlogin.loading(false);
            return "帐号:"+mIlogin.getName()+"-----密码:"+mIlogin.getPwd();
        }
        mIlogin.loading(false);
        return "error：0x00001";
    }
}
