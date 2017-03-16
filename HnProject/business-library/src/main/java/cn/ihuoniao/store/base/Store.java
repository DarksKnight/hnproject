package cn.ihuoniao.store.base;

import com.squareup.otto.Bus;

import cn.ihuoniao.actions.base.BaseAction;

/**
 * Created by sdk-app-shy on 2017/3/16.
 */

public abstract class Store {

    private  static final Bus bus = new Bus();

    protected Store() {
    }

    public void register(final Object view) {
        this.bus.register(view);
    }

    public void unregister(final Object view) {
        this.bus.unregister(view);
    }

    protected void emitStoreChange() {
        this.bus.post(changeEvent());
    }

    public abstract StoreChangeEvent changeEvent();
    public abstract void onAction(BaseAction action);

    public class StoreChangeEvent {}
}
