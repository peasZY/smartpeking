package com.lens.testdemo.pagercontent;

import android.app.Activity;
import android.app.Fragment;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.lens.testdemo.R;
import com.lens.testdemo.base.BasePager;

public class SettingPager extends BasePager{

    public SettingPager(Activity activity) {
        super(activity);
    }

    @Override
    public void initData() {
        System.out.println("setting");
        ibtn_left_menu.setVisibility(View.INVISIBLE);
        setSlidingMenuEnable(false);
        tv_title.setText("设置");
        TextView textView = new TextView(mActivity);
        textView.setText("setting");
        textView.setTextSize(15);
        textView.setTextColor(Color.RED);
        fr_content.addView(textView);
    }
}
