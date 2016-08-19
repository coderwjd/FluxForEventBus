package com.wang.leadmap.eventbusdemo.stores;

import com.wang.leadmap.eventbusdemo.actions.Action;
import com.wang.leadmap.eventbusdemo.actions.MessageAction;
import com.wang.leadmap.eventbusdemo.model.MessageShow;

import org.greenrobot.eventbus.Subscribe;

/**
 * Created by wang on 16/7/26.
 */
public class MessageStore extends Store {

    private MessageShow message = new MessageShow();

    private String oldString;

    @Override
    public StoreChangeEvent changeEvent() {
        return new StoreChangeEvent(MessageAction.ACTION_NEW_MESSAGE);
    }

    public String getMessage(){
        return this.message.getMessage();
    }

    @Override
    @Subscribe
    public void onAction(Action action) {
        switch (action.getType()){
            case MessageAction.ACTION_NEW_MESSAGE:
                this.message.setMessage((String)action.getData());
                break;
            case MessageAction.ACTION_OLD_MESSAGE:
                this.oldString = ((String)action.getData());
                break;
        }

        emitStoreChange();
    }

    public String getOldString() {
        return oldString;
    }
}
