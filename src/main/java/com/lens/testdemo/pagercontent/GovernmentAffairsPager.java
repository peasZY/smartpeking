package com.lens.testdemo.pagercontent;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.lens.testdemo.R;
import com.lens.testdemo.base.BasePager;

/**
 * Created by LY305512 on 2017/12/7.
 */

public  class GovernmentAffairsPager extends BasePager{

    public GovernmentAffairsPager(Activity activity) {
        super(activity);
    }

    @Override
    public void initData() {
        tv_title.setText("政务");
        setSlidingMenuEnable(true);
        TextView textView = new TextView(mActivity);
        textView.setText("你好");
        textView.setTextSize(15);
        textView.setTextColor(Color.YELLOW);
        fr_content.addView(textView);
    }
}
