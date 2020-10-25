package com.rachel.world.view.activity;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;

import com.noahark.moments.R;
import com.noahark.moments.ui.activity.FindActivity;
import com.noahark.moments.ui.activity.HomeActivity;
import com.noahark.moments.ui.activity.MessageActivity;


public class CommunityActivity extends TabActivity {

    private TabHost mTabHost;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
    }

    public void initView() {
        setContentView(R.layout.activity_community);
        //tabhost相关配置,缓存4个标签页面，以便可在一个页面中跳转
        mTabHost = this.getTabHost();
        //首页
        Intent intent = new Intent().setClass(this, HomeActivity.class);
        TabHost.TabSpec tabSpec = mTabHost.newTabSpec("home").setIndicator("home").setContent(intent);
        mTabHost.addTab(tabSpec);
        //发现
        intent = new Intent().setClass(this, FindActivity.class);
        tabSpec = mTabHost.newTabSpec("find").setIndicator("find").setContent(intent);
        mTabHost.addTab(tabSpec);

        //消息
        intent = new Intent().setClass(this, MessageActivity.class);
        tabSpec = mTabHost.newTabSpec("message").setIndicator("message").setContent(intent);
        mTabHost.addTab(tabSpec);

        //我的
        intent = new Intent().setClass(this, UserCenterActivity.class);
        tabSpec = mTabHost.newTabSpec("mine").setIndicator("mine").setContent(intent);
        mTabHost.addTab(tabSpec);

        //初始选中
        mTabHost.setCurrentTabByTag("home");

    }

    public void initData() {

    }

    //进入聊天页
    public void onHomeBtn(View view) {
        mTabHost.setCurrentTabByTag("home");
    }

    //进入发现页
    public void onFindBtn(View view) {
        mTabHost.setCurrentTabByTag("find");
    }

    //进入画友页（关系）
    public void onMessageBtn(View view) {
        mTabHost.setCurrentTabByTag("message");
    }

    //进入动态页
    public void onMeBtn(View view) {
        mTabHost.setCurrentTabByTag("mine");
    }
    //进入聊天页
    public void onDrawBtn(View view){
        Intent intent = new Intent();
        intent.setClass(this, MainActivity.class);
        startActivity(intent);
    }


}
