package com.xrwl.fleet.view.login;

import com.xrwl.fleet.R;
import com.xrwl.fleet.base.BaseActivity;
import com.xrwl.fleet.util.StatusBarUtil;

import androidx.core.content.ContextCompat;

public class LoginActivity extends BaseActivity {


    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {

        StatusBarUtil.setStatusBar(this, ContextCompat.getColor(context, R.color.color_1C81E9));

        hideTitleLayout();


    }

    @Override
    public void initData() {
    }

}
