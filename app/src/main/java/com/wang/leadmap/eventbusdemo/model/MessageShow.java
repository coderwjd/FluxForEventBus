package com.wang.leadmap.eventbusdemo.model;

/**
 * Created by wang on 16/7/26.
 */
public class MessageShow {

    private String message;

    public MessageShow(){}

    public MessageShow(String message) {
        this.message = message;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
