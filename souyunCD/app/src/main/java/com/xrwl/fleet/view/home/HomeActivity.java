package com.xrwl.fleet.view.home;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.xrwl.fleet.R;
import com.xrwl.fleet.base.BaseActivity;
import com.xrwl.fleet.base.BaseFragment;
import com.xrwl.fleet.util.StatusBarUtil;
import com.xrwl.fleet.view.home.fragment.OrderFragment;
import com.xrwl.fleet.widget.tab.TabItem;
import com.xrwl.fleet.widget.tab.TabLayout;
import com.xrwl.fleet.widget.tab.TabView;

import java.util.ArrayList;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class HomeActivity extends BaseActivity implements TabLayout.OnTabClickListener {

    private TabLayout tabLayout;
    private ArrayList<TabItem> tabItems;

    private Class[] fragmentCls = new Class[5];
    private Fragment[] fragments = new Fragment[5];

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        tabLayout = $(R.id.cus_tab_layout);

    }


    @Override
    public void initData() {
        tabItems = new ArrayList<>();
        fragmentCls = new Class[3];
        fragments = new Fragment[3];

        // 初始化页面
        try {
            fragmentCls[0] = OrderFragment.class;
            fragmentCls[1] = OrderFragment.class;
            fragmentCls[2] = OrderFragment.class;

            fragments[0] = (BaseFragment) fragmentCls[0].newInstance();
            fragments[1] = (BaseFragment) fragmentCls[1].newInstance();
            fragments[2] = (BaseFragment) fragmentCls[2].newInstance();

        } catch (Exception e) {
            e.printStackTrace();
        }

        tabItems.add(new TabItem(R.drawable.tab_order, R.string.str_tab_order, 0, fragmentCls[0]));
        tabItems.add(new TabItem(R.drawable.tab_fleet, R.string.str_tab_fleet, 0, fragmentCls[1]));
        tabItems.add(new TabItem(R.drawable.tab_my, R.string.str_tab_my, 0, fragmentCls[2]));

        tabLayout.initData(tabItems, this);

        setTabIndex(0);
    }

    public void setTabIndex(int i) {
        onTabItemClick(tabItems.get(i));
    }

    //设置标题
    public void setTitleSingle(boolean showTitle, String title) {
        if (showTitle) {
            showTitleLayout();
            showTitleTv();
            getTitleTv().setText(title);
        } else {
            hideTitleLayout();
        }
    }

    /**
     * @param badgeNum
     */
    public void changeTabBadge(int badgeNum) {
        TabView tabView = tabLayout.getTabView();
        if (null != tabView) {
            if (badgeNum > 0) {
                tabView.setDotNum(-1);
            } else {
                tabView.setDotNum(badgeNum);
            }
        }
        tabView.requestFocus();
        tabView.invalidate();
    }

    @Override
    public void onTabItemClick(TabItem tabItem) {

        int index = 0;
        index = tabItems.indexOf(tabItem);

        switch (index) {
            case 0:
                setTitleSingle(true, getResString(R.string.str_tab_order));
                break;
            case 1:
                setTitleSingle(true, getResString(R.string.str_tab_fleet));
                break;
            case 2:
                setTitleSingle(true, getResString(R.string.str_tab_my));
                break;
        }

        StatusBarUtil.setStatusBar(this, ContextCompat.getColor(context, R.color.white));

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        for (Fragment fragment : fragments) {
            if (fragment.isAdded()) {
                transaction.hide(fragment);
            }
        }

        try {
            tabLayout.setTabSelect(index);

            if (fragments[index].isAdded()) {
                transaction.show(fragments[index]).commitAllowingStateLoss();
            } else {
                transaction.add(R.id.cus_tab_fragment, fragments[index]).commitAllowingStateLoss();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //防止fragment混淆
    @SuppressLint("MissingSuperCall")
    @Override
    protected void onSaveInstanceState(Bundle outState) {
//		super.onSaveInstanceState(outState);
    }

}
