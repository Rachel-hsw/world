package com.noahark.moments.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.facebook.drawee.view.SimpleDraweeView;
import com.noahark.moments.R;
import com.noahark.moments.utils.TopTitleUtils;

public class UserSnapshotActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_snapshot);
        new TopTitleUtils(this).setTitle("浮生");
        initView();
        initData();
    }

    public void initView(){
        String[] pictureUrls = {
                "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1603622393694&di=65f87b8fb215ed29fbe721c9d8fc71ce&imgtype=0&src=http%3A%2F%2Fattach.bbs.miui.com%2Fforum%2F201311%2F14%2F234553f16wj1ejnebtt514.jpg",
                "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1603622095265&di=6d3bc10300985c7e42ce71cc0212d006&imgtype=0&src=http%3A%2F%2Fcdn.duitang.com%2Fuploads%2Fitem%2F201510%2F01%2F20151001212224_SJwzm.thumb.700_0.jpeg",
                "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1603622095268&di=d09c495c76757f4dd5de1d18df72d179&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fmobile%2F2020-09-28%2F5f717e4854adc.jpg",
                "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1603622024555&di=ce92a4874c3a6eec5f7d643c844a15a8&imgtype=0&src=http%3A%2F%2Fqqpublic.qpic.cn%2Fqq_public%2F0%2F0-2181273543-32C66F149AC8833538E86AA53622A885%2F0%3Ffmt%3Djpg%26size%3D47%26h%3D641%26w%3D640%26ppv%3D1.jpg",
                "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1603622043268&di=f7078ef5e64c6058807460ac45e0decd&imgtype=0&src=http%3A%2F%2Fc-ssl.duitang.com%2Fuploads%2Fitem%2F202007%2F31%2F20200731083620_mLaVs.thumb.400_0.jpeg",
                "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1603621874341&di=77c8bd9dfb95ee78d130058a33e8d800&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201307%2F09%2F20130709140313_Puczz.png",
                "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1603621874466&di=849a533eca6f137d59d183c7777898e8&imgtype=0&src=http%3A%2F%2Fh.hiphotos.baidu.com%2Fzhidao%2Fpic%2Fitem%2F2cf5e0fe9925bc314b48b5cb5cdf8db1cb13704f.jpg",
                "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1603621874468&di=e611c6ef1f80ebef2ebc3da2ef418949&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201509%2F17%2F20150917190203_wtvs5.jpeg",
                "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1603621874469&di=937143ce38ac1369b8e09b8c3d786d29&imgtype=0&src=http%3A%2F%2Fcdn.duitang.com%2Fuploads%2Fitem%2F201504%2F18%2F20150418H4958_BASxy.jpeg",
                "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1603622932791&di=e381438c1d674d5c7c6c5141c26d0d7a&imgtype=0&src=http%3A%2F%2Fc-ssl.duitang.com%2Fuploads%2Fitem%2F202005%2F16%2F20200516064110_xkrfm.thumb.400_0.jpeg",
                "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1603622935092&di=e44fb1315c47aa0538489f2fb157fe0d&imgtype=0&src=http%3A%2F%2Fb.hiphotos.baidu.com%2Fzhidao%2Fpic%2Fitem%2F0df431adcbef7609a2a725892cdda3cc7cd99e7c.jpg",
                "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1603622936793&di=02c86835d3be496c4e8b7ce8b38e3687&imgtype=0&src=http%3A%2F%2Fc-ssl.duitang.com%2Fuploads%2Fblog%2F202008%2F22%2F20200822115118_wxbsf.thumb.400_0.jpeg",
                "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1603622940290&di=c45c226da3e39e9b16e85238d5c09c30&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201511%2F26%2F20151126193708_uzMir.jpeg"
        };
        SimpleDraweeView avatarImgVi = (SimpleDraweeView) findViewById(R.id.usersnapshot_avatar_imgvi);
        avatarImgVi.setImageURI("https://gss0.baidu.com/7Ls0a8Sm2Q5IlBGlnYG/sys/portraith/item/tb.1.cffe3497.noDYhPINR_CR7ksiKxNR3Q?t=1596719117");

        SimpleDraweeView zonePhotoImgVi1 = (SimpleDraweeView) findViewById(R.id.usersnapshot_zonephoto_imgvi1);
        zonePhotoImgVi1.setImageURI(pictureUrls[9]);

        SimpleDraweeView zonePhotoImgVi2 = (SimpleDraweeView) findViewById(R.id.usersnapshot_zonephoto_imgvi2);
        zonePhotoImgVi2.setImageURI(pictureUrls[10]);

        SimpleDraweeView zonePhotoImgVi3 = (SimpleDraweeView) findViewById(R.id.usersnapshot_zonephoto_imgvi3);
        zonePhotoImgVi3.setImageURI(pictureUrls[11]);
    }

    public void initData(){

    }

    public void onCloseUserSnapshotBtn(View view)
    {
        finish();
    }

    public void onEnterUserNoteSettingBtn(View view)
    {
        Intent intent = new Intent();
        intent.setClass(this,UserNoteSettingActivity.class);
        startActivity(intent);
    }

    public void onEnterUserZoneBtn(View view)
    {
        Intent intent = new Intent();
        intent.setClass(this,UserZoneActivity.class);
        startActivity(intent);
    }
}
