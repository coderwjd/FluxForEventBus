package com.wang.leadmap.eventbusdemo.actions;

/**
 * Created by wang on 16/7/26.
 */
public class MessageAction extends Action<String> {

    public static final String ACTION_NEW_MESSAGE = "new_message";
    public static final String ACTION_OLD_MESSAGE = "old_message";

    public MessageAction(String type, String data) {
        super(type, data);
    }
}
