package com.noahark.moments.ui.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.gyf.immersionbar.ImmersionBar;
import com.noahark.moments.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity {

    private Unbinder unbinder;
    protected BaseActivity activity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(layoutResId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        ImmersionBar.with(this)
                .statusBarColor(R.color.black999)
                //状态栏字体是深色，不写默认为亮色
                .statusBarDarkFont(true)
                //导航栏图标是深色，不写默认为亮色
                .navigationBarDarkIcon(true)
                .init();
        activity = this;
        unbinder = ButterKnife.bind(this);

    }


    protected abstract int layoutResId();

    @Override
    protected void onDestroy() {
        unbinder.unbind();
        super.onDestroy();
    }


}
