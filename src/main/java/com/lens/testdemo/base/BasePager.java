package com.lens.testdemo.base;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.lens.testdemo.R;
import com.lens.testdemo.activity.MainActivity;

public class BasePager {
    public View mRootView;
    public Activity mActivity;
    public ImageButton ibtn_left_menu;
    public TextView tv_title;
    public FrameLayout fr_content;
    private MainActivity mainUi;
    public BasePager(Activity activity){
        this.mActivity = activity;
        initView();
    }
    public View initView(){
        mRootView = View.inflate(mActivity, R.layout.pager_base, null);
        ibtn_left_menu = mRootView.findViewById(R.id.ibtn_left_menu);
        tv_title = mRootView.findViewById(R.id.tv_title);
        fr_content = mRootView.findViewById(R.id.fr_content);
        ibtn_left_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleSlidingMenu();
            }
        });
        return mRootView;
    }
    public void setSlidingMenuEnable(boolean value){
        mainUi = (MainActivity)mActivity;
        SlidingMenu slidingMenu = mainUi.getSlidingMenu();
        if(value){
           slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
       }else {
           slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
       }
    }
    private void toggleSlidingMenu() {
        SlidingMenu slidingMenu = mainUi.getSlidingMenu();
        slidingMenu.toggle();
    }

    public void initData(){

    }
}
