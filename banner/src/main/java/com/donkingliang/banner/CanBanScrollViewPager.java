package com.donkingliang.banner;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by beijixiong on 2019/3/8.
 * 自定义Viewpager,可禁止手动滑动的ViewPager
 */

public class CanBanScrollViewPager extends ViewPager {

    //是否可以手动滑动,默认是可以滑动的
    private boolean isCanScroll = true;

    public CanBanScrollViewPager(Context context) {
        super(context);
    }

    public CanBanScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public boolean isCanScroll() {
        return isCanScroll;
    }

    public void setCanScroll(boolean canScroll) {
        isCanScroll = canScroll;
    }

    /**
     * 重写此方法，判断当前是否可以滑动，如果可以，正常调用父类的方法，该干嘛干嘛！如果不可以滑动，直接返回false，不做任何触摸事件的处理
     *
     * @param ev
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (isCanScroll()) {
            return super.onTouchEvent(ev);
        }
        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (isCanScroll()) {
            return super.onInterceptTouchEvent(ev);
        }
        return false;
    }
}
