package com.lens.testdemo.pagercontent;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import com.lens.testdemo.base.BasePager;

/**
 * Created by LY305512 on 2017/12/7.
 */

public class HomePager extends BasePager{
    public HomePager(Activity activity) {
        super(activity);
    }

    @Override
    public void initData() {
        tv_title.setText("智慧北京");
        ibtn_left_menu.setVisibility(View.INVISIBLE);
        setSlidingMenuEnable(false);
        TextView textView = new TextView(mActivity);
        textView.setText("首页");
        textView.setTextSize(15);
        textView.setTextColor(Color.YELLOW);
        fr_content.addView(textView);
    }
}

