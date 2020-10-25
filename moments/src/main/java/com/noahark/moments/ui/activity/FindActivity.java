package com.noahark.moments.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.noahark.moments.R;
import com.noahark.moments.ui.base.BaseActivity;

public class FindActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);
    }

    @Override
    protected int layoutResId() {
        return 0;
    }

    public void onCloseTabPageBtn(View view)
    {
        finish();
    }
}
