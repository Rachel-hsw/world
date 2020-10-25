package com.noahark.moments.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.noahark.moments.R;
import com.noahark.moments.ui.base.BaseActivity;
import com.noahark.moments.utils.TopTitleUtils;

public class MeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new TopTitleUtils(this).setTitle("个人信息");
    }

    @Override
    protected int layoutResId() {
        return R.layout.activity_me;
    }


    public void onEnterMeAvatarBtn(View view) {
        Intent intent = new Intent();
        intent.setClass(this, MeAvatarActivity.class);
        startActivity(intent);
    }

    public void onEnterMeNicknameBtn(View view) {
        Intent intent = new Intent();
        intent.setClass(this, MeNicknameActivity.class);
        startActivity(intent);
    }

    public void onEnterMeQRCodeBtn(View view) {
        Intent intent = new Intent();
        intent.setClass(this, MeQRCodeActivity.class);
        startActivity(intent);
    }

    public void onEnterMeSexBtn(View view) {
        Intent intent = new Intent();
        intent.setClass(this, MeSexActivity.class);
        startActivity(intent);
    }

    public void onEnterMeDistrictBtn(View view) {
        Intent intent = new Intent();
        intent.setClass(this, MeDistrictActivity.class);
        startActivity(intent);
    }

    public void onEnterMeMottoBtn(View view) {
        Intent intent = new Intent();
        intent.setClass(this, MeMottoActivity.class);
        startActivity(intent);
    }

    public void onLogoutBtn(View view) {

    }
}
