
package com.noahark.moments.ui.activity;

import android.content.Context;
import android.os.Bundle;

import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.astuetz.PagerSlidingTabStrip;
import com.noahark.moments.R;
import com.noahark.moments.bean.FollowBean;
import com.noahark.moments.ui.fragment.FansFragment;
import com.noahark.moments.ui.fragment.FollowFragment;

public class RelationActivity extends FragmentActivity {

    private Context mContext;

    private ViewPager mRelationPager;
    private PagerAdapter mRelationPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relation);

        initView();
        initData();
    }

    public void initView()
    {
        mContext = this;

        mRelationPager = (ViewPager) findViewById(R.id.relation_pager);
        mRelationPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        mRelationPager.setAdapter(mRelationPagerAdapter);

        PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        tabs.setViewPager(mRelationPager);
    }

    public void initData()
    {

    }

    public void onCloseTabPageBtn(View view)
    {
        finish();
    }

    //点击添加关注
    public void onAddFollowBtn(View view)
    {
        FollowFragment followFragment = (FollowFragment) mRelationPagerAdapter.instantiateItem(mRelationPager,0);

        FollowBean followBean1 = new FollowBean();
        followBean1.setAvatar("http://tupian.enterdesk.com/2014/mxy/11/5/4/10.jpg");
        followBean1.setNickname("rachel");
        followFragment.addListItem(followBean1);
    }


//    class SelectEditTextFocuser implements OnFocusChangeListener{
//
//        @Override
//        public void onFocusChange(View view, boolean hasFocused) {
//
//            if(hasFocused)
//            {
//                mCareListView.setVisibility(View.INVISIBLE);
//                mCareSelectListView.setVisibility(View.VISIBLE);
//                mCareSelectCancelBtn.setVisibility(View.VISIBLE);
//            }
//        }
//    }


//    class SelectEditTextWatcher implements TextWatcher{
//
//        @Override
//        public void beforeTextChanged(CharSequence selection, int start, int count, int after) {
//
//        }
//
//        @Override
//        public void onTextChanged(CharSequence selection, int start, int before, int count) {
//
//        }
//
//        @Override
//        public void afterTextChanged(Editable editable) {
//
//        }
//    }



//    public void onSelectClearBtn(View view)
//    {
//        mCareSelectEditText.setText(""); //清空
//    }
//

//    public void onSelectCancelBtn(View view)
//    {
//        mCareSelectEditText.setText(""); //清空
//        mCareListView.setVisibility(View.VISIBLE);
//        mCareSelectListView.setVisibility(View.INVISIBLE);
//        mCareSelectCancelBtn.setVisibility(View.GONE);
//        mCareSelectEditText.clearFocus();
//    }


    public class MyPagerAdapter extends FragmentPagerAdapter {

        private final String[] TITLES = {"关注", "粉丝"};

        MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return TITLES[position];
        }

        @Override
        public int getCount() {
            return TITLES.length;
        }

        @Override
        public Fragment getItem(int position) {

            if(position == 0)
                return FollowFragment.newInstance(position);
            else
                return FansFragment.newInstance(position);
        }
    }

}

