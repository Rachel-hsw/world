package com.noahark.moments.ui.activity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.facebook.drawee.view.SimpleDraweeView;
import com.noahark.moments.R;
import com.noahark.moments.ui.base.BaseActivity;
import com.noahark.moments.utils.TopTitleUtils;

public class MeQRCodeActivity extends BaseActivity {

    private SimpleDraweeView mAvatarImgVi;
    private SimpleDraweeView mQRCodeImgVi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me_qrcode);
        new TopTitleUtils(this)
                .setTitle("我的二维码");
        initView();
    }

    @Override
    protected int layoutResId() {
        return 0;
    }

    public void initView() {
        mAvatarImgVi = (SimpleDraweeView) findViewById(R.id.avatar_qrcode_imgvi);
        mQRCodeImgVi = (SimpleDraweeView) findViewById(R.id.qrcode_imgvi);
        mQRCodeImgVi.setImageURI((new Uri.Builder()).scheme("res").path(String.valueOf(R.drawable.qr)).build());

        mAvatarImgVi.setImageURI("http://ent.taiwan.cn/list/201403/W020140321365741707073.jpg");
//        mQRCodeImgVi.setImageURI("http://image.9928.tv/Mobile/admin/20151124/20151124160303495.jpg");
    }

    public void onCloseMeQrcodeBtn(View view) {
        finish();
    }
}
