package com.rachel.world.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.viewpager.widget.ViewPager;

/**
 * Description:
 * Data: 2018/8/14
 *
 * @author: cqian
 */
public class CustomViewPager extends ViewPager {

    private boolean mIsCanScroll = true;
    private boolean mChangeItemAnim = true;

    public CustomViewPager(Context context) {
        super(context);
    }

    public CustomViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 设置其是否能滑动换页
     *
     * @param isCanScroll false 不能换页， true 可以滑动换页
     */
    public void setScanScroll(boolean isCanScroll) {
        this.mIsCanScroll = isCanScroll;
    }

    /**
     * 设置切换时是否带有动画效果
     *
     * @param changeItemAnim
     */
    public void setChangeItemAnim(boolean changeItemAnim) {
        mChangeItemAnim = changeItemAnim;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return mIsCanScroll && super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return mIsCanScroll && super.onTouchEvent(ev);
    }

    @Override
    public void setCurrentItem(int item) {
        super.setCurrentItem(item, mChangeItemAnim);
    }


}