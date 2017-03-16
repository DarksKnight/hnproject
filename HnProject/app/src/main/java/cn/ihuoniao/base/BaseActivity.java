package cn.ihuoniao.base;

import android.app.Activity;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import cn.ihuoniao.dispatcher.Dispatcher;
import cn.ihuoniao.store.base.Store;

/**
 * Created by sdk-app-shy on 2017/3/15.
 */

public abstract class BaseActivity extends Activity {

    protected List<Store> listStore = new ArrayList<>();
    protected Dispatcher dispatcher = Dispatcher.INSTANCE;

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

    protected void addStore(Store store) {
        listStore.add(store);
    }

    protected void removeStore(Store store) {
        listStore.remove(store);
    }

    @Override
    protected void onResume() {
        super.onResume();
        for(int i = 0;i < listStore.size() ;i++) {
            listStore.get(i).register(this);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        for(int i = 0;i < listStore.size() ;i++) {
            listStore.get(i).unregister(this);
        }
    }
}