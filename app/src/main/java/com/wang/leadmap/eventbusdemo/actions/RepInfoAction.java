package com.wang.leadmap.eventbusdemo.actions;

import com.wang.leadmap.eventbusdemo.model.response.RepFinishTaskResponse;

import java.util.List;

/**
 * Created by wang on 16/8/19.
 */
public class RepInfoAction extends Action<List<RepFinishTaskResponse>> {

    public static final String ACTION_GET_REP_INFO = "get_rep_info";

    public RepInfoAction(String type, List<RepFinishTaskResponse> data) {
        super(type, data);
    }
}
