package com.xrwl.fleet.view.login;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.xrwl.fleet.R;
import com.xrwl.fleet.base.BaseActivity;
import com.xrwl.fleet.bean.MySelfInfo;
import com.xrwl.fleet.bean.login.LoginBean;
import com.xrwl.fleet.util.LoginUtil;
import com.xrwl.fleet.view.home.HomeActivity;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    EditText et_account,et_password;
    TextView tv_btn;

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {

        hideTitleLayout();

        et_account = $(R.id.et_account);
        et_password = $(R.id.et_password);
        tv_btn = $(R.id.tv_btn);

        tv_btn.setOnClickListener(this);

    }

    @Override
    public void initData() {
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_btn:

                if (!LoginUtil.verifyPhone(et_account.getText().toString()))
                    return;
                if (!LoginUtil.verifyPassword(et_password.getText().toString()))
                    return;

                             LoginBean data = new LoginBean();
                data.setToken("token");
                data.setUserId("123");

                MySelfInfo.getInstance().setLoginData(data, et_account.getText().toString());
                finish();
                startActivity(new Intent(context, HomeActivity.class));
                break;
        }
    }
}
