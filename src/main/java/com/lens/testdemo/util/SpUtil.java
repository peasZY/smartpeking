package com.lens.testdemo.util;

import android.content.Context;
import android.content.SharedPreferences;


public class SpUtil {
    private static SharedPreferences sp;
    public static void putBoolean(Context context,String string,boolean values){
        if(sp==null){
            sp = context.getSharedPreferences("config",Context.MODE_PRIVATE);
        }
        sp.edit().putBoolean(string,values).commit();
    }
    public static boolean getBoolean(Context context,String string,boolean defValues){
        if(sp==null){
            sp = context.getSharedPreferences("config",Context.MODE_PRIVATE);
        }
        return sp.getBoolean(string,defValues);
    }
}
