package com.lens.testdemo.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingActivity;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import com.lens.testdemo.R;
import com.lens.testdemo.fragment.ContentFragment;
import com.lens.testdemo.fragment.LeftMenuFragment;


public class MainActivity extends SlidingFragmentActivity {
    private android.support.v4.app.FragmentManager fm;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        SlidingMenu menu = getSlidingMenu();
        setBehindContentView(R.layout.fragment_left_menu);
        menu.setFadeDegree(0.4f);
        menu.setMode(SlidingMenu.LEFT);
        menu.setBehindOffset(200);
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        initView();
    }

    private void initView() {
        fm = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fr_content,new LeftMenuFragment());
        ft.replace(R.id.fr_content,new ContentFragment());
        ft.commit();
    }
}
