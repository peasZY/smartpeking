package com.lens.testdemo.activity;

import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.lens.testdemo.R;
import com.lens.testdemo.util.ContantValue;
import com.lens.testdemo.util.SpUtil;

import java.util.ArrayList;
import java.util.List;

public class GuidActivity extends AppCompatActivity {
    private ViewPager vp_navigation;
    private Button btn_start;
    private List<View> viewList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initUI();
        initData();
    }

    private void initData() {
        LayoutInflater layoutInflater = getLayoutInflater();
        final View view1 = layoutInflater.inflate(R.layout.view1, null);
        View view2 = layoutInflater.inflate(R.layout.view2, null);
        View view3 = layoutInflater.inflate(R.layout.view3, null);
        viewList = new ArrayList<>();
        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);
        MyAdapter mAdapter = new MyAdapter();
        vp_navigation.setAdapter(mAdapter);
        vp_navigation.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position==viewList.size()-1){
                    btn_start.setVisibility(View.VISIBLE);
                }else {
                    btn_start.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SpUtil.putBoolean(getApplicationContext(), ContantValue.IS_FIRST,true);
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    class MyAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return viewList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            
            return view==object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(viewList.get(position));
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(viewList.get(position));
            return viewList.get(position);
        }

    }
    private void initUI() {
        vp_navigation = findViewById(R.id.vp_navigation);
        btn_start = findViewById(R.id.btn_start);
    }
}
