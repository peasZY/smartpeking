package com.lens.testdemo.pagercontent;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.lens.testdemo.R;
import com.lens.testdemo.base.BasePager;


public  class ServicerPager extends BasePager{

    public ServicerPager(Activity activity) {
        super(activity);
    }

    @Override
    public void initData() {
        System.out.println("fuwu");
        setSlidingMenuEnable(true);
        tv_title.setText("服务");
        TextView textView = new TextView(mActivity);
        textView.setText("服务");
        textView.setTextSize(15);
        textView.setTextColor(Color.YELLOW);
        fr_content.addView(textView);
    }
}
