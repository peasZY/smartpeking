package com.lens.testdemo.fragment;

import android.support.v4.app.Fragment;
import android.view.View;

import com.lens.testdemo.R;
import com.lens.testdemo.base.BaseFragment;

/**
 * Created by LY305512 on 2017/12/8.
 */

public class LeftMenuFragment extends BaseFragment {

    @Override
    public View initView() {
        View view = View.inflate(mActivity, R.layout.fragment_left_menu, null);
        return view;
    }

    @Override
    public void initData() {

    }
}
