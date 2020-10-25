
package com.noahark.moments.ui.activity;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import com.noahark.moments.R;
import com.noahark.moments.bean.FollowBean;
import com.noahark.moments.ui.base.BaseActivity;
import com.noahark.moments.ui.fragment.FansFragment;
import com.noahark.moments.ui.fragment.FollowFragment;
import com.qinjie.pagerslidingtabstrip.PagerSlidingTabStrip;
import com.qinjie.pagerslidingtabstrip.adapter.TabTextPagerAdapter;

public class MessageActivity extends BaseActivity implements TabTextPagerAdapter.TabPagerListener {

    private Context mContext;
    private final String[] TITLES = {"消息", "聊天"};
    private ViewPager mRelationPager;

    private TabTextPagerAdapter mAdapter;
    private PagerSlidingTabStrip tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relation);

        initView();
//        setTabsValue();
        initViewPager();
        initData();
    }

    @Override
    protected int layoutResId() {
        return 0;
    }

    private void setTabsValue() {
        DisplayMetrics dm = getResources().getDisplayMetrics();
        // 设置文字类型
        tabs.setTypeface(null, Typeface.NORMAL);
        // 设置Tab底部选中的指示器的颜色
        tabs.setIndicatorColor(getResources().getColor(R.color.color_1897F2));
        // 设置Tab底部指示器的颜色
        tabs.setUnderlineColor(Color.TRANSPARENT);
        // 设置Tab间的分割线的颜色
        tabs.setDividerColor(Color.TRANSPARENT);
        // 设置Tab选中的文字的颜色
        tabs.setSelectedTextColor(getResources().getColor(R.color.color_1897F2));
        // 设置Tab文字的颜色
        tabs.setTextColor(getResources().getColor(R.color.color_313131));
        // 设置指示点的颜色
        tabs.setDotColor(getResources().getColor(R.color.color_FF3300));
        // 设置Tab的背景色
        tabs.setTabBackground(Color.TRANSPARENT);
        // 设置Tab底部选中的指示器的高度
        tabs.setIndicatorHeight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 2.0f, dm));
        // 设置Tab底部指示器的高度
        tabs.setUnderlineHeight(0);
        // 设置Tab间的分割线的上下padding
        tabs.setDividerPadding(0);
        // 设置Tab间的分割线的宽度
        tabs.setDividerWidth(0);
        // 设置Tab的左右padding
        tabs.setTabPaddingLeftRight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20.0f, dm));
        // 设置Tab底部指示器相对被选中的标签的偏移
        tabs.setScrollOffset(0);
        // 设置Tab的文字大小
        tabs.setTextSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 16, dm));
        // 设置Tab是否自动填充满屏幕
        tabs.setShouldExpand(true);
        // Tab文字大小写
        tabs.setAllCaps(false);
        // 设置Tab底部指示器是否跟文字宽度一致
        tabs.setIndicatorinFollower(true);
    }
    public void initView() {
        mContext = this;
        mRelationPager = findViewById(R.id.relation_pager);
        tabs = findViewById(R.id.tabs);


    }
    private void initViewPager() {
        mAdapter = new TabTextPagerAdapter(getSupportFragmentManager(), 2, TITLES);
        mAdapter.setListener(this);
        mRelationPager.setAdapter(mAdapter);
        tabs.setViewPager(mRelationPager);

        //mPagerSlidingTabStrip.clearAllDots();
    }
    public void initData() {

    }

    public void onCloseTabPageBtn(View view) {
        finish();
    }

    //点击添加关注
    public void onAddFollowBtn(View view) {
        FollowFragment followFragment = (FollowFragment) mAdapter.instantiateItem(mRelationPager, 0);

        FollowBean followBean1 = new FollowBean();
        followBean1.setAvatar("http://tupian.enterdesk.com/2014/mxy/11/5/4/10.jpg");
        followBean1.setNickname("rachel");
        followFragment.addListItem(followBean1);
    }




    @Override
    public Fragment getFragment(int position) {
        if (position == 0)
            return FollowFragment.newInstance(position);
        else
            return FansFragment.newInstance(position);
    }

}

