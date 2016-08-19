package com.wang.leadmap.eventbusdemo.actions;

/**
 * Created by wang on 16/7/26.
 */
public class Action<T> {
    private final String Type;

    private final T data;

    public Action(String type, T data){
        this.Type = type;
        this.data = data;
    }

    public String getType() {
        return Type;
    }

    public T getData() {
        return data;
    }
}
