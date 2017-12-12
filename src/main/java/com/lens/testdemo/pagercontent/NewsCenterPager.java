package com.lens.testdemo.pagercontent;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.YuvImage;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lens.testdemo.base.BasePager;
import com.lens.testdemo.domain.NewsData;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

public class NewsCenterPager extends BasePager{


    public NewsCenterPager(Activity activity) {
        super(activity);
    }

    @Override
    public void initData() {
        System.out.println("新闻中心qidong了");
        tv_title.setText("新闻中心");
        TextView textView = new TextView(mActivity);
        textView.setText("news");
        textView.setTextSize(15);
        textView.setTextColor(Color.RED);
        fr_content.addView(textView);
        setSlidingMenuEnable(true);
        getDataFromServer();
    }

    private void getDataFromServer() {
        HttpUtils utils = new HttpUtils();
        utils.send(HttpRequest.HttpMethod.GET, "", new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String result = responseInfo.result;
                System.out.println("返回数据"+result);
                parseData(result);
            }

            @Override
            public void onFailure(HttpException e, String s) {
                Toast.makeText(mActivity,s,Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void parseData(String result) {
        Gson gson = new Gson();
        NewsData newsData = gson.fromJson(result, NewsData.class);

    }
}
