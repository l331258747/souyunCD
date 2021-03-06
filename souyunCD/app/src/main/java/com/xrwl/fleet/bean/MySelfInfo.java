package com.xrwl.fleet.bean;

import android.text.TextUtils;

import com.xrwl.fleet.bean.login.LoginBean;
import com.xrwl.fleet.util.SPUtils;

/**
 * Created by LGQ
 * Time: 2018/8/24
 * Function:
 */

public class MySelfInfo {

    private String userToken;

    private MySelfInfo() {
    }

    private final static class HolderClass {
        private final static MySelfInfo INSTANCE = new MySelfInfo();
    }

    public static MySelfInfo getInstance() {
        return HolderClass.INSTANCE;
    }

    public boolean isLogin() {
        if (!TextUtils.isEmpty(getUserToken())) {
            return true;
        }
        return false;
    }

    public void setLoginData(LoginBean model, String phone){
        SPUtils.getInstance().putString(SPUtils.SP_USER_TOKEN, model.getToken());
        SPUtils.getInstance().putString(SPUtils.SP_USER_ID, model.getUserId());
        SPUtils.getInstance().putString(SPUtils.SP_USER_MOBILE, phone);
    }

    public String getUserId(){
        return SPUtils.getInstance().getString(SPUtils.SP_USER_ID);
    }

    public String getUserToken() {
        return SPUtils.getInstance().getString(SPUtils.SP_USER_TOKEN);
    }

    public String getUserMobile(){
        return SPUtils.getInstance().getString(SPUtils.SP_USER_MOBILE);
    }


    public void loginOff() {
        SPUtils.getInstance().logoff();
    }
}
