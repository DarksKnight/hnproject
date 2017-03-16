package cn.ihuoniao.actions;

import cn.ihuoniao.actions.base.BaseAction;
import cn.ihuoniao.dispatcher.Dispatcher;

/**
 * Created by sdk-app-shy on 2017/3/16.
 */

public class ActionsCreator {

    private static ActionsCreator instance;
    final Dispatcher dispatcher;

    ActionsCreator(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    public static ActionsCreator get(Dispatcher dispatcher) {
        if (instance == null) {
            instance = new ActionsCreator(dispatcher);
        }
        return instance;
    }

    public void sendAction(BaseAction action) {
        dispatcher.dispatch(action);
    }
}
