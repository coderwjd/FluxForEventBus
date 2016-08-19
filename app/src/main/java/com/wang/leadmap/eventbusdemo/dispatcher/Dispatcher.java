package com.wang.leadmap.eventbusdemo.dispatcher;

import com.wang.leadmap.eventbusdemo.actions.Action;
import com.wang.leadmap.eventbusdemo.stores.Store;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wang on 16/7/26.
 */
public class Dispatcher {

    private static Dispatcher instance;

    private final List<Store> stores = new ArrayList<>();

    private Dispatcher(){}

    public static synchronized Dispatcher getInstance(){
        if (instance == null)
            instance = new Dispatcher();

        return instance;
    }

    public void register(final Store store){
        if (store == null)
            return;
        stores.add(store);
    }

    public void unregister(final Store store){
        if (store == null)
            return;
        stores.remove(store);
    }

    public void dispatch(Action action){
        post(action);
    }

    private void post(final Action action){
        if (stores.size() <= 0)
            return;
        for (Store store : stores){
            store.onAction(action);
        }
    }

}
