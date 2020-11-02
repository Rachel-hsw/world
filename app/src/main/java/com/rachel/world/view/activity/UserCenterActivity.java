package com.rachel.world.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.noahark.moments.Constans;
import com.noahark.moments.ui.activity.MeActivity;
import com.noahark.moments.ui.base.BaseActivity;
import com.noahark.moments.ui.widget.TextButton;
import com.rachel.world.R;
import com.rachel.world.view.fragment.GalleryActivity;

import java.io.File;

public class UserCenterActivity extends BaseActivity {
    ImageView imageView;
    TextView textView;
    TextButton loginBtn;
    LinearLayout loginLl;

    @Override
    protected int layoutResId() {
        return R.layout.fragment_user_center;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginLl = findViewById(R.id.login_ll);
        loginLl.setVisibility(!Constans.hasLogined ? View.VISIBLE : View.GONE);

        imageView = findViewById(R.id.iv_paid);
        textView = findViewById(R.id.album_num_tv);
        imageView.setImageLevel(2);
        textView.setText(String.valueOf(getInSDPhoto()));

    }
    public void onLoginBtn(View view)
    {
        Intent intent = new Intent();
        intent.setClass(this, LoginActivity.class);
        startActivity(intent);
        finish();

    }
    private int getInSDPhoto() {
        String softDir = "/FreeGraffiti";

        String photosPath = Environment.getExternalStorageDirectory().getPath() + softDir + "/";

        File f = new File(photosPath);
        File[] files = f.listFiles();
        if (files == null) {
            return 0;
        }
        return files.length;
    }

    //打开我的画廊
    public void onOpenGalleryBtn(View v) {

        Intent intent = new Intent(); // 绑定主活动
        intent.setClass(UserCenterActivity.this, GalleryActivity.class);
        startActivity(intent);
    }

    //打开编辑个人信息界面
    public void onEnterMeBtn(View v) {
        boolean hasLogined = true; //访问服务端检查是否已登录
        if (hasLogined) //已登录
        {
            Intent intent = new Intent(); // 绑定主活动
            intent.setClass(UserCenterActivity.this, MeActivity.class);
            startActivity(intent);
        } else //未登录
        {
            Intent intent = new Intent(); // 绑定主活动
            intent.setClass(UserCenterActivity.this, LoginActivity.class);
            startActivity(intent);
        }
    }
}

