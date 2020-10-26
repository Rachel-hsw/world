package com.noahark.moments.ui.activity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.chanven.lib.cptr.PtrClassicFrameLayout;
import com.chanven.lib.cptr.PtrDefaultHandler;
import com.chanven.lib.cptr.PtrFrameLayout;
import com.chanven.lib.cptr.loadmore.OnLoadMoreListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.noahark.moments.R;
import com.noahark.moments.R2;
import com.noahark.moments.bean.UserZoneBean;
import com.noahark.moments.ui.adapter.UserZoneAdapter;
import com.noahark.moments.ui.base.BaseActivity;
import com.noahark.moments.utils.TopTitleUtils;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserZoneActivity extends BaseActivity {
    PtrClassicFrameLayout mRefreshLayout;
    Handler handler = new Handler();

    //相册背景

    //头像
    SimpleDraweeView mAvatarImgVi;

    //列表
    ListView mListView;


    private List<UserZoneBean> mUsrZoneList = new ArrayList<UserZoneBean>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_zone);
        mRefreshLayout = findViewById(R.id.refresh_layout_userzone);
        mListView=findViewById(R.id.userzonelist);
        new TopTitleUtils(this).setTitle("浮生");
        initView();
        initData();
    }

    @Override
    protected int layoutResId() {
        return 0;
    }


    public void initView() {
        RelativeLayout userZoneListHeaderView = (RelativeLayout) View.inflate(this, R.layout.listitem_userzone_header, null);
        mListView.addHeaderView(userZoneListHeaderView);
        mAvatarImgVi = (SimpleDraweeView) userZoneListHeaderView.findViewById(R.id.avatar_userzone_imgvi);
    }

    public void initData() {
        //加载头像
        mAvatarImgVi.setImageURI("https://gss0.baidu.com/7Ls0a8Sm2Q5IlBGlnYG/sys/portraith/item/tb.1.cffe3497.noDYhPINR_CR7ksiKxNR3Q?t=1596719117");

        //初次自动加载
        mRefreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                mRefreshLayout.setLoadMoreEnable(true);
                mRefreshLayout.autoRefresh(true);
            }
        }, 150);

        //下拉加载
        mRefreshLayout.setPtrHandler(new PtrDefaultHandler() {

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        initListData();
                        mRefreshLayout.refreshComplete();

                    }
                }, 1500);
            }
        });

        //上拉加载
        mRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {

            @Override
            public void loadMore() {
                handler.postDelayed(new Runnable() {

                    @Override
                    public void run() {

//                        if (page == 1) {
//                            //set load more disable
//                            ptrClassicFrameLayout.setLoadMoreEnable(false);
//                        }
                        mRefreshLayout.loadMoreComplete(true);
                    }
                }, 1000);
            }
        });
    }

    public void initListData() {
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(UserZoneActivity.this, "跳转到该条说说详情界面!", Toast.LENGTH_SHORT).show();
            }
        });
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
        //用户数据！！直接读取数据库中关注的人
        UserZoneBean userZoneBean = new UserZoneBean();
        userZoneBean.setTime(new Date(System.currentTimeMillis()));
        userZoneBean.setPicture(pictureUrls[9]);
        userZoneBean.setContent("那是我一生中永永远远都没法忘记的时光，是我们三人一起共度之时光");
        mUsrZoneList.add(userZoneBean);

        UserZoneBean userZoneBean1 = new UserZoneBean();
        userZoneBean1.setTime(new Date(System.currentTimeMillis()));
        userZoneBean1.setContent("今天玩了天之痕，感觉又回到了童年时代，满满的回忆！");
        mUsrZoneList.add(userZoneBean1);


        //配置表项
        UserZoneAdapter adapter = new UserZoneAdapter(UserZoneActivity.this, mUsrZoneList);
        mListView.setAdapter(adapter);
    }

}
