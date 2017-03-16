package cn.ihuoniao.store;

import cn.ihuoniao.actions.base.BaseAction;
import cn.ihuoniao.model.Message;
import cn.ihuoniao.store.base.Store;

/**
 * Created by sdk-app-shy on 2017/3/16.
 */

public class ClickStore extends Store {

    private Message message = null;

    @Override
    public StoreChangeEvent changeEvent() {
        return new StoreChangeEvent();
    }

    @Override
    public void onAction(BaseAction action) {
        message = new Message();
        message.msg = "hello world";
        emitStoreChange();
    }

    public Message getMessage() {
        return message;
    }
}
