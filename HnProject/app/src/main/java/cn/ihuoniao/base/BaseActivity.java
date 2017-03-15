package cn.ihuoniao.base;

import android.app.Activity;
import android.view.View;

/**
 * Created by sdk-app-shy on 2017/3/15.
 */

public class BaseActivity extends Activity {

    protected void init() {
        initView();
        initData();
    }

    protected void initData() {
    }

    protected void initView() {
    }

    protected final <E extends View> E getView(int id) {
        return (E) findViewById(id);
    }
}
