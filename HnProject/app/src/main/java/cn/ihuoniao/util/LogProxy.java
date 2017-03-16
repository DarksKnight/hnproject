package cn.ihuoniao.util;

import android.util.Log;

/**
 * Created by sdk-app-shy on 2017/3/16.
 */

public class LogProxy {

    private final static String TAG = LogProxy.class.getSimpleName();

    public static void i(String str) {
        Log.i(TAG, str);
    }
}
