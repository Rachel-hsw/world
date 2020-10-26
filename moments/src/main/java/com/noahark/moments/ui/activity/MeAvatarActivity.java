package com.noahark.moments.ui.activity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.noahark.moments.R;
import com.noahark.moments.ui.base.BaseActivity;
import com.noahark.moments.utils.TopTitleUtils;

import me.relex.photodraweeview.PhotoDraweeView;

public class MeAvatarActivity extends BaseActivity {

    private PhotoDraweeView mDetailedAvatarVi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me_avatar);
        new TopTitleUtils(this).setTitle("头像");
        initView();
    }

    @Override
    protected int layoutResId() {
        return 0;
    }

    public void initView() {

        mDetailedAvatarVi = (PhotoDraweeView) findViewById(R.id.detailavatar_imgvi);
        mDetailedAvatarVi.setPhotoUri(Uri.parse("http://news.shangqiuw.com/upload/News/2016-3-15/2016315123740276kdc9d.jpg"));
    }

    public void onCloseMeAvatarBtn(View view) {
        finish();
    }
}
