package com.wang.leadmap.eventbusdemo.stores;

import com.wang.leadmap.eventbusdemo.actions.Action;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by wang on 16/7/26.
 */
public abstract class Store {

    private static final EventBus bus = EventBus.getDefault();

    protected Store(){}

    public void register(final Object view){
        this.bus.register(view);
    }

    public void unregister(final Object view){
        this.bus.unregister(view);
    }

    void emitStoreChange(){
        this.bus.post(changeEvent());
    }

    public abstract StoreChangeEvent changeEvent();

    public abstract void onAction(Action action);

    public class StoreChangeEvent {

        private String type;

        public StoreChangeEvent(String type){
            this.type = type;
        }

        public String getType(){
            return this.type;
        }
    }
}
