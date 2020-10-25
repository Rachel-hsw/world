package com.noahark.moments.utils;

import android.app.Activity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.noahark.moments.R;
import com.noahark.moments.ui.base.BaseActivity;


/**
 * Description: 实例化title工具类
 * Data: 2018/6/22
 *
 * @author: cqian
 */

public class TopTitleUtils {
    private RelativeLayout mRightWrapper;
    private View mRootView;
    private Activity mActivity;

    public TopTitleUtils(Activity activity) {
        this.mActivity = activity;
        this.mRootView = activity.getWindow().getDecorView();
        setLeft(null);
    }

    public TopTitleUtils(View view) {
        this.mRootView = view;
    }

    public TopTitleUtils setLeft(View.OnClickListener clickListener) {
        if (clickListener != null) {
            mRootView.findViewById(R.id.leftWrapper).setOnClickListener(clickListener);
        } else {
            mRootView.findViewById(R.id.leftWrapper).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mActivity != null) {
                        mActivity.finish();
                    }
                }
            });
        }
        return this;
    }

    public TopTitleUtils setRight(View.OnClickListener clickListener) {
        if (clickListener != null) {
            mRootView.findViewById(R.id.rightWrapper).setOnClickListener(clickListener);
        }
        return this;
    }

    public TopTitleUtils setTitle(String title) {
        TextView tvTitle = mRootView.findViewById(R.id.title_name);
        tvTitle.setText(title);
        return this;
    }

    public String getTitle() {
        TextView tvTitle = mRootView.findViewById(R.id.title_name);
        return tvTitle.getText().toString();
    }

    public TopTitleUtils setTitle(int title) {
        TextView tvTitle = mRootView.findViewById(R.id.title_name);
        tvTitle.setText(title);
        return this;
    }

    public TopTitleUtils addRightView(View view) {
        mRightWrapper = mRootView.findViewById(R.id.rightWrapper);
        mRightWrapper.addView(view);
        return this;
    }

    public TopTitleUtils setRightViewVisiable(int visiable) {
        mRightWrapper.setVisibility(visiable);
        return this;
    }

    public RelativeLayout getRightWrapper() {
        return mRightWrapper;
    }

    public RelativeLayout getRootView() {
        return mRootView.findViewById(R.id.titleBar);
    }


    public TopTitleUtils setTitleBackgroundResource(int bgResource) {
        mRootView.findViewById(R.id.titleBar).setBackgroundResource(bgResource);
        return this;
    }

    public void setTitleOnClickListener(View.OnClickListener listener) {
        mRootView.findViewById(R.id.title_name).setOnClickListener(listener);
    }
}
