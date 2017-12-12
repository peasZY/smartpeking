package com.lens.testdemo.fragment;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.lens.testdemo.R;
import com.lens.testdemo.base.BaseFragment;
import com.lens.testdemo.base.BasePager;
import com.lens.testdemo.pagercontent.GovernmentAffairsPager;
import com.lens.testdemo.pagercontent.HomePager;
import com.lens.testdemo.pagercontent.NewsCenterPager;
import com.lens.testdemo.pagercontent.ServicerPager;
import com.lens.testdemo.pagercontent.SettingPager;

import java.util.ArrayList;

public class ContentFragment extends BaseFragment {
    private ArrayList<BasePager> list;
    private ViewPager vp_content;
    private RadioGroup radioGroup;
    @Override
    public View initView() {
        View view = View.inflate(mActivity, R.layout.fragment_content, null);
        vp_content = view.findViewById(R.id.vp_content);
        radioGroup = view.findViewById(R.id.rg_group);
        return view;
    }

    @Override
    public void initData() {
        list = new ArrayList<>();
        list.add(new HomePager(mActivity));
        list.add(new NewsCenterPager(mActivity));
        list.add(new ServicerPager(mActivity));
        list.add(new GovernmentAffairsPager(mActivity));
        list.add(new SettingPager(mActivity));
        MyAdapter mAdapter = new MyAdapter();
        vp_content.setAdapter(mAdapter);
        list.get(0).initData();
        radioGroup.check(R.id.rb_home);
        vp_content.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                    list.get(position).initData();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(RadioGroup group, int checkedId) {
               switch (checkedId){
                   case R.id.rb_home:
                       vp_content.setCurrentItem(0,false);
                       break;
                   case R.id.rb_newscenter:
                       vp_content.setCurrentItem(1,false);
                       break;
                   case R.id.rb_service:
                       vp_content.setCurrentItem(2,false);
                       break;
                   case R.id.rb_government:
                       vp_content.setCurrentItem(3,false);
                       break;
                   case R.id.rb_setting:
                       vp_content.setCurrentItem(4,false);
                       break;
               }
           }
       });
    }
    class MyAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            BasePager basePager = list.get(position);
            container.addView(basePager.mRootView);
            return basePager.mRootView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(list.get(position).mRootView);

        }
    }

}
