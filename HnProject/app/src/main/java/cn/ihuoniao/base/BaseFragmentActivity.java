package cn.ihuoniao.base;

import android.support.v4.app.FragmentActivity;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import cn.ihuoniao.dispatcher.Dispatcher;
import cn.ihuoniao.store.base.Store;

/**
 * Created by sdk-app-shy on 2017/3/16.
 */

public class BaseFragmentActivity extends FragmentActivity {

    protected List<Store> listStore = new ArrayList<>();
    protected Dispatcher dispatcher = Dispatcher.getInstance();

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

        for(int i =0;i < listStore.size();i++) {
            Dispatcher.getInstance().addStore(listStore.get(i));
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        for(int i =0;i < listStore.size();i++) {
            Dispatcher.getInstance().removeStore(listStore.get(i));
        }
    }
}
