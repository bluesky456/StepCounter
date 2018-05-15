package com.tony.stepcounter.ui.view;

import android.content.Context;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.GestureDetector;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.MotionEvent;

/**
 * 滑屏事件监听
 * @author lantian
 *
 */
public class SwipeListener extends SimpleOnGestureListener implements OnTouchListener {
    /** 滑动距离 */
    private int distance = 100;
    /** 滑动速度 */
    private int velocity = 200;

    private GestureDetector gestureDetector;

    public SwipeListener(Context context) {
        super();
        gestureDetector = new GestureDetector(context, this);
    }

    /**
     * 向左滑
     * @return
     */
    public boolean swipeLeft() {
        return false;
    }

    /**
     * 向右滑
     * @return
     */
    public boolean swipeRight() {
        return false;
    }

    /**
     * 向上滑
     * @return
     */
    public boolean swipeUp() {
        return false;
    }

    /**
     * 向下滑
     * @return
     */
    public boolean swipeDown() {
        return false;
    }



    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                           float velocityY) {
        // TODO Auto-generated method stub
        // e1：第1个ACTION_DOWN MotionEvent
        // e2：最后一个ACTION_MOVE MotionEvent
        // velocityX：X轴上的移动速度（像素/秒）
        // velocityY：Y轴上的移动速度（像素/秒）

        if (e1.getX() - e2.getX() > distance
                && Math.abs(velocityX) > velocity) {
            swipeLeft();
        }
        if (e2.getX() - e1.getX() > distance
                && Math.abs(velocityX) > velocity) {
            swipeRight();
        }
        if (e1.getY() - e2.getY() > distance
                && Math.abs(velocityY) > velocity) {
            swipeUp();
        }
        if (e2.getY() - e1.getY() > distance
                && Math.abs(velocityY) > velocity) {
            swipeDown();
        }
        return false;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        // TODO Auto-generated method stub  
        gestureDetector.onTouchEvent(event);
        return false;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    public GestureDetector getGestureDetector() {
        return gestureDetector;
    }

    public void setGestureDetector(GestureDetector gestureDetector) {
        this.gestureDetector = gestureDetector;
    }
}