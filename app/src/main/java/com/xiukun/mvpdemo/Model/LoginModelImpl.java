package com.xiukun.mvpdemo.Model;


import java.util.HashMap;

/**
 * Created by ASUS on 2017/11/20.
 */

public class LoginModelImpl implements ILoginModel {

    private HashMap<String,String> map = new  HashMap();
    @Override
    public void save(String name,String pwd) {
        map.put(name,pwd);
    }
}
